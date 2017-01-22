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

    GameButton(GameMark mark) {
        addMouseListener(this);
        this.mark = mark;

        setText(this.mark.toString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (isEnabled() && !pairsToCheck.contains(this) && pairsToCheck.size() < 2) {
            mark.setFlag(true);
            updateMark();
            pairsToCheck.add(this);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        check();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void updateMark() {
        setText(mark.toString());
    }

    private GameMark getMark() {
        return mark;
    }

    private void check(){
        if (pairsToCheck.size() == 2) {

            if (pairsToCheck.get(0).getMark().getMark().equals(pairsToCheck.get(1).getMark().getMark())) {
                pairsToCheck.get(0).setEnabled(false);
                pairsToCheck.get(1).setEnabled(false);
                pairs.add(pairsToCheck.get(0));
                pairs.add(pairsToCheck.get(1));

            } else {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                pairsToCheck.get(0).getMark().setFlag(false);
                pairsToCheck.get(0).updateMark();
                pairsToCheck.get(1).getMark().setFlag(false);
                pairsToCheck.get(1).updateMark();

            }
            pairsToCheck.clear();
            if (pairs.size()==16){
                GameBoard.randomlyFillBoard();
                for (int i = 0; i < pairs.size(); i++) {
                    pairs.get(i).getMark().setFlag(false);
                    pairs.get(i).setEnabled(true);
                    pairs.get(i).updateMark();
                }
                pairs.clear();
            }
        }
    }
}
