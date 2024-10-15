package pieces;

public class Pawn extends Piece {
	String title = "p";
	public Pawn() {
		title = "p";
	}
	Pawn(String color,String position) {
		super(color,position);
	}
	public String getTitle() {
		return title;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String  getPosition() {
		return position;
	}
	

}
