package DAM_2.psp.tareaUT3.ejercicio_2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

//Puertos conocidos   [0, 1023]      Son puertos reservados a aplicaciones de uso estándar
//Puertos registrados [1024, 49151]  Estos puertos pueden ser utilizados por los usuarios libremente.
//Puertos dinámicos   [49152, 65535] Este rango de puertos no puede ser registrado y su uso se establece para conexiones temporales entre aplicaciones.

public class TareaServidorUDP {
    public static void main(String[] args) {

        //String nombreHostCliente = "localhost";
        String nombreHostCliente;
        InetAddress inetHostCliete;
        int puertoCliente;
        Random rnd = new Random();

        try {
            //Crea el socket
            DatagramSocket sSocket = new DatagramSocket(1500);

            //Crea el espacio para los mensajes y DatagramPacket
            byte[] cadena = new byte[1000];
            DatagramPacket mensaje = new DatagramPacket(cadena, cadena.length);

            
            while (true) {
                System.out.println("El servidor UDP queda a la espera de peticiones.");
                sSocket.receive(mensaje); //A la espera de peticiones

                //mensaje recivido
                String datos = new String(mensaje.getData(), 0, mensaje.getLength());
                System.out.println("Recibida petición " + datos);
                
                //Datos de socket cliente conectado 
                puertoCliente = mensaje.getPort();                      //obtiene el puerto del cliente que ha realizado la petición
                nombreHostCliente =  mensaje.getAddress().toString();   //obtiene la direccion del cliente que ha realizado la petición
                inetHostCliete = mensaje.getAddress();                  //obtiene InetAddress del cliente que ha realizado la petición
                System.out.println("direccion remoto: " + nombreHostCliente); 
                System.out.println("puerto remoto: " + puertoCliente); 
                System.out.println("");
                
                String apuesta = "";

                //evalua el tipo de apuesta para responder
                if (datos.toLowerCase().equals("quiniela")) { //si es quiniela, crea la apuesta aleatoria de quiniela
                    for (int i = 1; i < 16; i++) {
                        apuesta = apuesta.concat("Partido " + i + ": ");
                        switch(rnd.nextInt(3)) {
                            case 0 -> apuesta = apuesta.concat("1\n");
                            case 1 -> apuesta = apuesta.concat("X\n");
                            case 2 -> apuesta = apuesta.concat("2\n");
                        }
                    }

                } else if (datos.toLowerCase().equals("primitiva")) { //si es primitiva, crea la apuesta aleatoria de primitiva
                    apuesta = "Números ";
                    
                    for (int i = 0; i < 6; i++) {
                        apuesta = apuesta.concat(rnd.nextInt(50) + " ");
                    }

                    apuesta = apuesta.concat("Reintegro: " + rnd.nextInt(10));
                    
                } else { //si la petición recibida no es quiniela o primitiva
                    System.out.println(" -- Petición desconocida -- \n");
                    apuesta = "Petición desconocidad";
                }
                
                
                // Crea el array de byte con los datos de la apuesta
                byte[] eCadena = apuesta.getBytes();
                
                //puertoCliente = mensaje.getPort();//obtiene el puerto del cliente que ha realizado la petición
                //InetAddress maquina = InetAddress.getByName(nombreHostCliente);//crea el objeto InetAddress con la direccion del cliente

                InetAddress maquina = inetHostCliete;
                //DatagramPacket(Mensaje a enviar, Longitud del mensaje, equipo al que se le envía el mensaje, Puerto destino)
                DatagramPacket eMensaje = new DatagramPacket(eCadena, apuesta.length(), maquina,  puertoCliente);
                sSocket.send(eMensaje);//envia los datos
                
            }//Fin while(true) 
           
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }

    }
}
