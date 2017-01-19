package StooqMarket;

import StooqMarket.Components.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {

        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


        InputField inputField = new InputField(150, 30, 5,5);
        add(inputField);

        OutputArea value = new OutputArea(95, 25, 5,70);
        add(value);

        OutputArea change = new OutputArea(95, 25, 109,70);
        add(change);

        OutputArea opening = new OutputArea(95, 25, 213,70);
        add(opening);

        CombBox combBox = new CombBox(150, 30, 5, 100, inputField, value);
        add(combBox);

        GetButton getButton = new GetButton(150,30,160,5, inputField, value);
        add(getButton);


        repaint();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
