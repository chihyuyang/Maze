/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: Tile
 * Description: This is the tile class of the maze game. 
                It is an abstract class that serves as framework/ blueprint for other tile types.
 */

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
