package pl.memoryGame.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by RENT on 2017-01-16.
 */
public class SumOfInts {
    public static void main(String[] args) {
        final int[] y = {0};

        IntStream.range(0,100).forEach(x-> y[0] +=x);
        System.out.println(y[0]);

        List<Person> personList;
        personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1960));
        personList.add(new Person("Łukasz", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Adamski", 1970));

        personList.stream().filter(x -> x.getYear() < 1970).forEach(x-> System.out.println(x));
    }
}
