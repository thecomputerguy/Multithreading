package racecondition;

import java.util.Random;

public class RaceCondition {

    private int randInt;
    private Random random = new Random(System.currentTimeMillis());

    public void printer() {
        int count = 1000000;
        while (count != 0) {
            if (randInt % 5 == 0) { // critical section, race condition here, test then act
                if (randInt % 5 != 0) {
                    System.out.println(randInt);
                }
            }
            count--;
        }
    }

    public void modifier() {
        int count = 1000000;
        while (count != 0) {
            randInt = random.nextInt(1000);
            count--;
        }
    }

    public static void runTests() throws InterruptedException {
        RaceCondition raceCondition = new RaceCondition();
        Thread thread1 = new Thread(() -> raceCondition.printer());
        Thread thread2 = new Thread(() -> raceCondition.modifier());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}