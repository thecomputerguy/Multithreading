package settingupthreads.extendingthreadclass;

public class ExtendingThreadClassMain {

    public static void main(String[] args) {
        ExecuteMe executeMe = new ExecuteMe();
        executeMe.start();
        System.out.println("I am main thread.");
    }
}