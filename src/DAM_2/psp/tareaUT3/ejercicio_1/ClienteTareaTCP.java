package DAM_2.psp.tareaUT3.ejercicio_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class ClienteTareaTCP {

    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String numero;
        String mensaje;

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

            soketCliente.close();

        } catch (Exception e) {
            System.out.println("ERROR ---" + e.getMessage());
        }
        
        teclado.close();
    }
}
