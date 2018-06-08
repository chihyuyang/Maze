import java.awt.Color;

public abstract class Tile {
	private int xCoord;
	private int yCoord;
	private boolean passable;
	private Color tileColor;
	private String type;

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
