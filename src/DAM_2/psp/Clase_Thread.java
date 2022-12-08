package DAM_2.psp;

/*
 * NOTA: si se hereda la clase Thead hay que sobrescribir el metodo run que es de la interfaz Runnable.
 * 
 * PRIORIDA DE EJECUCION:
 * La prioridad de un hilo en java es de 1 a 10.
 * por defecto, la clase main tiene 5.
 * 
 * Constantes: 
 *  MAX_PRIORITY - 10 
 *  MINPRIORITY  - 1
 *  NORM_PRIORITY - 5
 * 
 * METODOS
 *  start()             - Hace que este subproceso comience a ejecutarse.
 *  currentThread();    - Devuelve una referencia al objeto de subproceso que se está ejecutando actualmente.
 *  getName()           - Devuelve el nombre de este hilo.
 *  getState()          - Devuelve el estado de este hilo.
 *  isAlive()           - Comprueba si este hilo está vivo.
 *  sleep(long)         - Hace que el subproceso que se está ejecutando entre en suspensión.
 *  setPriority​(int)    - Establece la prioridad de este hilo.  
 *  getPriority()       - Devuelve la prioridad de este hilo.
 *  yield()             - hace que un hilo que está "ejecutándose" pase a "preparado" para permitir que otros hilos de la misma prioridad puedan ejecutarse.
 */

public class Clase_Thread {
    public static void main(String[] args) {

        Thread miHilo = new Hilo("SubProceso_1");

        miHilo.start();
        System.out.println("Prioridad de hilo: " +miHilo.getPriority());

        
    }//FIN MAIN

}

//HACEMOS UNA CLASE QUE HEREDA DE LA CLASE Thead
class Hilo extends Thread {

    String nombre = "Hilo_Thread";

    public Hilo() {} //constructor sin parametros

    public Hilo(String nombre) { //constructor con parametros
    this.nombre = nombre;
    }


    @Override
    public void run() {  //redefinimos run() con el código asociado al hilo
        System.out.println("\nEjecuto el metodo run:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " " +nombre);
        }
    }

}//FIN CLASE Hilo
