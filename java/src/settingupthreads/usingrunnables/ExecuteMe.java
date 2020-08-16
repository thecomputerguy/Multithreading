package settingupthreads.usingrunnables;

public class ExecuteMe implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1000 * 60);
            System.out.println("i am a runnable");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}