package orderedprintingusingcountdownlatch;

public class OrderedPrintingThread extends Thread {

    String method;
    OrderedPrinting orderedPrinting;

    public OrderedPrintingThread(OrderedPrinting orderedPrinting, String method) {
        this.orderedPrinting = orderedPrinting;
        this.method = method;
    }

    @Override
    public void run() {
        if ("first".equals(method)) {
            this.orderedPrinting.first();
        } else if ("second".equals(method)) {
            try {
                this.orderedPrinting.second();
            } catch (InterruptedException ex) {

            }

        } else if ("third".equals(method)) {
            try {
                this.orderedPrinting.third();
            } catch (InterruptedException ex) {

            }
        }
    }
}