package printnumberseries;

import java.util.concurrent.Semaphore;

public class PrintNumberSeries {
    private int n;
    private Semaphore semaphore1;
    private Semaphore semaphore2;
    private Semaphore semaphore3;

    public PrintNumberSeries(int n) {
        this.n = n;
        this.semaphore1 = new Semaphore(1);
        this.semaphore2 = new Semaphore(0);
        this.semaphore3 = new Semaphore(0);
    }

    public void printZero() throws InterruptedException {
        for (int i = 0; i < this.n; i++) {

            this.semaphore1.acquire();
            System.out.println("0");
            ((i % 2 == 0) ? this.semaphore2 : this.semaphore3).release();
        }

    }

    public void printOdd() throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            this.semaphore2.acquire();
            System.out.println(i);
            this.semaphore1.release();
        }
    }

    public void printEven() throws InterruptedException {
        for (int i = 2; i < n; i = i + 2) {
            this.semaphore3.acquire();
            System.out.println(i);
            this.semaphore1.release();
        }
    }
}