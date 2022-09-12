package pruebas;

import java.util.HashSet;

import javax.swing.JOptionPane;

/*
- Notas:
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
*/
public class Pruebas {
    public static void main(String[] args) {
        
        HashSet<Integer> conjunto = new HashSet<>();
        String str;

        do{
            str = JOptionPane.showInputDialog("Introduce un numero " + (conjunto.size()+1) + ":");
            try{
                Integer n = Integer.parseInt(str);
                if(!conjunto.add(n)){
                    JOptionPane.showMessageDialog(null, "Numero ya esta en la lista. debes introducir otro.");
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "numero erroneo.");
            }
        }while(conjunto.size() < 5);

        for(Integer i: conjunto){
            System.out.println("en la poscion " + i);
        }

        Integer suma = 0;
        for(Integer i: conjunto){
            suma = suma + i;
        }
        JOptionPane.showMessageDialog(null, "la suma es: " + suma);
    }
}
