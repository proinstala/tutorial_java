package juez;

import java.util.Scanner;

public class JuezUT3_3 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del modulo");
        String modulo = teclado.nextLine();
        System.out.println("Introduce la nota");
        float nota = teclado.nextFloat();
        System.out.println("La nota del modulo " + modulo + " es: " + nota);
    }
}
