package executorframework;

public class DumbExecutorMain {

    public static void main(String[] args) {
        Task task = new Task();
        DumbExecutor dumbExecutor = new DumbExecutor();
        dumbExecutor.execute(task);
    }
}