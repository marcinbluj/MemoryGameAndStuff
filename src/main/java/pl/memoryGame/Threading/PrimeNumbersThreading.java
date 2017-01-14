package pl.memoryGame.Threading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-01-14.
 */
public class PrimeNumbersThreading {

    public static List<Integer> primeNumbersList(int range){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= range; i++) {
            boolean flag = false;
            for (int j = 2; j < i-1; i++) {
                if (i%j == 0){
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(primeNumbersList(50));
    }
}
