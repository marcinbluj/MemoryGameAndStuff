package pl.memoryGame;

/**
 * Created by RENT on 2017-01-14.
 */
public enum GameMarks {
    GAME_MARK_A("A", false),
    GAME_MARK_B("B", false),
    GAME_MARK_C("C", false),
    GAME_MARK_D("D", false),
    GAME_MARK_E("E", false),
    GAME_MARK_F("F", false),
    GAME_MARK_G("G", false),
    GAME_MARK_H("H", false);

    String mark;
    boolean state;

    GameMarks(String mark, boolean state) {
        this.mark = mark;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public String getMark() {
        return mark;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return (state) ? this.mark : "";
    }
}
