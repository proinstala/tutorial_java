package DAM_1.juez;

import java.util.Scanner;

/*
Crea una aplicación que muestre tablas de multiplicar de los números enteros positivos.

Por cada una de las tablas de multiplicar, la aplicación deberá esperar que se introduzca un número: si se introduce un número distinto de 0, 
la aplicación mostrará la siguiente tabla de multiplicar; si el número que se introduce es un 0, la aplicación finalizará.
*/


public class juezUT4_2_4 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

    int entrada = 1;
    int cont = 1;
    do{
        for(int i = 0; i < 11; i++){
            System.out.println(cont + " x " + i + " = " + (cont * i));
        }
        cont++;
        entrada = teclado.nextInt();

    }while(entrada != 0);
        
    }
}
