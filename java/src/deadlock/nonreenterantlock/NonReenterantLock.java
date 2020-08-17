package deadlock.nonreenterantlock;

public class NonReenterantLock {

    private boolean isLocked;

    public NonReenterantLock() {
        this.isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            this.wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        this.notifyAll();
    }
}