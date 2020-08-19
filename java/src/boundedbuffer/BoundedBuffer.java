package boundedbuffer;

public class BoundedBuffer<T> {
    private int tail = 0;
    private int head = 0;
    private int size = 0;
    private int capacity;
    private T[] array;
    private CountingSemaphore producerSemaphore;
    private CountingSemaphore consumerSemaphore;
    private CountingSemaphore lock = new CountingSemaphore(1);

    @SuppressWarnings("unchecked")
    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
        this.producerSemaphore = new CountingSemaphore(this.capacity, this.capacity);
        this.consumerSemaphore = new CountingSemaphore(this.capacity, 0);
    }

    public void enqueue(T item) throws InterruptedException {
        this.producerSemaphore.acquire();
        this.lock.acquire();
        if (this.tail == this.capacity) {
            this.tail = 0;
        }
        this.array[this.tail] = item;
        this.tail++;
        this.size++;
        this.lock.release();
        this.consumerSemaphore.release();
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        this.consumerSemaphore.acquire();
        this.lock.acquire();
        if (this.head == this.capacity) {
            this.head = 0;
        }
        item = this.array[this.head];
        this.head++;
        this.size--;
        this.lock.release();
        this.producerSemaphore.release();
        return item;
    }
}