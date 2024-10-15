package pieces;

public class Bishop extends Piece {
	String title;
	public Bishop() {
		this.title="B";
	}
	Bishop(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}
	public void setColor(String color) {
		this.color=color;
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
