package multithreadedfizzbuzz;

public class MultithreadedFizzBuzz {
    private int n;
    private int num = 1;

    public MultithreadedFizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (num <= n) {
            if ((num % 3 == 0) && (num % 5 != 0)) {
                System.out.println("Fizz");
                this.num++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (num <= n) {
            if ((num % 3 != 0) && (num % 5 == 0)) {
                System.out.println("Buzz");
                this.num++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void fizzBuzz() throws InterruptedException {
        while (num <= n) {
            if ((num % 3 == 0) && (num % 5 == 0)) {
                System.out.println("FizzBuzz");
                this.num++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (num <= n) {
            if ((num % 3 != 0) && (num % 5 != 0)) {
                System.out.println(num);
                this.num++;
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }
}