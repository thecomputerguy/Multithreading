package deadlock.nonreenterantlock;

public class NonReenterantLockMain {

    public static void main(String[] args) throws InterruptedException {
        NonReenterantLock nreLock = new NonReenterantLock();

        nreLock.lock();
        System.out.println("Acquired lock first time");
        Thread.sleep(200);
        System.out.println("Trying to acquire lock for second time.");
        nreLock.lock();
        System.out.println("Acquired lock for second time.");
    }
}