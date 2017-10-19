
public class Knight extends Piece {

	public Knight(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkDirection(Tile from, Tile to) {
		if(Math.abs(from.position.x - to.position.x) == 2 && Math.abs(from.position.y - to.position.y) == 1) {
			return true;
		}
		else if(Math.abs(from.position.x - to.position.x) == 2 && Math.abs(from.position.y - to.position.y) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return super.color + " KNIGHT";
	}
}
