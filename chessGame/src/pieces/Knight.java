package pieces;

public class Knight extends Piece {
	String title;
	Knight(String color, String position) {
		super(color, position);
		// TODO Auto-generated constructor stub
	}
	public Knight() {
		// TODO Auto-generated constructor stub
		 title = "N";
	}
	public void setPosition(String position) {
		this.position = position;
		// TODO Auto-generated method stub
	}
	public void setColor(String color) {
		this.color=color;
		// TODO Auto-generated method stub
		
	}
	public String getColor() {
		// TODO Auto-generated method stub
		return color;
	}
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

}
