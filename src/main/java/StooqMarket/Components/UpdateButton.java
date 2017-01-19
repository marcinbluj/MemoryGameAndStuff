package StooqMarket.Components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class UpdateButton extends JButton implements MouseListener {
    private InputField inputField;
    private OutputArea outputAreaValue;
    private OutputArea outputAreaChange;
    private OutputArea outputAreaOpening;

    public UpdateButton(int width, int height, int x, int y, InputField inputField,
                        OutputArea outputAreaValue, OutputArea outputAreaChange, OutputArea outputAreaOpening) {
        this.inputField = inputField;
        this.outputAreaValue = outputAreaValue;
        this.outputAreaChange = outputAreaChange;
        this.outputAreaOpening = outputAreaOpening;

        addMouseListener(this);
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(0));
        setText("Update");
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String inputText = inputField.getText().toLowerCase().trim();

        Document doc;
        try {
            doc = Jsoup.connect(("http://stooq.pl/q/?s=" + inputText)).get();
            Element content = doc.getElementById("aq_" + inputText + "_c2");
            String value = content.text();

            Element contentChange1 = doc.getElementById("aq_" + inputText + "_m2");
            Element contentChange2 = doc.getElementById("aq_" + inputText + "_m3");
            String change1 = contentChange1.text();
            String change2 = contentChange2.text();

            Element contentOpening = doc.getElementById("aq_" + inputText + "_o");
            String opening = contentOpening.text();

            outputAreaValue.setText(value);
            outputAreaChange.setText(change1 + " " + change2);
            outputAreaOpening.setText(opening);

            ChartPanel.setImg(inputText);

            if (!outputAreaValue.getText().isEmpty()) {
                if (outputAreaValue.getText().charAt(0) == '+') {
                    outputAreaValue.setForeground(Color.green);
                } else if (outputAreaValue.getText().charAt(0) == '-') {
                    outputAreaValue.setForeground(Color.red);
                } else {
                    outputAreaValue.setForeground(Color.darkGray);
                }
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
