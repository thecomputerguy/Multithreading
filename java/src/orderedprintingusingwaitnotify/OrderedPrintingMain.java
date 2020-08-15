package orderedprintingusingwaitnotify;

public class OrderedPrintingMain {

    public static void main(String[] args) {
        OrderedPrinting orderedPrinting = new OrderedPrinting();
        OrderedPrintingThread thread1 = new OrderedPrintingThread(orderedPrinting, "first");
        OrderedPrintingThread thread2 = new OrderedPrintingThread(orderedPrinting, "second");
        OrderedPrintingThread thread3 = new OrderedPrintingThread(orderedPrinting, "third");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}