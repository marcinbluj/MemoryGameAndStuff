package pl.memoryGame.java8;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Created by RENT on 2017-01-16.
 */
public class LambdaStuff {
    public static void main(String[] args) {

//        final int[] y = {0};
//
//        IntStream.range(0, 100).forEach(x -> y[0] += x);
//        System.out.println(y[0]);


        List<Person> personList;
        personList = new ArrayList<>();
        personList.add(new Person("Jan", "Kowalski", 1980));
        personList.add(new Person("Piotr", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Mickiewicz", 1960));
        personList.add(new Person("Łukasz", "Mickiewicz", 1960));
        personList.add(new Person("Adam", "Adamski", 1970));


//        personList.stream().filter(x -> x.getYear() < 1970).forEach(System.out::println);


//        List<String> stringList = personList.stream().map(x -> x.getName() + " " + x.getLastName()).collect(Collectors.toList());


//        personList.stream().map(x -> x.getName() + " " + x.getLastName()).forEach(System.out::println);


//        stringList.forEach(System.out::println);
//
//        List<String> collectList = personList.stream().map(x -> x.getLastName()).collect(Collectors.toList());
//
//        Set<String> collectSet = personList.stream().map(x -> x.getLastName()).collect(Collectors.toSet());


//        List<Integer> birthYears = personList.stream().map(x -> x.getYear()).collect(Collectors.toList());
//        IntSummaryStatistics intSummaryStatistics = personList.stream().mapToInt(x -> x.getYear()).summaryStatistics();
//
//        double average = intSummaryStatistics.getAverage();
//        System.out.println(average);


//        int numberToCheck = 17;
//        boolean isPrimeNumber = IntStream.range(2, numberToCheck).noneMatch(x -> numberToCheck % x == 0);
//        System.out.println(isPrimeNumber);


//        Map<Boolean, List<Person>> collect2 = personList.stream().collect(partitioningBy(x -> x.getYear() < 1980));
//
//        Map<Boolean, List<Person>> mapByA = personList.stream().collect(partitioningBy(x -> x.getName().startsWith("A")));
//
//        System.out.println(mapByA.get(true));
//        System.out.println(mapByA.get(false));


//        Map<String, List<Person>> groupedMap = personList.stream().collect(groupingBy(x -> x.getLastName()));
//
//        Set<String> lastNames = groupedMap.keySet();
//
//        for (String lastName :
//                lastNames) {
//            System.out.println(lastName);
//            List<Person> persons = groupedMap.get(lastName);
//            System.out.println(persons);
//        }


        String collect = personList.stream().map(x -> x.getName()).collect(joining("; ", "IMIONA ", " KONIEC"));
        System.out.println(collect);


    }
}
