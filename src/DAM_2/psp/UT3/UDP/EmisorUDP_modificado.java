
package DAM_2.psp.UT3.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * EmisorUDP envía un string
 * a un receptor que se encuentra en host localhost.
 * La conexión se hace mediante UDP.
 * 
 * @author David
 */
public class EmisorUDP_modificado {

    public static void main(String args[])  {

        String nombreHost = "localhost";    //Host receptor
        String texto = "hola mundo";        //String a enviar
        int Puerto = 1500;

        try {
            // Construye la dirección del socket del receptor
            // Crea el socket
            try (DatagramSocket sSocket = new DatagramSocket()) {
                // Construye la dirección del socket del receptor
                InetAddress maquina = InetAddress.getByName(nombreHost);

                // Crea el mensaje
                byte[] cadena = texto.getBytes();
                
                //DatagramPacket(Mensaje a enviar, Longitud del mensaje, equipo al que se le envía el mensaje, Puerto destino)
                DatagramPacket mensaje = new DatagramPacket(cadena, texto.length(), maquina, Puerto);
                
                // Envía el mensaje
                sSocket.send(mensaje);
                System.out.println("Mensaje enviado");
                
                // Cierra el socket
                sSocket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }
}
