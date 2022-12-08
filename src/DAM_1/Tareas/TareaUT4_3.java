package DAM_1.Tareas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TareaUT4_3 {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        int op = 0,y = 0,aux = 0;
        boolean correcto1, correcto2, correcto3;
        String x;

        while(op != 8){
            correcto1 = false;
            correcto2 = false;
            correcto3 = false;
            System.out.println("Elige una opción:");
            System.out.println(
                "1. Sumar (x+y)\n" +
                "2. Restar (x-y)\n" +
                "3. Multiplicar (x*y)\n" +
                "4. Dividir (x/y)\n" +
                "5. Resto de la división entera (x%y)\n" +
                "6. Raíz cuadrada (\u221Ax)\n" +
                "7. Potencia (x^y)\n" +
                "8. Salir\n");
            
            while(correcto1 == false || correcto2 == false || correcto3 == false){
                try{
                    while(correcto1 == false){
                        System.out.print("Opción: ");
                        op = entrada.nextInt();
                        if(op > 0 && op < 8){
                            correcto1 = true;
                        }else if(op == 8){
                            correcto1 = true;
                            correcto2 = true;
                            correcto3 = true;
                        }
                        else{
                            System.out.println("Error - Esa opción no se contempla en el menu\n");
                        }
                    }
                        
                    if(correcto1 == true && correcto2 == false){
                        System.out.print("introduce el valor de x: ");
                        System.out.print("");
                        x = entrada.next();
                        aux = Integer.parseInt(x);
                        correcto2 = true;
                        }

                    if(op != 6 && correcto3 == false){
                        System.out.print("introduce el valor de y: ");
                        y = entrada.nextInt();
                        if(op == 4 || op == 5){int division = aux / y;}
                        correcto3 = true;
                    }
                    else{
                        correcto3 = true;
                    }
                
                }catch(NumberFormatException e){ //Salta cuando da error al convertir una cadena a un entero
                    System.out.println("Error 1 - El valor introducido no es valido\n");
                    if(correcto1 == false)op = 0;
                }catch(InputMismatchException e){ //Salta si el formato que se introduce no es el esperado
                    System.out.println("Error 2 - El valor introducido no es valido\n");
                    entrada.next();
                    if(correcto1 == false)op = 0;
                }catch(ArithmeticException e){
                    System.out.println("Error 3 - No se puede dividir entre 0\n");
                }
            }

            if(op == 1){ //Sumar
                System.out.println("SUMAR --- " + aux + " + " + y + " = " + (aux + y) + "\n");
            }
            else if(op == 2){ //Restar
                System.out.println("RESTAR --- " + aux + " - " + y + " = " + (aux - y) + "\n");
            }
            else if(op == 3){ //Multiplicar
                System.out.println("MULTIPLICAR --- " + aux + " x " + y + " = " + (aux * y) + "\n");
            }
            else if(op == 4){ //Dividir
                System.out.println("DIVIDIR --- " + aux + " / " + y + " = " + (aux / y) + "\n");  
            }
            else if(op == 5){ //Resto de la division entera  
                System.out.println("RESTO DE DIVISION --- " + aux + " % " + y + " = " + (aux % y) + "\n"); 
            }
            else if(op == 6){ //Raiz cuadrada
                System.out.println("RAIZ CUADRADA --- \u221A" + aux + " = " + Math.sqrt(aux) + "\n");
            }
            else if(op == 7){ //Potencia
                System.out.println("POTENCIA --- " + aux + " ^ " + y + " = " + Math.pow(aux, y) + "\n"); 
            }
            else if(op == 8){ //Salir
                System.out.println("Adiós");
            }
        }
    }
}
