package orderedprintingusingwaitnotify;

public class OrderedPrintingThread extends Thread {
    private String method;
    private OrderedPrinting orderedPrinting;

    public OrderedPrintingThread(OrderedPrinting orderedPrinting, String method) {
        this.orderedPrinting = orderedPrinting;
        this.method = method;
    }

    @Override
    public void run() {
        if ("first".equals(method)) {
            this.orderedPrinting.first();
        } else if ("second".equals(method)) {
            this.orderedPrinting.second();
        } else if ("third".equals(method)) {
            this.orderedPrinting.third();
        }
    }
}