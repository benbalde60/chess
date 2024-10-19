package pieces;
/**
 * public class for Bishop, inheriting piece class functions and methods
 */
public class Bishop extends Piece {
	/**
	 * constructor for bishop piece 
	 * sets title to B indicated bishop
	 */
	public Bishop() {
		this.title="B";
	}
	/**
	 * constructor for bishop piece 
	 * @param color indicated the color of the piece
	 * @param position indicated position of piece
	 */
	Bishop(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}

}
