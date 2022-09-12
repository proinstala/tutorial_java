package tutorial;

import java.util.HashMap;

/*
- Estas clases implementan la interfaz Map, que implementa la interfaza Collection.
- Asociacion Clave-Valor.
- No puede tener claves iguales.


- HashMap:                 - LinkedHashMap:                    - TreeMap:                  - EnumMap:
    * Rápida.                   * Ordenación por entrada.           * Es ordenado.              * La mejor para tipos enumerados.
    * No duplicados.            * Eficiente al acceder.             * Poco eficiente.
    * es ordenado.              * No eficiente al agregar.
    * No acceso aleatorio.


*/
public class I_map {
    public static void main(String[] args) {
        
        HashMap<String, String> mapa1 = new HashMap<String, String>();

        mapa1.put("3", "Miercoles"); //asocia el la clave especificada con el valor especificado
        mapa1.put("1", "Lunes"); 
        mapa1.put("2", "Martes");
        mapa1.put("6", "Sabado");
        mapa1.put("7", "Domingo");
        mapa1.put("4", "Jueves");
        mapa1.put("5", "Viernes");

        System.out.println("\nEjemplo 1---- " + mapa1);          //devuelve todas las claves-valor en una lista
        System.out.println("\nEjemplo 2---- " + mapa1.get("7")); //obtnemos el valor que tiene como llave 7
        System.out.println("\nEjemplo 3---- " + mapa1.size());   //devuelve un entero con la cantidad de claves-valor que contiene el mapa
        System.out.println("\nEjemplo 4---- " + mapa1.keySet()); //devuelve un set con las claves del mapa
        System.out.println("\nEjemplo 5---- " + mapa1.values()); //devuelve un set con los valores del mapa
        System.out.println("\nEjemplo 6---- " + mapa1.entrySet()); //devuelve un set con todas las claves-valor
        System.out.println("\nEjemplo 7---- " + mapa1.containsKey("5"));         //Devuelve verdadero si este mapa contiene un mapeo para la clave especificada.
        System.out.println("\nEjemplo 8---- " + mapa1.containsValue("Viernes")); //Devuelve verdadero si este mapa asigna una o más claves al valor especificado.

        System.out.println("\nEjemplo 9---- ");
        mapa1.remove("5"); //elimina el elemento que tiene como clave 5
        System.out.println(mapa1);
    }
}
