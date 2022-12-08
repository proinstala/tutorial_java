
package DAM_2.psp.ut2.poolHilos;

import java.util.Random;

//compone una cadena de diez números aleatorios menores que 50, separados por ','
public class NumerosAleatorios implements Runnable {

    public void run() {

        String strReturn = "";
        Random random = new Random();

        for (int i = 0; i <10; i++) {
            strReturn += random.nextInt(50) + ", ";
            Thread.yield();
        }

        System.out.println("Números aleatorio obtenidos por " + Thread.currentThread().getName() + ": " + strReturn);
    }
}
