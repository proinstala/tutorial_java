package DAM_2.psp.tareaUT3.ejercicio_1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;


public class ServidorTareaTCP {
    
    static final int Puerto = 2000;

    public static void main(String[] args) {
        
        int intentos;
        int numero;
        int numeroAleatorio;
        
        ServerSocket skServidor = null;

        while (true) {
            try {
                if(skServidor == null) {
                    skServidor = new ServerSocket(Puerto);
                }
            
                System.out.println("Soy el servidor TCP esperando a que alguien se conecte en el puerto " + Puerto);
                Socket sCliente = skServidor.accept();
                System.out.println("¡Se ha conectado un nuevo jugador!");

                OutputStream aux1 = sCliente.getOutputStream();
                DataOutputStream flujo_salida = new DataOutputStream(aux1);
                flujo_salida.writeUTF("Servidor de juegos: Bienvenido al juego, tienes que adivinar un número del 0 al 10");
                intentos = 0;
                numeroAleatorio = new Random().nextInt(11);
                System.out.println("numero generado " + numeroAleatorio);

                InputStream aux2 = sCliente.getInputStream();
                DataInputStream flujo_entrada = new DataInputStream(aux2);

                while (intentos < 3) {
                    String entrada = flujo_entrada.readUTF(); //espera a que tenga datos en la entrada.
                    
                        try {
                            System.out.println("El cliente ha dicho: " + entrada);
                            numero = Integer.parseInt(entrada);

                            if (numero < 0 || numero > 10) {
                                flujo_salida.writeUTF("Servidor de juegos: Debe introducir un entero entre 0 y 10.");
                                continue;
                            } else {
                                intentos++;
                            }

                            if (numero == numeroAleatorio) {
                                flujo_salida.writeUTF("Servidor de juegos: FIN: ¡Has acertado después de " + (intentos -= 1) + " fallos!");
                                break;
                            }

                            if (intentos == 3) {
                                flujo_salida.writeUTF("Servidor de juegos: FIN: Has perdido, el numero era " + numeroAleatorio);
                                break;

                            } else {
                                if (numero > numeroAleatorio) {
                                    flujo_salida.writeUTF("Servidor de juegos: El número secreto es menor. Total de fallos: " + intentos);
                                } else {
                                    flujo_salida.writeUTF("Servidor de juegos: El número secreto es mayor. Total de fallos: " + intentos);
                                }

                            }

                        } catch (NumberFormatException e) {
                            flujo_salida.writeUTF("Servidor de juegos: Debe introducir un entero entre 0 y 10.");
                        } catch (Exception e) {
                            System.out.println("ERROR inesperado --- " + e);
                            sCliente.close();
                        }
                }
               
                sCliente.close();
                System.out.println("Cliente desconectado");

            } catch (BindException e) {
                System.out.println("ERROR ---  " + e);
                break;
            } catch (SocketException e) {
                System.out.println("ERROR --- Fallo conexión con Cliente.");
            } catch (IOException e) {
                System.out.println("ERROR ---  " + e);
            } catch (Exception e) {
                System.out.println("ERROR General---  " + e);
                
            }
            
        }//while
    }//Fin Main.
}
