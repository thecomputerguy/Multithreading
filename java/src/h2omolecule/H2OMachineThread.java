package h2omolecule;

public class H2OMachineThread extends Thread {

    private H2OMachine h2oMachine;
    private String method;

    public H2OMachineThread(H2OMachine h2oMachine, String method) {
        this.h2oMachine = h2oMachine;
        this.method = method;
    }

    @Override
    public void run() {
        if ("hydrogenAtom".equals(method)) {
            try {
                this.h2oMachine.hydrogenAtom();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        } else if ("oxygenAtom".equals(method)) {
            try {
                this.h2oMachine.oxygenAtom();
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }
}