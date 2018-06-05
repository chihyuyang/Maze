import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MazePanel extends JPanel implements KeyListener, ActionListener{
	private int width;
	private int height;
	private Tile[][] maze;
	private int playerX;
	private int playerY;
    //construct a PongPanel
    public MazePanel(int width, int height, Tile[][] maze){
        setBackground(Color.WHITE);
        this.width = width;
        this.height = height;
        this.maze = maze;
        this.playerX = 0;
        this.playerY = 0;
        this.setFocusable(true);
        this.addKeyListener(this);
        Timer listener = new Timer(1000/60, this);
        listener.start();
    }

    //paint a ball
    public void paintComponent(Graphics g){
    	/*
    	GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        GraphicsConfiguration config = device.getDefaultConfiguration();
        BufferedImage buffy = config.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        g = buffy.getGraphics();
	*/
        super.paintComponent(g); //get background stuff
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //get screen dimensions
        int tileSize;
        double scalingFactor = .75;
        //use the screen size to determine the ideal tile size
        
        if (screenSize.height > screenSize.width) {
        	if (maze.length > maze[0].length) {
        		tileSize = (int) (screenSize.width * scalingFactor / maze[0].length);
        	}
        	else {
        		tileSize = (int) (screenSize.width * scalingFactor / maze.length);
        	}
        }
        else {
        	if (maze.length > maze[0].length) {
        		tileSize = (int) (screenSize.height * scalingFactor / maze[0].length);
        	}
        	else {
        		tileSize = (int) (screenSize.height * scalingFactor / maze.length);
        	}
        }
        //Draw tiles
        for (int row = 0; row < maze.length; row++) {
        	for (int col = 0; col < maze[0].length; col++) {
        		try {
        			URL imgFile;
        			if (maze[row][col].getType() == TileType.WALL) {
        				imgFile = getClass().getResource("/Images/wallPixelArt.jpg");
        			}
        			else {
        				imgFile = getClass().getResource("/Images/tilePixelArt.png");
        			}
					g.drawImage(ImageIO.read(imgFile), row*tileSize + (screenSize.width - maze.length * tileSize)/2, col*tileSize + (screenSize.height - maze[0].length * tileSize)/2, tileSize, tileSize, this);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        //Draw player
        try {
			g.drawImage(ImageIO.read(getClass().getResource("/Images/kanyePixelArt.jpg")), playerX * tileSize + (screenSize.width - maze.length * tileSize)/2, playerY*tileSize + (screenSize.height - maze[0].length * tileSize)/2, (int) (tileSize * 1.00), (int) (tileSize * 1.00), this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println(keyCode);
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	            // handle up
	        	System.out.println("Arrow key pressed");
	        	if (playerY != 0 && maze[playerX][playerY-1].isWalkable()) {
	        		playerY--;
	        	}
	            break;
	        case KeyEvent.VK_DOWN:
	            // handle down 
	        	System.out.println("Arrow key pressed");
	        	if (playerY != height - 1 && maze[playerX][playerY+1].isWalkable()) {
	        		playerY++;
	        	}
	            break;
	        case KeyEvent.VK_LEFT:
	            // handle left
	        	System.out.println("Arrow key pressed");
	        	if (playerX != 0 && maze[playerX-1][playerY].isWalkable()) {
	        		playerX--;
	        	}
	            break;
	        case KeyEvent.VK_RIGHT :
	            // handle right
	        	System.out.println("Arrow key pressed");
	        	if (playerX != width - 1 && maze[playerX+1][playerY].isWalkable()) {
	        		playerX++;
	        	}
	            break;
	     }
	    repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}