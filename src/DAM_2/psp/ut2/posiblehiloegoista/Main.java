
package DAM_2.psp.ut2.posiblehiloegoista;

public class Main {
 public static void main(String[] args) {
       //se crean dos hilos: hrojo y hazul
       Color hrojo = new Color ("Rojo");
       Color hazul = new Color ("Azul");
       //se inician los hilos para su ejecución
       hrojo.start();
       hazul.start();
    }
}
