package pl.memoryGame.Threading;

/**
 * Created by RENT on 2017-01-14.
 */
public class Threading {
    public static void main(String[] args) {

        Runnable runnable = new MyThread();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 100000; i < 110000; i++) {
                    System.out.println(i);
                }
            }
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);

        System.out.println("Przed wywołaniem");
        thread.start();
        thread1.start();
        System.out.println("Po wywołaniu");

        Thread thread2 = new MyThread2();
        thread2.start();
    }
}
