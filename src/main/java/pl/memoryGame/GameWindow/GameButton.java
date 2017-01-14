package pl.memoryGame.GameWindow;

import pl.memoryGame.GameMarks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameButton extends JButton implements MouseListener {
    private static int counter;
    private static GameMarks[] currentMark = new GameMarks[2];

    private GameMarks mark;


    public GameButton(Dimension location, GameMarks mark) {

        addMouseListener(this);

        setSize(70,70);
        setLocation(location.width, location.height);

        counter = 0;
        this.mark = mark;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        counter++;
//        if (counter == 1 && mark.getMark().equals())
//        mark.setState(true);
//        currentMark[counter] = mark;
//
//        setText(mark.toString());
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
