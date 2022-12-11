
package DAM_2.psp.ut2.semaforoRecurso;


/**
 * Programa que simula una clase que tiene un semaforo con 7 permisos.
 * La clase Recurso es la que tiene el semaforo.
 * 
 * La clase HiloHiloEjemploSemaforo tiene una campo de tipo Recurso.
 */
public class Main {

    public static void main(String[] args) {
        
        Recurso recurso = new Recurso(); // Creamos una instancia de la clase Recurso. La clase Recurso tiene el semaforo.
        
        // Creamos 10 hilos y los lanzamos.
        Thread hilo;
        for (int i=1; i<=10; i++) {
            hilo = new HiloEjemploSemaforo(recurso);
            hilo.setName("H" + i);
            hilo.start();
        }
    }
    
}
