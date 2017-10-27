package piece;
import chess.Color;
import chess.Tile;

public abstract class Piece {
	private Color color;
	
	public Piece(Color color) {
		this.color = color;
	}
		
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}



	//public abstract boolean checkMove(Tile from, Tile to); // Check move - uses checkColor, CheckDirection
	public abstract boolean checkDirection(Tile from, Tile to); //check direction 
}
