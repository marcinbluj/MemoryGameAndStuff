package StooqMarket.Components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by RENT on 2017-01-18.
 */
public class CombBox extends JComboBox implements ItemListener{

    public CombBox(int width, int height, int x, int y) {
        addItemListener(this);
        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(1));
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        e.getItem().toString();

        System.out.println("a");
    }
}
