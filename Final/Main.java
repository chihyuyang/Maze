/**
 * Name: Cliffton Woo and Chih Yu (Eric) Yang
 * File Name: Main
 * Description: This is the runner class of the maze game. It creates the JFrame and sets the window size.
 */

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
