package DAM_2.psp.tareaUT3.ejercicio_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TareaClienteUDP {
    
    public static void main(String[] args) {
        
        String nombreHost = "localhost";//Host receptor
        String texto = "primitiva";      //String a enviar. Apuesta.
        int Puerto = 1500;              //Puerto Servidor
        
        try {
            // Crea el socket
            try (DatagramSocket sSocket = new DatagramSocket()) {
                // Construye la dirección del socket del receptor
                InetAddress maquina = InetAddress.getByName(nombreHost);

                // Crea el mensaje
                byte[] eCadena = texto.getBytes();

                // DatagramPacket(Mensaje a enviar, Longitud del mensaje, equipo al que se le envía el mensaje, Puerto destino)
                DatagramPacket eMensaje = new DatagramPacket(eCadena, texto.length(), maquina, Puerto);

                // Envía el mensaje
                System.out.println("Vamos a solicitar nuestro sorteo " + texto + "\n");
                sSocket.send(eMensaje);

                // Recibir ---------------------------
                byte[] rCadena = new byte[1000];
                DatagramPacket rMensaje = new DatagramPacket(rCadena, rCadena.length);

                sSocket.receive(rMensaje); // esperamos la respuesta del servidor
                String datos = new String(rMensaje.getData(), 0, rMensaje.getLength());

                if (texto.toLowerCase().equals("primitiva")) {
                    System.out.println("Mi apuesta de primitiva: " + datos);
                } else if (texto.toLowerCase().equals("quiniela")) {
                    System.out.println("Mi apuesta de quiniela:\n" + datos);

                } else {
                    System.out.println(datos);
                }

                // Cierra el socket
                sSocket.close();

            }
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }

    }
}
