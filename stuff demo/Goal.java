import java.awt.Color;

public class Goal extends Tile
{
	private int xCoord;
	private int yCoord;
	private boolean passable = true;
	private Color tileColor = Color.GREEN;
	private String type = "Goal";
	
	public boolean complete = false;
	
	public Goal(int x, int y)
	{
		super(x, y);
	}
	
	public void complete()
	{
		complete = true;
	}
	
	public boolean getComplete()
	{
		return complete;
	}
	
	public boolean getPassable()
	{
		return passable;
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