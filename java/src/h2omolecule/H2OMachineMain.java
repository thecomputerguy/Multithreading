package h2omolecule;

public class H2OMachineMain {

    public static void main(String[] args) {
        H2OMachine h2oMachine = new H2OMachine();
        H2OMachineThread hydrogenThread1 = new H2OMachineThread(h2oMachine, "hydrogenAtom");
        H2OMachineThread hydrogenThread2 = new H2OMachineThread(h2oMachine, "hydrogenAtom");
        H2OMachineThread oxygenThread1 = new H2OMachineThread(h2oMachine, "oxygenAtom");
        H2OMachineThread oxygenThread2 = new H2OMachineThread(h2oMachine, "oxygenAtom");
        oxygenThread1.start();
        hydrogenThread1.start();
        oxygenThread2.start();
        hydrogenThread2.start();

    }
}