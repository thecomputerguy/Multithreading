package threadlocal.safecounter;

public class SafeCounterWithThreadLocal {
    private ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    public void increment() {
        this.count.set(this.count.get() + 1);
    }

    public Integer getCount() {
        return this.count.get();
    }
}