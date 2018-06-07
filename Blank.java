import java.awt.Color;

public class Blank extends Tile
{
	private int xCoord;
	private int yCoord;
	private boolean passable = true;
	private Color tileColor;

	public Blank(int x, int y)
	{
		this.xCoord = x;
		this.yCoord = y;
	}
	
	public boolean getPassable()
	{
		return passable;
	}
}
