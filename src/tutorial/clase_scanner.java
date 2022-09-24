package tutorial;
import java.util.Scanner;

public class clase_scanner {
    public static void main(String[] args) {
        /* 
        - La clase Scanner se usa para introducir informacion por consola.
        - El metodo nexInt() no es estatico. Se necesita crear un objeto para su uso.
        - El metodo nexLine() no es estatico. Se necesita crear un objeto para su uso.
        */

        Scanner entrada = new Scanner(System.in); //instanciamos la clase 

        System.out.print("introduce tu nombre: ");
        String nombre_usario = entrada.nextLine(); //introduce un dato de tipo string

        System.out.print("introduce edad: "); 
        int edad = entrada.nextInt(); //introduce un dato de tipo int

        System.out.println("Hola " + nombre_usario + ", tu edad es " + edad + " años.");

        entrada.close();
    }
}
