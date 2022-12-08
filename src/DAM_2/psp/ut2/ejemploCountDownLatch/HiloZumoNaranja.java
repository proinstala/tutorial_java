package DAM_2.psp.ut2.ejemploCountDownLatch;

import java.util.concurrent.CountDownLatch;

public class HiloZumoNaranja extends Thread {
    private CountDownLatch latch;
    
    public HiloZumoNaranja(CountDownLatch l) {
        this.latch = l;
    }
    
    @Override
    public void run() {
        System.out.println("Haciendo zumo...");
        try {
            // Dormimos el hilo entre 1s y 2s
            sleep((long) (Math.random() * 1000 + 1000));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Zumo hecho.");
        latch.countDown();
    }
}
