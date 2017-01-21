package pl.memoryGame.bounceball;

import javax.swing.*;
import java.awt.*;

/**
 * Created by RENT on 2017-01-21.
 */
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
        new BallWindow();
    }
}
