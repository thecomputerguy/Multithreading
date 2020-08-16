package executorframework;

import java.util.concurrent.Executor;

public class DumbExecutor implements Executor {

    @Override
    public void execute(Runnable command) {

        Thread thread = new Thread(command);
        thread.start();

    }

}