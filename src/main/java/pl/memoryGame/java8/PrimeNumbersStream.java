package pl.memoryGame.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumbersStream {
    public static void main(String[] args) {

        List<Integer> primeList = new ArrayList<>();
        final boolean[] flag = new boolean[1];

        long start = System.nanoTime();


        IntStream.range(2, 5_000_000).forEach(x -> {
            flag[0] = false;

            IntStream.range(0, primeList.size()).filter(y -> primeList.get(y) <= Math.sqrt(x) && !flag[0]).forEach(y -> {
                if (x % primeList.get(y) == 0) {
                    flag[0] = true;
                }
            });

            if (!flag[0]) {
                primeList.add(x);
                System.out.println(x);
            }
        });


        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000000f + " s");
        System.out.println(primeList.size());
    }
}
