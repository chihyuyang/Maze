import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main
{
  public static void main(String[] args) 
  {
    JFrame frame = new JFrame("Maze");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    MazePanel ballPanel = new MazePanel();
    frame.add(ballPanel, BorderLayout.CENTER);

    frame.setSize(500, 500);
    frame.setVisible(true);
  }
}
