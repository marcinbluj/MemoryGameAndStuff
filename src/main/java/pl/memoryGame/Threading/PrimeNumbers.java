package pl.memoryGame.Threading;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    private int range;

    public PrimeNumbers(int range) {
        this.range = range;
    }

    public List<Integer> primeNumbersList() {
        List<Integer> list = new ArrayList<>();
        boolean flag;

        for (int i = 2; i <= range; i++) {
            flag = false;

            for (int j = 0; j < list.size() && list.get(j) <= Math.sqrt(i); j++) {
                if (i % list.get(j) == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
//                System.out.println(i);
            }
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {

        List<Integer> primes;

        PrimeNumbers primeNumbers = new PrimeNumbers(5_000_000);

        long start = System.nanoTime();
        primes = primeNumbers.primeNumbersList();
        System.out.println(primes);
        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000000f + " s");
        System.out.println(primes.size());

        for (int i = 0; i < 10; i++) {
            System.out.println(primes.get(i));
        }

    }
}
