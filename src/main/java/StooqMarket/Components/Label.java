package StooqMarket.Components;

import javax.swing.*;

/**
 * Created by MSI on 19.01.2017.
 */
public class Label extends JLabel {
    public Label(String text, int width, int height, int x, int y) {
        super(text);
        setSize(width, height);
        setLocation(x, y);
    }
}
