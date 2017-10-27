package chess;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		board.initialize();
		board.display();
		board.movePiece(board.getTiles()[0][3], board.getTiles()[4][7]);
		System.out.println();
		System.out.println();
		board.display();
		System.out.println();
		System.out.println(Arrays.toString(board.getTemp().toArray()));
	}
}
