
package DAM_2.psp.ut2.prioridadHilos;

/*
 * En el siguiente enlace tienes un ejemplo en el que se declara un hilo cuya tarea es llenar un vector con 20000 caracteres. 
 * Se inician 15 hilos con prioridades diferentes, 5 con prioridad máxima, 5 con prioridad normal y 5 con prioridad mínima. 
 * Al ejecutar el programa comprobarás que los hilos con prioridad más alta tienden a finalizar antes.
 * 
 */

public class Main {

    public static void main(String[] args) {
       
        int contador = 5;

        //vectores para hilos de distintas prioridades
        Thread[] hiloMIN = new Thread[contador];
        Thread[] hiloNORM = new Thread[contador];
        Thread[] hiloMAX = new Thread[contador];

        //crea los hilos de prioridad mínima
        for (int i = 0; i < contador; i++) {
            hiloMIN[i] = new Hilo(Thread.MIN_PRIORITY);
        }

        //crea los hilos de prioridad normal 
        for (int i = 0; i < contador; i++) {
            hiloNORM[i] = new Hilo();
        }

        //crea los hilos de máxima prioridad
        for (int i = 0; i < contador; i++) {
            hiloMAX[i] = new Hilo(Thread.MAX_PRIORITY);
        }

        System.out.println("Hilos en proceso, espera......\nLos de mayor " + "prioridad tienden a terminar antes...\n");

        //inicia los hilos
        for (int i = 0; i < contador; i++) {
            hiloMIN[i].start();
            hiloNORM[i].start();
            hiloMAX[i].start();
        }

    }
}
