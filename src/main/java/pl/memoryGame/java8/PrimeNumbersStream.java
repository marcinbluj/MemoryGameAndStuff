package pl.memoryGame.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumbersStream {
    public static void main(String[] args) {

        List<Integer> primeList = new ArrayList<>(41538);
        final boolean[] flag = new boolean[1];

        long start = System.nanoTime();


        primeList.add(2);

        IntStream.range(3, 500_000).filter(x ->
                IntStream.range(0, primeList.size())
                        .filter(y -> primeList.get(y) <= Math.sqrt(x))
                        .noneMatch(y -> x % primeList.get(y) == 0))
                .forEach(primeList::add);


//        List<Integer> primaryNumbers = new ArrayList<>();
//        List<Integer> collect = IntStream.range(2, 5_000_000).parallel().filter(x -> IntStream.range(2, (int) Math.sqrt(x) + 1)
//                .noneMatch(y -> x % y == 0)).boxed().collect(Collectors.toList());


//        IntStream.range(2, 5_000_000).filter(x -> !IntStream.range(0, primaryNumbers.size())
//                .anyMatch(y -> x % primaryNumbers.get(y) == 0))
//                .forEach(primaryNumbers::add);

        long stop = System.nanoTime();

        System.out.println((stop - start) / 1000000000f + " s");
        System.out.println(primeList.size());
        System.out.println(primeList.get(0));
    }
}
