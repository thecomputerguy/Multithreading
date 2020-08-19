package blockingqueue;

public class BlockingQueueMain {

    public static void main(String[] args) throws InterruptedException {
        CustomBlockingQueue<Integer> blockingQueue = new CustomBlockingQueue<>(10);

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Enqueuing " + i);
                    blockingQueue.enqueue(Integer.valueOf(i));
                    System.out.println("Enqueued " + i);
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Dequeing an item from the blocking queue.");
                    Integer item = blockingQueue.dequeue();
                    System.out.println("Item from blocking queue: " + item);
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                for (int j = 0; j < 25; j++) {
                    System.out.println("Dequeing an item to the blocking queue.");
                    Integer item = blockingQueue.dequeue();
                    System.out.println("Dequeued an item " + item + " to the blocking queue.");
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        });

        thread1.start();
        Thread.sleep(5000);
        thread2.start();
        thread2.join();
        thread3.start();
        thread1.join();
        thread3.join();
        System.out.println("Exiting main thread.");

    }
}