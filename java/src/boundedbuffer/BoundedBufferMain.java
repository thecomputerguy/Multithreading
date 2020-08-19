package boundedbuffer;

public class BoundedBufferMain {

    private static final BoundedBuffer<Integer> boundedBuffer = new BoundedBuffer<>(15);

    public static void produce(int threadId, int initialValue) {
        int value = initialValue;
        try {
            while (true) {
                System.out.println("Producer " + threadId + " producing " + value);
                boundedBuffer.enqueue(value);
                System.out.println("producer " + threadId + " produced " + value);
                value++;
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public static void consume(int threadId) {

        try {
            while (true) {
                System.out.println("Consumer " + threadId + " is ready to consume");
                Integer item = boundedBuffer.dequeue();
                System.out.println("Consumer " + threadId + " consumed " + item);
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // Create three producers
        Thread producer1 = new Thread(() -> produce(1, 1));
        Thread producer2 = new Thread(() -> produce(2, 10000));
        Thread producer3 = new Thread(() -> produce(3, 100000));

        // Create three consumers
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
        Thread.sleep(1000);
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(1000 * 60);
        System.out.println("Exiting main thread.");
    }
}