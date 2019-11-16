import java.awt.Point;

public class TESTING
{
	public static void main(String[] args)
	{
		Board board = new Board(10,10);
		board.addRandShips();
		for(int r = 0; r < board.tiles.length; r++)
			for(int c = 0; c < board.tiles[r].length;c++)
				board.tryHit(c, r);
		System.out.println(board.ships.get(board.ships.size()-1).isAlive());
		System.out.println(board);
		System.out.println(board.isLost());
	}
}