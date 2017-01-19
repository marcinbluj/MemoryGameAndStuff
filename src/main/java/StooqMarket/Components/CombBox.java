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
import java.util.ArrayList;
import java.util.List;

public class CombBox extends JComboBox implements ItemListener {
    private InputField inputField;
    private OutputArea outputArea;

    public CombBox(int width, int height, int x, int y, InputField inputField, OutputArea outputArea) {
        this.outputArea = outputArea;
        this.inputField = inputField;

        addItemListener(this);
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(1));

        List<String> values = new ArrayList<>();
        Document doc = null;
        try {
            doc = Jsoup.connect(("http://stooq.pl/t/?i=525")).get();

            for (int i = 0; i < 31; i++) {
                Element elements = doc.getElementById("r_" + i);
                String names = elements.getElementsByTag("a").text().toLowerCase();
                values.add(names);
                this.addItem(names);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        setOutputArea(this.getSelectedItem().toString());
    }

    private void setOutputArea(String inputText) {

        inputText = inputText.trim();
        Document doc = null;

        try {
            doc = Jsoup.connect(("http://stooq.pl/q/?s=" + inputText)).get();
            Element content = doc.getElementById("aq_" + inputText + "_c2");
            String value = content.text();

            inputField.setText(inputText);
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
}
