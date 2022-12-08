
package DAM_2.psp.ut2.semaforoHilos2;

import java.util.concurrent.Semaphore;

/**Se trata de simular el acceso simultáneo de 4 terminales (hilos) a un servidor
 * y llevar la cuenta de accesos en cada instante. Desde cada terminal se
 * simularán 10 accesos.
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      //semáforo para las secciones críticas de esta clase (permisos 1)
      Semaphore semaforo = new Semaphore(1);  
      
      //crea un objeto ServidorWeb
      ServidorWeb servidor = new ServidorWeb();  
      
      //Se crean cuatro hilos
      Hilo_Terminal hterminal1 = new Hilo_Terminal(servidor, semaforo);
      Hilo_Terminal hterminal2 = new Hilo_Terminal(servidor, semaforo);
      Hilo_Terminal hterminal3 = new Hilo_Terminal(servidor, semaforo);
      Hilo_Terminal hterminal4 = new Hilo_Terminal(servidor, semaforo);

      //se inician los cuatro hilos
      hterminal1.start();
      hterminal2.start();
      hterminal3.start();
      hterminal4.start();
        
    }

}
