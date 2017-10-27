package piece;
import chess.Color;
import chess.Tile;

public class Rook extends Piece {

	public Rook(Color color) {
		super(color);
	}
	
	/*
	@Override
	public boolean checkMove(Tile from, Tile to) {
		return false;
	}*/
	
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
		//illegal move
		else {
			return false;
		}
	}
	
	public String toString() {
		return super.getColor() + " ROOK";
	}
}
