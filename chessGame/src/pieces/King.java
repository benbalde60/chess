package pieces;

public class King extends Piece {
	String title;
	public King() {
		this.title = "K";
	}

	King(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getColor() {
		return color;
	}
	public String getPosition() {
		return position;
	}

}
