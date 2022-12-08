package DAM_2.psp.tareaUT2.ejercicio_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


/**
 * Este programa va a simular los movimientos que se hacen en una cuenta bancaria.
 * La cuenta bancaria comienza con un saldo inicial de 2000 euros.
 * Se van ha generar 20 hilos para simular que cada hilo realiza un movimiento en la cuenta Bancaria.
 * Los movimientos generados van de -500 a 1000.
 * Se va ha implementa un semaforo para acceder en exclusió mutua al metodo de la cuenta que realiza los movimientos.
 * Se va ha implementa un pool de hilos mediante la clase Executor para no generar mas de 5 hilos a la vez.
 * 
 * @author David Jimenez Alonso
 */

public class MainTareaUT2_1 {
    public static void main(String[] args) {

    
    Semaphore semaforo = new Semaphore(1);  //semáforo para las secciones críticas de esta clase (permisos 1),
    CuentaBancaria cuentaBanc = new CuentaBancaria(); // Creo una instancia de la clase CuentaBancaria,
    ExecutorService executor = Executors.newFixedThreadPool(5); //define un pool fijo de cinco hilos,

    //crea 20 hiloOperacion. Se pasan al pool de 5 hilos para que no se creen mas de cico hilos a la vez.
    for (int i = 1; i <= 20; i++) {
        executor.submit(new HiloOperacion("Hilo " + i, cuentaBanc, semaforo));
    }

    executor.shutdown(); //ordena la destrucción de los dos hilos del pool cuando hayan completado todas las tareas

    }

}
