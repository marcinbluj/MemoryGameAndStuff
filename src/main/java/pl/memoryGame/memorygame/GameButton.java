package pl.memoryGame.memorygame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class GameButton extends JButton implements MouseListener {
    private GameMark mark;
    private static List<GameButton> pairsToCheck = new ArrayList<>(2);
    private static List<GameButton> pairs = new ArrayList<>();

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

        if (isEnabled() && !pairsToCheck.contains(this) && pairsToCheck.size() < 2) {
            mark.setFlag(true);
            updateMark();
            pairsToCheck.add(this);

            if (pairsToCheck.size()==2){

                if (pairsToCheck.get(0).getMark().getMark().equals(pairsToCheck.get(1).getMark().getMark())){
                    pairsToCheck.get(0).setEnabled(false);
                    pairsToCheck.get(1).setEnabled(false);
                    pairs.add(pairsToCheck.get(0));
                    pairs.add(pairsToCheck.get(1));
                    pairsToCheck.clear();

                } else {
                    pairsToCheck.get(0).getMark().setFlag(false);
                    pairsToCheck.get(0).updateMark();
                    pairsToCheck.get(1).getMark().setFlag(false);
                    pairsToCheck.get(1).updateMark();
                    pairsToCheck.clear();

                }
            }
        }

//        else if (isEnabled() && !pairsToCheck.contains(this) && pairsToCheck.size() == 2) {
//            if (pairsToCheck.get(0).getMark().getMark().equals(pairsToCheck.get(1).getMark().getMark())){
//                pairsToCheck.get(0).setEnabled(false);
//                pairsToCheck.get(0);
//                pairsToCheck.get(1).setEnabled(false);
//                pairsToCheck.get(1);
//                pairsToCheck.clear();
//                mark.setFlag(true);
//                pairsToCheck.add(this);
//                updateMark();
//            } else {
//                pairsToCheck.get(0).getMark().setFlag(false);
//                pairsToCheck.get(0).updateMark();
//                pairsToCheck.get(1).getMark().setFlag(false);
//                pairsToCheck.get(1).updateMark();
//                pairsToCheck.clear();
//                mark.setFlag(true);
//                pairsToCheck.add(this);
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
