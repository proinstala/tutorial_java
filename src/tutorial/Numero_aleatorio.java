
package tutorial;

//EJEMPLOS CON Math.random()

public class Numero_aleatorio {

    public static void main(String[] args) {
        
        // valorm = (int)Math.round(Math.random()*2);
        int numero;
        
        //ejemplo 1 ------------------------------------------------------------
        //crea un numero aleatorio hasta un numero menos por el que lo multipliquemos y hacemos un casting para guardarlo en la variable numero
        System.out.println("EJEMPLO 1 -----------------------------------------");
        numero = (int)(Math.random()*2); 
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
        
        
        
                
    }
    
}
