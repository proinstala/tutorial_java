package tutorial;



public class cadenas {
    public static void main(String[] args) {
        /* Metodos mas usados de la clase String:

        length()            - devuelve la longitud de una cadena de caracteres.
        charAt(posicion)    - devuelve el caracter indicando su posicion dentro de una cadena.
        substring(x)        - devuelve una subcadena a partir de la posicion indicada hasta el final. 
        substring(x,y)      - devuelve una subcadena de una cadena, siendo x la posicon del carater a partir el 
                              cual se extrae e Y la posicion del caractere que termina.

        replace(x_old, x_new)               - remplaza un solo carácter en una cadena.
        replace(x_old, x_new).replace(y_old, y_new) - remplaza dos caracteres diferentes en una cadena
        replaceFirst(x_old, x_new)          - remplaza la primera aparición de un caracter o subcadena.
        replaceAll(cadena, cadena nueva)    - remplaza una secuencia de caracteres por una nueva
        replaceAll("\\s", "")               - quita los espacios en una cadena.

        endWith(cad)    - devuelve true si la cadena termina por la cadena pasada como argumento.
        startsWith(cad)   - devuelve true si la cadena comienza por la cadena pasada como argumento. 
        contains(cad)   - devuelve true si la cadena pasada por argumento esta contenida dentro de la cadena.
        trim()          - genera una copia de la cadena quitandole los espacios de delante y detras.
        concat()        - concatena cadenas. se puede pasar un literar o una variable String. es como usar el operador +.
        toUpperCase()   - devuelve la cadena en mayusculas.
        toLowerCase()   - devuelve la candena en minusculas.
        indexOf('x')    - devuelve la posición de la primera ocurrencia del caracter indicado.
        indexOf('x', n) - devuelve la posición de la primera ocurrencia del caracter indicado enpenzando a buscar por la posicion indicada.
        lastIndexOf('x')- devuelve la posición de la ultima ocurrencia del caracter indicado.
        equals(cadena)  - devuelve true si las cadenas que se comparan son iguales. Distingue entre mayusculas y minusculas.
        equalsignoreCase(cadena)    - igual que equals, pero sin tener en cuenta mayusculas y minusculas.


        Metodos envoltorios: ----------------------------------------------------------------

        Integer.parseInt(cadena)    - convierte el numero de la cadena de tipo string a un entero.
        Integer.toString(numero)    - convierte el numero a un string
        Integer.valueOf(cadena)     - igual que parseInt
        Integer.toBinaryString(numero) - Crea y devuelve una representación en binario del número entero como un String
        Double.parseDouble(cadena)  - convierte el string en un doble
        Double.toString(numero)

        Integer.MIN_VALUE; //constante Mínimo valor representable con int
        Integer.MAX_VALUE; //constante Máximo valor representable con int


        METODOS CLASE StringBuilder: ------------------------------------------------------------------

        StringBuilder nombre = new StringBuilder(cadena) - intancia e iniciacion de clase StringBuilder. se puede pasar por parametro una cadena o un objeto de tipo String
        
        reverse()       - invierte la cadena
        toString()      - pasa la cadena de tipo StringBuilder a tipo String
        append(cadena)  - añade en el final de la cadena la cadena pasada por parametro
        delete(pos inicio, pos fin)             - borra las posiciones definidas
        replace(pos inicio, pos fin, cadena)    - replaza los caracteres desde la posicion inicio hasta la poscion fin por la cadena pasada por parametro 
        
        COLORES:
        NOMBRE DEL COLOR	CODIGO DE COLOR		CÓDIGO DE COLOR DE FONDO
        NEGRO				\u001B[30m		    \u001B[40m
        ROJO				\u001B[31m		    \u001B[41m
        VERDE				\u001B[32m		    \u001B[42m
        AMARILLO			\u001B[33m		    \u001B[43m
        AZUL				\u001B[34m		    \u001B[44m
        PÚRPURA				\u001B[35m		    \u001B[45m
        CYAN				\u001B[36m		    \u001B[46m
        BLANCO				\u001B[37m		    \u001B[47m

        */
        System.out.println("Hola GitHub, esto es una prueba");
        String nombre = "David";
        String nombre2 = "Juan";
        String apellidos = "Jimenez Alonso";
        System.out.println("Mi nombre es " + nombre);
        System.out.println("Mi nombrbre tiene " + nombre.length() + " letras");
        System.out.println("La primera letra de mi nombre es " + nombre.charAt(0));
        System.out.println("Primer apellido: " + apellidos.substring(0, 7));
        System.out.println("Mi nombrbre tiene " + apellidos.length() + " letras");
        System.out.println("Segundo apellido: " + apellidos.substring(8, 14));
        System.out.println(nombre.equals(nombre2));
        int x = 10;
        int z = ++x%5;
        System.out.println("x: " + x + " z: " + z);

        
        //INVERTIR UNA CADENA -------------------------------------------------------------------------------------------------------
        System.out.println("\nInvertir una cadena ------------------"); 

        String cad = "David";
        String cad_invertida;
        StringBuilder cad_aux;

        cad_aux = (new StringBuilder(cad));
        cad_invertida = cad_aux.reverse().toString(); //usamos metodos de StringBuilder

        System.out.println("cadena: " + cad);
        System.out.println("cad_invertida: " + cad_invertida); 


        //FROMATO DE CADENA --------------------------------------------------------------------------------------------------------------------
        System.out.println("\nFORMATO DE CADENA EJEMPLO 1 ----------------------");
        float x1=27.5256F;
        
        //Con printf, imprimimos el numero dandole formato.
        System.out.printf("%.2f", x1); //imprime x con 2 decimales. Hay que poner prinf en vez de println


        System.out.println("\nFORMATO DE CADENA EJEMPLO 2 ----------------------");
        float precio=3.3f;
        System.out.println(precio);
        String salida=String.format("El precio es: %.3f", precio); //le damos formato con tres decimales
        System.out.println(salida);

        System.out.println("\nFORMATO DE CADENA EJEMPLO 3 ----------------------");
        System.out.println(10);
        System.out.println(String.format("%4d", 10)); //le decimos cuantas posiciones ocupa la cadena que vamos a mostrar por panatalla
        
        System.out.println("\nFORMATO DE CADENA EJEMPLO 4 ----------------------");
        System.out.println(10);
        int nun = 2;
        System.out.println(String.format("%1$4d mutiplicado por 10 es:  \n%2$7d multiplicado por 20 es: ", nun * 10, nun * 20));


    }
}
