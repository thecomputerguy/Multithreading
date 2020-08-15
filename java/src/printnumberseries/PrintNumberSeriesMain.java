package printnumberseries;

public class PrintNumberSeriesMain {

    public static void main(String[] args) {
        PrintNumberSeries printNumberSeries = new PrintNumberSeries(10);
        PrintNumberSeriesThread zeroThread = new PrintNumberSeriesThread(printNumberSeries, "zero");
        PrintNumberSeriesThread oddThread = new PrintNumberSeriesThread(printNumberSeries, "odd");
        PrintNumberSeriesThread evenThread = new PrintNumberSeriesThread(printNumberSeries, "even");

        zeroThread.start();
        oddThread.start();
        evenThread.start();
    }
}