package orderedprintingusingcountdownlatch;

import java.util.concurrent.CountDownLatch;

public class OrderedPrinting {
    CountDownLatch latch1;
    CountDownLatch latch2;

    public OrderedPrinting(CountDownLatch latch1, CountDownLatch latch2) {
        this.latch1 = latch1;
        this.latch2 = latch2;
    }

    public void first() {
        System.out.println("First");
        latch1.countDown();
    }

    public void second() throws InterruptedException {
        this.latch1.await();
        System.out.println("Second");
        this.latch2.countDown();
    }

    public void third() throws InterruptedException {
        this.latch2.await();
        System.out.println("Third");
    }
}