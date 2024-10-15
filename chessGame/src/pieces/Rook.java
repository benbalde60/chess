package pieces;

public class Rook extends Piece {
	String title;
	Rook(String color,String position) {
		super(color,position);
	}
	public Rook() {
		this.title = "R";
	}
	public void setPosition(String position) {
		this.position = position;
		
	}
	public void setColor(String color) {
		this.color = color;
		// TODO Auto-generated method stub
		
	}
	public String getTitle() {
		return title;
	}
	public String getColor() {
		// TODO Auto-generated method stub
		return color;

	}

}
