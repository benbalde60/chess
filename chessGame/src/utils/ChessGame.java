package utils;

import java.util.Scanner;

import board.Board;
/**
 * public class for ChessGame, continuously running and prompting the players for input then executing thier input as moves in game
 */
public class ChessGame {
/**
 * Main executes the primary functions of the chessGame including prompting players for names, team colors then awaiting input for moves
 */
	public static void main(String[] args) {
		Board gameBoard = new Board();
		Scanner scnr = new Scanner(System.in);
		System.out.println("What are the names of the players?");
		String p1Name = scnr.next();
		String p2Name = scnr.next();
		Player player1 = new Player(gameBoard.getPieces(), "w", p1Name);
		Player player2 = new Player(gameBoard.getPieces(),"b",p2Name);
		int optionSelected = -1;
		int turn =1;
		System.out.println("------------------------------------------------------------\n"
				+"------------------------------------------------------------\n"+
				"              WELCOME TO OUR CHESS GAME!!\n"+
				"------------------------------------------------------------\n"+
				"------------------------------------------------------------");
		System.out.println("Hello "+player1.name+" and "+player2.name);
		do {
			if(turn==1) {
				gameBoard.printBoard();
				if(optionSelected==-1) {
				System.out.println("White goes first: which piece would like to move and where? enter positions like E1 and A4");
				}
				String pos = scnr.next();
				String pos2=scnr.next();
				gameBoard.move(convertToCor(pos),convertToCor(pos2));
			}
		optionSelected++;
		}while(optionSelected!=4);
	}

	/** 
	 * @param position
	 * 
	 * Method takes string position entered by user and converts to index of ints
	 * 
	 * @return int[]
	 */
	private static int[] convertToCor(String position) {
		// TODO Auto-generated method stub
		char first = position.charAt(0);
		char second = position.charAt(1);
		int col = first-'A'+1;
		int row = 8-(second-'1');
		return new int[]{row,col};
	}

}
