package tutorial;

import java.util.Arrays;

public class matriz {
    public static void main(String[] args) {
        /*
        - Son estructuras de datos que contienen una colección de valores del mismo tipo.
        - Sirven para almacenar valores qu normalmente tienen alguna relación entre si.

        - SINTAXIS:
            declaracion de una matriz tipo int:     int nombre_de_matriz[] = new int[numero de valores];
            declaración y iniciacion de matriz:     int nombre_de_matriz[] = new int[15, 25, 6, -7, 523];

        
        - METODOS: 
            Arrays.sort(nombre de la matriz a ordenar);     metodo para ordenar el contenido de la matriz
            Arrays.toString(nombre de la matriz)            imprime una matriz de numerica en formato lista
            Array.asList(nombre de la matriz);              imprime una matriz de String en formato lista
            Array.deepToString(nombre de la matriz);        imprime una matriz multidimensional en formato lista.

            System.arraycopy(mi_array1, 0, mi_array2, 0, mi_array1.length); copoia los valores del mi_array1 en mi_array2
        */

        //EJEMPLO 0 ----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 0 -------------- ");
        int[] nuevo = new int[5];
        System.out.println(nuevo[2]); //Los datos de tipo primitivos devolveran 0 si no se han iniciado

        String [] hola = new String[3];
        System.out.println(hola[2]); //Los objetos devolveran null si no se han iniciado

        //EJEMPLO 1 ----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 1 -------------- ");
        int mi_matriz[] = new int[5];    //declarando matriz para 5 valores
        mi_matriz[3] = 47; //añadiendo un valor a la posición 3 de mi_matriz
        System.out.println(mi_matriz[3]); //imprimiendo la posicion 3 de mi_matriz

        //EJEMPLO 2 ----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 2 -------------- ");
        int mi_matriz_2[] = {10, 60, 30, 80, 50};
        for(int i = 0; i < mi_matriz_2.length; i++){ //blucle para recorrer los valores de una matriz
            System.out.println(mi_matriz_2[i]); 
        }

        System.out.println("\nOrdenamos la matriz");
        Arrays.sort(mi_matriz_2); //con este metodo ordenamos la matriz
        for (int i : mi_matriz_2) {
            System.out.println(i);
        }

        //EJEMPLO 3 -----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 3 -------------- ");
        String mi_matriz_3[] = new String[6];
        mi_matriz_3[0] = "España";
        mi_matriz_3[1] = "Japon";
        mi_matriz_3[2] = "Francia";
        mi_matriz_3[3] = "Italia";
        mi_matriz_3[4] = "Egipto";
        mi_matriz_3[5] = "Polonia";

        for(String i:mi_matriz_3){  //bucle for each
            System.out.println(i);
        }

        System.out.println(Arrays.asList(mi_matriz_3)); //imprime el array en formato lista

        //EJEMPLO 4 -----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 4 -------------- ");

        int mi_matriz_4[][] = new int[3][4]; //declaración de matriz bidimensional
        mi_matriz_4[0][0] = 2;
        mi_matriz_4[0][1] = 1;
        mi_matriz_4[0][2] = 4;
        mi_matriz_4[0][3] = 7;

        mi_matriz_4[1][0] = 16;
        mi_matriz_4[1][1] = 18;
        mi_matriz_4[1][2] = 14;
        mi_matriz_4[1][3] = 11;

        mi_matriz_4[2][0] = 57;
        mi_matriz_4[2][1] = 58;
        mi_matriz_4[2][2] = 52;
        mi_matriz_4[2][3] = 56;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                System.out.println("mi_matriz_4 " + i + " " + j + ": " + mi_matriz_4[i][j]);
            }
        }

        System.out.println(Arrays.deepToString(mi_matriz_4)); //imprime una matriz multidimensional en formato lista

        //EJEMPLO 5 -----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 5 -------------- ");

        int mi_matriz_5[][] = {
            {1, 2, 3, 4},
            {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34}
        };

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.println("mi_matriz_5 " + i + " " + j + ": " + mi_matriz_5[i][j]);
            }
        }

        //EJEMPLO 6 -----------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 6 -------------- ");

        int mi_matriz_6[][] = {
            {1, 2, 3, 4},
            {11, 12, 13, 14},
            {21, 22, 23, 24},
            {31, 32, 33, 34}
        };

        for(int x[]:mi_matriz_6){   //bucle for each
            for(int y:x){
                System.out.print(y + " ");
            }
            System.out.println("");
        }


    }
}
