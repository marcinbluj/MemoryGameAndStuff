package pl.memoryGame.Threading;


public class PleaseWait {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; true; i++) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        break;
                    }
                    if (i % 4 == 0) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n-");
                    } else if (i % 4 == 1) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\\");
                    } else if (i % 4 == 2) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n|");
                    } else {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n/");
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

        long sum = sum(10_000_000_000L);
        System.out.println("\nSuma: " + sum);

        thread.interrupt();
    }

    public static long sum(long x) {
        long sum = 0;
        for (long i = 1; i <= x; i++) {
            sum += i;
        }
        return sum;
    }
}