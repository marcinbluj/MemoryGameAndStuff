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

        OutputArea outputArea = new OutputArea(305, 55, 5,40);
        add(outputArea);

        CombBox combBox = new CombBox(150, 30, 5, 100, inputField, outputArea);
        add(combBox);

        GetButton getButton = new GetButton(150,30,160,5, inputField, outputArea, combBox);
        add(getButton);


        repaint();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
