package pl.memoryGame.Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LowestValue {
    private int[] array;
    private int lowestValue = Integer.MAX_VALUE;
    private int i = 0;

    private LowestValue(int length, int maxNumber, int threadsNumber) throws InterruptedException {
        array = new int[length];

        Thread[] threads = new Thread[threadsNumber];

        while (i < threadsNumber) {

            threads[i] = new Thread(new Runnable() {

                int i = getI();

                @Override
                public void run() {

                    double startValue = array.length * ((double) i / threadsNumber);

                    double endValue = array.length * ((double) (i + 1) / threadsNumber);

                    System.out.println("starts with: " + i + ": " + startValue);
                    System.out.println("ends with: " + i + ": " + endValue);

                    for (int j = (int) startValue; j < (int) endValue; j++) {

                        array[j] = new Random().nextInt(maxNumber) + 1;
//                        array[j] = j;
                    }
                }
            });

            i = i + 1;
        }

        long start = System.nanoTime();

        for (Thread threadStart : threads) {

            threadStart.start();
        }
        for (Thread threadJoin : threads) {

            threadJoin.join();
        }

        long stop = System.nanoTime();

        System.out.println((stop - start) / 1_000_000_000f + " s");

    }

    public int getI() {
        return i;
    }

    private List<int[]> lowestValueThreading() throws InterruptedException {

        List<int[]> lowestValueWithIndex = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {

            if (array[i] < lowestValue) {

                lowestValue = array[i];
                lowestValueWithIndex.clear();
                lowestValueWithIndex.add(new int[]{i, lowestValue});
            } else if (array[i] == lowestValue) {

                lowestValueWithIndex.add(new int[]{i, lowestValue});
            }
        }

        return lowestValueWithIndex;
    }

    public static void main(String[] args) throws InterruptedException {

        long start = System.nanoTime();

        List<int[]> list = new LowestValue(200_000_000, 200_000, 4).lowestValueThreading();
        System.out.println("index: "+list.get(0)[0]);
        System.out.println("value: "+list.get(0)[1]);

        System.out.println("size: "+list.size());

        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000000f + " s");

    }
}
