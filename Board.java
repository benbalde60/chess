package board;

import java.util.ArrayList;
import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

/**
 * Represents a chessboard and manages the pieces on it.
 * The board is a 9x9 grid, where the first row and column are used for coordinates.
 */
public class Board {
    // 9x9 grid to hold pieces
    private Piece[][] chessBoard = new Piece[9][9]; 
    private ArrayList<Piece> pieces = new ArrayList<>(); // List to track pieces

    /** 
     * Returns all pieces currently on the board.
     * @return An ArrayList containing the pieces on the board.
     */
    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    /**
     * Default constructor for the board. 
     * Initializes the board with pieces in their starting positions.
     */
    public Board() {
        initializePieces(); // Call method to set up the pieces on the board
    }

    /**
     * Initializes all pieces and places them on the board.
     */
    private void initializePieces() {
        // Place black pieces
        placeBlackPieces();

        // Place white pieces
        placeWhitePieces();

        // Initialize empty squares
        initializeEmptySquares();
    }

    /**
     * Places all black pieces on the board.
     */
    private void placeBlackPieces() {
        String color = "b"; // Black color
        // Rooks
        addPiece(new Rook(), 0, 1, color);
        addPiece(new Knight(), 0, 2, color);
        addPiece(new Bishop(), 0, 3, color);
        addPiece(new Queen(), 0, 4, color);
        addPiece(new King(), 0, 5, color);
        addPiece(new Bishop(), 0, 6, color);
        addPiece(new Knight(), 0, 7, color);
        addPiece(new Rook(), 0, 8, color);

        // Pawns
        for (int col = 1; col <= 8; col++) {
            addPiece(new Pawn(), 1, col, color);
        }
    }

    /**
     * Places all white pieces on the board.
     */
    private void placeWhitePieces() {
        String color = "w"; // White color
        // Rooks
        addPiece(new Rook(), 7, 1, color);
        addPiece(new Knight(), 7, 2, color);
        addPiece(new Bishop(), 7, 3, color);
        addPiece(new Queen(), 7, 4, color);
        addPiece(new King(), 7, 5, color);
        addPiece(new Bishop(), 7, 6, color);
        addPiece(new Knight(), 7, 7, color);
        addPiece(new Rook(), 7, 8, color);

        // Pawns
        for (int col = 1; col <= 8; col++) {
            addPiece(new Pawn(), 6, col, color);
        }
    }

    /**
     * Adds a piece to the board at specified coordinates.
     * @param piece The piece to add.
     * @param row The row where the piece will be placed.
     * @param col The column where the piece will be placed.
     * @param color The color of the piece (black or white).
     */
    private void addPiece(Piece piece, int row, int col, String color) {
        piece.setColor(color);
        piece.setCoordinates(row, col);
        chessBoard[row][col] = piece; // Place the piece on the board
        pieces.add(piece); // Add piece to the list of pieces
    }

    /**
     * Initializes empty squares on the board (for aesthetic purposes).
     */
    private void initializeEmptySquares() {
        for (int i = 2; i <= 5; i++) { // Middle rows
            for (int j = 1; j <= 8; j++) {
                chessBoard[i][j] = null; // Set empty squares to null
            }
        }
    }

    /**
     * Moves a piece from one coordinate to another.
     * @param from Coordinates indicating the original position of the piece.
     * @param to Coordinates indicating the destination position of the piece.
     */
    public void move(int[] from, int[] to) {
        Piece pieceToMove = chessBoard[from[0]][from[1]]; // Get the piece at the original position

        // Check if the move is valid
        if (pieceToMove == null) {
            System.out.println("Invalid move: No piece at the specified location.");
            return;
        }
        
        Piece targetPiece = chessBoard[to[0]][to[1]]; // Check the target position
        
        if (targetPiece != null && targetPiece.getColor().equals(pieceToMove.getColor())) {
            System.out.println("Invalid move: Cannot move to a square occupied by an ally.");
            return;
        }
        
        // Move the piece
        chessBoard[to[0]][to[1]] = pieceToMove;
        chessBoard[from[0]][from[1]] = null; // Set the original position to empty
        pieceToMove.setCoordinates(to[0], to[1]); // Update the piece's coordinates
    }

    /**
     * Prints the current state of the board with coordinates.
     */
    public void printBoard() {
        // Print column labels
        System.out.print("  A  B  C  D  E  F  G  H\n");
        
        for (int i = 1; i <= 8; i++) {
            System.out.print(i + " "); // Print row number
            for (int j = 1; j <= 8; j++) {
                Piece piece = chessBoard[i][j];
                if (piece != null) {
                    System.out.print(piece.getColor() + piece.getTitle() + " "); // Print the piece
                } else {
                    System.out.print(" . "); // Print an empty square
                }
            }
            System.out.println(); // New line for each row
        }
    }
}

