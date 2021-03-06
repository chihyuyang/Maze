import java.awt.Color;

public class ButtonLock extends Tile
{
	private int xCoord;
	private int yCoord;
	private boolean passable = true;
	private Color tileColor = Color.RED;
	private String type = "ButtonLock";
	
	private int unlockX; //so we can use these if we need to unlock a specific door; i didnt really take this into account so its gonna be a little weird i think
	private int unlockY;

	public ButtonLock(int x, int y)
	{
		super(x, y);
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