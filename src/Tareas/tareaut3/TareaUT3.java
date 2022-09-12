/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas.tareaut3;

import java.util.Scanner;

/**
 *
 * @author David Jimenez Alonso
 */
public class TareaUT3 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /* ----- PARTE 1 - STRING -----> COMPROBAR SI UN STRING ES UN PALÍNDROMO ----- */
        
        /* DECLARACIÓN DE VARIABLES */
        
        //1. Declara un objeto llamado teclado de tipo Scanner. Asígnale en el constructor la entrada estándar.
        Scanner teclado = new Scanner(System.in);
        
        //2. Declara 2 variables de tipo String llamadas: cad1 y cad2.
        String cad1, cad2;
        
        //3. Declara una variable de tipo StringBuilder y llámala cadAux.
        StringBuilder cadAux;
        
        /* USO DE CONSTRUCTORES */
        
        //4. Declara una variable booleana, llamada esPalindromo. Asignale el valor false
        boolean esPalidromo = false;

        //5. Usa el constructor por defecto para inicializar cad1
        cad1 = new String();
        
        //6. Usa un constructor para cad2 que reciba el String literal: "¿Son robos o sobornos?"
        cad2 = new String("¿Son robos o sobornos?");
        
        
        /* UTILIZACIÓN DE MÉTODOS */
        System.out.println("PARTE 1 - PALÍNDROMO");
        System.out.println("---------------------------------");
        
        //7. Muestra la longitud de cad1 y cad2
        System.out.println("La longitud de CAD1: " + cad1.length());
        System.out.println("La longitud de CAD2: " + cad2.length());

        //8. Comprueba si cad1 está vacía usando el operador condicional
        if(cad1.length() == 0) System.out.println("\ncad1 es vacía");
        else System.out.println("\ncad1 no es vacía");
        
        //9. Elimina de cad2 los caracteres '¿' y '?'
        cad2 = cad2.replace("¿", " ").replace("?", " ");
            
        //10. Elimina los espacios al inicio y al final de cad2
        cad2 = cad2.substring(1,cad2.lastIndexOf(' '));
        
        //11. Copia en cad1, la cadena cad2 al revés. Pista: debes usar la clase StringBuilder como ayuda.
        cadAux = new StringBuilder(cad2);
        cad1 = cadAux.reverse().toString();
        
        //12. Muestra los valores de cad1 y cad2
        System.out.println("\nCAD1:" + cad1);
        System.out.println("CAD2:" + cad2);
        
        //13. Comprueba si cad1 y cad2 son iguales usando el método equals(es un palíndromo)
        //Indica por qué crees que el programa dice que NO es un palíndromo.
        if(cad1.equals(cad2)) System.out.println("\ncad1 y cad2 son iguales");
        else System.out.println("\ncad1 y cad2 no son iguales");

        /*
        El metodo equals compara dos objetos, distingue entre mayusculas y minusculas. Los espacios tambien son como carateres y los tiene en cuenta.
        Por lo tanto, al comparar cada caracter de una cadena con la otra, el resultado es que no son iguales.
        */

        //14. Elimina todos los espacios en cad1 y cad2
        cad1 = cad1.replaceAll("\\s", "");
        cad2 = cad2.replaceAll("\\s", "");
        
        //15. Convierte a minúsculas cad1 y a mayúsculas cad2
        cad1 = cad1.toLowerCase();
        cad2 = cad2.toUpperCase();
        
        //16. Muestra los valores de cad1 y cad2
        System.out.println("\nCAD1:" + cad1);
        System.out.println("CAD2:" + cad2);
        
        //17. Comprueba su cad1 y cad2 son iguales comparando sin tener en cuenta las mayúsculas y minúsculas.
        if(cad1.equalsIgnoreCase(cad2)) System.out.println("\ncad1 y cad2 son iguales - PALÍNDROMO");
        else System.out.println("\ncad1 y cad2 no son iguales");

        // Además debes usar la variable booleana esPalindromo.
        System.out.println("FIN PARTE 1");
        System.out.println("");
        
       
        /* ----- PARTE 2 - STRING -----> CONCATENAR DOS STRINGS ----- */
        
        System.out.println("PARTE 2 - CONCATENACIÓN DE DOS STRINGS");
        System.out.println("---------------------------------");
        
        //18. Solicita al usuario el valor de cad1 y cad2
        System.out.println("introduce el valor de cad1");
        cad1 = teclado.nextLine(); 

        System.out.println("introduce el valor de cad2");
        cad2 = teclado.nextLine(); 

        //19. Concatena al final de cad1 el String cad2
        cad1 = cad1 + cad2;

        //20. Muestra los valores de cad1 y cad2
        System.out.println("\nCAD1:" + cad1);
        System.out.println("CAD2:" + cad2);

        System.out.println("FIN PARTE 2");
        System.out.println("");
        
    }
    
}
