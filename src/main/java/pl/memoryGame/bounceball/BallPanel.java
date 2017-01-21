package pl.memoryGame.bounceball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallPanel extends JPanel implements Runnable, MouseListener {
    private Thread thread;
    private int x, y;
    private int sleepMils = 3;

    public BallPanel() {
        addMouseListener(this);

        setSize(800, 600);
        x = 100;
        y = 400;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

//        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//
//        g2D.setRenderingHints(rh);

        g.setColor(Color.black);
        g.fillOval(x, y, 20, 20);
    }

    int counter;
    boolean falling = false;

    public void animate() {
        if (counter == 75) {
            falling = true;
        }



        x = 100;

        if (!falling) {
            y -= 1;
            counter++;
        } else {
            y += 1;
        }

        repaint();
    }

    @Override
    public void run() {
        while (true) {
            animate();
            try {
                Thread.sleep(sleepMils);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            if (y > getSize().getHeight() || y < 0) {
                System.out.println(1);
                stop();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        counter = 0;
        if (y > getSize().getHeight() || y < 0) {
            System.out.println(1);
            stop();
        } else {
            stop();
            falling = false;
            start();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        if (thread != null) {
            //                thread.join();
            thread.stop();
        }
    }
}
