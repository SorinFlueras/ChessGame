
public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		board.initialize();
		board.display();
		//board.movePiece(board.tiles[0][1], board.tiles[2][2]);
		System.out.println();
		System.out.println();
		board.display();
	}
}
