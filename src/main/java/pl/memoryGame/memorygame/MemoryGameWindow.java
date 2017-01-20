package pl.memoryGame.memorygame;

import javax.swing.*;
import java.awt.*;

public class MemoryGameWindow extends JFrame {
    GameBoard board;

    public MemoryGameWindow() throws HeadlessException {
        board = new GameBoard();

        GridLayout layout = new GridLayout(4,4, 5, 5);
        setLayout(layout);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        for (int i = 0; i < GameBoard.board.length; i++) {
            for (int j = 0; j < GameBoard.board[i].length; j++) {
                add(new GameButton(GameBoard.board[i][j]));
            }
        }


        pack();
        setSize(600, 400);


        repaint();

    }

    public static void main(String[] args) {
        new MemoryGameWindow();
    }
}
