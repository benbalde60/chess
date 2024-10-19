package pieces;
/**
 * public class for King, inheriting piece class functions and methods
 */
public class King extends Piece {
	/**
	 * constructor for king piece 
	 * sets title to K indicating king
	 */
	public King() {
		this.title = "K";
	}
	/**
	 * constructor for king piece 
	 * @param color indicated the color of the piece
	 * @param position indicated position of piece
	 */
	King(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}
	

}