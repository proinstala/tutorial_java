package juez;

/*
La estructura básica de un bucle for decreciente es la siguiente:

for(i = limiteSuperior; i >= limiteInferior; i--)

Utilizando la estructura anterior, solicita un número por teclado y haz una cuenta atrás desde ese número hasta 0.
*/

import java.util.Scanner;

public class juezUT4_2_2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        int numero = teclado.nextInt();
        int limite_inferior = 0;
        for(int i = numero; i >= limite_inferior; i--){
            System.out.println(i);
        }
    }
}
