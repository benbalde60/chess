package utils;

import java.util.ArrayList;

import board.Board;
import pieces.Piece;

public class Player {
	ArrayList<Piece> pieces;
	//Board board;
	String color;
	String name;
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
	public void printPieces() {
		for(int i=0;i<pieces.size();i++) {
			System.out.println(pieces.get(i).getColor()+pieces.get(i).getTitle());
		}
	}
}
		

