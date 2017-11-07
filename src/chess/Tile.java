package chess;
import chess.piece.Piece;

public class Tile {
	private Position position;
	//protected Color color;
	private Piece piece;
	
	public Tile(Position position, Piece piece) {
		this.position = position;
		//this.color = color;
		this.piece = piece;
	}
	
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Piece getPiece() {
		return piece;
	}



	public void setPiece(Piece piece) {
		this.piece = piece;
	}



	public String toString() {
		return "(" + this.getPosition().getX() + ":" + this.getPosition().getY() + ")" + this.getPiece() + " | ";
	}

}
