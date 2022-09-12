package pruebas;

import java.util.Scanner;

public class vectores1 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String matriz[];
        int tamano;
        String datos;


        System.out.print("tamaño de array: ");
        tamano = teclado.nextInt();
        matriz = new String[tamano];

        System.out.print("Introduce los numero de la matriz separados por un espacio: ");
        teclado.nextLine(); // Borra el buffer
        datos = teclado.nextLine();

        matriz = datos.split("\\s", tamano);
        
        System.out.println("");
        /* 
        for (int i = 0; i < matriz.length; i++) {
            System.out.println(matriz[i]);
        }
        */

        /* 
        for (int i = 0; i < tamano; i++) {
            matriz[i] = i+1;
        }
        */
        
        
        for (int i = 0; i < matriz.length; i++) {
            
            if(matriz.length / 2 == i){
                if(matriz.length % 2 == 1){
                    System.out.print(i+1);
                }
                break;
            }

            System.out.print(i+1 + " ");
            System.out.print(matriz.length - i + " ");
            
            
        }

    }
}
