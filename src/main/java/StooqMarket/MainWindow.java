package StooqMarket;

import StooqMarket.Components.*;
import StooqMarket.Components.Label;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainWindow extends JFrame {

    private MainWindow() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(890, 390);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);


        InputField inputField = new InputField(150, 30, 5, 5);
        add(inputField);

        add(new Label("Kurs", 95, 20, 5, 45));
        OutputArea value = new OutputArea(95, 25, 5, 70);
        add(value);

        add(new Label("Zmiana", 95, 20, 109, 45));
        OutputArea change = new OutputArea(95, 25, 109, 70);
        add(change);

        add(new Label("Otwarcie", 95, 20, 213, 45));
        OutputArea opening = new OutputArea(95, 25, 213, 70);
        add(opening);

        try {
            ChartPanel chartPanel = new ChartPanel(320, 5, inputField);
            add(chartPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }


        CombBox combBox = new CombBox(150, 30, 5, 100, inputField, value, change, opening);
        add(combBox);

        UpdateButton updateButton = new UpdateButton(150, 30, 160, 5, inputField, value, change, opening);
        add(updateButton);


        repaint();
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
