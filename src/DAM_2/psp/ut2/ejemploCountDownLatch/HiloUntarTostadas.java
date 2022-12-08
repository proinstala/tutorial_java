package DAM_2.psp.ut2.ejemploCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class HiloUntarTostadas extends Thread {
    
    private CountDownLatch latch;
    
    public HiloUntarTostadas(CountDownLatch l) {
        this.latch = l;
    } 
    
    @Override
    public void run() {
        System.out.println("Untando las tostadas...");
        try {
            // Dormimos el hilo entre 1s y 2s
            sleep((long) (Math.random() * 1000 + 1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Tostadas untadas.");
        latch.countDown();
    }
}
