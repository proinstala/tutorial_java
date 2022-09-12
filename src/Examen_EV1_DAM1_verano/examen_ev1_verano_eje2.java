package Examen_EV1_DAM1_verano;

import java.util.InputMismatchException;
import java.util.Scanner;

public class examen_ev1_verano_eje2 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int puntos_j1 = 0;
        int puntos_m = 0;
        int opcionJugador = 0; 
        int opcionMaquina = 0; 
        // opcion 0 = piedra
        // opcion 1 = papel
        // opcion 2 = tijera

        System.out.println("JUEGO PIEDRA-PAPEL-TIJERA");

        while(puntos_j1 < 2 && puntos_m < 2){

            System.out.println("OPCIONES:");
            System.out.println("0 - Piedra \n1 - Papel \n2 - Tijera");
            System.out.print("\nIntroduce la opcion: ");

            try {
                opcionJugador = teclado.nextInt();
                if(opcionJugador > 2) throw new OpcionException();

            } catch (InputMismatchException e) {
                System.out.println(OpcionException.OPCION_INCORRECTA);
                teclado.next(); //con esto corregimos el error de que se queda todo el tiempo leyendo la entrada.
                continue;
                
            } catch (OpcionException e){
                System.out.println(e.getMessage());
                continue;
            }

            

            System.out.print("\nEl jugador ha elejido: ");
            switch (opcionJugador) {
                case 0:
                    System.out.println("PIEDRA");
                    break;
                case 1:
                    System.out.println("PAPEL");
                    break;
                case 2:
                    System.out.println("TIJERA");
                    break;
            }

            opcionMaquina = (int)(Math.random()*3);
            System.out.print("La maquina ha elejido: ");
            switch (opcionMaquina) {
                case 0:
                    System.out.println("PIEDRA");
                    break;
                case 1:
                    System.out.println("PAPEL");
                    break;
                case 2:
                    System.out.println("TIJERA");
                    break;
            }

            if(opcionJugador == opcionMaquina){
                System.out.println("-------- EMPATE -------------");

            } else if (opcionJugador == 0 && opcionMaquina == 1) {
                System.out.println("----- Gana la maquina! ------");
                puntos_m++;

            } else if (opcionJugador == 0 && opcionMaquina == 2){
                System.out.println("----- Gana el jugador! ------");
                puntos_j1++;

            } else if (opcionJugador == 1 && opcionMaquina == 0){
                System.out.println("----- Gana el jugador! ------");
                puntos_j1++;

            } else if (opcionJugador == 1 && opcionMaquina == 2){
                System.out.println("----- Gana la maquina! ------");
                puntos_m++;

            } else if (opcionJugador == 2 && opcionMaquina == 0){
                System.out.println("----- Gana la maquina! ------");
                puntos_m++;

            } else if (opcionJugador == 2 && opcionMaquina == 1){
                System.out.println("----- Gana el jugador! ------");
                puntos_j1++;
            }

            System.out.println(
                "\nMARCADOR PARCIAL" +
                "\n----------------" +
                "\nJugador: " + puntos_j1 + " || Maquina: " + puntos_m +
                "\n");

        


        }//fin while

        System.out.println("\n\n\n----FIN DE PARTIDA ---------\n");
        if(puntos_j1 > puntos_m){
            System.out.println("Ha ganado el jugador!!!!!!!");
        } else{
            System.out.println("Ha ganado la maquina!!!!!!!");
        }

        System.out.println("Puntos jugador: " + puntos_j1);
        System.out.println("Puntos maquina: " + puntos_m);

    }//fin main
}//fin clase examen_ev1_verano_eje2
