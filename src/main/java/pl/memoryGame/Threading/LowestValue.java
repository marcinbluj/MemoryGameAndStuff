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

            System.out.println("i = "+i);
                threads[i] = new Thread(new Runnable() {
                    int i = getI();

                    @Override
                    public void run() {

                        System.out.println("i' = "+i);
                        double startValue = array.length * ((double)i / threadsNumber);

                        System.out.println("1. "+((double)i / threadsNumber));
                        double endValue = array.length * ((double)(i + 1) / threadsNumber);

                        System.out.println("starts with: "+i+": "+startValue);
                        System.out.println("ends with: "+i+": "+endValue);

                        for (int j = (int) startValue; j < (int) endValue; j++) {

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
        System.out.println((stop - start) / 1_000_000_000f + " s");

    }

    public int getI(){
        return i;
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

        List<int[]> list = new LowestValue(100_000_000, 200_000, 2).lowestValueThreading();
        System.out.println(list.get(0)[0]);
        System.out.println(list.get(0)[1]);
        System.out.println(list.get(1)[0]);
        System.out.println(list.get(1)[1]);

        System.out.println(list.size());

        long stop = System.nanoTime();
        System.out.println((stop - start) / 1000000000f + " s");

    }
}
