/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: Goal
 * Description: This is the goal class of the maze game. When the player reaches the goal, the screen turns green.
 *              The class also contains accessor methods for the fields.
 */

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
    tileColor = Color.ORANGE;
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
