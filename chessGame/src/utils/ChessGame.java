package utils;

import java.util.Scanner;

import board.Board;

public class ChessGame {

	public static void main(String[] args) {
		Board gameBoard = new Board();
		Scanner scnr = new Scanner(System.in);
		System.out.println("What are the names of the players?");
		String p1Name = scnr.next();
		String p2Name = scnr.next();
		Player player1 = new Player(gameBoard.getPieces(), "b", p1Name);
		Player player2 = new Player(gameBoard.getPieces(),"w",p2Name);
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
				System.out.println("White goes first: which piece would like to move and where? enter positions like E1 and A4");
				String pos = scnr.next();
				//convertToCor(pos);
				String pos2=scnr.next();
				gameBoard.move(convertToCor(pos),convertToCor(pos2));
				//gameBoard.printBoard();
			}
		optionSelected++;
		}while(optionSelected!=4);
		//gameBoard.printBoard();
	}

	private static int[] convertToCor(String position) {
		// TODO Auto-generated method stub
		char first = position.charAt(0);
		char second = position.charAt(1);
		int col = first-'A'+1;
		int row = 8-(second-'1');
		return new int[]{row,col};
	}
	public static String convertToPos(int row,int col) {
		char rowC = (char)('A' +col);
		int colC = 8-row;
		return""+rowC+colC;
	}

	

}
