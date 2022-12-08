package DAM_2.psp.tareaUT2.ejercicio_1;

import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 * Clase que simula una operacion en CuentaBancaria.
 * 
 * @author David Jimenez Alonso
 */
public class HiloOperacion implements Runnable {
    
    //Campos de clase.
    private CuentaBancaria cuenta;
    private Semaphore semaforo;
    private String nombre;


    /**
     * Crea un objeto de tipo HiloOpercion.
     * 
     * @param nombre    Nombre de HiloOpercion.
     * @param cuenta    Cuenata donde se va ha realizar el movimiento.
     * @param semaforo  Semaforo para acceder en exclusion a la cuenta.
     */
    public HiloOperacion(String nombre, CuentaBancaria cuenta, Semaphore semaforo) {
        this.cuenta = cuenta;
        this.semaforo = semaforo;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        
        Thread.currentThread().setName(nombre); //Asignamos el nombre del objeto al hilo.
        try {
            //Mostramos un mensaje de que vamos a generar un movimiento en la cuenta.
            System.out.println(Thread.currentThread().getName() + " va a generar un gasto/ingreso");
            
            //Intentamos obtener el permiso para poder realizar el movimiento en la cuenta.
            semaforo.acquire(); 
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        //Generamos la cantidad aleatoria del movimiento.
        int cantidad = new Random().nextInt(1000-(-500)) -500; //Cantidad aleatoria entre -500 a 1000.
        
        //Mostramos el mensaje que la cuenta quiere hacer el movimiento y la cantidad del movimiento.
        System.out.println(Thread.currentThread().getName() + " quiere añadir a la cuenta el movimiento " + cantidad);
        
        //llamamos la metodo de la cuenta que hace el movimiento y le pasamos la cantidad del movimiento.
        cuenta.addMovimiento(cantidad);

        //Mostramos un mesaje como que ya ha finalizado la operación.
        System.out.println(Thread.currentThread().getName() + " ha finalizado ");

        semaforo.release(); //Liberamos el permiso para que otro hilo pueda ejecutar su operación.
    }
    
}
