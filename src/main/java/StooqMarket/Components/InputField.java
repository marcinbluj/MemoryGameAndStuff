package StooqMarket.Components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputField extends JTextArea implements KeyListener{
    public InputField(int width, int height, int x, int y) {
        addKeyListener(this);
        setSize(width, height);
        setLocation(x, y);
        setEditable(false);
        setBorder(new BevelBorder(1));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
