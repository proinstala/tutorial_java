package DAM_1.Tareas;

import java.util.Scanner;

public class TareaUT4_2 {
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        int valor1;
        int valor2;
        int tiro = 1;
        int resultado = 0;

        System.out.println("Dime el valor actual del marcador:");
        valor1 = teclado.nextInt();
        System.out.println("");

        while(tiro < 4){
            System.out.println("Dime el valor actual del marcador:");
            valor2 = teclado.nextInt();
            resultado = valor2 - valor1;
            System.out.println("Tiro " + tiro);

            switch (resultado) {
                case 0:
                    System.out.println("Fallo\n");
                    valor1 = valor2;
                    tiro++;
                    break;
                
                case 1:
                    System.out.println("Tiro libre\n");
                    valor1 = valor2;
                    tiro++;
                    break;

                case 2:
                    System.out.println("Canasta de dos\n");
                    valor1 = valor2;
                    tiro++;
                    break;
                
                case 3:
                    System.out.println("Triple!!\n");
                    valor1 = valor2;
                    tiro++;
                    break;

                default:
                    System.out.println("El valor introducido no es correcto\n");
                    break;
            }


        }
    }
}
