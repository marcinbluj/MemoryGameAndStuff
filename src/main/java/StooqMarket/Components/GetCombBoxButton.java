package StooqMarket.Components;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by RENT on 2017-01-18.
 */
public class GetCombBoxButton extends JComboBox implements MouseListener{
    private InputField inputField;
    private OutputArea outputArea;
    private CombBox combBox;

    public GetCombBoxButton(int width, int height, int x, int y, InputField inputField, OutputArea outputArea, CombBox combBox) {
        this.inputField = inputField;
        this.outputArea = outputArea;
        this.combBox = combBox;

        setSize(width, height);
        setLocation(x, y);
        setBorder(new BevelBorder(0));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        combBox.getSelectedItem();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
