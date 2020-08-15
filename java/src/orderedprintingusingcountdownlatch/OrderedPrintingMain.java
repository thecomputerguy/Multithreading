package orderedprintingusingcountdownlatch;

import java.util.concurrent.CountDownLatch;

public class OrderedPrintingMain {

    public static void main(String[] args) {
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        OrderedPrinting orderedPrinting = new OrderedPrinting(latch1, latch2);
        OrderedPrintingThread thread1 = new OrderedPrintingThread(orderedPrinting, "first");
        OrderedPrintingThread thread2 = new OrderedPrintingThread(orderedPrinting, "second");
        OrderedPrintingThread thread3 = new OrderedPrintingThread(orderedPrinting, "third");
        System.out.println("Starting threads for ordered printing with count down latch.");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}