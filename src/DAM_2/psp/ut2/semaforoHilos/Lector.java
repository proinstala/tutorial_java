
package DAM_2.psp.ut2.semaforoHilos;


import java.util.concurrent.Semaphore;

//clase que implementa al hilo lector
public class Lector extends Thread {

    private Semaphore semaforo;

    public Lector(String nombre, Semaphore s) {
        super(nombre);
        this.semaforo = s;
    }

    public void run() {
        System.out.println(getName() + " : Intentando leer"); //mensaje en consola para comprobar el funcionamiento
        
        try {
            semaforo.acquire();
            //solicita un permiso para acceder a la BD a leer
            //los otros 4 permisos, los pueden utilizar los otros hilos lectores
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(getName() + " : Leyendo");
        try {
            sleep((int) (Math.random() * 50));
            //se duerme al hilo un tiempo aleatorio (para simular que tarda en realizar su tarea y así otros hilos compiten por el acceso )
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(getName() + " : Ya he leido"); //mensaje en consola para comprobar el funcionamiento
        semaforo.release();  //libera el permiso
        
        
    }
}
