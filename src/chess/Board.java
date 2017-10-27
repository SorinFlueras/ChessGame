package chess;
import java.util.ArrayList;
import piece.Bishop;
import piece.Knight;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class Board {
	private Tile[][] tiles;
	private ArrayList<Piece> removedPieces;
	private ArrayList<Tile> temp = new ArrayList<>();
	public Board() {
		tiles = new Tile[8][8];
		removedPieces = new ArrayList<>();
	}
	
	
	
	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public ArrayList<Piece> getRemovedPieces() {
		return removedPieces;
	}

	public void setRemovedPieces(ArrayList<Piece> removedPieces) {
		this.removedPieces = removedPieces;
	}

	public ArrayList<Tile> getTemp() {
		return temp;
	}

	public void setTemp(ArrayList<Tile> temp) {
		this.temp = temp;
	}



	//checks the path between Tile from and Tile to for pieces and returns true for any found piece
	public boolean checkPath(Tile from, Tile to) {
		if(from.getPiece() instanceof Knight) {
			return false;
		}
		//moving horizontally
		if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) > 0 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) == 0) {
			for(int i = from.getPosition().getX() + 1; i < to.getPosition().getX(); i++) {
				if(tiles[i][from.getPosition().getY()].getPiece() != null) {
					return true;
				}
			}
		}
		//moving vertically
		else if(Math.abs(from.getPosition().getX() - to.getPosition().getX()) == 0 && Math.abs(from.getPosition().getY() - to.getPosition().getY()) > 0) {
			for(int i = from.getPosition().getY() + 1; i < to.getPosition().getY(); i++) {
				if(tiles[from.getPosition().getX()][i].getPiece() != null) {
					return true;
				}
			}
		}
		//moving diagonally
		/*else if(Math.abs(from.position.x - to.position.x) == Math.abs(from.position.y - to.position.y)) {
			for(int i = from.position.x; i < to.position.x; i++) {
				for(int j = to.position.y; j < to.position.y; j++) {
					if(tiles[i][j].piece != null) {
						temp.add(tiles[i][j]);
					}
				}
			}
		}*/
		else {
			return false;
		}
		return false;
	} 
	
	// checks the color of the Piece where we want to move
	//!!!PROBLEMA: nu poate compara cand da de null
	public boolean checkColor(Tile from, Tile to) { 
		if(from.getPiece().getColor() != to.getPiece().getColor()) {
			return true;
		}
		else { //piece "to" has the same color as the piece we move
			return false;
		}
	}
	
	//tiles[x][y]
	public boolean movePiece(Tile from, Tile to) {
		if(from.getPiece() == null) { //empty tile
			return false;
		}
		else if(from.getPiece().checkDirection(from, to)){
			if(checkPath(from,to) == false) { //nothing is on the way
				if(to.getPiece() == null) { //destination tile is empty
					to.setPiece(from.getPiece());
					from.setPiece(null);
					return true;
				}
				else { //destination tile has a Piece
					if(checkColor(from, to)) {
						removePiece(to);
						to.setPiece(from.getPiece());
						from.setPiece(null);
						return true;
					}
					else {
						return false;
					}
				}
			}
			else { //other piece is in the way
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void removePiece(Tile from) {
		removedPieces.add(from.getPiece());
		from.setPiece(null);
	}
	
	public void initialize() {
		//initialize board with tiles
		for(int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				tiles[i][j] = new Tile(new Position(i,j), null);
			}
		}
		
		//initialize with pieces
		
		//initialize Rooks
		tiles[0][0].setPiece(new Rook(Color.BLACK));
		tiles[0][7].setPiece(new Rook(Color.BLACK));
		tiles[7][0].setPiece(new Rook(Color.WHITE));
		tiles[7][7].setPiece(new Rook(Color.WHITE));
		
		//initialize Knights
		tiles[0][1].setPiece(new Knight(Color.BLACK));
		tiles[0][6].setPiece(new Knight(Color.BLACK));
		tiles[7][1].setPiece(new Knight(Color.WHITE));
		tiles[7][6].setPiece(new Knight(Color.WHITE));
		
		//initialize Bishops
		tiles[0][2].setPiece(new Bishop(Color.BLACK));
		tiles[0][5].setPiece(new Bishop(Color.BLACK));
		tiles[7][2].setPiece(new Bishop(Color.WHITE));
		tiles[7][5].setPiece(new Bishop(Color.WHITE));
	
		//initialize QUEENS
		tiles[0][3].setPiece(new Queen(Color.BLACK));
		tiles[7][3].setPiece(new Queen(Color.WHITE));
		
		//testing
		tiles[3][6].setPiece(new Knight(Color.WHITE));
		tiles[2][5].setPiece(new Knight(Color.BLACK));
		
	}
	
	public void display() {
		for(int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				System.out.print(tiles[i][j] + " ");
			}
			System.out.println();
		}
	}

}
