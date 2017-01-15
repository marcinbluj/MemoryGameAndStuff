package pl.memoryGame.Threading;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LowestValue {
    int[] array;
    int lowestValue = Integer.MAX_VALUE;
    int i = 0;

    public LowestValue(int[] array) {
        this.array = array;
    }

    public LowestValue(int length, int maxNumber, int threadsNumber) throws InterruptedException {
        array = new int[length];

        Thread[] threads = new Thread[threadsNumber];

        while (i < threadsNumber) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        for (int j = (array.length / threadsNumber) * i; j < (((array.length / threadsNumber) * (i + 1)) - 1); j++) {
                            array[j] = new Random().nextInt(maxNumber) + 1;
                        }
                    }
                });
            i = i + 1;
        }

        long start = System.nanoTime();

        for (int j = 0; j < threads.length; j++) {
            threads[j].start();
        }
        for (int j = 0; j < threads.length; j++) {
            threads[j].join();
        }

        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000000f + " s");

    }

    public List<int[]> lowestValue() {

        int lowestValue = Integer.MAX_VALUE;
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

    public List<int[]> lowestValueThreading() throws InterruptedException {

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

        System.out.println(new LowestValue(100_000_000, 200_000, 2).lowestValueThreading().size());

        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000000f + " s");

    }
}
