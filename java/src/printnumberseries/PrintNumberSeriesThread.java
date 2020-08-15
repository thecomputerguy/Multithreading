package printnumberseries;

public class PrintNumberSeriesThread extends Thread {
    private String method;
    private PrintNumberSeries printNumberSeries;

    public PrintNumberSeriesThread(PrintNumberSeries printNumberSeries, String method) {
        this.printNumberSeries = printNumberSeries;
        this.method = method;
    }

    @Override
    public void run() {
        if ("zero".equals(this.method)) {
            try {
                this.printNumberSeries.printZero();
            } catch (InterruptedException ex) {
                // TODO: handle exception
            }
        } else if ("odd".equals(this.method)) {
            try {

                this.printNumberSeries.printOdd();
            } catch (InterruptedException ex) {
                // TODO: handle exception
            }
        } else if ("even".equals(this.method)) {
            try {
                this.printNumberSeries.printEven();
            } catch (InterruptedException ex) {
                // TODO: handle exception
            }
        }
    }
}