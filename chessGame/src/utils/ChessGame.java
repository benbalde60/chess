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
		Player player1 = new Player(gameBoard.getPieces(),gameBoard ,"w", p1Name);
		Player player2 = new Player(gameBoard.getPieces(),gameBoard,"b",p2Name);
		int optionSelected = -1;
		int turn =1;
		System.out.println("------------------------------------------------------------\n"
				+"------------------------------------------------------------\n"+
				"              WELCOME TO OUR CHESS GAME!!\n"+
				"------------------------------------------------------------\n"+
				"------------------------------------------------------------");
		System.out.println("Hello "+player1.name+" and "+player2.name);
		do {
			if(turn%2!=0) {
				while(!player1.turnEnded) {
				gameBoard.printBoard();
				if(turn==1) {
						System.out.println("White goes first: which piece would like to move and where? enter positions like E1 and A4");
				}
				System.out.println("This is "+player1.getName()+"'s turn moves are entered by row/columns ex: E2 E4");
 				String pos = scnr.next();
				String pos2=scnr.next();
				//0for(int i =0;i<16;i++) {
					//if(player1.getPieces().get(i).getPosition().equals(pos)) {
					//	player1.PossibleMoves(player1.getPieces().get(i));
					//}
				//}
				player1.move(Helpers.convertToCor(pos),Helpers.convertToCor(pos2));
			}
				turn++;
				player1.setTurnEnded(false);
			} else {
				while(!player2.turnEnded) {
					gameBoard.printBoard();
					System.out.println("This is "+player2.getName()+"'s turn moves are entered by row/columns ex: E2 E4");

	 				String pos = scnr.next();
					String pos2=scnr.next();
					//0for(int i =0;i<16;i++) {
						//if(player1.getPieces().get(i).getPosition().equals(pos)) {
						//	player1.PossibleMoves(player1.getPieces().get(i));
						//}
					//}
					player2.move(Helpers.convertToCor(pos),Helpers.convertToCor(pos2));
				}
					turn++;
					player2.setTurnEnded(false);
			optionSelected++;
			}
		}while(optionSelected!=4);
	}

	/** 
	 * @param position
	 * 
	 * Method takes string position entered by user and converts to index of ints
	 * 
	 * @return int[]
	 */


}
