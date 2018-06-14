/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: Wall
 * Description: This is the wall class of the maze game that extends the tile class. 
 *              It constructs a wall in the maze that is not passable and contains accessor methods for the fields.
 */

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
