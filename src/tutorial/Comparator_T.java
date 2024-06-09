package tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/* Comparator.
 * Es una interfaz funcional utilizada para definir un orden total sobre un conjunto de objetos. 
 * 
 * Puedes usar un Comparator para personalizar el orden en que se ordenan los objetos, 
 * ya sea por un campo específico o por una combinación de campos.
 * 
 * 
 * 
 */

public class Comparator_T {

    public record Persona(String nombre, int edad) {}
    public record Coche(String marca, int caballos) {}
    
    public static void main(String[] args) {
        
        Persona persona1 = new Persona("David", 38);
        Persona persona2 = new Persona("Juan", 40);
        Persona persona3 = new Persona("Alberto", 26);

        System.out.println("Imprimimos las personas: ");
        List<Persona> listaPersonas = List.of(persona1, persona2, persona3);
        for(Persona p : listaPersonas) {
            System.out.println(p);
        }

        System.out.println("\n1) Imprimimos las personas ordenadas: ");
        listaPersonas.stream()
            .sorted((per1, per2) -> Integer.compare(per1.edad(), per2.edad()))
            .forEach(p-> System.out.println(p));
        


        System.out.println("\n2) Imprimimos las personas ordenadas: ");
        listaPersonas.stream()
            .sorted((per1, per2) -> Integer.compare(per1.edad(), per2.edad()))
            .forEach(System.out::println);

        // Ordenar la lista por edad utilizando un comparador lambda
        // List.of() devuelve una lista inmutable, por lo que necesitamos una lista mutable para ordenar
        List<Persona> listaPersonasMutable = new ArrayList<>(listaPersonas);
        listaPersonasMutable.sort((per1, per2) -> Integer.compare(per1.edad(), per2.edad()));

        System.out.println("\n3) Imprimimos las personas ordenadas: ");
        System.out.println(listaPersonasMutable);



        //-------------------------------------------------------------------------------------------
        //Creando un comparador.

        List<Coche> listaCoches = Arrays.asList(
            new Coche("Opel", 95), 
            new Coche("Ford", 100), 
            new Coche("Renault", 105),
            new Coche("Seat", 120),
            new Coche("Fiat", 85),
            new Coche("Audi", 135),
            new Coche("Ferrari", 210)
        );

        //Comparator. Ordena por marca. 
        Comparator<Coche> comparadorCochesPorMarca = new Comparator<Coche>() {
            @Override
            public int compare(Coche c1, Coche c2) {
                return c1.marca().compareTo(c2.marca());
            }
        };

        //Comparator usando expresión lambda. Ordena por marca.
        Comparator<Coche> comparadorCochesPorMarca_lambda = (c1, c2) -> c1.marca().compareTo(c2.marca());

        //Comparator usando el método estático. Ordena por marca y por caballos.
        Comparator<Coche> comparadorMultipleCoche = Comparator
            .comparing(Coche::marca)
            .thenComparing(Coche::caballos);


        //Para probar los diferentes comparadores, cambia el de este metodo por uno de los definidos anteriormente.
        // comparadorCochesPorMarca
        // comparadorCochesPorMarca_lambda
        // comparadorMultipleCoche
        Collections.sort(listaCoches, comparadorMultipleCoche);

        System.out.println("\n4) Imprimimos la lista de coches ordenada: ");
        for(Coche coche : listaCoches) {
            System.out.println(coche.toString());
        }

    }
}
