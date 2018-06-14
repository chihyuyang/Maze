import java.awt.Color;

public class Blank extends Tile
{
  private boolean passable;
  private Color tileColor;
  private String type;

  public Blank(int x, int y)
  {
    super(x, y);
    passable = true;
    tileColor = Color.WHITE;
    type = "Blank";
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
