import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Board
{
	private static Random rand = new Random();
	public Tile[][] tiles;
	public ArrayList<Ship> ships = new ArrayList<Ship>();
	public Board(int columns, int rows)
	{
		tiles = new Tile[rows][columns];
		for(int r = 0; r < tiles.length; r++)
			for(int c = 0; c < tiles[r].length; c++)
				tiles[r][c] = Tile.BLANK;
	}
	public boolean isLost()
	{
		for(Ship ship:ships)
			if(ship.isAlive())
				return false;
		return true;
	}
	public void addRandShips()
	{
		int[] shipLengths = new int[] {5,4,3,3,2};
		for(int i = 0; i < shipLengths.length; i++)
		{
			boolean exceptionCaught = true;
			while(exceptionCaught)
			{
				exceptionCaught = false;
				boolean vertical = rand.nextBoolean();
				try
				{
					int xCord1 = vertical?rand.nextInt(tiles[0].length):rand.nextInt(tiles[0].length-shipLengths[i]-1);
					int xCord2 = vertical?xCord1:xCord1+shipLengths[i]-1;
					int yCord1 = vertical?rand.nextInt(tiles.length-shipLengths[i]-1):rand.nextInt(tiles.length);
					int yCord2 = vertical?yCord1+shipLengths[i]-1:yCord1;
					addShip("TEST",shipLengths[i],new Point(xCord1,yCord1),new Point(xCord2,yCord2));
				}catch(Exception e)
				{
					exceptionCaught = true;
				}
			}
		}
	}
	public void addShip(String name, int length, Point p1, Point p2)
	{
		ships.add(new Ship(name,length,p1,p2,this));
	}
	
	public String getString(boolean playerBoard)
	{
		return null;
	}
	public boolean isShipOnSquare(int x, int y)
	{
		for(Ship ship: ships)
			if(ship.hasPoint(x, y))
				return true;
		
		return false;
	}
	
	public boolean tryHit(int x, int y)
	{
		for(Ship ship:ships)
		{
			if(ship.hasPoint(x,y)&&tiles[y][x]==Tile.BLANK)
			{
				ship.damage();
				tiles[y][x] = Tile.HIT;
				return true;
			}
		}
		tiles[y][x] = Tile.MISSED;		
		return false;
	}
	@Override
	public String toString()
	{
		String ret = "";
		for(int r = 0; r < tiles.length; r++)
		{
			for(int c = 0; c < tiles[r].length;c++)
			{
				switch(tiles[r][c])
				{
					case BLANK:
						ret+="'";
						break;
					case MISSED:
						ret+="-";
						break;
					case HIT:
						ret+="x";
						break;
				}
			}
			ret+="ABCDEFGHIJKLMNOPQRSTUVWYXZ".charAt(r);
			ret+="\n";
		}
		for(int c = 0; c < tiles[0].length;c++)
			ret+=c;
		return ret;
	}
}