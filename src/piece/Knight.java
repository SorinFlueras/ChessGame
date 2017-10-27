package piece;
import chess.Color;
import chess.Tile;

public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkDirection(Tile from, Tile to) {
		if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 2 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 1) {
			return true;
		}
		else if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 2 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return super.getColor() + " KNIGHT";
	}
}
