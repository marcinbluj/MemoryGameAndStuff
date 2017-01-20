package pl.stooqExercises.Components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ChartPanel extends JPanel {
    private static BufferedImage img;

    public ChartPanel(int x, int y, InputField inputField) throws IOException {

        String inputText = inputField.getText().trim();

        setSize(560, 350);

        setLocation(x, y);

        Document doc = Jsoup.connect(("http://stooq.pl/q/?s=" + inputText)).get();

        Element content = doc.getElementById("aqi_mc");

        String img1 = content.getElementsByTag("img").attr("src");
        URL imgURL = new URL("http://stooq.pl/" + img1 + ".img".trim());

        img = ImageIO.read(imgURL);

    }

    static void setImg(String inputText) throws IOException {

        Document doc = Jsoup.connect(("http://stooq.pl/q/?s=" + inputText)).get();

        Element content = doc.getElementById("aqi_mc");

        String img1 = content.getElementsByTag("img").attr("src");
        URL imgURL = new URL("http://stooq.pl/" + img1 + ".img".trim());

        ChartPanel.img = ImageIO.read(imgURL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawImage(g2d);

        repaint();
    }

    private void drawImage(Graphics2D graphics2D) {

        graphics2D.drawImage(img, 0, 0, 560, 350, null);
    }
}
