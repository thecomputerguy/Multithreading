package h2omolecule;

import java.util.Arrays;
import java.util.Collections;

public class H2OMachine {
    private Object lock;
    private int count;
    private String[] atoms;

    public H2OMachine() {
        this.lock = new Object();
        this.count = 0;
        this.atoms = new String[3];
    }

    public void hydrogenAtom() throws InterruptedException {
        synchronized (this.lock) {
            int hydrogenFrequency = Collections.frequency(Arrays.asList(this.atoms), "H");
            while (hydrogenFrequency == 2) {
                this.lock.wait();
            }

            this.atoms[this.count] = "H";
            this.count++;
            if (count == 3) {
                for (String atom : atoms) {
                    System.out.print(atom + " ");
                }
                System.out.println();
                Arrays.fill(this.atoms, null);
                this.count = 0;
            }
            this.lock.notifyAll();
        }
    }

    public void oxygenAtom() throws InterruptedException {
        synchronized (this.lock) {
            int oxygenFrequency = Collections.frequency(Arrays.asList(this.atoms), "O");
            while (oxygenFrequency == 1) {
                this.lock.wait();
            }
            this.atoms[count] = "O";
            this.count++;
            if (this.count == 3) {
                for (String atom : atoms) {
                    System.out.print(atom + " ");
                }
                System.out.println();
                Arrays.fill(this.atoms, null);
                this.count = 0;
            }
            this.lock.notifyAll();
        }
    }
}