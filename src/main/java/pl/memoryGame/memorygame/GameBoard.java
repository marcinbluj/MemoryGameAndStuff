package pl.memoryGame.memorygame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {

    public static GameMark[][] board = new GameMark[4][4];

    public GameBoard() {
        randomlyFillBoard();
    }

    public static void randomlyFillBoard(){

        List<GameMark> gameMarks = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            gameMarks.add(GameMark.A);
            gameMarks.add(GameMark.B);
            gameMarks.add(GameMark.C);
            gameMarks.add(GameMark.D);
            gameMarks.add(GameMark.E);
            gameMarks.add(GameMark.F);
            gameMarks.add(GameMark.G);
            gameMarks.add(GameMark.H);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                int random = new Random().nextInt(gameMarks.size());
                board[i][j] = gameMarks.get(random);
                gameMarks.remove(random);
            }
        }
    }
}
