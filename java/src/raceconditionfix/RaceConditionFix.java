package raceconditionfix;

import java.util.Random;

public class RaceConditionFix {

    private Random random = new Random(System.currentTimeMillis());
    private int randInt;

    public void printer() {
        int count = 1000000;
        while (count != 0) {
            synchronized (this) {
                if (randInt % 5 == 0) {
                    // if (randInt % 5 != 0) {
                    System.out.println(randInt);
                    // }
                }
            }
            count--;
        }
    }

    public void modifier() {
        int count = 1000000;
        while (count != 0) {
            synchronized (this) {
                randInt = random.nextInt(1000);
                count--;
            }

        }
    }

    public static void runTests() throws InterruptedException {
        RaceConditionFix raceConditionFix = new RaceConditionFix();
        Thread thread1 = new Thread(() -> raceConditionFix.printer());
        Thread thread2 = new Thread(() -> raceConditionFix.modifier());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}