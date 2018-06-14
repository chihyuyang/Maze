import java.awt.Color;

public class Goal extends Tile
{
  private boolean passable;
  private Color tileColor;
  private String type;
  private boolean complete;
  
  public Goal(int x, int y)
  {
    super(x, y);
    passable = true;
    tileColor = Color.BLUE;
    type = "Goal";
    complete = false;
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
  
  public boolean getComplete()
  {
    return complete;
  }
  
  public void complete()
  {
    complete = true;
  }
}
