import java.awt.Color;

public class Door extends Tile
{
	private int xCoord;
	private int yCoord;
	private boolean passable = false;
	private Color tileColor = Color.YELLOW;
	private String type = "Door";

	public Door(int x, int y)
	{
		this.xCoord = x;
		this.yCoord = y;
	}

	public boolean getPassable()
	{
	  return passable;
	}
	
	public void unlock()
	{
		passable = true;
		tileColor = Color.WHITE;
	}
	
	public void lock()
	{
		passable = false;
		tileColor = Color.YELLOW;
	}
	
	public Color getColor()
	{
		  return tileColor;
	}
	
	public String getType()
	{
		return type;
	}
}
