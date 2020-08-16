package settingupthreads.usingrunnables;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.start();
        thread.join();
        System.out.println("I am main thread");
    }
}