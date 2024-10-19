package pieces;

public class Pawn extends Piece {
	public Pawn() {
		title = "p";
		this.color = "none";
	}
	Pawn(String color,String position) {
		super(color,position);
	}
	public void move() {
		if(color.equals("w")) {
			coordinates[1]=+2;
		}
	}

}
