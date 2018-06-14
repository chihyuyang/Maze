/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: MazePanel
 * Description: This is the main class of the maze game. It involves setting up the whole JPanel of the maze and changes
 *              the screen according to user input.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazePanel extends JPanel implements ActionListener, KeyListener
{
  private boolean upPressed = false;
  private boolean downPressed = false;
  private boolean leftPressed = false;
  private boolean rightPressed = false;

  private int x_pos = 50;
  private int y_pos = 50;
  private int ballDiameter = 50;

  // private boolean swapped = false;

  int[][] mazeArray = new int[][] { //0 = Blank, 1 = Wall, 2 = Door, 3 = Button, 4 = ButtonLock, 5 = Goal
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
    {1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 4, 1, 0, 1, 0, 1, 0, 1, 1},
    {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
    {1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
    {1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 3, 1, 0, 1, 0, 1, 0, 1, 1},
    {1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 4, 1, 0, 1, 1},
    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1},
    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
    {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1},
    {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
    {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
    {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 4, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1},
    {1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 4, 1, 1, 1, 0, 4, 0, 1, 1},
    {1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 2, 1, 1}, // Door (2) and 
    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 5, 1, 1}, // Goal (5) are in fixed
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};// positions.
      
  Tile[][] tileArray = new Tile[mazeArray.length][mazeArray[0].length]; // Creates a new 2D array of tile-objects 
                                                                        // equivalent to the integer array.
  //ArrayList<ArrayList<Integer>> doorArray = new ArrayList<>(); // Creates a new ArrayList of two integers that 
                                                               // represents a door.
  
  public MazePanel()
  {
    setBackground(Color.WHITE);
    setFocusable(true);
    addKeyListener(this);
    
    // The nested for loops construct the tileArray according to mazeArray coordinates.
    for (int r = 0; r < mazeArray.length; r++) 
    {
      for (int c = 0; c < mazeArray[r].length; c++)
      {
        if (mazeArray[r][c] == 0)
        {
          tileArray[r][c] = new Blank(c, r);
        }

        if (mazeArray[r][c] == 1)
        {
          tileArray[r][c] = new Wall(c, r);
        }

        if (mazeArray[r][c] == 2)
        {
          tileArray[r][c] = new Door(c, r);
          /*
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(c);
          temp.add(r);
          doorArray.add(temp);
          */
        }

        if (mazeArray[r][c] == 3)
        {
          tileArray[r][c] = new Button(c, r);
        }

        if (mazeArray[r][c] == 4)
        {
          tileArray[r][c] = new ButtonLock(c, r);
        }
        
        if (mazeArray[r][c] == 5)
        {
          Goal newGoal = new Goal(c, r); 
          
          tileArray[r][c] = newGoal;
        }
      }
    }
    
    // call the step() function once every 100ms
    Timer timer = new Timer(100, this);
    timer.start();
  }

  public void actionPerformed(ActionEvent e)
  {
    step();

    /*
    if ((tileArray[(y_pos / 50)][(x_pos / 50)]).getType().equals("Button"))
    {
      int number = ((Button) tileArray[(y_pos / 50)][(x_pos / 50)]).getNumber();
      doorArray.get(number).unlock();
      System.out.println("BUTTON xPos: " + x_pos + " yPos: " + y_pos + " number: " + number);
      
      int number = ((Button) tileArray[(y_pos / 50)][(x_pos / 50)]).getNumber();
      int column = doorArray.get(number).get(0);
      int row = doorArray.get(number).get(1);
      Door door = (Door) tileArray[row][column];
      door.unlock();
    }
    */
    
    /*
    if ((tileArray[(y_pos / 50)][(x_pos / 50)]).getType().equals("ButtonLock"))
    {
      int number = ((ButtonLock) tileArray[(y_pos / 50)][(x_pos / 50)]).getNumber();
      doorArray.get(number).lock();
      System.out.println("BUTTON_LOCK xPos: " + x_pos + " yPos: " + y_pos + " number: " + number);
      
      int number = ((ButtonLock) tileArray[(y_pos / 50)][(x_pos / 50)]).getNumber();
      int column = doorArray.get(number).get(0);
      int row = doorArray.get(number).get(1);
      Door door = (Door) tileArray[row][column];
      door.lock();
    }
    */
    
    // when the player steps on button
    if((tileArray[(y_pos/50)][(x_pos/50)]).getType().equals("Button"))
    {
      ((Door) tileArray[16][27]).unlock(); // only accounts for one door right now, so specific coordinates
    }
      
    // when the player steps on buttonLock
    if((tileArray[(y_pos/50)][(x_pos/50)]).getType().equals("ButtonLock"))
    {
      ((Door) tileArray[16][27]).lock(); // only accounts for one door right now, so specific coordinates
    }
    
    // when the player reaches the goal
    if((tileArray[(y_pos/50)][(x_pos/50)]).getType().equals("Goal"))
    {
      ((Goal) tileArray[17][27]).complete();
    }
  }

  // move the ball based on which keys are pressed
  public void step()
  {
    if (rightPressed)
    {
      if ((tileArray[(y_pos / 50)][(x_pos / 50) + 1]).getPassable() == true)
      {
        x_pos += 50;
      }
    }

    if (leftPressed)
    {
      if ((tileArray[(y_pos / 50)][(x_pos / 50) - 1]).getPassable() == true)
      {
        x_pos -= 50;
      }
    }

    if (upPressed)
    {
      if ((tileArray[(y_pos / 50) - 1][(x_pos / 50)]).getPassable() == true)
      {
        y_pos -= 50;
      }
    }

    if (downPressed)
    {
      if ((tileArray[(y_pos / 50) + 1][(x_pos / 50)]).getPassable() == true)
      {
        y_pos += 50;
      }
    }

    repaint();
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    // paint the tiles in mazeArray
    for (int r = 0; r < mazeArray.length; r++)
    {
      for (int c = 0; c < mazeArray[r].length; c++)
      {
        if (mazeArray[r][c] > 0)
        {
          g.setColor(tileArray[r][c].getColor());
          g.fillRect(c * 50, r * 50, ballDiameter, ballDiameter);
          repaint();
        }
      }
    }

    // changes the screen to green when the player reaches the goal
    if (((Goal) (tileArray[17][27])).getComplete()) // specific coordinate
    {
      g.setColor(Color.GREEN);
      g.fillRect(0, 0, 1500, 1000);
      repaint();
    }
    
    // paint the ball
    g.setColor(Color.BLUE);
    g.fillOval(x_pos, y_pos, ballDiameter, ballDiameter);
  }

  public void keyPressed(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      rightPressed = true;
    }

    else if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      leftPressed = true;
    }

    else if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      upPressed = true;
    }

    else if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      downPressed = true;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT)
    {
      rightPressed = false;
    }

    else if (e.getKeyCode() == KeyEvent.VK_LEFT)
    {
      leftPressed = false;
    }

    else if (e.getKeyCode() == KeyEvent.VK_UP)
    {
      upPressed = false;
    }

    else if (e.getKeyCode() == KeyEvent.VK_DOWN)
    {
      downPressed = false;
    }
  }

  public void keyTyped(KeyEvent e) {}
}
