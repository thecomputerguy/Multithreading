package settingupthreads.extendingthreadclass;

public class ExecuteMe extends Thread {

    @Override
    public void run() {
        System.out.println("I am extending from Thread class");
    }
}