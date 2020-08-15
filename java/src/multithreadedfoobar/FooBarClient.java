package multithreadedfoobar;

public class FooBarClient {

    public static void main(String[] args) {

        FooBar fooBar = new FooBar(10);
        FooBarThread fooThread = new FooBarThread(fooBar, "foo");
        FooBarThread barThread = new FooBarThread(fooBar, "bar");
        fooThread.start();
        barThread.start();
    }
}