package utils;

import java.util.ArrayList;

import board.Board;
import pieces.Piece;
/**
 * public class for Player, setting the attributes of the players determined by user input
 */
public class Player {
	ArrayList<Piece> pieces;
	//Board board;
	String color;
	String name;
	/**
	 * Constructor that creates player object
	 * @param allPieces List that contains all pieces belonging to player class
	 * @param color Assigns black or white color
	 * @param name String of player name besed on input
	 */
	public Player(ArrayList<Piece> allPieces/*Board board*/,String color,String name) {
	//	this.board = board;
		this.name = name;
		this.color = color;
		this.pieces = new ArrayList<>();
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
	/**
	 * Prints the board pieces 
	 */
	public void printPieces() {
		for(int i=0;i<pieces.size();i++) {
			System.out.println(pieces.get(i).getColor()+pieces.get(i).getTitle());
		}
	}
}
		

