package tutorial;

import java.util.Iterator;
import java.util.LinkedList;

/*
metodos:
get(int index)              -devuelve un elemento especificado su posicion en la lista
getFirst()                  -devuelve el primer elemento de la lista
getLast()                   -devuelve el ultimo elemento de la lista
indexOf(Objet o)            -Devuelve el índice de la primera aparición del elemento especificado en esta lista, o -1 si esta lista no contiene el elemento.
set​(int index, E element)   -Reemplaza el elemento en la posición especificada en esta lista con el elemento especificado.
poll()                      -Recupera y elimina el encabezado (primer elemento) de esta lista.
peel()                      -Recupera, pero no elimina, el encabezado (primer elemento) de esta lista.
toArray()                   -Devuelve una matriz que contiene todos los elementos de esta lista en la secuencia adecuada (desde el primero hasta el último elemento).


- interfaz Iterator:
    boolean	hasNext()           - Devuelve true si la iteración tiene más elementos.
    E next()                    - Devuelve el siguiente elemento de la iteración.
    default void remove()       - Elimina de la colección subyacente el último elemento devuelto por este iterador (operación opcional).
*/

public class C_LinkedList {
    public static void main(String[] args) {
        

        LinkedList<String> personas = new LinkedList<String>();

        personas.add("pepe"); //insertamos el objeto al final de la lista.
        personas.add("sandra");
        personas.add("ana");
        personas.add("laura");
        personas.add(0, "juan"); //insertamos el objeto en la posicion indicada.
        personas.add(personas.indexOf("ana") +1, "david"); //inserta david despues de ana.

        System.out.println("EJEMPLO 1 ---------------------------------------");
        System.out.println(personas.size()); //imprime el tamaño que tiene el LinkedList
        
        for (String per : personas) {
            System.out.println(per);
        }

        System.out.println("\nEJEMPLO 2 ---------------------------------------");
        System.out.println(personas.get(1));         //obtenemos el objeto que esta en la posicion 1 de la lista
        System.out.println(personas.indexOf("ana")); //obtenemos la posicion del objeto que coincide con el parametro especificado


        System.out.println("\nEJEMPLO 3 ---------------------------------------");
        String mi_matriz[] = personas.toArray(new String[0]); //pasamos el LinkedList a un Array

        for (String s : mi_matriz) { //imprimimos el Array mi_matriz
            System.out.println(s);
        }

        
        System.out.println("\nEJEMPLO 4 ---------------------------------------");
        Iterator <String> mi_iterador = personas.iterator();
        while(mi_iterador.hasNext()){
            System.out.println(mi_iterador.next());
        }
        

    }
}
