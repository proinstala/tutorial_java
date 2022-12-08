package DAM_1.juez;

import java.util.Scanner;

public class juezUT4_1_3 {
    public static void main(String[] args) {
        int resultado;
        Scanner teclado = new Scanner(System.in);

        int a = teclado.nextInt();
        int b = teclado.nextInt();
        String operacion = teclado.next();

        switch(operacion){
            case "+":
                resultado = a+b;
                break;
            case "-":
            resultado = a-b;
                break;
            case "x":
            resultado = a*b;
                break;
            case ":":
            resultado = a/b ;
                break;
            default:
                System.out.println("ERROR");
                resultado = 0;
        }
        System.out.println(resultado);
    }
}
