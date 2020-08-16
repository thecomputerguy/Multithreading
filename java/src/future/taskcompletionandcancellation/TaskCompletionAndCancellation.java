package future.taskcompletionandcancellation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskCompletionAndCancellation {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        int result = pollingAndCancellationOfTask(15);
        System.out.println(result);
        executorService.shutdown();
    }

    private static Integer pollingAndCancellationOfTask(final int n) {

        int result = -1;
        Callable<Integer> sumTask = new Callable<>() {

            public Integer call() throws Exception {
                int sum = 0;
                Thread.sleep(50);
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        Callable<Void> uselessTask = new Callable<Void>() {

            @Override
            public Void call() throws Exception {
                Thread.sleep(1000 * 3600);
                return null;
            }
        };

        Future<Integer> future1 = executorService.submit(sumTask);
        Future<Void> future2 = executorService.submit(uselessTask);

        try {
            future2.cancel(true);
            while (!future1.isDone()) {
                System.out.println("Waiting for task 1 to finish.");
            }
            result = future1.get();
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Something went wrong.");
        }
        System.out.println(" Is second task cancelled " + future2.isCancelled());
        return result;
    }
}