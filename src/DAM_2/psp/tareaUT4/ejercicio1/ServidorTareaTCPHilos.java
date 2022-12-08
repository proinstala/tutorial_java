package DAM_2.psp.tareaUT4.ejercicio1;

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


public class ServidorTareaTCPHilos extends Thread {
    
    static final int Puerto = 2000; //puerto en el que queremos escuchar.
    private Socket sClienteHilo;

    /**
     * Crea un nuevo objeto de tipo Tarea_PSP_04_1_servidor
     * @param sCliente Socket para este hilo.
     */
    public ServidorTareaTCPHilos(Socket sCliente) {
        this.sClienteHilo = sCliente;
    }

    public static void main(String[] args) {
        
        ServerSocket skServidor = null;

        while (true) {
            try {
                if(skServidor == null) {
                    skServidor = new ServerSocket(Puerto);
                    System.out.println("Soy el servidor TCP esperando a que alguien se conecte en el puerto " + Puerto);
                }
                
                //Esperando a que se conecte un nuevo jugador
                Socket sCliente = skServidor.accept();
                
                //Se conecta un cliente
                System.out.println(sCliente.getPort() + ": ¡Se ha conectado un nuevo jugador!");
        
                //creo un nuevo hilo para atender a el cliente
                new ServidorTareaTCPHilos(sCliente).start();

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

    @Override
    public void run() {
        try {
            int intentos;       //número de intentos del cliente.
            int numero;         //variable en la que guardamos el numero que ha dicho el cliente convertido a entero.
            int numeroAleatorio;//variable donde se guarda el número aleatorio generado para este cliente.
            int puertoCliente = sClienteHilo.getPort(); //puerto del cliente.

            // Creo flujo de salida
            OutputStream aux1 = sClienteHilo.getOutputStream();
            DataOutputStream flujo_salida = new DataOutputStream(aux1);

            // Creo flujo de entrada
            InputStream aux2 = sClienteHilo.getInputStream();
            DataInputStream flujo_entrada = new DataInputStream(aux2);

            flujo_salida.writeUTF("Servidor de juegos: Bienvenido al juego, tienes que adivinar un número del 0 al 10");
            intentos = 0;
            numeroAleatorio = new Random().nextInt(11); //genero el número aleatorio.
            System.out.println(puertoCliente + ": numero generado " + numeroAleatorio);

            while (intentos < 3) {
                String entrada = flujo_entrada.readUTF(); //espera a que tenga datos en la entrada.
            
                try {
                    System.out.println(puertoCliente  + ": El cliente ha dicho: " + entrada);
                    numero = Integer.parseInt(entrada); //convierto el numero que hay en la variable entrada a un entero.

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
                }

            }//FIN While

            System.out.println(puertoCliente + " Cliente desconectado");
            sClienteHilo.close(); //cierro el Socket.
            
        } catch (IOException e) {
            System.out.println("ERROR --- " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR inesperado --- " + e);
        } 
       
    }//Fin run.
    
}
