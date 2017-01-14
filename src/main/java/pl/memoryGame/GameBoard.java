package pl.memoryGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {
    private GameMarks[][] gameBoardArray;
    public static final int ARRAY_SIZE = 4;
    private List<GameMarks> marksToFillGameBoard;

    public GameBoard() {
        gameBoardArray = new GameMarks[ARRAY_SIZE][ARRAY_SIZE];

        marksToFillGameBoard = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            marksToFillGameBoard.add(GameMarks.GAME_MARK_A);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_B);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_C);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_D);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_E);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_F);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_G);
            marksToFillGameBoard.add(GameMarks.GAME_MARK_H);
        }

        fillGameBoard();
    }

    private void fillGameBoard(){
        for (int i = 0; i < gameBoardArray.length; i++) {

            System.out.println("\n");

            for (int j = 0; j < gameBoardArray[i].length; j++) {
                int index = new Random().nextInt(marksToFillGameBoard.size());
                gameBoardArray[i][j] = marksToFillGameBoard.get(index);
                marksToFillGameBoard.remove(index);

                System.out.print(gameBoardArray[i][j]+" ");

            }
        }
    }

    public GameMarks getMarkAt(int x, int y){
        return gameBoardArray[x][y];
    }
}
