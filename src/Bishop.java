
public class Bishop extends Piece {

	public Bishop(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkDirection(Tile from, Tile to) {
		if(Math.abs(from.position.x - to.position.x) == 1 && Math.abs(from.position.y - to.position.y) == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return super.color + " BISHOP";
	}

}
