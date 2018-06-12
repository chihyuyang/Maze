import java.awt.Color;

public class Blank extends Tile
{
	private int xCoord;
	private int yCoord;
	private boolean passable = true;
	private Color tileColor;
	private String type = "Blank";

	public Blank(int x, int y)
	{
		super(x, y);
	}
	
	public boolean getPassable()
	{
		return passable;
	}
	
	public String getType()
	{
		return type;
	}
}
