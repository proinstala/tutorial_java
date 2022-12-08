
package DAM_2.psp.ut2.semaforoRecurso;

import java.util.concurrent.Semaphore;

/**
 * Se trata de una clase para representar un recurso compartido por varios
 * hilos. Tendrá un objeto semáforo que se utilizará para controlar el número de
 * hilos que están haciendo uso del recurso.
 *
 */
public class Recurso {

    // Dependiendo del argumento del constructor podrán acceder un número distinto de hilos concurrentemente
    Semaphore semaforo = new Semaphore(7);

    public void lock() {
        try {
            // Si el contador de permisos es cero, el hilo se duerme
            // de lo contrario se reduce y obtiene el acceso
            semaforo.acquire();
            System.out.println("Comenzando, el hilo " + Thread.currentThread().getName() + " tiene el lock");
            Thread.sleep(5000); // Hacemos que durante 10 segundos esté usando el recurso
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println("Terminado, el hilo " + Thread.currentThread().getName() + " deja el lock");
        semaforo.release();
    }
}
