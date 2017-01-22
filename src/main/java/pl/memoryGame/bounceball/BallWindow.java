package pl.memoryGame.bounceball;

import javax.swing.*;
import java.awt.*;

public class BallWindow extends JFrame {
    public BallWindow() throws HeadlessException {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        setVisible(true);

        BallPanel panel = new BallPanel();
        add(panel);

        repaint();
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new BallWindow();
                ex.setVisible(true);
            }
        });
    }
}
