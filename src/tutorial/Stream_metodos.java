package tutorial;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
/*
- skip(long n) -> Se utiliza para omitir (es decir, saltar) un número específico de elementos desde el inicio de un Stream. 
- limit(long maxSize) -> se utiliza para restringir el tamaño de un Stream a un número máximo de elementos.

- distinct() ->  
    Se utiliza para eliminar elementos duplicados de un Stream. 
    El método compara los elementos utilizando el método equals de los objetos para determinar si son iguales.

- sorted() -> 
    Se utiliza para ordenar los elementos de un Stream según un criterio especificado. 
    Hay dos variantes de este método: orden natural o pasandole un comparador.


-  peek(Consumer<? super T> action) -> 
    se utiliza para realizar una operación intermedia en los elementos de un Stream. 
    Este método es útil para depuración o para realizar operaciones secundarias en los elementos, 
    como registrar los valores, sin modificar el flujo en sí.

- dropWhile(Predicate<? super T> predicate) ->  
    se utiliza para descartar elementos de un flujo mientras una condición específica se mantenga verdadera. 
    Una vez que se encuentra un elemento que no cumple con la condición, el flujo incluirá ese elemento y todos los elementos restantes, 
    sin evaluar la condición para los elementos posteriores. 

- takeWhile(Predicate<? super T> predicate) -> 
    se utiliza para tomar elementos de un flujo mientras una condición específica se mantenga verdadera. 
    Una vez que se encuentra un elemento que no cumple con la condición, el flujo se detiene y no incluye ese ni los elementos posteriores.



*/
import java.util.stream.Collectors;


public class Stream_metodos {

    public record Coche(String marca, int caballos) {}
    
    public static void main(String[] args) {

        List<Coche> listaCoches = Arrays.asList(
            new Coche("Opel", 95), 
            new Coche("Ford", 100), 
            new Coche("Renault", 105),
            new Coche("Seat", 120),
            new Coche("Fiat", 85),
            new Coche("Audi", 135),
            new Coche("Ferrari", 210)
        );
        
        List<String> listaContinetes = Arrays.asList("America", "Europa", "Asia", "America", "Africa", "Oceania");

        System.out.println("\n1) Imprimimos la lista de continentes: ");
        listaContinetes.stream().forEach(System.out::println);


        //skip
        System.out.println("\n2) Imprimimos la lista de continentes a partir del 2: ");
        listaContinetes.stream().skip(2).forEach(System.out::println);

        //limit
        System.out.println("\n3) Imprimimos los 3 primeros elementos de la lista de continentes: ");
        listaContinetes.stream().limit(3).forEach(System.out::println);

        //peek
        System.out.println("\n4) Imprimimos los 2 primeros elementos de la lista de continentes: ");
        listaContinetes.stream()
            .peek(str -> System.out.println("pasa por peek. pais: " + str)) //Es un consumidor de la lista
            .limit(2)
            .forEach(System.out::println);
        
        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("\n4.2) Otro ejemplo con peek: ");
        List<Integer> resultado = numeros.stream()
            .peek(n -> System.out.println("Procesando número: " + n))
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("Número par: " + n))
            .collect(Collectors.toList());

        System.out.println("Números pares: " + resultado);
        
        //drop while
        System.out.println("\n5) Ordena los cohes por caballos y descarta los que tengan menos de 100 caballos: ");
        listaCoches.stream()
            .sorted((c1, c2) -> Integer.compare(c1.caballos, c2.caballos))
            .dropWhile(coche -> coche.caballos < 100)
            .forEach(System.out::println);

        System.out.println("\n6) Usando dropWhile sin ordenar. descarta los que tengan menos de 100 caballos hasta que uno cumpla la condición: ");
        listaCoches.stream()
            .dropWhile(coche -> coche.caballos < 100)
            .forEach(System.out::println);


        //takeWhile
        System.out.println("\n7) Toma todos los números menores que 5 desde el inicio hasta que encuentres un número que no sea menor que 5: ");
        List<Integer> numeros2 = numeros.stream().takeWhile(n -> n < 5).collect(Collectors.toList());
        System.out.println("resultado: " + numeros2);


        //sorted
        List<Integer> numerosAleatorios = List.of(5, 3, 8, 1, 9, 2);
        List<Integer> numerosAleatoriosOrdenados = numerosAleatorios.stream()
            .sorted()
            .collect(Collectors.toList());
            System.out.println("\n8) Ordena los numeros por orden natural: ");
        System.out.println(numerosAleatoriosOrdenados); // Salida: [1, 2, 3, 5, 8, 9]

        //distinct
        System.out.println("\n9) Imprime los paises de la lista descartando elementos duplicados: ");
        listaContinetes.stream().distinct().forEach(c -> System.out.print(" " + c));

    }
}
