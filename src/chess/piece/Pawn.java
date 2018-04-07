package chess.piece;

import chess.Color;
import chess.Tile;

public class Pawn extends Piece {
	private int numberOfMoves;
	
	public Pawn(Color color) {
		super(color);
		numberOfMoves = 0;
	}
	
	public int getNumberOfMoves() {
		return numberOfMoves;
	}
	
	public void setNumberOfMoves(int numberOfMoves) {
		this.numberOfMoves = numberOfMoves;
	}

	@Override
	public boolean checkDirection(Tile from, Tile to) {
		if(numberOfMoves == 0) {
			//moving vertically
			if((Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 1 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 0) || (Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 2 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 0)) {
				return true;
			}
			//moving diagonally
			else if(to.getPiece() != null) {
				if((Math.abs(from.getPosition().getX() - to.getPosition().getX()) == Math.abs(from.getPosition().getY() - to.getPosition().getY()) && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 1) || (Math.abs(from.getPosition().getX() - to.getPosition().getX()) == Math.abs(from.getPosition().getY() - to.getPosition().getY()) && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 2)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			//moving vertically
			if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 1 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 0) {
				return true;
			}
			//moving diagonally
			else if(to.getPiece() != null) {
				if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == Math.abs(from.getPosition().getY() - to.getPosition().getY()) && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 1) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
	
	public String toString() {
		return super.getColor() + " PAWN";
	}

}
