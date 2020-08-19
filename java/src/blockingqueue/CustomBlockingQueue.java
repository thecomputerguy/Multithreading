package blockingqueue;

public class CustomBlockingQueue<T> {

    private Object lock = new Object();
    private int capacity;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = (T[]) (new Object[this.capacity]);
    }

    public void enqueue(T item) throws InterruptedException {

        synchronized (lock) {
            while (this.size == this.capacity) {
                lock.wait();
            }

            if (this.tail == capacity) {
                this.tail = 0;
            }

            this.queue[this.tail] = item;
            this.size++;
            this.tail++;

            lock.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        synchronized (lock) {

            while (this.size == 0) {
                lock.wait();
            }

            if (this.head == this.capacity) {
                this.head = 0;
            }

            item = this.queue[this.head];
            this.queue[this.head] = null;
            this.head++;
            this.size--;
            lock.notifyAll();

        }

        return item;
    }
}