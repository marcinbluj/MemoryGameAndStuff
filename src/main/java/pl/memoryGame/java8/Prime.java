package pl.memoryGame.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by RENT on 2017-01-17.
 */
public class Prime {

    public static List<Integer> getAllPrimeNumbersLessThan(int number){

        return IntStream.range(2, number).parallel().filter(x -> IntStream.range(2, (int) Math.sqrt(x) + 1)
                .noneMatch(y -> x % y == 0)).boxed().collect(Collectors.toList());
    }

    public static IntStream getAllPrimeNumbersLessThanIntStream(int number){

        return IntStream.range(2, number).parallel().filter(x -> IntStream.range(2, (int) Math.sqrt(x) + 1)
                .noneMatch(y -> x % y == 0));
    }
}
