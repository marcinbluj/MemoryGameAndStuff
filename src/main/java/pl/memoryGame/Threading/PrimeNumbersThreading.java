package pl.memoryGame.Threading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeNumbersThreading {

    public static List<Integer> primeNumbersList(int range){
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= range; i++) {
            boolean flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j == 0){
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
                System.out.println(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<Integer> primes;
        long start = System.nanoTime();
        primes = primeNumbersList(500000);
        System.out.println(primes);
        long stop = System.nanoTime();
        System.out.println((stop-start)/1000000000f+" s");
        System.out.println(primes.size());
    }
}
