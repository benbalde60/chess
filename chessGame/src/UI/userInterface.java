package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A graphical user interface for a simple chess game.
 */
public class userInterface {

    // Unicode characters for chess pieces
    private static final String[] UNICODE_PIECES = {
            "\u2654", "\u2655", "\u2656", "\u2657", "\u2658", "\u2659",
            "\u265A", "\u265B", "\u265C", "\u265D", "\u265E", "\u265F"
    };
    private static JLabel clickedPieceLabel = null;
    private static int clickedRow = -1, clickedCol = -1;

    private static Color lightColor = new Color(240, 217, 181); // Default light color
    private static Color darkColor = new Color(181, 136, 99);   // Default dark color

    // Game history list
    private static List<String> moveHistory = new ArrayList<>();
    private static JTextArea historyArea;
    private static JPanel boardPanel;
    private static JFrame mainFrame;
    private static String[][] boardState = new String[8][8];

    /**
     * Main method to start the chess game UI.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        mainFrame = new JFrame("Chess Board");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenuItem newGameItem = new JMenuItem("New Game");
        newGameItem.addActionListener(e -> resetBoard());
        menuBar.add(newGameItem);

        JMenuItem saveGameItem = new JMenuItem("Save Game");
        saveGameItem.addActionListener(e -> saveGame());
        menuBar.add(saveGameItem);

        JMenuItem loadGameItem = new JMenuItem("Load Game");
        loadGameItem.addActionListener(e -> loadGame());
        menuBar.add(loadGameItem);

        JMenuItem settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(e -> openSettingsWindow());
        menuBar.add(settingsItem);

        mainFrame.setJMenuBar(menuBar);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(8, 8));
        boardPanel.setPreferredSize(new Dimension(400, 400));

        createBoard();

        JPanel historyPanel = new JPanel(new BorderLayout());
        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyPanel.add(new JScrollPane(historyArea), BorderLayout.CENTER);

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> undoLastMove());
        historyPanel.add(undoButton, BorderLayout.SOUTH);

        mainFrame.add(boardPanel, BorderLayout.CENTER);
        mainFrame.add(historyPanel, BorderLayout.EAST);

        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    /**
     * Creates and initializes the chessboard with pieces in their default positions.
     */
    private static void createBoard() {
        boardPanel.removeAll(); // Clear the existing board

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel square = new JLabel(getPieceUnicode(row, col));
                square.setFont(new Font("Serif", Font.BOLD, 32));
                square.setHorizontalAlignment(JLabel.CENTER);
                square.setVerticalAlignment(JLabel.CENTER);

                JPanel panelSquare = new JPanel(new BorderLayout());
                panelSquare.setBorder(BorderFactory.createLineBorder(Color.GRAY));

                if ((row + col) % 2 == 0) {
                    panelSquare.setBackground(lightColor);
                } else {
                    panelSquare.setBackground(darkColor);
                }

                panelSquare.add(square);
                final int currentRow = row;
                final int currentCol = col;
                panelSquare.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        handleSquareClick(square, currentRow, currentCol);
                    }
                });
                boardPanel.add(panelSquare);
            }
        }

        boardPanel.revalidate(); // Refresh board to show changes
        boardPanel.repaint();
    }

    /**
     * Gets the Unicode representation of a chess piece for the specified row and column.
     *
     * @param row The row of the piece.
     * @param col The column of the piece.
     * @return The Unicode character representing the piece.
     */
    private static String getPieceUnicode(int row, int col) {
        if (row == 0 || row == 7) {
            int offset = (row == 0) ? 0 : 6;
            switch (col) {
                case 0:
                case 7:
                    return UNICODE_PIECES[2 + offset];
                case 1:
                case 6:
                    return UNICODE_PIECES[4 + offset];
                case 2:
                case 5:
                    return UNICODE_PIECES[3 + offset];
                case 3:
                    return (row == 0) ? UNICODE_PIECES[1] : UNICODE_PIECES[7];
                case 4:
                    return (row == 0) ? UNICODE_PIECES[0] : UNICODE_PIECES[6];
            }
        } else if (row == 1 || row == 6) {
            return (row == 1) ? UNICODE_PIECES[5] : UNICODE_PIECES[11];
        }
        return "";
    }

    /**
     * Handles a click event on a chessboard square, allowing piece selection and movement.
     *
     * @param square The JLabel representing the square.
     * @param row    The row of the square clicked.
     * @param col    The column of the square clicked.
     */
    private static void handleSquareClick(JLabel square, int row, int col) {
        String piece = square.getText();
        if (clickedPieceLabel == null && !piece.isEmpty()) {
            clickedPieceLabel = square;
            clickedRow = row;
            clickedCol = col;
            square.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
        } else if (clickedPieceLabel != null) {
            clickedPieceLabel.setBorder(null);
            String move = "Moved " + clickedPieceLabel.getText() + " from (" + clickedRow + ", " + clickedCol + ") to (" + row + ", " + col + ")";
            moveHistory.add(move);
            historyArea.append(move + "\n");
            boardState[clickedRow][clickedCol] = "";
            boardState[row][col] = clickedPieceLabel.getText();
            String removedPiece = square.getText();
            square.setText(clickedPieceLabel.getText());
            clickedPieceLabel.setText("");
            checkCondition(removedPiece);
            clickedPieceLabel = null;
            clickedRow = -1;
            clickedCol = -1;
        }
    }

    /**
     * Checks if a removed piece is a king, ending the game if so.
     *
     * @param removedPiece The piece that was removed.
     */
    private static void checkCondition(String removedPiece) {
        String whiteKing = "\u2654";
        String blackKing = "\u265A";

        if (removedPiece.equals(blackKing) || removedPiece.equals(whiteKing)) {
            JOptionPane.showMessageDialog(null, "                 King's Dead 💀 \nDeath becomes my blade once more", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * Resets the chessboard to its initial state.
     */
    private static void resetBoard() {
        createBoard();
    }

    /**
     * Saves the game state and move history to a file.
     */
    private static void saveGame() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Game");
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(selectedFile))) {
                out.writeObject(moveHistory);
                out.writeObject(boardState);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Loads a previously saved game state and move history from a file.
     */
    private static void loadGame() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load Game");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(selectedFile))) {
                moveHistory = (List<String>) in.readObject();
                boardState = (String[][]) in.readObject();
                historyArea.setText(String.join("\n", moveHistory));
                createBoard();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Opens a settings window allowing customization of board color, piece style, and board size.
     */
    private static void openSettingsWindow() {
        JFrame settingsFrame = new JFrame("Settings");
        settingsFrame.setSize(300, 200);
        settingsFrame.setLayout(new GridLayout(3, 2));

        JButton boardColorButton = new JButton("Select Board Color");
        boardColorButton.addActionListener(e -> {
            lightColor = JColorChooser.showDialog(null, "Choose Light Square Color", lightColor);
            darkColor = JColorChooser.showDialog(null, "Choose Dark Square Color", darkColor);
            createBoard();
        });
        settingsFrame.add(boardColorButton);

        JButton pieceStyleButton = new JButton("Select Piece Style");
        pieceStyleButton.addActionListener(e -> {
            // Future feature for selecting piece style, if implemented
        });
        settingsFrame.add(pieceStyleButton);

        JButton boardSizeButton = new JButton("Select Board Size");
        boardSizeButton.addActionListener(e -> {
            String[] sizes = {"400", "600", "800"};
            String size = (String) JOptionPane.showInputDialog(
                    settingsFrame,
                    "Choose Board Size:",
                    "Board Size",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    sizes,
                    "400"
            );
            if (size != null) {
                boardPanel.setPreferredSize(new Dimension(Integer.parseInt(size), Integer.parseInt(size)));
                mainFrame.pack();
            }
        });
        settingsFrame.add(boardSizeButton);

        settingsFrame.setVisible(true);
    }

    /**
     * Reverts the last move made on the chessboard.
     */
    private static void undoLastMove() {
        if (!moveHistory.isEmpty()) {
            moveHistory.remove(moveHistory.size() - 1);
            historyArea.setText(String.join("\n", moveHistory));
        }
    }
}
