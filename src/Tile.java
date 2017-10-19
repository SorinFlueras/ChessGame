
public class Tile {
	protected Position position;
	//protected Color color;
	protected Piece piece;
	
	public Tile(Position position, Piece piece) {
		this.position = position;
		//this.color = color;
		this.piece = piece;
	}
	
	public String toString() {
		return "(" + this.position.x + ":" + this.position.y + ")" + this.piece + "	";
	}

}
