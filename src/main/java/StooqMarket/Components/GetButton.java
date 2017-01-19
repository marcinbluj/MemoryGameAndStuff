package StooqMarket.Components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class GetButton extends JButton implements MouseListener {
    private InputField inputField;
    private OutputArea outputArea;
    private CombBox combBox;

    public GetButton(int width, int height, int x, int y, InputField inputField, OutputArea outputArea) {
        this.inputField = inputField;
        this.outputArea = outputArea;

        addMouseListener(this);
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(0));
        setText("GET");
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

        Document doc = null;
        try {
            doc = Jsoup.connect(("http://stooq.pl/q/?s=" + inputText)).get();
            Element content = doc.getElementById("aq_" + inputText + "_c2");
            String value = content.text();

            outputArea.setText(value);

            if (!outputArea.getText().isEmpty()) {
                if (outputArea.getText().charAt(0) == '+') {
                    outputArea.setForeground(Color.green);
                } else if (outputArea.getText().charAt(0) == '-') {
                    outputArea.setForeground(Color.red);
                } else {
                    outputArea.setForeground(Color.darkGray);
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
