package orderedprintingusingwaitnotify;

public class OrderedPrinting {

    int count = 0;

    public OrderedPrinting() {
        this.count = 1;
    }

    public void first() {
        synchronized (this) {
            System.out.println("first");
            this.count++;
            this.notifyAll();
        }
    }

    public void second() {
        synchronized (this) {
            while (this.count != 2) {
                try {

                    this.wait();
                } catch (InterruptedException ex) {
                    // handle exception properly.
                }
            }
            System.out.println("second");
            this.count++;
            this.notifyAll();
        }
    }

    public void third() {
        synchronized (this) {
            while (this.count != 3) {
                try {

                    this.wait();
                } catch (InterruptedException ex) {
                    // handle exception properly
                }
            }
            System.out.println("Third");
        }
    }
}