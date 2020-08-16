package multithreadedfizzbuzz;

public class MultithreadedFizzBuzzClient {
    public static void main(String[] args) {
        MultithreadedFizzBuzz multithreadedFizzBuzz = new MultithreadedFizzBuzz(20);
        MultithreadedFizzBuzzThread fizzThread = new MultithreadedFizzBuzzThread(multithreadedFizzBuzz, "Fizz");
        MultithreadedFizzBuzzThread buzzThread = new MultithreadedFizzBuzzThread(multithreadedFizzBuzz, "Buzz");
        MultithreadedFizzBuzzThread fizzBuzzThread = new MultithreadedFizzBuzzThread(multithreadedFizzBuzz, "FizzBuzz");
        MultithreadedFizzBuzzThread numberThread = new MultithreadedFizzBuzzThread(multithreadedFizzBuzz, "Number");

        fizzBuzzThread.start();
        fizzThread.start();
        buzzThread.start();
        numberThread.start();
    }
}