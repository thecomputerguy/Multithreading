package executorframework;

public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("A dumb task.");
    }
}