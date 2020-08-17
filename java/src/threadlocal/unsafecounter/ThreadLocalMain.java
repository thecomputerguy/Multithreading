package threadlocal.unsafecounter;

public class ThreadLocalMain {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        UnsafeCounter usc = new UnsafeCounter();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        Thread.sleep(500);
                        usc.increment();
                        System.out.println(Thread.currentThread().getName() + " -> " + usc.getCounter());

                    } catch (Exception e) {

                    }
                }
            });
            thread.start();
            threads[i] = thread;

        }

        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }

        System.out.println("Final value " + usc.getCounter());
    }
}