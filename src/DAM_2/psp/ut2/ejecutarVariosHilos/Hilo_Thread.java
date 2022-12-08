
package DAM_2.psp.ut2.ejecutarVariosHilos;

//clase que extiende a Thread con 2 constructores
public class Hilo_Thread extends Thread {

    String nombre = "Hilo_Thread";

    public Hilo_Thread() {} //constructor sin parametros

    public Hilo_Thread(String nombre) { //constructor con parametros
        this.nombre = nombre;
    }

    
    @Override
    public void run() {  //redefinimos run() con el código asociado al hilo
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre);
        }
    }
}
