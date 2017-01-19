package StooqMarket.Components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RefreshTableButton extends JButton implements MouseListener {
    private Table table;
    private static String[][] data;

    public RefreshTableButton(int width, int height, int x, int y, Table table) {
        addMouseListener(this);
        this.table = table;

        setText("Refresh table");
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(0));
        refresh();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        refresh();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void refresh(){

        List<String> markList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();

        Document doc;
        try {
            doc = Jsoup.connect(("http://stooq.pl/t/?i=525")).get();

            for (int i = 0; i < 31; i++) {
                Element elements = doc.getElementById("r_" + i);
                String names = elements.getElementsByTag("a").text().toLowerCase().trim();
                Elements mark = elements.getElementsByAttributeValue("href", "q/?s=" + names);
                markList.add(mark.text());

                Element name = elements.getElementById("f10");
                nameList.add(name.text());

                Element value = elements.getElementById("aq_" + names + "_c2");
                valueList.add(value.text());


            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        data = new String[markList.size()][3];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                switch (j) {
                    case 0:
                        data[i][j] = markList.get(i);
                        break;
                    case 1:
                        data[i][j] = nameList.get(i);
                        break;
                    case 2:
                        data[i][j] = valueList.get(i);
                        break;
                    default:
                        break;
                }
            }
        }

        table.setData(data);
    }
}
