package threadunsafe;

public class ThreadUnsafeCounter {
    int counter = 0;

    public void increment() {
        System.out.println("Before incrementing value is " + this.counter);
        this.counter++;
        System.out.println("After incrementing value is " + this.counter);
    }

    public void decrement() {
        System.out.println("Before decrementing value is " + this.counter);
        this.counter--;
        System.out.println("After decrementing value is " + this.counter);
    }

    public void printFinalCounterValue() {
        System.out.println("Final counter value is " + counter);
    }
}