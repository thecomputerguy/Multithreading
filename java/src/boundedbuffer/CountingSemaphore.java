package boundedbuffer;

public class CountingSemaphore {

    private int usedPermits = 0;
    private int maxCount;

    public CountingSemaphore(int count) {
        this.maxCount = count;
    }

    public CountingSemaphore(int count, int initialPermits) {
        this.maxCount = count;
        this.usedPermits = this.maxCount - initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {

        while (this.usedPermits == this.maxCount) {
            this.wait();
        }
        this.usedPermits++;
        this.notifyAll();
    }

    public synchronized void release() throws InterruptedException {

        while (this.usedPermits == 0) {
            this.wait();
        }

        this.usedPermits--;
        this.notifyAll();
    }

}