package pl.memoryGame.bounceball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallPanel extends JPanel implements Runnable, MouseListener {
    private Thread thread;
    private int x, y;
    private int obstacleX, obstacleY;
    private int obstacleX1, obstacleY1;
    private int obstacleX2, obstacleY2;

    private int sleepMils = 5;

    private int counterUp;
    private int counterDown;
    private boolean falling = false;

    private static int timer = 0;

    public BallPanel() {
        addMouseListener(this);

        x = 100;
        y = 400;

        obstacleX = 850;
        obstacleY = 400;

        obstacleX1 = 850;
        obstacleY1 = 400;

        obstacleX2 = 850;
        obstacleY2 = 400;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2D.setRenderingHints(rh);

        g2D.setColor(Color.black);
        g2D.fillOval(x - 10, y - 10, 20, 20);

        drawObstacles(g2D);

    }

    private void drawObstacles(Graphics2D graphics2D) {
        graphics2D.setColor(Color.red);
        graphics2D.fillRect(obstacleX, obstacleY, 50, 200);
        graphics2D.fillRect(obstacleX, obstacleY - 400, 50, 300);

        graphics2D.setColor(Color.blue);
        graphics2D.fillRect(obstacleX1, obstacleY1 - 300, 50, 500);

        graphics2D.setColor(Color.magenta);
        graphics2D.fillRect(obstacleX2, obstacleY2 + 100, 100, 100);
        graphics2D.fillRect(obstacleX2, obstacleY2 - 400, 100, 400);
    }


    public void animate(int timer, int level) {
        if (timer % level == 0) {
            if (counterUp >= 30) {
                falling = true;
            }
            x = 100;

            if (!falling) {
                if (counterUp <= 20) {
                    y -= 3;
                } else if (counterUp <= 25 && counterUp > 20) {
                    y -= 2;
                } else if (counterUp <= 30 && counterUp > 25) {
                    y -= 1;
                }
                counterUp++;
            } else {
                if (counterDown <= 5) {
                    y += 1;
                } else if (counterDown <= 10 && counterDown > 5) {
                    y += 2;
                } else if (counterDown > 10) {
                    y += 3;
                }
                counterDown++;
            }
            repaint();
        }
    }

    private void obstacleMovement(int timer, int level, int start) {
        if (timer % level == 0 && timer >= start) {
            if (obstacleX > -100) {
                if (timer % 3 == 0) {
                    obstacleX += 10;
                    obstacleY += 20;
                } else if (timer % 3 == 1) {
                    obstacleX -= 5;
                    obstacleY -= 10;
                } else {
                    obstacleX -= 7;
                    obstacleY -= 10;
                }
//                obstacleX -= 1;
                repaint();
            }
        }
    }

    private void obstacle1Movement(int timer, int level, int start) {
        if (timer % level == 0 && timer >= start) {
            if (obstacleX1 > -100) {
                obstacleX1 -= 1;
                repaint();
            }
        }
    }

    private void obstacle2Movement(int timer, int level, int start) {
        if ((timer % level == 0) && (timer >= start)) {
            if (obstacleX2 > -100) {
                obstacleX2 -= 1;
                repaint();
            }
        }
    }

    @Override
    public void run() {

        while (true) {
            timer++;

            animate(timer, 1);

            obstacleMovement(timer, 2, 0);

            obstacle1Movement(timer, 2, 1500);

            obstacle2Movement(timer, 2, 3000);

            try {
                Thread.sleep(sleepMils);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ((y > getSize().getHeight() || y < 0)
                    || ((x >= obstacleX && x <= (obstacleX + 50)) && (y >= 400 || y <= 300))
                    || ((x >= obstacleX1 && x <= (obstacleX1 + 50)) && (y >= 100 || y <= 0))
                    || ((x >= obstacleX2 && x <= (obstacleX2 + 100)) && (y >= 500 || y <= 400))) {
                stop();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        counterUp = 0;
        counterDown = 0;
        if (y > getSize().getHeight() || y < 0) {
            System.out.println("stop");
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
