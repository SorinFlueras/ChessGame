import java.util.ArrayList;

public class Board {
	protected Tile[][] tiles;
	protected ArrayList<Piece> removedPieces;
	
	public Board() {
		tiles = new Tile[8][8];
		removedPieces = new ArrayList<>();
	}
	
	//checks the path between Tile from and Tile to for pieces and returns true for any found piece
	public boolean checkPath(Tile from, Tile to) {
		if(from.piece instanceof Knight) {
			return false;
		}
		//moving horizontally
		if(Math.abs(from.position.x - to.position.x) > 0 && Math.abs(from.position.y - to.position.y) == 0) {
			for(int i = from.position.x + 1; i < to.position.x; i++) {
				if(tiles[i][from.position.y].piece != null) {
					return true;
				}
			}
		}
		//moving vertically
		else if(Math.abs(from.position.x - to.position.x) == 0 && Math.abs(from.position.y - to.position.y) > 0) {
			for(int i = from.position.y + 1; i < to.position.y; i++) {
				if(tiles[from.position.x][i].piece != null) {
					return true;
				}
			}
		}
		//moving diagonally
		//.....
		return false;
	} 
	
	// checks the color of the Piece where we want to move
	//!!!PROBLEMA: nu poate compara cand da de null
	public boolean checkColor(Tile from, Tile to) { 
		if(from.piece.color != to.piece.color) {
			return true;
		}
		else { //piece "to" has the same color as the piece we move
			return false;
		}
	}
	
	//tiles[x][y]
	public boolean movePiece(Tile from, Tile to) {
		if(from.piece == null) { //empty tile
			return false;
		}
		else if(from.piece.checkDirection(from, to)){
			if(checkPath(from,to) == false) { //nothing is on the way
				if(to.piece == null) { //destination tile is empty
					to.piece = from.piece;
					from.piece = null;
					return true;
				}
				else { //destination tile has a Piece
					if(checkColor(from, to)) {
						removePiece(to);
						to.piece = from.piece;
						from.piece = null;
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
		removedPieces.add(from.piece);
		from.piece = null;
	}
	
	public void initialize() {
		//initialize board with tiles
		for(int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles.length; j++) {
				tiles[i][j] = new Tile(new Position(i,j), null);
			}
		}
		
		//initialize with pieces
		
		//initialize with Rooks
		tiles[0][0].piece = new Rook(Color.BLACK);
		tiles[0][7].piece = new Rook(Color.BLACK);
		tiles[7][0].piece = new Rook(Color.WHITE);
		tiles[7][7].piece = new Rook(Color.WHITE);
		
		//initialize with Knights
		tiles[0][1].piece = new Knight(Color.BLACK);
		tiles[0][6].piece = new Knight(Color.BLACK);
		tiles[7][1].piece = new Knight(Color.WHITE);
		tiles[7][6].piece = new Knight(Color.WHITE);
		
		//testing
		//tiles[2][0].piece = new Knight(Color.BLACK);
		
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
