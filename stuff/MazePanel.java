import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MazePanel extends JPanel implements KeyListener, ActionListener, MouseListener
{
  private boolean upPressed = false;
  private boolean downPressed = false;
  private boolean leftPressed = false;
  private boolean rightPressed = false;

  private int x_pos = 0;
  private int y_pos = 0;
  private int ballDiameter = 50;
  
  int[][] mazeArray = new int[][] {
    {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 1, 0, 1, 0, 1, 3, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1}};
    
    Tile[][] tileArray = new Tile[mazeArray.length][mazeArray[0].length];

  public MazePanel()
  {
    setBackground(Color.WHITE);
    setFocusable(true);
    addKeyListener(this);
    addMouseListener(this);
    
    for (int i = 0; i < mazeArray.length; i++)//Creates a new 2D array for a tile-object equivalent to the integer array.
    {
      for (int n = 0; n < mazeArray[i].length; n++)
      {
        if (mazeArray[i][n] == 0)
        {
          Blank newBlank = new Blank(n, i);
          
          tileArray[i][n] = newBlank;
        }
        
        if (mazeArray[i][n] == 1)
        {
          Wall newWall = new Wall(n, i);
          
          tileArray[i][n] = newWall;
        }
        
        if (mazeArray[i][n] == 2)
        {
          Door newDoor = new Door(n, i); //feat doorrace
          
          tileArray[i][n] = newDoor;
        }
        
        if (mazeArray[i][n] == 3)
        {
          Button newButton = new Button(n, i); //yeah this is kinda weird
          
          tileArray[i][n] = newButton;
        }
      }
    }
    //call the step() function once every 100ms
    Timer timer = new Timer(100, this);
    timer.start();
  }

  public void actionPerformed(ActionEvent e) 
  {
    step(); //im trying to make some boundaries for window size rn
    
    if((tileArray[(y_pos/50)][(x_pos/50)]).getType().equals("Button"))
	{
		((Door) tileArray[11][28]).unlock();
	}
  }

  //move the ball based on which keys are pressed
  public void step()
  {
    if (rightPressed) 
    {
    	//System.out.println((tileArray[(y_pos/50)][(x_pos/50) + 1]).getPassable());
		//System.out.println((tileArray[(y_pos/50)][(x_pos/50) + 1]));
    	if((tileArray[(y_pos/50)][(x_pos/50) + 1]).getPassable() == false)
    	{
    		x_pos = x_pos;
    	}
    	
    	else
    	{
    		x_pos += 50;
    	}
    } 

    if (leftPressed)
    {
    	//System.out.println((tileArray[(y_pos/50)][(x_pos/50) - 1]).getPassable());
		//System.out.println((tileArray[(y_pos/50)][(x_pos/50) - 1]));
    	if((tileArray[(y_pos/50)][(x_pos/50) - 1]).getPassable() == false)
    	{
    		x_pos = x_pos;
    	}
    	
    	else
    	{
    		x_pos -= 50;
    	}
	}

    if (upPressed) 
    {
    	if((tileArray[(y_pos/50) - 1][(x_pos/50)]).getPassable() == false)
    	{
    		y_pos = y_pos;
    	}
    	
    	else
    	{
    		y_pos -= 50;
    	}
    }

    if (downPressed)
    {
    	System.out.println((tileArray[(y_pos/50 + 1)][(x_pos/50)]).getPassable());
    	System.out.println((tileArray[(y_pos/50 + 1)][(x_pos/50)]));
    	if((tileArray[(y_pos/50) + 1][(x_pos/50)]).getPassable() == false)
    	{
    		y_pos = y_pos;
    	}
    	
    	else
    	{
    		y_pos += 50;
    	}
    }

    repaint();
  }

  //paint the ball
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    for (int i = 0; i < mazeArray.length; i++)// creates the visual
    {
      for (int n = 0; n < mazeArray[i].length; n++)
      {
        if (mazeArray[i][n] > 0)
        {
          //Wall newWall = new Wall(n, i);

          g.setColor(tileArray[i][n].getColor());
          g.fillRect(n * 50, i * 50, ballDiameter, ballDiameter);
          repaint();
        }
      }
    }
    

    g.setColor(Color.BLUE);
    g.fillOval(x_pos, y_pos, ballDiameter, ballDiameter);

    ///////
    
  }

  public void keyPressed(KeyEvent e) 
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) 
    {
      rightPressed = true;
    } 

    else if (e.getKeyCode() == KeyEvent.VK_LEFT ) 
    {
      leftPressed = true;
    } 

    else if (e.getKeyCode() == KeyEvent.VK_UP ) 
    {
      upPressed = true;
    } 

    else if (e.getKeyCode() == KeyEvent.VK_DOWN ) 
    {
      downPressed = true;
    }
  }

  public void keyReleased(KeyEvent e) 
  {
    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) 
    {
      rightPressed = false;
    } 

    else if (e.getKeyCode() == KeyEvent.VK_LEFT ) 
    {
      leftPressed = false;
    } 

    else if (e.getKeyCode() == KeyEvent.VK_UP ) 
    {
      upPressed = false;
    } 

    else if (e.getKeyCode() == KeyEvent.VK_DOWN ) 
    {
      downPressed = false;
    }
  }

  public void keyTyped(KeyEvent e) {}

  public void mouseClicked(MouseEvent e) {}

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

  public void mousePressed(MouseEvent e) {}

  public void mouseReleased(MouseEvent e) {}
}