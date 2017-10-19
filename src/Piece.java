
public abstract class Piece {
	protected Color color;
	
	public Piece(Color color) {
		this.color = color;
	}
	
	//public abstract boolean checkMove(Tile from, Tile to); // Check move - uses checkColor, CheckDirection
	public abstract boolean checkDirection(Tile from, Tile to); //check direction 
}
