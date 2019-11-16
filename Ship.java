import java.awt.Point;


public class Ship
{
	
	private String name;
	private Point p1;
	private Point p2;
	private int life;
	
	public Ship(String name, int length, Point p1, Point p2, Board board)
	{
		if(!(p1.x==p2.x||p1.y==p2.y))
			throw new IllegalArgumentException("Ships may not be diagonal.");
		if(!(Math.abs(p1.x-p2.x)==(length-1)||Math.abs(p1.y-p2.y)==(length-1)))
			throw new IllegalArgumentException("The ship is too long or too short.");
		
		if(p1.x == p2.x)
			if(p1.y>p2.y)
				for(int i = p2.y; i <= p1.y; i++)
					if(board.isShipOnSquare(p1.x, i))
						throw new IllegalArgumentException("Ships may not intersect with each other");
					else;
			else
				for(int i = p1.y; i <= p2.y; i++)
					if(board.isShipOnSquare(p1.x, i))
						throw new IllegalArgumentException("Ships may not intersect with each other");
					else;
		else
			if(p1.x>p2.x)
				for(int i = p2.x; i <= p1.x; i++)
					if(board.isShipOnSquare(i, p1.y))
						throw new IllegalArgumentException("Ships may not intersect with each other");
					else;
			else
				for(int i = p1.x; i < p2.x; i++)
					if(board.isShipOnSquare(i, p1.y))
						throw new IllegalArgumentException("Ships may not intersect with each other");
					else;
		
		this.name = name;
		this.life = length;
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void damage() {life--;}
	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static Point pointToString(String pointString)
	{
		int y = alphabet.indexOf(pointString.charAt(0));
		int x = Integer.parseInt(pointString.substring(1));
		return new Point(x,y);
	}
	public String getName() {return name;}
	public boolean isAlive() {return life>1;}
	public boolean hasPoint(int x, int y)
	{
		return (x >= (p1.x<p2.x?p1.x:p2.x))
			   &&
			   (x <= (p1.x>p2.x?p1.x:p2.x))
			   &&
			   (y >= (p1.y<p2.y?p1.y:p2.y))
			   &&
			   (y <= (p1.y>p2.y?p1.y:p2.y));
	}
}