package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumTaskMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        SumTask sumTask = new SumTask(15);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(sumTask);
        System.out.println(future.get());
        executor.shutdown();
    }
}