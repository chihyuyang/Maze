import java.awt.Color;

public abstract class Tile {
	private int xCoord;
	private int yCoord;
	private boolean passable;
	private Color tileColor;

	public boolean getPassable()
	{
		return passable;
	}
}
