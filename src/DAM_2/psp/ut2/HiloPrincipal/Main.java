
package DAM_2.psp.ut2.HiloPrincipal;

/****************************************************************************
   * Este programa Identifica el hilo que ejecuta el método main() de la típica
   * aplicación de consola "¡Hola mundo!"
   * Se utilizan para ello los métodos: currentThread() y getName()
   * de la clase Thread
   */

public class Main {
   public static void main(String[] args) {
      System.out.println("¡Hola mundo!\n"); //imprime "¡Hola mundo!" en la Salida
      
      //obtiene el hilo donde se está ejecutando este método mediante la
      //función Thread.currentThread(), y lo almacena en la variable local miHilo
      Thread miHilo = Thread.currentThread();
      //imprime el nombre del hilo en la Salida (función getName())
      System.out.println("Por defecto, el hilo que ejecuta el método main() " +"de mi programa se llama '" + miHilo.getName() + "'\n");

      //otra forma
      String Hilo = Thread.currentThread().getName();
      System.out.println("Otra forma: nombre de hilo en ejecucion: " + Hilo);

   }
}
