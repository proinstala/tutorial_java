package DAM_2.psp.ut2.ejemploCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class HiloTostadas extends Thread {
   
    private CountDownLatch latch;
    
    public HiloTostadas(CountDownLatch l) {
        this.latch = l;
    }
    
    @Override
    public void run() {
        System.out.println("Haciendo tostadas...");
        try {
            // Dormimos el hilo entre 3s y 7s
            sleep((long) (Math.random() * 4000 + 3000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
       
        System.out.println("Tostadas hechas.");
        new HiloUntarTostadas(latch).start();
       
    }
}
