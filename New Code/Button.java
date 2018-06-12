import java.awt.Color;

public class Button extends Tile
{
  private boolean passable;
  private Color tileColor;
  private String type;
  private int number;

  int count = 0;
  
  public Button(int x, int y)
  {
    super(x, y);
    passable = true;
    tileColor = Color.GREEN;
    type = "Button";
    number = count;
    count++;
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
  
  public int getNumber()
  {
    return number;
  }
}
