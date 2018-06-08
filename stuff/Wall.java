import java.awt.Color;

public class Wall extends Tile
{
  private int xCoord;
  private int yCoord;
  private boolean passable = false;
  private Color tileColor = Color.BLACK;
  private String type = "Wall";
  
  public Wall(int x, int y)
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
	  return tileColor;
  }
  
  public String getType()
  {
	  return type;
  }

}
