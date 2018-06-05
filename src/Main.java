import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Main{

	static GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze");
        frame.setFocusable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
        device.setFullScreenWindow(frame);
        
        JButton exitButton = new JButton("Quit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                frame.dispose();
            }
        });
        
        frame.setLayout(new BorderLayout());
        int exampleSize = 10;
        Tile[][] exampleMaze = new Tile[exampleSize][exampleSize];
        for (int i = 0; i < exampleSize; i ++) {
        	for (int j = 0; j < exampleSize; j++) {
        		if (i == 1 && j == 1) {
        			exampleMaze[i][j] = new Tile(TileType.DOOR, null, false, i, j);
        		}
        		else if (i == j) {
        			exampleMaze[i][j] = new Tile(TileType.WALL, null, false, i, j);
        		}
        		else {
        			exampleMaze[i][j] = new Tile(TileType.FLOOR, null, true, i, j);
        		}
        	}
        }
        
        MazePanel mazePanel = new MazePanel(exampleSize,exampleSize,exampleMaze);
        mazePanel.add(exitButton);
        mazePanel.setFocusable(true);
        frame.add(mazePanel, BorderLayout.CENTER);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);

    }
}
