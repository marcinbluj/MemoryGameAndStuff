package pl.memoryGame.Calculator;

/**
 * Created by RENT on 2017-01-14.
 */
public class Add implements Action {


    @Override
    public double evaluate(double x, double y) {
        return x+y;
    }
}
