package pl.memoryGame.GameWindow;

import pl.memoryGame.GameBoard;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    GameBoard gameBoard;

    public GameWindow() throws HeadlessException {
        gameBoard = new GameBoard();

        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("MemoryGame");
        setVisible(true);

        addGameButtons();
        repaint();
    }

    public void addGameButtons() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < GameBoard.ARRAY_SIZE; i++) {

            for (int j = 0; j < GameBoard.ARRAY_SIZE; j++) {
                add(new GameButton(new Dimension(x, y), gameBoard.getMarkAt(i, j)));
                x += 75;
            }
            x = 0;
            y += 75;
        }
    }
}
