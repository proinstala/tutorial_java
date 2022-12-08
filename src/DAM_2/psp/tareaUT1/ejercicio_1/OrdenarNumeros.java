
package DAM_2.psp.tareaUT1.ejercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Este programa ordena los numeros recibidos por la entrada estandar.
 * Ordena los 10 primeros numeros recibidos y los imprime por la salida estandar.
 * 
 * @author David Jimenez Alonso
 */
public class OrdenarNumeros {

    /**
     * @param args No recive argumentos
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> listaNumero = new ArrayList<>(); //creo el ArrayList donde voy a guardar los numeros
        BufferedReader bf = new BufferedReader (new InputStreamReader(System.in));   //creo un buffer de datos para leer los datos de la entrada estandar.
        String lineaTeclado = null;
        
        try {
            int contador=0;
            while ((lineaTeclado = bf.readLine())!= null) {         //leeo la entrada estandar
                listaNumero.add(Integer.parseInt(lineaTeclado));    //añado cada numero que se introduzca por la entrada estandar
                contador++;                 //en cada vuelta, la variable contador se implementa en 1
                if (contador == 10) break;  //cuando la variable contador llegue a 10, sale del bucle while
                
            }
        } catch(IOException e){ //capturamos la excepcion si se produce un error al leer los datos por la entrada estandar
            System.err.println("Se ha producido un error de E/S.");
            System.err.println(e.getMessage());
            
        } catch(NumberFormatException e){ //capturamos la excepcion si se introduce un dato no valido
            System.out.println("Error: solo se admiten numeros enteros");
            System.err.println(e.getMessage());
        }
        
        System.out.println("\nOrdenamos la lista de numeros:"); //ordenamos la lista de numeros y la imprimimos por la salida estandar
        Collections.sort(listaNumero); //ordenamos la lista
        listaNumero.forEach(i -> {
            System.out.println(i);
        });
    }
}
