package pieces;
/**
 * public class for Rook, inheriting piece class functions and methods
 */
public class Rook extends Piece {
	/**
	 * constructor for rook piece 
	 * @param color indicated the color of the piece
	 * @param position indicated position of piece
	 */
	Rook(String color,String position) {
		super(color,position);
	}
	/**
	 * constructor for rook piece 
	 * sets title to r indicating rook
	*/
	public Rook() {
		this.title = "R";
	}
}
