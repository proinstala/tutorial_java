package tutorial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
matches()   - Devolverá true si toda la cadena (de principio a fin) encaja con el patrón o false en caso contrario.
lookingAt() - Devolverá true si el patrón se ha encontrado al principio de la cadena.
find().     - Devolverá true si el patrón existe en algún lugar la cadena.
start() y m.end() - para saber la posición inicial y final donde se ha encontrado.

[xyz] - tiene que aparecer uno de los caracteres indicados.
[x-z] - tiene que aparecer uno de los caracteres dentro del rango indicado.
[123] - tiene que aparecer uno de los digitos indicado.
[1-5] - tiene que aparecer uno de los digitos dentro del rango indicado.

a?      - puede aparecer una vez o ninguna.
a*      - puede aparecer una o mas de una, tambien no aparecer.
a+      - tiene que aparecer al menos una vez.
a{1,4}  - tiene que aparecer entre 1 a cuatro veces.
a{3,}   - tiene que aparecer 3 veces o mas.
a{5}    - tiene que aparecer 5 veces.

[^abc]  - negacion. el simbolo tiene que ser diferente a los especificados.
^hola   - la primera palabra de la cadena tiene que ser hola.
hola$   - la ultima palabra de la cadena tiene que ser hola.
.       - cualquier caracter.
\\d     - cualquier digito de 1 a 9.
\\D     - cualquier caracter menos digitos.
\\s     - espacio en blanco.
\\S     - cualquier caracter o digito menos espacio en blanco.
\\w     - cualquier cosas.
*/


public class Regex_ {
    public static void main(String[] args) {
        
        //EJEMPLO 1 ----------------------------------------------------------
        System.out.println("\nEJEMPLO 1 -------------------------------------");

        Pattern p = Pattern.compile("([XY]?)([0-9]{1,9})([A-Za-z])");  //compilamos la expresion regular
        Matcher m = p.matcher("X123456789Z Y00110011M 999999T");

        while (m.find()){
            System.out.println("\nLetra inicial (opcional):" + m.group(1));
            System.out.println("Número:" + m.group(2));
            System.out.println("Letra NIF:" + m.group(3));
        }

        //EJEMPLO 1dsfsdfsdf ----------------------------------------------------------
        System.out.println("\nEJEMPLO 1 -------------------------------------");

        Pattern p1 = Pattern.compile("([A-Z]*)([a-z]*)([0-9]+)");  //compilamos la expresion regular
        Matcher m1 = p1.matcher("AABB ccdd 1234");

        while (m.find()){
            System.out.println("\nLetra inicial (opcional):" + m1.group(1));
            System.out.println("Número:" + m1.group(2));
            System.out.println("Letra NIF:" + m1.group(3));
        }


        //EJEMPLO 2 ----------------------------------------------------------
        System.out.println("\nEJEMPLO 2 -------------------------------------");

        Pattern p2 = Pattern.compile("[01]+"); //compilamos la expresion regular
        Pattern p3 = Pattern.compile("11+");
        Matcher m2 = p2.matcher("00001010");
        Matcher m3 = p3.matcher("00001010");

        if (m2.matches()){
            System.out.println("Si, contiene el patrón p2");
        }else{
            System.out.println("No, no contiene el patrón p2");
        }

        if(m3.matches()){
            System.out.println("Si, contiene el patrón p3");
        }else{
            System.out.println("No, no contiene el patrón p3");
        }
        
            
    } //FIN VOID MAIN
}
