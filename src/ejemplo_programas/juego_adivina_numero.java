package ejemplo_programas;

import java.util.*;

public class juego_adivina_numero {
    public static void main(String[] args) {
        /*
        - Math.random() devuelve un numero de tipo double(coma flotante doble) entre 0 y 1
        */

        int numero_introducido = 0;
        int intentos = 0;

        Scanner entrada = new Scanner(System.in); //instanciamos la clase y creamos un objeto de tipo Scanner para introducir datos por consola

        //usamos refundicion para convertir el dato de tipo double que devuelve Math.random() en entero descartando la parte decimal
        int n_aleatorio = (int)(Math.random()*100); //Math.random() lo multiplicamos por 100 para obtener un numero entre 0 a 100

        //System.out.println(n_aleatorio); // descomentar esta linea para ver el numero aleatorio generado

        do{
            System.out.print("Introduce un numero: ");
            numero_introducido = entrada.nextInt();

            if(n_aleatorio < numero_introducido) System.out.println("El numero aleatorio es MÁS BAJO !!!!!!!!!!!!!!!!!!!!!!!!");
            else if(n_aleatorio > numero_introducido) System.out.println("El numero aleatorio es MÁS ALTO !!!!!!!!!!!!!!!!!!!!!!!!");
            intentos ++;
        }while(numero_introducido != n_aleatorio);
        
        System.out.println("Correcto. Lo as conseguido en " + intentos + " intentos.");
        System.out.println("--- FIN ---");
        
    }
}
