import java.awt.Color;

public abstract class Tile {
	private int xCoord;
	private int yCoord;
	private boolean passable;
	private Color tileColor;
	private String type;

	public Tile(int x, int y)
	 {
	    this.xCoord = x;
	    this.yCoord = y;
	 }
	
	public boolean getPassable()
	{
		return passable;
	}

	public Color getColor()
	{
		return null;
	}
	
	public String getType()
	{
		return null;
	}
}
