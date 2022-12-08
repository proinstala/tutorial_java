
package DAM_2.psp.ut2.semaforoRecurso;

public class Main {

    public static void main(String[] args) {
        
        Recurso unRecurso = new Recurso(); // Creamos el recurso
        
        // Creamos varios hilos y los lanzamos
        Thread hilo;
        for (int i=1; i<=10; i++) {
            hilo = new HiloEjemploSemaforo(unRecurso);
            hilo.setName("H" + i);
            hilo.start();
        }
    }
    
}
