package future.sumofnnumbers;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureMain {
    static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int result = sumTask(15);
        System.out.println(result);
        executorService.shutdown();
    }

    public static int sumTask(final int n) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {

            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        Future<Integer> future = executorService.submit(callable);
        return future.get();
    }
}