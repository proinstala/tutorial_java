
package DAM_2.psp.ut2.poolHilos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// ejecuta ocho veces la tarea NumerosAleatorios que imprime diez números aleatorios menores que cincuenta, 
// mediante un pool de tan sólo dos hilos

public class Main {
    public static void main(String[] args) {
        
        //define un pool fijo de dos hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //pasa 30 tareas NumerosAleatorios al pool de 2 hilos
        for (int i = 1; i <= 30; i++) {
            executor.submit(new NumerosAleatorios());
        }

        //ordena la destrucción de los dos hilos del pool cuando hayan completado todas las tareas
        executor.shutdown();
    }
}
