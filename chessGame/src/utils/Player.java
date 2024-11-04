package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import board.Board;
import pieces.Piece;
import utils.Helpers;
/**
 * public class for Player, setting the attributes of the players determined by user input
 */
public class Player {
	ArrayList<Piece> pieces;
	Board chessBoard = new Board();
	String color;
	String name;
	/**
	 * Constructor that creates player object
	 * @param allPieces List that contains all pieces belonging to player class
	 * @param color Assigns black or white color
	 * @param name String of player name besed on input
	 */
	public Player(ArrayList<Piece> allPieces,Board board,String color,String name) {
	//	this.board = board;
		this.name = name;
		this.color = color;
		this.pieces = new ArrayList<>();
		this.chessBoard= board;
		if(color=="b") {
			for(int i=0;i<allPieces.size();i++) {
				if(allPieces.get(i).getColor()=="b") {
					pieces.add(allPieces.get(i));
					
				}
			}
		}else {
			for(int i=0;i<allPieces.size();i++) {
				if(allPieces.get(i).getColor()=="w") {
					pieces.add(allPieces.get(i));

		
				}
			}			
		}
	}
	public void resetPossibleMoves(Piece piece) {
		piece.getPossibleMoves().clear();
	}
	public void PossibleMoves(Piece piece) {
		if(!piece.getColor().equals(color)) {
			System.out.println("You cannot move this piece");
		}else {
		switch(piece.getTitle()) {
		case "p":
			if(piece.getPosition().substring(1).equals("2")) {
				int[] cor = piece.getCor();
				cor[0]-=1;
				Helpers.convertCorToPos(cor);
				if(piece.getPossibleMoves().size()>=2) {
				resetPossibleMoves(piece);
				}
				piece.getPossibleMoves().add(Helpers.convertCorToPos(cor));
				cor[0]-=1;
				piece.getPossibleMoves().add(Helpers.convertCorToPos(cor));
			//	for(String moves: piece.getPossibleMoves() ) {
				//	System.out.println(moves);
				//}
			}
			break;
		 }
		}
	}
	public void move(int []a1,int [] a2) {
		if(chessBoard.getChessBoard()[a1[0]][a1[1]]=="  "||chessBoard.getChessBoard()[a1[0]][a1[1]]=="##") {
			System.out.println("invalid move");
		}else if(chessBoard.getChessBoard()[a2[0]][a2[1]].charAt(0)==chessBoard.getChessBoard()[a1[0]][a1[1]].charAt(0)){
			System.out.println("invalid move ally at this location");
		}else {
			for(int i=0;i<pieces.size();i++) {
				if(pieces.get(i).getPosition().equals(Helpers.convertCorToPos(a1))) {
					PossibleMoves(pieces.get(i));
					pieces.get(i).printPossibleMoves();
					if(!pieces.get(i).getPossibleMoves().contains(Helpers.convertCorToPos(a2))) {
					  System.out.println("Invalid move");
					 // resetPossibleMoves(pieces.get(i));
					}else {
					resetPossibleMoves(pieces.get(i));
					pieces.get(i).setCoordinates(a2[0],a2[1]);
					pieces.get(i).setPosition(Helpers.convertCorToPos(pieces.get(i).getCor()));
					chessBoard.getChessBoard()[a2[0]][a2[1]]=chessBoard.getChessBoard()[a1[0]][a1[1]];
					if((a1[0]%2!= 0 && a1[1]%2==0) ||(a1[0]%2==0 && a1[1]%2!=0)) {
						chessBoard.getChessBoard()[a1[0]][a1[1]]= "##";
					}else {
						chessBoard.getChessBoard()[a1[0]][a1[1]]= "  ";
					}
					}
				}
				resetPossibleMoves(pieces.get(i));			}
	   }
	}
	
public ArrayList<Piece> getPieces(){
	return pieces;
}
	/**
	 * Prints the board pieces 
	 */
	public void printPieces() {
		for(int i=0;i<pieces.size();i++) {
			System.out.println(pieces.get(i).getColor()+pieces.get(i).getTitle());
		}
	}
}
		

