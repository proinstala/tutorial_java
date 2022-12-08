package DAM_2.psp.ut2.lectorEscritor_monitor_synchronized;

/**
 * clase que proporciona un hilo que lee datos
 */
public class HiloLector extends Thread {

    /*  semaforo de control de acceso recibido por el constructor.
        Le proporciona al hilo el método de lectura de los datos, 
        así como el método para actualizar el estado cuando finaliza esa lectura
    */
    private Semaforo semaforo;
   
    public HiloLector(String nombre, Semaforo s) { //Constructor con parametros.
        this.setName(nombre); 
        this.semaforo = s;
    }
    

    @Override
    public void run() { //el método run() del hilo que lee los datos
        System.out.println(getName() + ": Intentando leer"); //mensaje de salida para comprobar el funcionamiento
        semaforo.accesoLeer();  //el hilo ha leido
       
        try {
            //duerme al hilo antes de que éste comunique que ha finalizado, para
            //poder ver accesos fallidos, con fines de comprobar funcionamiento
            sleep((int) (Math.random()) * 50);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        
        semaforo.lecturaFinalizada(); //comunica al semáforo la finalización de la lectura
        
    }
}
