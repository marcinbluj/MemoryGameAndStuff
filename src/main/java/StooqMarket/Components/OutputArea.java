package StooqMarket.Components;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class OutputArea extends JTextArea {
    public OutputArea(int width, int height, int x, int y) {

        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(1));
        setEditable(false);
    }
}
