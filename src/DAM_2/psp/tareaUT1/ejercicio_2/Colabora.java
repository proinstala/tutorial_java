
package DAM_2.psp.tareaUT1.ejercicio_2;

import java.io.IOException;

/**
 * Programa que que lanza 10 instancias de la aplicacion lenguaje.jar pasandole los argumentos que necista para ejecutarse correctamente.
 * En cada instancia se pasa a la aplicacion lenguaje como primer argumento el numero de palabras que tiene que generar 
 * y como segundo argumento el nombre del archivo donde se guardan las palabras generadas. 
 * Cada vez que se lanza una instancia, se aumenta en 10 el numero de palabras que tiene que generar la aplicacion lenguaje.
 * 
 * @author David Jimenez Alonso
 */
public class Colabora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Process nuevoProceso; //Definimos una variable de tipo Process
            for (int i = 1; i <= 10; i++) {
                nuevoProceso = Runtime.getRuntime().exec("java -jar "+ "lenguaje.jar " + i * 10 + " textoAleatorio.txt"); //lanza una instancia de lenguaje.jar
            }
            
        } catch (IOException e) { //si hay algun error, lo mostramos por la salida estandar.
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
