package pieces;

public abstract class Piece {
	String title;
	String color;
	String position;
	int [] coordinates= {0,0};
	Piece() {
		this.title = "none";
		this.color="none";
		this.position= "none";
	}
	Piece(String color,String position) {
		this.color = color;
		this.position = position;
	}
	public int[] getCor() {
		return coordinates;
	}
	public void setCor(int[] arr) {
		coordinates = arr;
	}
	public void setPosition(String position) {
		this.position=position;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPosition() {
		return position;
	}
	public void setCoordinates(int i,int j) {
		int [] newArr = {i,j};
		this.coordinates = newArr;
	} 
	public String getTitle() {
		return title;
	}
	public String getColor() {
		return color;
	}

	public void possibleMoves() {
	}
	public void move() {
	}

}
