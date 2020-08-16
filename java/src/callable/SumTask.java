package callable;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Integer> {

    private int n;

    public SumTask(int n) {
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {

        if (n <= 0)
            return 0;
        int sum = 0;
        for (int i = 1; i <= this.n; i++) {
            sum += i;
        }
        return sum;
    }
}