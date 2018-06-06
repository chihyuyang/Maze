import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
  private int y_pos = 395;
  private int ballDiameter = 50;

  public MazePanel()
  {
    setBackground(Color.WHITE);
    setFocusable(true);
    addKeyListener(this);
    addMouseListener(this);

    //call the step() function 60 times per second
    Timer timer = new Timer(100, this);
    timer.start();
  }

  public void actionPerformed(ActionEvent e) 
  {
    step();
  }

  //move the ball based on which keys are pressed
  public void step()
  {
    if (rightPressed) 
    {
      x_pos += 50;
    } 

    if (leftPressed)
    {
      x_pos -= 50;
    } 

    if (upPressed) 
    {
      y_pos -= 50;
    }

    if (downPressed)
    {
      y_pos += 50;
    }

    repaint();
  }

  //paint the ball
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    g.setColor(Color.BLUE);
    g.fillOval(x_pos, y_pos, ballDiameter, ballDiameter);     
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
