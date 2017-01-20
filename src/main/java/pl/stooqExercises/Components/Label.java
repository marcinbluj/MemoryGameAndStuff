package pl.stooqExercises.Components;

import javax.swing.*;

public class Label extends JLabel {
    public Label(String text, int width, int height, int x, int y) {
        super(text);

        setSize(width, height);
        setLocation(x, y);
    }
}
