import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	private int width;
	private int height;
	private Tile[][] maze;
    //construct a PongPanel
    public MazePanel(){
        setBackground(Color.WHITE);
    }

    //paint a ball
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.setColor(Color.WHITE);

        g.fillOval(250, 250, 20, 20);
    }

}