import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazePanel extends JPanel implements ActionListener, KeyListener, MouseListener
{
  private boolean upPressed = false;
  private boolean downPressed = false;
  private boolean leftPressed = false;
  private boolean rightPressed = false;

  private int x_pos = 50;
  private int y_pos = 50;
  private int ballDiameter = 50;

  // private boolean swapped = false;

  int[][] mazeArray = new int[][] {
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
      {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 4, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 4, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

  Tile[][] tileArray = new Tile[mazeArray.length][mazeArray[0].length]; // Creates a new 2D array of tile-objects 
                                                                        // equivalent to the integer array.
  ArrayList<Door> doorArray = new ArrayList<Door>(); // Creates a new ArrayList of door-objects.
  
  public MazePanel()
  {
    setBackground(Color.WHITE);
    setFocusable(true);
    addKeyListener(this);
    addMouseListener(this);

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
          doorArray.add(new Door(c, r));
        }

        if (mazeArray[r][c] == 3)
        {
          tileArray[r][c] = new Button(c, r);
        }

        if (mazeArray[r][c] == 4)
        {
          tileArray[r][c] = new ButtonLock(c, r);
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

    if ((tileArray[(y_pos / 50)][(x_pos / 50)]).getType().equals("Button"))
    {
      int number = ((Button) tileArray[(y_pos / 50)][(x_pos / 50)]).getNumber();
      doorArray.get(number).unlock();
    }

    if ((tileArray[(y_pos / 50)][(x_pos / 50)]).getType().equals("ButtonLock"))
    {
      int number = ((ButtonLock) tileArray[(y_pos / 50)][(x_pos / 50)]).getNumber();
      doorArray.get(number).lock();
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

  // paint the ball
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
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

  public void mouseClicked(MouseEvent e) {} // still need to implement mouse listener

  public void mouseEntered(MouseEvent e) {}

  public void mouseExited(MouseEvent e) {}

  public void mousePressed(MouseEvent e) {}
  
  public void mouseReleased(MouseEvent e) {}
}
