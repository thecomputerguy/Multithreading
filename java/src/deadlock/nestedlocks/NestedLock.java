package deadlock.nestedlocks;

public class NestedLock {
    private int count;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void increment() {
        synchronized (lock1) {
            System.out.println("Lock1 is acquired");
            try {

                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            synchronized (lock2) {
                this.count++;
                System.out.println(this.count);
            }
        }
    }

    public void decrement() {

        synchronized (lock2) {
            System.out.println("Lock2 is acquired");
            try {

                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
            synchronized (lock1) {
                this.count--;
                System.out.println(this.count);
            }
        }
    }

    public static void runTests() throws InterruptedException {
        NestedLock nestedLock = new NestedLock();
        Thread thread1 = new Thread(() -> nestedLock.increment());
        Thread thread2 = new Thread(() -> nestedLock.decrement());
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.join();
        thread2.join();
    }
}