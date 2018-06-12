import java.awt.Color;

public class Door extends Tile
{
  private boolean passable;
  private Color tileColor;
  private String type;
  
  public Door(int x, int y)
  {
    super(x, y);
    passable = false;
    tileColor = Color.YELLOW;
    type = "Door";
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
}
