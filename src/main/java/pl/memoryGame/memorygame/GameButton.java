package pl.memoryGame.memorygame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class GameButton extends JButton implements MouseListener {
    private GameMark mark;
    private static List<GameButton> pairs = new ArrayList<>(2);

    public GameButton(GameMark mark) {
        addMouseListener(this);
        this.mark = mark;

        setText(this.mark.toString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (isEnabled() && !pairs.contains(this) && pairs.size() < 2) {
            mark.setFlag(true);
            updateMark();
            pairs.add(this);

            if (pairs.size()==2){

                if (pairs.get(0).getMark().getMark().equals(pairs.get(1).getMark().getMark())){
                    pairs.get(0).setEnabled(false);
                    pairs.get(1).setEnabled(false);
                    pairs.clear();

                } else {
                    pairs.get(0).getMark().setFlag(false);
                    pairs.get(0).updateMark();
                    pairs.get(1).getMark().setFlag(false);
                    pairs.get(1).updateMark();
                    pairs.clear();

                }
            }
        }

//        else if (isEnabled() && !pairs.contains(this) && pairs.size() == 2) {
//            if (pairs.get(0).getMark().getMark().equals(pairs.get(1).getMark().getMark())){
//                pairs.get(0).setEnabled(false);
//                pairs.get(0);
//                pairs.get(1).setEnabled(false);
//                pairs.get(1);
//                pairs.clear();
//                mark.setFlag(true);
//                pairs.add(this);
//                updateMark();
//            } else {
//                pairs.get(0).getMark().setFlag(false);
//                pairs.get(0).updateMark();
//                pairs.get(1).getMark().setFlag(false);
//                pairs.get(1).updateMark();
//                pairs.clear();
//                mark.setFlag(true);
//                pairs.add(this);
//                updateMark();
//            }
//        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void updateMark() {
        setText(mark.toString());
    }

    public GameMark getMark() {
        return mark;
    }

}
