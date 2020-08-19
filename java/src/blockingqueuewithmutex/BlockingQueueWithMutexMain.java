package blockingqueuewithmutex;

public class BlockingQueueWithMutexMain {
    private static BlockingQueueWithMutex<Integer> queue = new BlockingQueueWithMutex<>(10);

    private static void produce(int initialValue, int threadId) {

        // perpetual loop
        int item = initialValue;
        while (true) {
            System.out.println("Thread " + threadId + " producing item " + item);
            queue.enqueue(Integer.valueOf(item));
            System.out.println("Thread " + threadId + " produced item " + item);
            item++;
        }
    }

    private static void consume(int threadId) {

        // perpetual loop
        while (true) {
            System.out.println("Thread " + threadId + " is ready to consume. ");
            Integer item = queue.dequeue();
            System.out.println("Thread " + threadId + " consumed item " + item);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        // Create threads and assign tasks to them.
        // Three producers
        Thread producer1 = new Thread(() -> produce(1, 1));
        Thread producer2 = new Thread(() -> produce(50000, 2));
        Thread producer3 = new Thread(() -> produce(100000, 3));

        // Three consumers
        Thread consumer1 = new Thread(() -> consume(4));
        Thread consumer2 = new Thread(() -> consume(5));
        Thread consumer3 = new Thread(() -> consume(6));

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer3.setDaemon(true);
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer3.setDaemon(true);
        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
        Thread.sleep(1000 * 60);
    }
}