package tutorial;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 - HashSet:                 - LinkedHashSet:                    - TreeSet:                  - EnumSet:
    * Rápida.                   * Ordenación por entrada.           * Es ordenado.              * La mejor para tipos enumerados.
    * No duplicados.            * Eficiente al acceder.             * Poco eficiente.
    * es ordenado.              * No eficiente al agregar.
    * No acceso aleatorio.

 - metodos:
    Método int size(): retorna el número de elementos de la colección.
    Método boolean isEmpty(): retornará verdadero si la colección está vacía.
    Método boolean contains (Object element): retornará verdadero si la colección tiene el elemento pasado como parámetro.
    Método boolean add(E element): permitirá añadir elementos a la colección.
    Método boolean remove (Object element): permitirá eliminar elementos de la colección.
    Método Iterator<E> iterator(): permitirá crear un iterador para recorrer los elementos de la colección. Esto se ve más adelante, no te preocupes.
    Método Object[] toArray(): permite pasar la colección a un array de objetos tipo Object.
    Método containsAll(Collection<?> c): permite comprobar si una colección contiene los elementos existentes en otra colección, si es así, retorna verdadero.
    Método addAll (Collection<? extends E> c): permite añadir todos los elementos de una colección a otra colección, siempre que sean del mismo tipo (o deriven del mismo tipo base).
    Método boolean removeAll(Collection<?> c): si los elementos de la colección pasada como parámetro están en nuestra colección, se eliminan, el resto se quedan.
    Método boolean retainAll(Collection<?> c): si los elementos de la colección pasada como parámetro están en nuestra colección, se dejan, el resto se eliminan.
    Método void clear(): vacíar la colección.


 - interfaz Iterator:
    boolean	hasNext()           - Devuelve true si la iteración tiene más elementos.
    E next()                    - Devuelve el siguiente elemento de la iteración.
    default void remove()       - Elimina de la colección subyacente el último elemento devuelto por este iterador (operación opcional).

*/

public class I_set {
    public static void main(String[] args) {
        
        String uno = "enero";
        String dos = "febrero";
        String tres = "marzo";
        String cuatro = "abril";
        String cinco = "mayo";
        String seis = "junio";
        

        System.out.println("EJEMPLO 1 ----------------------------------------------");
        Set <String> lista1 = new HashSet<String>();
        lista1.add(uno);
        lista1.add(dos);
        lista1.add(tres);
        lista1.add(cuatro);
        
        for (String i : lista1) {
            System.out.println(i);
        }


        System.out.println("\nEJEMPLO 2 ----------------------------------------------");
        Iterator<String> it = lista1.iterator();
        
        while(it.hasNext()){ //devuelve true si hay mas elementos en el iterador
            System.out.println(it.next()); //devuelve el siguiente elemento en el iterador
        }


        System.out.println("\nEJEMPLO 3 ----------------------------------------------");
        //ordena los objetos con la interfaz Comparator<T>
        Set<String> lista2 = new TreeSet<String>();
        lista2.add(uno);
        lista2.add(tres);
        lista2.add(cuatro);
        lista2.add(seis);
        lista2.add(cinco);

        for (String s : lista2) {
            System.out.println(s);
        }
    }
}
