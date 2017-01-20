package pl.memoryGame.memorygame;

public enum GameMark {

    A("[A]",false),
    B("[B]",false),
    C("[C]",false),
    D("[D]",false),
    E("[E]",false),
    F("[F]",false),
    G("[G]",false),
    H("[H]",false);


    private String mark;
    private boolean flag;

    GameMark(String mark, boolean flag) {
        this.mark = mark;
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMark() {
        return mark;
    }

    public boolean isFlag() {
        return flag;
    }

    public void changeFlag() {
        flag = !flag;
    }

    @Override
    public String toString() {
        return flag ? mark : "[ ]";
    }
}
