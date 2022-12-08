
package DAM_2.psp.ut2.ejemploCountDownLatch;

import java.util.concurrent.CountDownLatch;

/* Nota: es similar al metodo join() de Thread.
 * Con el objeto CountDownLatch conseguimos que al lanzar los hilos desde el programa principal,
 * tenga que pararse su ejecucion cuando invoca el metodo await() del objeto CountDownLatch haste que 
 * los hilos que se ha pasado el objeto invoquen al metodo countDown() del objeto CountDownLatch.
 * 
 * La diferencia con join() es que se puede lanzar desde un hilo otro hilo y pasarle el objeto CountDownLatch
 * para que el otro hilo invoque el metodo countDown().
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        
        Thread hiloCafe = new HiloHacerCafe(latch);
        Thread hiloTostadas = new HiloTostadas(latch);
        Thread hiloZumo = new HiloZumoNaranja(latch);
      
        
        System.out.println("Preparando desayuno...");
        
        hiloCafe.start();
        hiloTostadas.start();
        hiloZumo.start();
        
        latch.await();
        System.out.println("Desayuno servido.");
    }
    
}
