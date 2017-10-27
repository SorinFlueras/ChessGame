package piece;
import chess.Color;
import chess.Tile;

public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkDirection(Tile from, Tile to) {
		//moving horizontally
		if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) > 0 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 0) {
			return true;
		}
		//moving vertically
		else if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 0 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) > 0) {
			return true;
		}
		//moving diagonally
		else if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == Math.abs(from.getPosition().getY() - to.getPosition().getY())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return super.getColor() + " QUEEN";
	}

}
