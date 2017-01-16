package pl.memoryGame.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by RENT on 2017-01-16.
 */
public class Streams {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(9);
        integers.add(3);
        integers.add(6);
        integers.add(5);
        integers.add(14);
        integers.add(2);

//        integers.stream().filter(x -> x < 10).forEach(x -> System.out.println(x));
//
//        integers.stream().map(x -> "liczba "+ x).forEach(System.out::println);
//
//        boolean b = integers.stream().anyMatch(x -> x == 9);

        IntStream.range(0,100).filter(x-> x%2 == 0).forEach(System.out::println);
        List<Integer> collect = IntStream.range(0, 100).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());

//        integers.stream().filter(x -> x < 10).forEach(System.out::println);

//        integers.forEach(x -> System.out.println(x));

//        for (int i = 0; i < integers.size(); i++) {
//            if (integers.get(i) > 10) {
//                integers.remove(i);
//            }
//        }
//
//
//
//        for (Integer integer : integers) {
//            if (integer < 10) {
//                System.out.println(integer);
//            }
//        }


    }
}
