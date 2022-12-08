package DAM_1.Examen_EV2_DAM1_verano;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Examen_EV2_verano {

    public static final String ROJO_FONDO = "\u001B[41m";
    public static final String NEGRO_FONDO = "\u001B[40m";

    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String BLANCO = "\u001B[37m";

    public static void main(String[] args) {
        
        int tablero[][] = new int[6][7];
        int turno = 1;
        int quitarFicha = 0;
        int numeroJugadores = 0;
        int columna = 0;
        int borraColumna;
        int borraFila;

        Jugador j1 = new Jugador("j1", Jugador.ROJO);
        Jugador j2 = new Jugador("j2", Jugador.AMARILLO);
        Jugador j3 = new Jugador("j3", Jugador.AZUL);
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("HOLA. Bienvenido al juego de Conecta 4");

        while(numeroJugadores != 2 && numeroJugadores != 3){
            try {
                System.out.print("Elige el numero de jugadores. 1, 2 o 3: ");
                numeroJugadores = teclado.nextInt();
                teclado.nextLine(); //Con esto quitamos el fallo de Scanner
                System.out.println("");
            } catch (InputMismatchException e) {
                System.out.println( "\n" + BLANCO + ROJO_FONDO + "ERROR. Los jugadores pueden ser 2 o 3. Elige entre uno de esos dos valores.");
                System.out.println(NEGRO_FONDO);
                teclado.next(); //Con esto quitamos el fallo de Scanner
                continue;
            }

            if(numeroJugadores < 1 || numeroJugadores > 3){
                System.out.println( "\n" + BLANCO + ROJO_FONDO + "ERROR. Los jugadores pueden ser 2 o 3. Elige entre uno de esos dos valores.");
                System.out.println(NEGRO_FONDO);
            }
        }

        System.out.println("Ahora pon nombre a los jugadores.");
        System.out.print("jugador 1, Introduce tu nombre: ");
        j1.setNombre(teclado.nextLine());
        System.out.print("jugador 2, Introduce tu nombre: ");
        j2.setNombre(teclado.nextLine());
        if(numeroJugadores == 3){
            System.out.print("jugador 3, Introduce tu nombre: ");
            j3.setNombre(teclado.nextLine());
        }
        
        System.out.println("\nEMPEZAMOS EL JUEGO!!!");
    
        while(true){
            try {
                imprimirMatriz(tablero);
                if(turno == 1){
                    System.out.print(j1.getColor() + j1.getNombre() +  ", ¿Quieres quitar ficha o insertar ficha?, 0-(quitar), 1-(insertar): ");
                    quitarFicha = teclado.nextInt();
                    if(quitarFicha == 0){
                        System.out.print("Elige una columna(0-6): ");
                        borraColumna = teclado.nextInt();
                        System.out.print("Elige una fila(0-5). la fila 0 es la mas alta: ");
                        borraFila = teclado.nextInt();
                        borrarFicha(tablero, borraFila, borraColumna);
                    } else if(quitarFicha == 1){
                        System.out.print(j1.getNombre() +  ", Elige una columna(0-6): ");
                        columna = teclado.nextInt();
                        if(columnaLlena(tablero, columna)){
                            System.out.println("AVISO. Esa fila esta completa.");
                            continue;
                        }
                        insertarFicha(tablero, columna, turno);
                        j1.añadirMovimientos(columna);
                    } else {
                        System.out.println("AVISO. Elección no contemplada.");
                        continue;
                    }
                    
                }//FIN TURNO 1
    
                if(turno == 2){
                    System.out.print(j2.getColor() + j2.getNombre() +  ", ¿Quieres quitar ficha o insertar ficha?, 0-(quitar), 1-(insertar): ");
                    quitarFicha = teclado.nextInt();
                    if(quitarFicha == 0){
                        System.out.print("Elige una columna(0-6): ");
                        borraColumna = teclado.nextInt();
                        System.out.print("Elige una fila(0-5). la fila 0 es la mas alta: ");
                        borraFila = teclado.nextInt();
                        borrarFicha(tablero, borraFila, borraColumna);
                    } else if(quitarFicha == 1){
                        System.out.print(j2.getNombre() +  ", Elige una columna(0-6): ");
                        columna = teclado.nextInt();
                        if(columnaLlena(tablero, columna)){
                            System.out.println("AVISO. Esa fila esta completa.");
                            continue;
                        }
                        insertarFicha(tablero, columna, turno);
                        j2.añadirMovimientos(columna);
                    } else {
                        System.out.println("AVISO. Elección no contemplada.");
                        continue;
                    }
                    
                }//FIN TURNO 2

                if(turno == 3){
                    System.out.print(j3.getColor() + j3.getNombre() +  ", ¿Quieres quitar ficha o insertar ficha?, 0-(quitar), 1-(insertar): ");
                    quitarFicha = teclado.nextInt();
                    if(quitarFicha == 0){
                        System.out.print("Elige una columna(0-6): ");
                        borraColumna = teclado.nextInt();
                        System.out.print("Elige una fila(0-5). la fila 0 es la mas alta: ");
                        borraFila = teclado.nextInt();
                        borrarFicha(tablero, borraFila, borraColumna);
                    } else if(quitarFicha == 1){
                        System.out.print(j3.getNombre() +  ", Elige una columna(0-6): ");
                        columna = teclado.nextInt();
                        if(columnaLlena(tablero, columna)){
                            System.out.println("AVISO. Esa fila esta completa.");
                            continue;
                        }
                        insertarFicha(tablero, columna, turno);
                        j3.añadirMovimientos(columna);
                    } else {
                        System.out.println("AVISO. Elección no contemplada.");
                        continue;
                    }
                    
                }//FIN TURNO 3

                if(comprobarTablero(tablero, 1)){
                    imprimirMatriz(tablero);
                    ganador(j1);
                    break;
                } else if (comprobarTablero(tablero, 2)){
                    imprimirMatriz(tablero);
                    ganador(j2);
                    break;
                } else if (comprobarTablero(tablero, 3)){
                    imprimirMatriz(tablero);
                    ganador(j3);
                    break;
                }
    
                if(turno == 1){
                    turno++;
                }else if(turno == 2){
                    if(numeroJugadores == 3){
                        turno++;
                    } else{
                        turno = 1;
                    }
                    
                }else{
                    turno = 1;
                }

            } catch (InputMismatchException e) {
                System.out.println( "\n" + BLANCO + ROJO_FONDO + "ERROR. El valor introducido no es correcto.");
                System.out.println(NEGRO_FONDO);
                teclado.next();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println( "\n" + BLANCO + ROJO_FONDO + "ERROR. El valor introducido esta fuera del rango.");
                System.out.println(NEGRO_FONDO);
                //teclado.next();
            }
            
            
        }//FIN while;

        System.out.println(BLANCO + "\n---- FIN DEL JUEGO ---- \n");
        teclado.close();
        


    }//FIN main.

    //inserta la ficha del jugador "j" en la columna "c".
    //recorre la columna "c" de abajo hacia arriva para buscar el primer hueco vacio (0).
    public static void insertarFicha(int m[][], int c, int j){
        for (int i = m.length -1;i>= 0; i--) {
            if(m[i][c] == 0){
                m[i][c] = j;
                break;
            }
        }

    }//FIN insertarFicha.


    //comprobacion de columna llena para poder insertar ficha en la columna elegida.
    public static boolean columnaLlena(int m[][], int c){
        if(m[0][c] == 0){
            return false;
        }
        return true;

    }//FIN columnaLlena.


    public static boolean comprobarTablero(int m[][], int j){
        int cont = 0;
        
        //comprobacion horizontal(fila)
        for (int v = m.length -1; v >= 0; v--) {
            for (int h = 0; h < m[v].length; h++) {
                if(m[v][h] == j){
                    cont++;
                }
                else{
                    cont = 0;
                }
                if(cont == 4){
                    return true;
                }
            }
        }
        cont = 0;
        
        //comprobacion vertical(columna)
        for (int h = 0; h < m[0].length; h++) {
            for (int v = m.length -1; v >= 0; v--) {
                if(m[v][h] == j){
                    cont++;
                }
                else{
                    cont = 0;
                }
                if(cont == 4){
                    return true;
                }
            }
        }
        return false;

    }//FIN comprobarTablero


    public static void ganador(Jugador j){
        System.out.println(j.getColor() + "Ha ganado " + j.getNombre() + "!!!!!");
        System.out.println("Lista de movimientos: " + j.getListaMovimientos());
    }//FIN ganador


    public static void borrarFicha(int m[][], int f, int c){
        System.out.println("fila: " + f + " || columna: " + c);
        m[f][c] = 0;
        for (int i = f; i >= 1; i--) {
            if(m[i-1][c] != 0){
                m[i][c] = m[i-1][c];
                m[i-1][c] = 0;
            }
        }
    }
    /*
     for(int i=f;i>=1;i--){
                if(m[i-1][c] != 0){
                    m[i][c] = m[i-1][c];
                    m[i-1][c] = 0;
                }
     */


    public static int imprimirMatriz(int m[][]) {
        String pref;
        int conta=0;
        
        System.out.println(NEGRO + "");
        
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

    }//FIN imprimirMatriz

}//FIN CLASE.

