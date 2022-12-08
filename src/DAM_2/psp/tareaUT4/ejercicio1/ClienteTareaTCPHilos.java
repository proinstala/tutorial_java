package DAM_2.psp.tareaUT4.ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClienteTareaTCPHilos {

    static final String HOST = "localhost"; //Nombre o direccion del servidor
    static final int Puerto = 2000; //Puerto al que queremos conectarnos

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String numero;  //en esta variable guardamos lo que introducimos por consola.
        String mensaje; //en esta variable guardamos el mensaje que recibimos por el DataInputStream.

        try {
            Socket soketCliente = new Socket(HOST, Puerto); //crea el socket (nombre del host, puerto al que se quiere conectar)

            InputStream iStream = soketCliente.getInputStream(); //crea el flujo de entrada
            DataInputStream flujoEntrada = new DataInputStream(iStream);
            
            OutputStream oStream = soketCliente.getOutputStream(); //crea el flujo de salida
            DataOutputStream flujoSalida = new DataOutputStream(oStream);

            System.out.println(flujoEntrada.readUTF()); //muestra el mensaje de bienveinida del servidor.

            while(true) {
                System.out.println("inserta numero para enviar: ");
                numero = teclado.nextLine();
                System.out.println("numero a enviar: " + numero);
                flujoSalida.writeUTF(numero); //envia al servidor el numero que tenemos en la variable numero
                mensaje = flujoEntrada.readUTF(); //lee el mensaje que recibe del servidor
                System.out.println(mensaje);
               
                if (mensaje.contains("FIN")) { //Si el mensaje contiene la paralabra "FIN" termina el programa.
                    break;
                }
            }

            soketCliente.close(); //cierro el socket

        } catch (Exception e) {
            System.out.println("ERROR ---" + e.getMessage());
        }
        
        teclado.close(); //cierro Scanner.
    }
}
