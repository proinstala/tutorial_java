package juez;

import java.util.Scanner;

public class juezUT3_5 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("MIN=" + Integer.MIN_VALUE + " MAX=" + Integer.MAX_VALUE);
        
        System.out.println("Introduce un número entero");
        int a = teclado.nextInt();
        String s = Integer.toString(a);
        System.out.println("String:" + s);
        System.out.println("ValueOf:" + Integer.valueOf(s) + " ParseInt:" + Integer.parseInt(s));
        System.out.println("Binario:" + Integer.toBinaryString(a));
    }
}
