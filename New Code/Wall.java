import java.awt.Color;

public class Wall extends Tile
{
  private boolean passable;
  private Color tileColor;
  private String type;
  
  public Wall(int x, int y)
  {
    super(x, y);
    passable = false;
    tileColor = Color.BLACK;
    type = "Wall";
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
