
package DAM_2.psp.ut2.manejoExcepiones;

import java.util.Random;

//clase que implementa el hilo
public class Hilo extends Thread {

    public Hilo(String nombre) {
        super(nombre);
    }

    public void run() {
        Random numero = new Random(); //crea un objeto Random
        int division = 100 / numero.nextInt(4); //divide 100 entre el número pseudoaleatorio entre 0 y 4
        System.out.println("Division: " + division); //muestra el valor de la división
        
    }
}
