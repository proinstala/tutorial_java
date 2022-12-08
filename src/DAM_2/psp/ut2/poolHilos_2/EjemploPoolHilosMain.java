package DAM_2.psp.ut2.poolHilos_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//NOTA: Para usar ExecutorService, los hilos tienen que implementar la interfaza Runnable.
//      No tienen que heredar de Thread.


//Ejemplo de uso de un pool de hilos.
 
public class EjemploPoolHilosMain {

    public static void main(String[] args) {
        // Creamos un pool usando newFixedThreadPool() que crea un pool de hilos con el número de hilos que le pasemos
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Añadimos 100 hilos al executor, que se irán ejecutando de 2 en dos cogiendo cada uno de los hilos del pool
        for (int i = 0; i < 100; i++) {
            executor.execute(new MiHilo(i));
        }

        executor.shutdown(); // Finalizamos el ExecutorService
        
    }

}
