package threadlocal.unsafecounter;

public class UnsafeCounter {

    private int counter;

    public void increment() {
        this.counter = this.counter + 1;
    }

    public int getCounter() {
        return counter;
    }
}