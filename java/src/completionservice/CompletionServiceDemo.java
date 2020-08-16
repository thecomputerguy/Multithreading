package completionservice;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceDemo {
    static private Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        completionServiceExample();
    }

    static private void completionServiceExample() throws InterruptedException, ExecutionException {

        class TrivialTask implements Runnable {

            private int n;

            public TrivialTask(int n) {
                this.n = n;
            }

            @Override
            public void run() {

                try {
                    Thread.sleep(random.nextInt(101));
                    System.out.println(n * n);
                } catch (Exception e) {

                }
            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);

        // submit 10 trivial tasks
        for (int i = 0; i < 10; i++) {
            executorCompletionService.submit(new TrivialTask(i), Integer.valueOf(i));
        }

        int count = 10;
        while (count != 0) {
            Future<Integer> future = executorCompletionService.poll();
            if (future != null) {
                System.out.println("Thread " + future.get() + "got complete");
                count--;
            }
        }
        executorService.shutdown();
    }
}