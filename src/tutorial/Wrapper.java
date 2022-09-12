package tutorial;

/*
Clases de contenedor Java
Clases de envoltura proporcionan una manera de utilizar los tipos de datos primitivos ( int, boolean, etc ..) como objetos.

Primitive Data Type || Wrapper Class

byte                    Byte
short                   Short
int                     Interger
long                    Long
float                   Float
double                  Double
boolean                 Boolean
char                    Character

Integer.parseInt(cadena)    - convierte el numero de la cadena de tipo string a un entero.
Integer.toString(numero)    - convierte el numero a un string
Integer.valueOf(cadena)     - igual que parseInt
Integer.toBinaryString(numero) - Crea y devuelve una representación en binario del número entero como un String
Double.parseDouble(cadena)  - convierte el string en un doble
Double.toString(numero)

Integer.MIN_VALUE; //constante Mínimo valor representable con int
Integer.MAX_VALUE; //constante Máximo valor representable con int

*/

public class Wrapper {
    public static void main(String[] args) {

        System.out.println("\nEJEMPLO 1 ------------------------------");
        //Para crear un objeto contenedor, use la clase contenedora en lugar del tipo primitivo. 
        //Para obtener el valor, simplemente puede imprimir el objeto:
        Integer myInt = 5;
        Double myDouble = 5.99;
        Character myChar = 'A';
        System.out.println(myInt);
        System.out.println(myDouble);
        System.out.println(myChar);


        System.out.println("\nEJEMPLO 2 ------------------------------");
        /*
        Dado que ahora está trabajando con objetos, puede usar ciertos métodos para obtener información sobre el objeto específico.
        Por ejemplo, se utilizan los siguientes métodos para obtener el valor asociado con el objeto de envoltura correspondiente: 
        intValue(), byteValue(), shortValue(), longValue(), floatValue(), doubleValue(), charValue(), booleanValue().
        */
        Integer myInt2 = 5;
        Double myDouble2 = 5.99;
        Character myChar2 = 'A';
        System.out.println(myInt2.intValue());
        System.out.println(myDouble2.doubleValue());
        System.out.println(myChar2.charValue());


        System.out.println("\nEJEMPLO 3 ------------------------------");
        /*
        Otro método útil es el toString()método, que se utiliza para convertir objetos de envoltura en cadenas.
        En el siguiente ejemplo, convertimos an en Integera String, y usamos el length()método de la Stringclase para generar la longitud de la "cadena":
        */
        Integer myInt3 = 100;
        String myString = myInt3.toString();
        System.out.println(myString.length());


        System.out.println("\nEJEMPLO 4 ------------------------------");

        System.out.println("Mínimo valor de byte: " + Byte.MIN_VALUE); //constante Mínimo valor representable con byte
        System.out.println("Maximo valor de byte: " + Byte.MAX_VALUE); //constante Máximo valor representable con byte

        System.out.println("Mínimo valor de short: " + Short.MIN_VALUE); //constante Mínimo valor representable con short
        System.out.println("Maximo valor de short: " + Short.MAX_VALUE); //constante Máximo valor representable con short

        System.out.println("Mínimo valor de int: " + Integer.MIN_VALUE); //constante Mínimo valor representable con int
        System.out.println("Maximo valor de int: " + Integer.MAX_VALUE); //constante Máximo valor representable con int

        System.out.println("Mínimo valor de long: " + Long.MIN_VALUE); //constante Mínimo valor representable con long
        System.out.println("Maximo valor de long: " + Long.MAX_VALUE); //constante Máximo valor representable con long

        System.out.println("Mínimo valor de float: " + Float.MIN_VALUE); //constante Mínimo valor representable con float
        System.out.println("Maximo valor de float: " + Float.MAX_VALUE); //constante Máximo valor representable con float

        System.out.println("Mínimo valor de double: " + Double.MIN_VALUE); //constante Mínimo valor representable con double
        System.out.println("Maximo valor de double: " + Double.MAX_VALUE); //constante Máximo valor representable con double
        
    }
}
