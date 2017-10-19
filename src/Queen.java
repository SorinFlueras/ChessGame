
public class Queen extends Piece {

	public Queen(Color color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkDirection(Tile from, Tile to) {
		//moving horizontally
		if(Math.abs(from.position.x - to.position.x) > 0 && Math.abs(from.position.y - to.position.y) == 0) {
			return true;
		}
		//moving vertically
		else if(Math.abs(from.position.x - to.position.x) == 0 && Math.abs(from.position.y - to.position.y) > 0) {
			return true;
		}
		//moving diagonally
		else if(Math.abs(from.position.x - to.position.x) == Math.abs(from.position.y - to.position.y)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return super.color + " QUEEN";
	}

}
