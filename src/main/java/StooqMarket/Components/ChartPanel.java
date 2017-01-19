package StooqMarket.Components;

import javax.swing.*;
import java.awt.*;

public class ChartPanel extends JPanel {

    public ChartPanel(int x, int y) {
        setLocation(x,y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawImage(g2d);
    }

    public void drawImage(Graphics2D graphics2D) {
//        graphics2D.drawImage();
    }
}
