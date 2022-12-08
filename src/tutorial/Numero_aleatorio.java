
package tutorial;

import java.util.Random;

// 1. Utilizando el método estático random de la clase Math: Math.random()
// 2. Utilizando la clase Random

public class Numero_aleatorio {

    public static void main(String[] args) {
        

        // 1. Utilizando el método estático random de la clase Math: Math.random() -----------------------------------------------------------
        //El método random() de la clase Math devuelve un número al azar positivo de tipo double mayor o igual que 0.0 y menor que 1.0
        // valorm = (int)Math.round(Math.random()*2);
        int numero;
        
        //ejemplo 1 ------------------------------------------------------------
        //crea un numero aleatorio hasta un numero menos por el que lo multipliquemos y hacemos un casting para guardarlo en la variable numero
        System.out.println("EJEMPLO 1 -----------------------------------------");
        numero = (int)(Math.random()*10000); 
        System.out.println(numero);
        
        //ejemplo 2 ------------------------------------------------------------
        //crea un numero aleatorio hasta el numero por el que multiplicamos
        System.out.println("\nEJEMPLO 2 -----------------------------------------");
        numero = (int)Math.round((Math.random()*2));
        System.out.println(numero);
        
        //ejemplo 3 ------------------------------------------------------------
        //imprimiendo directamente por consola
        System.out.println("\nEJEMPLO 3 -----------------------------------------");
        System.out.println(Math.round(Math.random()*10));
        System.out.println(Math.random()*2);
        System.out.println(Math.random());


        // 2. Utilizando la clase Random ----------------------------------------------------------------------------------------
        //La clase Random proporciona un generador de números aleatorios más flexible que el método random de la clase Math anterior.
        /* 
        Pasos:
            1. Importar la clase: import java.util.Random;
            2. Crear un objeto de la clase Random
            3. Utilizar uno de los métodos de la clase para obtener el número

        Algunos métodos de la clase Random:
            nextInt() devuelve un número entero positivo o negativo dentro del rango de enteros.
            nextInt(int n) devuelve un número entero >=0 y menor que n.
            nextDouble() Devuelve un número positivo de tipo double mayor o igual que 0.0 y menor que 1.0
        */
        Random rnd = new Random();
        //ejemplo 4 ------------------------------------------------------------
        System.out.println("\nEJEMPLO 4 -----------------------------------------");
        //generar un entero entre 0 y 6:
        System.out.println(rnd.nextInt(7));

        System.out.println("\nEJEMPLO 5 -----------------------------------------");
        //generar un entero entre 1 y 6:
        System.out.println(rnd.nextInt(6)+1);

        System.out.println("\nEJEMPLO 6 -----------------------------------------");
        //genera cantidad aleatoria desde-hasta, ambos incluidos
        //rnd.nextInt(HASTA-DESDE+1)+DESDE
        int cantidad = new Random().nextInt(1000-(-500)) -500; //Cantidad aleatoria entre -500 a 1000.
        System.out.println(cantidad);
    }
    
}
