package pruebas;

import java.util.Arrays;
import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        
       
       List<String> paises = Arrays.asList("Argentina", "bolivia", "bolivia", "Peru", "España", "Mexico", "Italia", "Inglaterra", "Francia");
       
       paises.stream()
        .distinct()
        .filter(pais -> pais.startsWith("It"))
        .forEach(pais -> System.out.println("pais: " + pais));

    }//Fin main.

   

}
