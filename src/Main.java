
public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		board.initialize();
		board.display();
		board.movePiece(board.tiles[0][0], board.tiles[5][0]);
		System.out.println();
		System.out.println();
		board.display();
	}
}
