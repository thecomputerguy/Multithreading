package blockingqueuewithmutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueWithMutex<T> {
    private Lock lock = new ReentrantLock();
    private int tail = 0;
    private int head = 0;
    private int capacity;
    private int size = 0;
    private T[] array;

    @SuppressWarnings("unchecked")
    public BlockingQueueWithMutex(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) (new Object[this.capacity]);
    }

    public void enqueue(T item) {
        this.lock.lock();
        while (this.size == this.capacity) {
            // by releasing the lock give other threads a chance to execute
            this.lock.unlock();
            // Reqacquire lock before checking the condition.
            this.lock.lock();
        }

        if (this.tail == this.capacity) {
            this.tail = 0;
        }

        this.array[this.tail] = item;
        this.size++;
        this.tail++;
        this.lock.unlock();
    }

    public T dequeue() {
        T item = null;
        this.lock.lock();
        while (this.size == 0) {
            // Release the lock to give other threads to execute while waiting for the
            // predicate to be true.
            this.lock.unlock();

            // Reqacquire the lock before testing the condition.
            this.lock.lock();
        }

        if (this.head == this.capacity) {
            this.head = 0;
        }

        item = this.array[this.head];
        this.head++;
        this.size--;
        this.lock.unlock();
        return item;
    }
}