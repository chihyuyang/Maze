/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: ButtonLock
 * Description: This is the buttonLock class of the maze game. When the player reaches the button, the door locks.
 *              The class also contains accessor methods for the fields.
 */

import java.awt.Color;

public class ButtonLock extends Tile
{
  private boolean passable;
  private Color tileColor;
  private String type;
  //private int number;
  
  //int count = 0;
  
  public ButtonLock(int x, int y)//, int count)
  {
    super(x, y);
    passable = true;
    tileColor = Color.RED;
    type = "ButtonLock";
    //number = count;
    //count++;
    //this.count =- count;
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
  
  /*
  public int getNumber()
  {
    return count;//number;
  }
  */
}
