package future.executionexception;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureWithException {
    // Fixed thread pool with one thread only
    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        runTask();
        executorService.shutdown();

    }

    public static void runTask() {

        Callable<Void> callable = new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                throw new RuntimeException("Not useful callable at all.");
            }
        };

        Future<Void> future = executorService.submit(callable);

        try {
            future.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Exception : " + e.getMessage());
        }

    }
}