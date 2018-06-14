import java.awt.Color;

public abstract class Tile
{
  private int xCoord;
  private int yCoord;
  
  public Tile(int x, int y)
  {
    this.xCoord = x;
    this.yCoord = y;
  }

  public abstract boolean getPassable();

  public abstract Color getColor();

  public abstract String getType();
}
