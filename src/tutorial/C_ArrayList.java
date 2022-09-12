package tutorial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
- Clase ArrayList
- Constructor:
    ArrayList() - Construye una lista vacía con la capacidad inicial de 10.
    ArrayList(int capacidad_inicial) - Construye una lista vacía con la capacidad inicial especificada.
    ArrayList(Collection<? extends E> c) - Construye una lista que contiene los elementos de la colección especificada, en el orden en que los devuelve el iterador de la colección.


- interfaz Iterator:
    boolean	hasNext()           - Devuelve true si la iteración tiene más elementos.
    E next()                    - Devuelve el siguiente elemento de la iteración.
    default void remove()       - Elimina de la colección subyacente el último elemento devuelto por este iterador (operación opcional).
*/

public class C_ArrayList {
    public static void main(String[] args) {
        
        ArrayList <String> dias = new ArrayList<String>(); //<tipo de clase> | dias = instancia de clase.
        
        dias.add(new String("lunes")); //añadimos un elemento al final de la lista
        dias.add(new String("martes"));
        dias.add(new String("miercoles"));
        dias.add(new String("jueves"));
        dias.add(new String("viernes"));
        dias.add(new String("sabado"));
        dias.add(new String("domingo"));

        dias.trimToSize(); //quita el espacio reservado sin usar para optimizar recursos.

        System.out.println("EJEMPLO 1 ---------------------------------------------------");
        for(String d: dias){
            System.out.println(d);
        }


        System.out.println("\nEJEMPLO 2 ---------------------------------------------------");
        System.out.println(dias.get(5)); //obtiene el elemento en la posicion 5


        System.out.println("\nEJEMPLO 3 ---------------------------------------------------");
        String descanso = "domingo";
        if(dias.contains(descanso)){ //comprueba si el objeto esta en la lista de objetos dias
            System.out.println(descanso + " esta en la lista dias");
        }
        else{
            System.out.println(descanso + " no esta en la lista dias");
        } 


        System.out.println("\nEJEMPLO 4 ---------------------------------------------------");
        System.out.println(dias.size()); //imprimimos la cantidad de datos que tiene el array


        System.out.println("\nEJEMPLO 5 ---------------------------------------------------");
        //dias.remove(descanso); //elimina de la lista dias el objeto pasado por parametro. (descanso = domingo)
        dias.remove(6); //elimina de la lista el objeto en la posicio 6
        dias.add(6, "dominguete"); //añadimos en la posicion 6 el string "dominguete"
        System.out.println(dias.get(6));


        System.out.println("\nEJEMPLO 6 ---------------------------------------------------");
        Iterator <String> mi_iterador = dias.iterator();
        while(mi_iterador.hasNext()){ //devuelve true si hay mas elementos en el iterador
            System.out.println(mi_iterador.next()); //devuelve el siguiente elemento en el iterador
        }
        
        System.out.println("\nEJEMPLO 7 ---------------------------------------------------");
        ArrayList<Integer> lista=new ArrayList<Integer>();
        lista.add(10); lista.add(9);lista.add(8); lista.add(3); lista.add(5);

        for(Integer i: lista){  //imprimimos la lista
            System.out.println(i);
        }

        System.out.println("\nordenamos la lista");
        Collections.sort(lista); //ordenamos la lista


        for(Integer i: lista){  //imprimimos la lista
            System.out.println(i);
        }

        System.out.println("\ndamos la vuelta a la lista");
        Collections.reverse(lista); //damos la vuelta a la lista

        for(Integer i: lista){  //imprimimos la lista
            System.out.println(i);
        }

    }
}
