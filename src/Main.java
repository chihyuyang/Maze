import java.awt.BorderLayout; 

import javax.swing.JFrame;

public class Main{

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        MazePanel mazePanel = new MazePanel();
        frame.add(mazePanel, BorderLayout.CENTER);

        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}