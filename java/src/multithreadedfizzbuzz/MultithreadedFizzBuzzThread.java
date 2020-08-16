package multithreadedfizzbuzz;

public class MultithreadedFizzBuzzThread extends Thread {

    private MultithreadedFizzBuzz multithreadedfizzbuzz;
    private String method;

    public MultithreadedFizzBuzzThread(MultithreadedFizzBuzz multithreadedFizzBuzz, String method) {
        this.multithreadedfizzbuzz = multithreadedFizzBuzz;
        this.method = method;
    }

    @Override
    public void run() {
        if ("Fizz".equals(method)) {
            try {
                multithreadedfizzbuzz.fizz();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        } else if ("Buzz".equals(method)) {
            try {
                multithreadedfizzbuzz.buzz();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        } else if ("FizzBuzz".equals(method)) {
            try {
                multithreadedfizzbuzz.fizzBuzz();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        } else if ("Number".equals(method)) {
            try {
                multithreadedfizzbuzz.number();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }
}