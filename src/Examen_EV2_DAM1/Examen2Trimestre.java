
package Examen_EV2_DAM1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author David Jimenez Alonso
 */
public class Examen2Trimestre {

    public static void main(String[] args) {
        boolean fin_partida = false;
        int turno = 1, jugadorGanador = 0, inserta = 0, nJugadores = 0;
        int m[][] = new int[6][7];
        
        Jugador jugador1 = new Jugador("Jugador1", Jugador.ROJO);
        Jugador jugador2 = new Jugador("Jugador2", Jugador.AMARILLO);
        Jugador jugador3 = new Jugador("Jugador3", Jugador.AZUL);
        
        
        Scanner teclado = new Scanner(System.in);
        
        do{
            System.out.println("Elige el numero de jugadores para esta partida");
            nJugadores = teclado.nextInt();
            if(nJugadores < 2 || nJugadores > 3){
                System.out.println("numero de jugadores elejido no valido");
            }
        }while(nJugadores < 2 || nJugadores > 3);
        
        System.out.println("Introduce el nombre de J1");
        jugador1.setNombre(teclado.next());
        
        System.out.println("Introduce el nombre de J2");
        jugador2.setNombre(teclado.next());
        
        if(nJugadores == 3){
            System.out.println("Introduce el nombre de J3");
            jugador3.setNombre(teclado.next());
        }
        
        while(fin_partida == false){
            
            try{
                imprimirMatriz(m);
                
                //TURNO JUGADOR 1 ------------------------------------------------------------------------------
                if(turno == 1){
                    System.out.println(jugador1.getColor() + jugador1.getNombre() + " - Elige una columna (0-6)");
                    inserta = teclado.nextInt();
                    if(inserta >= 0 && inserta <= 6){
                        jugador1.añadirMovimiento(inserta);
                    }
                    
                    for(int i=m.length -1;i>=0;i--){
                        if(m[i][inserta] == 0){
                            m[i][inserta] = 1;
                            break;
                        }
                    }
                }//FIN turno1
                
                //TURNO JUGADOR 2 ------------------------------------------------------------------------------
                if(turno == 2){
                    System.out.println(jugador2.getColor() + jugador2.getNombre() + " - Elige una columna (0-6)");
                    inserta = teclado.nextInt();
                    if(inserta >= 0 && inserta <= 6){
                        jugador2.añadirMovimiento(inserta);
                    }

                    for(int i=m.length -1;i>=0;i--){
                        if(m[i][inserta] == 0){
                            m[i][inserta] = 2;
                            break;
                        }
                    }
                }//FIN turno2
                
                //TURNO JUGADOR 3 ------------------------------------------------------------------------------
                if(turno == 3){
                    System.out.println(jugador3.getColor() + jugador3.getNombre() + " - Elige una columna (0-6)");
                    inserta = teclado.nextInt();
                    if(inserta >= 0 && inserta <= 6){
                        jugador3.añadirMovimiento(inserta);
                    }

                    for(int i=m.length -1;i>=0;i--){
                        if(m[i][inserta] == 0){
                            m[i][inserta] = 3;
                            break;
                        }
                    }
                }//FIN turno3
                
                if(turno == 2 && nJugadores == 2){
                    turno = 0;
                }
                else if(turno == 3){
                    turno = 0;
                }
                turno++;
                
                //comprobacion de puntuacion horizontal --------------------------------------------------------
                for(int i = 0, punt1 = 0,punt2 = 0, punt3 = 0; i < m.length; i++){ 
                    for(int j=0; j<m[0].length;j++){
                        if(m[i][j] == 1){ //comprobacion jugador 1
                            punt1++;
                            punt2 = 0;
                            punt3 = 0;
                            if(punt1 == 4){
                                fin_partida = true;
                                jugadorGanador = 1;
                            }
                        }else if(m[i][j] == 2){ //comprobacion jugador 2
                            punt2++;
                            punt1 = 0;
                            punt3 = 0;
                            if(punt2 == 4){
                                fin_partida = true;
                                jugadorGanador = 2;
                            }
                        }else if(m[i][j] == 3){ //comprobacion jugador 3
                            punt3++;
                            punt1 = 0;
                            punt2 = 0;
                            if(punt3 == 4){
                                fin_partida = true;
                                jugadorGanador = 3;
                            }
                        }else{
                            punt1 = 0;
                            punt2 = 0;
                            punt3 = 0;
                        }
                    }
                    
                }
                
                //comprobacion de puntuacion vertical ----------------------------------------------
                for(int i = 0, punt1 = 0, punt2 = 0, punt3 = 0; i < m[0].length; i++){ 
                    for (int j = 0; j < m.length; j++) {
                        if(m[j][i] == 1){ //comprobacion jugador 1
                            punt1++;
                            punt2 = 0;
                            punt3 = 0;
                            if(punt1 == 4){
                                fin_partida = true;
                                jugadorGanador = 1;
                            }
                        }else if(m[j][i] == 2){ //comprobacion jugador 2
                            punt2++;
                            punt1 = 0;
                            punt3 = 0;
                            if(punt2 == 4){
                                fin_partida = true;
                                jugadorGanador = 2;
                            }
                        }else if(m[j][i] == 3){ //comprobacion jugador 3
                            punt3++;
                            punt1 = 0;
                            punt2 = 0;
                            if(punt3 == 4){
                                fin_partida = true;
                                jugadorGanador = 3;
                            }
                        }else{
                            punt1 = 0;
                            punt2 = 0;
                            punt3 = 0;
                        }
                        
                    }
                }
                
                
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("\nValor introducido de columna no valido");
            }catch(InputMismatchException e){
                System.out.println("\nDeves introducir un valor de 0 a 6");
                teclado.next();
            }
            
        }//while
        
        imprimirMatriz(m);
        if(jugadorGanador == 1){
            System.out.println(jugador1.getColor() + "HA GANADO " + jugador1.getNombre());
            System.out.println(jugador1.getColor() + "Lista de movimientos: " + jugador1.getListaMovimientos());
        }
        else if(jugadorGanador == 2){
            System.out.println(jugador2.getColor() + "HA GANADO " + jugador2.getNombre());
            System.out.println(jugador2.getColor() + "Lista de movimientos: " + jugador2.getListaMovimientos());
        }
        else if(jugadorGanador == 3){
            System.out.println(jugador3.getColor() + "HA GANADO " + jugador3.getNombre());
            System.out.println(jugador3.getColor() + "Lista de movimientos: " + jugador3.getListaMovimientos());
        }
        
    
        
        
        
    }//FIN MAIN
    
    
    
    
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    public static int imprimirMatriz(int m[][]) {
        String pref;
        int conta=0;
        
        System.out.println("");
        
        for (int j=0; j<m[0].length-1; j++) System.out.print(j + "|");
        
        System.out.print(6);
        System.out.println("");

        for (int j=0; j<m[0].length-1; j++) System.out.print("==");
        
        System.out.print("=");
        System.out.println("");
             
        for(int i=0; i<m.length; i++){
            for (int j=0; j<m[i].length; j++){
                if (m[i][j] == 1){
                    pref = ROJO;
                    conta++;
                }    
                else if (m[i][j] == 2){
                    pref = AMARILLO;
                    conta++;
                }
                else if (m[i][j] == 3){
                    pref = AZUL;
                    conta++;
                }   
                else{
                    pref=NEGRO;
                }   
                
                System.out.print(pref + m[i][j] + " ");
            }    

            System.out.println("");
        }    
        
        System.out.println("");
        
        return conta;
    }

    
}
