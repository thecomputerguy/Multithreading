package multithreadedfoobar;

public class FooBar {
    int n;
    int flag = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {

                while (this.flag == 1) {
                    this.wait();
                }
                System.out.println("Foo");
                this.flag = 1;
                notifyAll();
            }
        }
    }

    public void bar() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (this.flag == 0) {
                    this.wait();
                }
                System.out.println("Bar");
                this.flag = 0;
                notifyAll();
            }
        }
    }
}