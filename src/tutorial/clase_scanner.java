package tutorial;
import java.util.Scanner;

public class clase_scanner {
    public static void main(String[] args) {
        /* 
        - La clase Scanner se usa para introducir informacion por consola.
        Metodos:
        - nexInt()
        - next()
        - nexLine() 
        
        NOTA:
        Los metodos nextInt() y next() no consumen salto de linea.
        Si hay un error en saltos de linea hay que poner debajo un nexLine() para consumir el salto de linea.

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
