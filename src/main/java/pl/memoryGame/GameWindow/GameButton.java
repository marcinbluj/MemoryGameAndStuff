package pl.memoryGame.GameWindow;

import pl.memoryGame.GameMarks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class GameButton extends JButton implements MouseListener {

    private static List<GameButton> buttonList = new ArrayList<>();
    private GameMarks mark;
    private int index;


    public GameButton(Dimension location, GameMarks mark) {

        this.mark = mark;

        addMouseListener(this);

        setSize(70, 70);
        setLocation(location.width, location.height);

        buttonList.add(this);
        index = buttonList.indexOf(this);
    }

    public List<GameButton> getButtonList(){
        return buttonList;
    }

    public GameMarks getMark(){
        return mark;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        mark.setState(true);
        setEnabled(false);
        setText(mark.toString());

//        if (buttonList.size()%2 == 0){
//            int indexOfLast = buttonList.size()-1;
//
//        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
