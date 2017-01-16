package pl.memoryGame.Threading;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading3 {

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sum(20_000_000_000L);
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                sum(40_000_000_000L);
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        Thread thread7 = new Thread(runnable);
        Thread thread8 = new Thread(runnable);
        Thread thread9 = new Thread(runnable2);

        long start = System.nanoTime();
        thread1.start();
        thread2.start();



        thread1.join();
        thread2.join();


        long end = System.nanoTime();


        double duration = (end - start) / 1_000_000_000d;
        System.out.println(duration);

        long start2 = System.nanoTime();
        thread9.start();

        thread9.join();
        long end2 = System.nanoTime();


        double duration2 = (end2 - start2) / 1_000_000_000d;
        System.out.println(duration2);
    }

    public static long sum(long x) {
        long sum = 0;
        for (long i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}
