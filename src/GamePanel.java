
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 */

public class GamePanel extends JPanel implements ActionListener {
    private final int WIDTH = 400;
    private final int HEIGHT = 600;
    private Timer timer;
    //Bird properties
    private int birdX = 100;
    private int birdY = 300;
    private int birdWidth = 30;
    private int birdHeight = 30;

    private int velocity = 0;
    private int gravity = 1;
    private int jumpStrength = -12;


    public GamePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.cyan);
        this.setFocusable(true);

        timer = new Timer(20, this);
        timer.start();

        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_SPACE) {
                    velocity = jumpStrength;
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillRect(birdX, birdY, birdWidth, birdHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        velocity += gravity;
        birdY += velocity;
        repaint();
    }
}