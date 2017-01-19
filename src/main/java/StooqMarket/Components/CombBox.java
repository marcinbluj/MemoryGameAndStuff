package StooqMarket.Components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class CombBox extends JComboBox implements ItemListener {
    private InputField inputField;
    private OutputArea outputAreaValue;
    private OutputArea outputAreaChange;
    private OutputArea outputAreaOpening;

    public CombBox(int width, int height, int x, int y, InputField inputField,
                   OutputArea outputAreaValue, OutputArea outputAreaChange, OutputArea outputAreaOpening) {

        this.outputAreaValue = outputAreaValue;
        this.outputAreaChange = outputAreaChange;
        this.outputAreaOpening = outputAreaOpening;
        this.inputField = inputField;

        addItemListener(this);
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(1));

        Document doc;

        try {
            doc = Jsoup.connect(("http://stooq.pl/t/?i=525")).get();

            for (int i = 0; i < 31; i++) {
                Element elements = doc.getElementById("r_" + i);
                String names = elements.getElementsByTag("a").text().toLowerCase();
                this.addItem(names);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        setOutputAreas(this.getSelectedItem().toString());
    }

    private void setOutputAreas(String inputText) {

        inputText = inputText.trim();
        Document doc;

        try {
            doc = Jsoup.connect(("http://stooq.pl/q/?s=" + inputText)).get();
            Element contentValue = doc.getElementById("aq_" + inputText + "_c2");
            String value = contentValue.text();

            Element contentChange1 = doc.getElementById("aq_" + inputText + "_m2");
            Element contentChange2 = doc.getElementById("aq_" + inputText + "_m3");
            String change1 = contentChange1.text();
            String change2 = contentChange2.text();

            Element contentOpening = doc.getElementById("aq_" + inputText + "_o");
            String opening = contentOpening.text();

            inputField.setText(inputText);
            outputAreaValue.setText(value);
            outputAreaChange.setText(change1 + " " + change2);
            outputAreaOpening.setText(opening);

            if (!outputAreaChange.getText().isEmpty()) {
                if (outputAreaChange.getText().trim().charAt(0) == '+') {
                    outputAreaChange.setForeground(Color.green);
                } else if (outputAreaChange.getText().trim().charAt(0) == '-') {
                    outputAreaChange.setForeground(Color.red);
                } else {
                    outputAreaChange.setForeground(Color.gray);
                }
            }

            ChartPanel.setImg(inputText);

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
