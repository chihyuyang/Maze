import java.awt.BorderLayout;
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

    frame.setSize(1511, 989);
    frame.setVisible(true);
  }
}
