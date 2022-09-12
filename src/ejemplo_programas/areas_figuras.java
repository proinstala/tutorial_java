package ejemplo_programas;

import java.util.*;
import javax.swing.*;

public class areas_figuras {
    public static void main(String[] args) {
        /*
        - El metodo Match.pow(x,y) es para calcular la potencia. Devulve un dato de tipo double.
        - El metodo Match.PI devuelve una constante con el numero pi.

        */


        Scanner entrada = new Scanner(System.in); //instanciamos la clase y creamos un objeto de tipo Scanner para introducir datos por consola

        System.out.println("Elige una opción: \n1: Cuadrado \n2: Rectángulo \n3: Trinángulo \n4: Círculo");

        int figura = entrada.nextInt(); //El numero inroducido por consola lo asignamos a esta variable

        switch(figura){
            case 1:
            int lado = Integer.parseInt(JOptionPane.showInputDialog("Introduce un lado"));
            System.out.println("El área del cuadrado es " + Math.pow(lado, 2)); 
            
            break;

            case 2:
            int base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
            int altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
            System.out.println("El área del rectángulo es " + base*altura);

            break;

            case 3:
            base = Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
            altura = Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
            System.out.println("El área del trangulo es " + (base*altura)/2);

            break;

            case 4:
            int radio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
            System.out.print("El área del círculo es ");
            System.out.printf("%1.2f", Math.PI * (Math.pow(radio, 2)));

            break;

            default:
            System.out.println("La opción no es correcta.");

        }
        
    }
    
}
