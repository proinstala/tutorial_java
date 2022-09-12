package juez;

import java.util.Scanner;

public class juezUT3_4 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("PI=" + Math.PI);
        System.out.println("Introduce dos números enteros");
        int a = teclado.nextInt();
        int y = teclado.nextInt();
        System.out.println("abs(x)=" + Math.abs(a) + " abs(y)=" + Math.abs(y));
        System.out.println("El mayor es:" + Math.max(a, y));
        System.out.println("Potencia(x^y):" + Math.pow(a, y));
        System.out.println("Raiz(y):" + Math.sqrt(y));
    }
}
