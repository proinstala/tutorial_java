
package DAM_2.psp.ut2.manejoExcepiones;

//manejador de excepciones para toda la aplicación
public class ManejadorExcepciones implements Thread.

   UncaughtExceptionHandler{

    //implementa el método uncaughtException()
    public void uncaughtException(Thread t, Throwable e){
        System.out.printf("Thread que lanzó la excepción: %s \n", t.getName()); //muestra en consola el hilo que produce la exceción
        e.printStackTrace(); //muestra en consola la pila de llamadas
    }
}
