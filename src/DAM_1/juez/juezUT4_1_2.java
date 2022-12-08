package DAM_1.juez;

import java.util.Scanner;

public class juezUT4_1_2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        int a = teclado.nextInt();
        int b = teclado.nextInt();
        if(a >= 5){
            System.out.println("APROBADO");
        }else{
            System.out.println("SUSPENSO");
        }
        
        System.out.println("========");
        
        if(b >= 5){
            System.out.println("APROBADO");
        }else{
            System.out.println("SUSPENSO");
        }
        System.out.println("========");
    }
}
