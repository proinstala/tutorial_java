package juez;

/*
Haz un programa que solicite al usuario un número entero positivo e indique cuántos números enteros consecutivos se necesitan sumar, 
a partir del número 1, para alcanzar dicha cantidad.
 
*/

import java.util.Scanner;

public class juezUT4_2_3 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int numero = teclado.nextInt();
        int contador = 1;
        int resultado = 0;

        while(resultado < numero){
            resultado = resultado + contador;
            contador++;
        }

        System.out.println(contador -1);
    }
}
