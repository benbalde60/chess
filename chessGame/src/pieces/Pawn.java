package pieces;

public class Pawn extends Piece {
	/**
	 * constructor for pawn piece 
	 * sets title to p indicating pawn
	 */
	public Pawn() {
		title = "p";
		this.color = "none";
	}
	/**
	 * constructor for pawn piece 
	 * @param color indicated the color of the piece
	 * @param position indicated position of piece
	 */
	Pawn(String color,String position) {
		super(color,position);
	}
}
