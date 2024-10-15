package pieces;

public abstract class Piece {
	String color;
	String position;
	Piece() {
		
	}
	Piece(String color,String position) {
		this.color = color;
		this.position = position;
	}
	public void possibleMoves() {
	}

}
