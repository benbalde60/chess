package pieces;
/**
 * public class for Queen, inheriting piece class functions and methods
 */
public class Queen extends Piece {
	/**
	 * constructor for queen piece 
	 * sets title to p indicating queen
	 */
	public Queen() {
		this.title = "Q";
	}
	/**
	 * constructor for queen piece 
	 * @param color indicated the color of the piece
	 * @param position indicated position of piece
	 */
	Queen(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}


}
