package threadlocal.safecounter;

public class ThreadLocalMain {
    public static void main(String[] args) throws InterruptedException {
        SafeCounterWithThreadLocal sc = new SafeCounterWithThreadLocal();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    sc.increment();
                    System.out.println(Thread.currentThread().getName() + " -> " + sc.getCount());
                }
            });

            thread.start();
            threads[i] = thread;
        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println("Final value of counter in main thread " + sc.getCount());
    }
}