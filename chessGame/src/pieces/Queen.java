package pieces;

public class Queen extends Piece {
	String title;
	public Queen() {
		this.title = "Q";
	}
	Queen(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public String getColor() {
		return color;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

}
