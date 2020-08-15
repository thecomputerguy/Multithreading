package multithreadedfoobar;

public class FooBarThread extends Thread {
    private String method;
    private FooBar foobar;

    public FooBarThread(FooBar foobar, String method) {
        this.foobar = foobar;
        this.method = method;
    }

    @Override
    public void run() {
        if ("foo".equals(this.method)) {
            try {

                this.foobar.foo();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else if ("bar".equals(this.method)) {
            try {
                this.foobar.bar();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}