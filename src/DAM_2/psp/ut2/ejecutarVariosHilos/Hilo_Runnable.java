
package DAM_2.psp.ut2.ejecutarVariosHilos;

//clase que implementa Runnable
public class Hilo_Runnable implements Runnable {
    
    private String nombre = "Sin nombre";

    public Hilo_Runnable () {}

    public Hilo_Runnable (String nombre) {
        this.nombre = nombre;
    }

    public void run() { //redefinimos run() con el código asociado al hilo
        for (int i = 1; i <= 5; i++) {
            System.out.println("  Hilo_Runnable " + nombre);
        }
    }
}