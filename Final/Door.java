/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: Door
 * Description: This is the door class of the maze game that extends the tile class. 
 *              It constructs a door in the maze that is not passable until the player reaches a Button.
 *              The door locks again when the player reaches a buttonLock. 
 *              The class also contains accessor methods for the fields.
 */

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
