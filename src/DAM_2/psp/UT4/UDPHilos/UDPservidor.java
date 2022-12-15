package DAM_2.psp.UT4.UDPHilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Random;

//Puertos conocidos   [0, 1023]      Son puertos reservados a aplicaciones de uso estándar
//Puertos registrados [1024, 49151]  Estos puertos pueden ser utilizados por los usuarios libremente.
//Puertos dinámicos   [49152, 65535] Este rango de puertos no puede ser registrado y su uso se establece para conexiones temporales entre aplicaciones.

/*
 * Este es un Proyecto de ejemplo de modificación de la Tarea 3_2 de PSP de un servidor UDP.
 * 
 * En esta modificación en vez de ser un servidor que acepta una sola petición a la vez, lo convertimos
 * en un Servidor multihilo.
 * 
 * Aunque en este proyecto no se parecia porque la informacion que envia es pequeña, si fuese un archivo grande el que hay que enviar,
 * se podria compobrar como se pueden conectar varios clientes a la vez y a todos se les atenderia de forma concurrente.
 */

 //Nota: El cliente es el programa de Tarea 3_2 de PSP.

public class UDPservidor extends Thread {

    static final int puerto = 1500; //puerto en el que queremos escuchar.
    static final int envioPuerto = 1600; 
    DatagramPacket hiloData;

    public UDPservidor(DatagramPacket d) {
        this.hiloData = d;
    }

    public static void main(String[] args) {

        try {
            //Crea el socket
            DatagramSocket sSocket = new DatagramSocket(puerto);

            //Crea el espacio para los hiloDatas y DatagramPacket
            byte[] cadena = new byte[1000];
            DatagramPacket hiloData = new DatagramPacket(cadena, cadena.length);

            
            while (true) {
                System.out.println("El servidor UDP queda a la espera de peticiones.");
                sSocket.receive(hiloData); //A la espera de peticiones

                new UDPservidor(hiloData).start();

                /*
                 * Aqui podria ponerse que imprimiera por consola que se ha recibido una peticion y los datos del cliente.
                 */
                
            }//Fin while(true) 
           
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }

    }//Fin Main.

    @Override
    public void run() {
        try {

            String nombreHostCliente;
            InetAddress inetHostCliete;
            int puertoCliente;
            Random rnd = new Random();

            /*
             * Esta parte del mensaje por consola se podria poner en el hilo principal.
             */
            // hiloData recivido
            String datos = new String(hiloData.getData(), 0, hiloData.getLength());
            System.out.println("Recibida petición " + datos);

            // Datos de socket cliente conectado
            puertoCliente = hiloData.getPort(); // obtiene el puerto del cliente que ha realizado la petición
            nombreHostCliente = hiloData.getAddress().toString(); // obtiene la direccion del cliente que ha realizado la petición
            inetHostCliete = hiloData.getAddress(); // obtiene InetAddress del cliente que ha realizado la petición
            System.out.println("direccion remoto: " + nombreHostCliente);
            System.out.println("puerto remoto: " + puertoCliente);
            System.out.println("");

            String apuesta = "";

            // evalua el tipo de apuesta para responder
            if (datos.toLowerCase().equals("quiniela")) { // si es quiniela, crea la apuesta aleatoria de quiniela
                for (int i = 1; i < 16; i++) {
                    apuesta = apuesta.concat("Partido " + i + ": ");
                    switch (rnd.nextInt(3)) {
                        case 0 -> apuesta = apuesta.concat("1\n");
                        case 1 -> apuesta = apuesta.concat("X\n");
                        case 2 -> apuesta = apuesta.concat("2\n");
                    }
                }

            } else if (datos.toLowerCase().equals("primitiva")) { // si es primitiva, crea la apuesta aleatoria de primitiva
                apuesta = "Números ";

                for (int i = 0; i < 6; i++) {
                    apuesta = apuesta.concat(rnd.nextInt(50) + " ");
                }

                apuesta = apuesta.concat("Reintegro: " + rnd.nextInt(10));

            } else { // si la petición recibida no es quiniela o primitiva
                System.out.println(" -- Petición desconocida -- \n");
                apuesta = "Petición desconocidad";
            }

            // Crea el array de byte con los datos de la apuesta
            byte[] eCadena = apuesta.getBytes();

            // puertoCliente = hiloData.getPort();//obtiene el puerto del cliente que ha realizado la petición
            // InetAddress maquina = InetAddress.getByName(nombreHostCliente);//crea el objeto InetAddress con la direccion del cliente

            InetAddress maquina = inetHostCliete;
            // DatagramPacket(hiloData a enviar, Longitud del hiloData, equipo al que se le envía el hiloData, Puerto destino)
            DatagramPacket eMensaje = new DatagramPacket(eCadena, apuesta.length(), maquina, puertoCliente);
            
            DatagramSocket eSocket = new DatagramSocket(envioPuerto);
            eSocket.send(eMensaje);
            eSocket.close();
           

        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
        }
    }

}
