package pieces;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * The attributes of a piece
 */
public abstract class Piece {
	String title;
	String color;
	String position;
	int [] coordinates= {0,0};
	Set<String>possibleMoves = new HashSet<>();
	Piece() {
		this.title = "none";
		this.color="none";
		this.position= "none";
	}
	Piece(String color,String position) {
		this.color = color;
		this.position = position;
	}
	
	/** 
	 * metod returns coords 
	 * @return int[] returns coordinate vector
	 */
	public int[] getCor() {
		return coordinates;
	}
	/**
	 * Sets position as readable string 
	 * @param position a string position of any piece represnted alphanumerically
	 */
	public void setPosition(String position) {
		this.position=position;
	}
	/**
	 * sets color for piece
	 * @param color string value indicating black or white color for piece 
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * returns string position
	 * @return position string 
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * sets coordinates for piece
	 * @param i indicates alpha position on board
	 * @param j indicates num position on board
	*/
	public void setCoordinates(int i,int j) {
		int [] newArr = {i,j};
		this.coordinates = newArr;
	}
	/**
	 * Returns the name for board piece 
	 * @return title string for piece
	 */ 
	public String getTitle() {
		return title;
	}
	/**
	 * Returns string indicated black or white color of piece
	 * @return can be string indicated black or white color
	 */
	public String getColor() {
		return color;
	}

	public Set<String> getPossibleMoves() {
		return possibleMoves;
	}
	public void printPossibleMoves() {
		System.out.println(possibleMoves.toString());
	}
	public void move() {
	}

}
