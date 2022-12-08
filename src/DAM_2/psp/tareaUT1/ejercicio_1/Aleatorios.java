
package DAM_2.psp.tareaUT1.ejercicio_1;

/**
 * Este programa imprime por la salida estandar 10 numeros enteros aleatorios entre 0 y 100.
 * 
 * @author David Jimenez Alonso
 */
public class Aleatorios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //en cada vuelta del bucle for, creamos un numero aleatorio y lo imprimimos por la salida estandar
        int numeroAleatorio;
        for (int i = 0; i < 10; i++) {
            numeroAleatorio = (int)(Math.random()*101); //genera un numero aleatorio de 0 a 100.
            System.out.println(numeroAleatorio);        //imprime el numero generado por la salida estandar.
        }
    }
    
}
