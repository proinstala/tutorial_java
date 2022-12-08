/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAM_1.Examen_EV1_DAM1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author david jimenez
 */
public class Jimenez_alonso_david_eje2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int valor = 0;
        int valorm = 0;
        boolean correcto1 = false;
        String valorAux = "";
        int partida = 0;
        int puntos1 = 0;
        int puntos2 = 0;

        while(partida < 3){
            correcto1 = false;
            System.out.println(
                "introduce la opción\n" +
                "0 - piedra\n" +
                "1 - papel\n" + 
                "2 - tijera");
            
            while(correcto1 == false){
                try{
                    valor = teclado.nextInt();
                    if(valor >= 0 && valor <= 2){
                        correcto1 = true;
                    }
                    else{
                        System.out.println("esa opcion no se contempla");
                    }
                    
                }catch(NumberFormatException e){
                    System.out.println("Error - El valor introducido no es valido\n");
                }catch(InputMismatchException e){
                    System.out.println("Error - El valor introducido no es valido\n");
                    teclado.next();
                }
            }
                
            if(valor == 0){
                valorAux = "piedra";
            }
            else if(valor == 1){
                valorAux = "papel";
            }
            else if(valor == 2){
                valorAux = "tijera";
            }

            System.out.println("El jugador a jugado: " + valorAux);
            
            valorm = (int)Math.round(Math.random()*2);
            if(valorm == 0){
                valorAux = "piedra";
            }
            else if(valorm == 1){
                valorAux = "papel";
            }
            else if(valorm == 2){
                valorAux = "tijera";
            }
            System.out.println("la maquina ha jugado " + valorAux);

            if(valor == 0 && valorm == 2 || valor == 1 && valorm == 0 || valor == 2 && valorm == 1){
                partida++;
                puntos1++;
                System.out.println("Gana el jugador");
            }
            else if(valorm == 0 && valor == 2 || valorm == 1 && valor == 0 || valorm == 2 && valor == 1){
                partida++;
                puntos2++;
                System.out.println("Gana la maquina");
            }
            else{
                System.out.println("Empate");
            }

            if(puntos1 < 2 && puntos2 < 2){
                System.out.println("MARCADOR PARCIAL");
                System.out.println("----------------");
                System.out.println("Ganadas por el jugador " + puntos1);
                System.out.println("Ganadas por la maquina " + puntos2);
            }
            else{
                partida = 3;
            }
        }
        if(puntos1 > puntos2){System.out.println("ha ganado el jugador");}
        if(puntos2 > puntos1){System.out.println("ha ganado la maquina");}
        System.out.println("Gandas por el jugador " + puntos1);
        System.out.println("Gandas por la maquina " + puntos2);
    }
    
}
