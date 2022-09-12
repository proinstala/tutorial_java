
package Examen_EV2_DAM1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author David Jimenez Alonso
 */
public class Examen_EV2_Revisado {

    public static void main(String[] args) {
        boolean fin_partida = false;
        int turno = 1, jugadorGanador = 0, inserta = 0, nJugadores = 0, jugada =0, fila, colum;
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
                    do{
                        System.out.println(jugador1.getColor() + jugador1.getNombre() + " - elige introducir ficha(0), o quitar ficha(1)");
                        jugada = teclado.nextInt();
                        if(jugada < 0 || jugada > 1) System.out.println("Eleccin no contemplada!!!");
                    }while(jugada != 0 && jugada != 1);
                    
                    if(jugada == 0){
                        System.out.println(jugador1.getColor() + jugador1.getNombre() + " - Elige una columna (0-6)");
                        inserta = teclado.nextInt();
                        if(inserta >= 0 && inserta <= 6){
                            jugador1.añadirMovimiento(inserta);
                        }
                        insertar(m, inserta, turno);

                    }else if(jugada == 1){
                        System.out.print("fila(0-5): ");
                        fila = teclado.nextInt();
                        System.out.print("columna(0-6): ");
                        colum = teclado.nextInt();
                        quitarFicha(m, fila, colum);
                    }
                    
                }//FIN turno1
                
                //TURNO JUGADOR 2 ------------------------------------------------------------------------------
                if(turno == 2){
                    do{
                        System.out.println(jugador2.getColor() + jugador2.getNombre() + " - elige introducir ficha(0), o quitar ficha(1)");
                        jugada = teclado.nextInt();
                        if(jugada < 0 || jugada > 1) System.out.println("Eleccin no contemplada!!!");
                    }while(jugada != 0 && jugada != 1);
                    
                    if(jugada == 0){
                        System.out.println(jugador2.getColor() + jugador2.getNombre() + " - Elige una columna (0-6)");
                        inserta = teclado.nextInt();
                        if(inserta >= 0 && inserta <= 6){
                            jugador2.añadirMovimiento(inserta);
                        }
                        insertar(m, inserta, turno);

                    }else if(jugada == 1){
                        System.out.print("fila(0-5): ");
                        fila = teclado.nextInt();
                        System.out.print("columna(0-6): ");
                        colum = teclado.nextInt();
                        quitarFicha(m, fila, colum);
                    }
                    
                }//FIN turno2
                
                //TURNO JUGADOR 3 ------------------------------------------------------------------------------
                if(turno == 3){
                    do{
                        System.out.println(jugador3.getColor() + jugador3.getNombre() + " - elige introducir ficha(0), o quitar ficha(1)");
                        jugada = teclado.nextInt();
                        if(jugada < 0 || jugada > 1) System.out.println("Eleccin no contemplada!!!");
                    }while(jugada != 0 && jugada != 1);
                    
                    if(jugada == 0){
                        System.out.println(jugador3.getColor() + jugador3.getNombre() + " - Elige una columna (0-6)");
                        inserta = teclado.nextInt();
                        if(inserta >= 0 && inserta <= 6){
                            jugador3.añadirMovimiento(inserta);
                        }
                        insertar(m, inserta, turno);

                    }else if(jugada == 1){
                        System.out.print("fila(0-5): ");
                        fila = teclado.nextInt();
                        System.out.print("columna(0-6): ");
                        colum = teclado.nextInt();
                        quitarFicha(m, fila, colum);
                    }
                }//FIN turno3
                
                
                turno = turno(turno, nJugadores);
                
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
                System.out.println("\nDeves introducir el valor 0 para insertar ficha o 1 para borrar ficha\n" +
                "Deves introducir un valor de 0 a 6 para introducir ficha");
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
    
    //inserta la ficha del jugador "j" en la columna "c".
    //recorre la columna "c" de abajo hacia arriva para buscar el primer hueco vacio (0).
    public static void insertar(int m[][], int c, int j){
        for(int i=m.length -1;i>=0;i--){
            if(m[i][c] == 0){
                m[i][c] = j;
                break;
            }
        }
    }


    //devuelve el turno de jugador.
    public static int turno(int turno, int numJ){
        if(turno == 2 && numJ == 2){
            turno = 0;
        }
        else if(turno == 3){
            turno = 0;
        }
        turno++;
        
        return turno;
    }

    //quita la ficha de la posicion elejida
    public static void quitarFicha(int m[][], int f, int c){
        if(m[f][c] != 0){
            m[f][c] = 0;
            for(int i=f;i>=1;i--){
                if(m[i-1][c] != 0){
                    m[i][c] = m[i-1][c];
                    m[i-1][c] = 0;
                }
                else{
                    break;
                }
            }
        } 
    }
    
    
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
