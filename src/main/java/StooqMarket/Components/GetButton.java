package StooqMarket.Components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by RENT on 2017-01-18.
 */
public class GetButton extends JButton implements MouseListener {
    private InputField inputField;
    private OutputArea outputArea;
    private CombBox combBox;

    public GetButton(int width, int height, int x, int y, InputField inputField, OutputArea outputArea, CombBox combBox) {
        this.inputField = inputField;
        this.outputArea = outputArea;
        this.combBox = combBox;

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
        String inputText = inputField.getText().toLowerCase();
        StringBuilder builder = new StringBuilder();

        try {
            URL stream = new URL("http://stooq.pl/q/?s=^" + inputText);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(stream.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                builder.append(inputLine);
            in.close();

            String urlText = builder.toString();

            int indexStart = urlText.lastIndexOf(inputText + "_c2>") + inputText.length() + 4;

            String rawNumber = urlText.subSequence(indexStart, indexStart + 20).toString();

            int indexEnd = rawNumber.indexOf("<");

            String value = rawNumber.substring(0, indexEnd);

            outputArea.setText(value);

            boolean flag = false;
            for (int i = 0; i < combBox.getItemCount(); i++) {
                if(combBox.getItemAt(i).equals(inputText)){
                    flag = true;
                }
            }
            if (!flag) {
                combBox.addItem(inputText);
                flag = false;
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
