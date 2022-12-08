package DAM_2.psp.ut2.lectorEscritor_monitor_synchronized;

/******************************************************************************
 * clase que proporciona el objeto Semaforo encargado de controlar el acceso
 * de lectores y escritores a los datos
 *
 * también proporciona los métodos para notificar al semáforo notificar que la
 * finalización de un lector y un escritor y así poder acualizar el estado
 * del semáforo
 */

public class Semaforo {

    //indica que no hay lectores leyendo, ni ningún escritor escribiendo.
    public final static int LIBRE = 0; //En este estado pueden entrar lectores a leer, o un escritor a escribir
   
    //constante que indica que hay lectores leyendo. 
    //Puede entrar un nuevo lector a leer, pero NO puede entrar ningún escritor a escribir
    public final static int CON_LECTORES = 1; 
    
    //constante que indica que hay escritores escribiendo. 
    //En este estado, NO puede entrar ningún lector a leer, ni nigún escritor a escribir
    public final static int CON_ESCRITOR = 2; 
    
    private int estado = LIBRE; //estado del semáforo (inicialmente: libre)
    
    private int numeroLectores = 0; //número de lectores (inicialmente: ninguno)
    

    /**
     * método que da acceso a la lectura de datos.
     * método sincronizado. Sólo un hilo lo usa a la vez.
     */
    public synchronized void accesoLeer() {
        
        String nombre = Thread.currentThread().getName(); //guarda el nombre del hilo que se hace con el método
        
        if (estado == LIBRE) { //BD sin lectores ni escritores. Pueden etrar a leer
            System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " entra a leer."); //mensaje para comprobar el funcionamiento
            estado = CON_LECTORES; //cambia estado, ya hay lector

        } else if (estado != CON_LECTORES) { //si no está libre, ni con lectores
            
            while (estado == CON_ESCRITOR) {
                try {
                    System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " trata de leer.ESPERA"); //mensaje para comprobar el funcionamiento
                    wait(); //pone en espera al hilo que intenta leer datos
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            System.out.println("BD:" + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " entra a leer."); //mensaje para comprobar el funcionamiento
            estado = CON_LECTORES; //cambia estado, ya hay lector
            
        } else { //en este punto el estado es CON_LECTORES
            System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " entra a leer."); //mensaje para comprobar funcionamiento
            
        }

        numeroLectores++; //otro lector más
        
        System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " Leyendo....."); //mensaje para comprobar funcionamiento
        
    }

    /**
     * método que da acceso para escribir datos si el estado de la BD lo permite
     */
    public synchronized void accesoEscribir() {
        String nombre = Thread.currentThread().getName(); //guarda el nombre del hilo que se hace con el método
        
        if (estado == LIBRE) { //sin lectores ni escritores
            System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " entra a escribir."); //mensaje para comprobar el funcionamiento
            estado = CON_ESCRITOR;  //cambia estado
           
        } else {//si no está libre
            while (estado != LIBRE) { //miestras BD está ocupada con lectores, o con un escritor
                try {
                    System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " trata de escribir. ESPERA"); //mensaje para comprobar funcionamiento
                    wait(); //pone en espera al hilo que intenta escribir datos
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            // el estado ahora es LIBRE
            System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " entra a escribir."); //mensaje para comprobar el funcionamiento
            estado = CON_ESCRITOR; //cambia estado
        }

        System.out.println("BD estado: " + estado + " || numero de lectores: " + numeroLectores + " || " + nombre + " Escribiendo.."); //mensaje para comprobar el funcionamiento
        
    }

    /**
     * método que invoca un HiloEscritor al terminar de escribir, para
     * actualizar el estado del semáforo y en su caso notificarlo a los hilos en espera.
     * Por supuesto, no se permite que dos hilos ejecuten estas instrucciones a la vez.
     */
    public synchronized void escrituraFinalizada() {
        estado = LIBRE; //cambia estado
        System.out.println(Thread.currentThread().getName() + ": Ya ha escrito"); //mensaje para comprobar el funcionamiento
        notify(); //notifica a los hilos en espera que ya ha finalizado   
    }

    /**
     * método que que invoca un HiloLector cuando termina de escribir, para 
     * actualizar el estado del semáforo y en su caso notificarlo a los hilos en espera.
     * por supuesto, no se permite que dos hilos ejecuten estas instrucciones a la vez.
     */
    public synchronized void lecturaFinalizada() {
        System.out.println(Thread.currentThread().getName() + ": Ya ha leido"); //mensaje para comprobar el funcionamiento
        numeroLectores--; //un lector menos leyendo
        
        if (numeroLectores == 0) { //no hay lectores en la BD
            estado = LIBRE; //cambia el estado
            notify(); //notifica a los hilos en espera que ya ha finalizado
        }
    }
}
