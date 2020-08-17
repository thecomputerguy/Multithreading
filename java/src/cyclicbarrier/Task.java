package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task implements Runnable {

    private CyclicBarrier cyclicbarrier;

    public Task(CyclicBarrier cyclicBarrier) {
        this.cyclicbarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is waiting on barrier");
            cyclicbarrier.await();
            System.out.println("Thread " + Thread.currentThread().getName() + " has crossed the barrier ");
        } catch (InterruptedException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BrokenBarrierException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}