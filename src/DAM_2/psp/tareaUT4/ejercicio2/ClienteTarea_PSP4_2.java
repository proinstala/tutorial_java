package DAM_2.psp.tareaUT4.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
Programa que simula un cliente que se conecta a un servidor para pedir información.
*/

/**
 *
 * @author David Jimenez Alonso
 */
public class ClienteTarea_PSP4_2 {
    public static void main(String[] args) {
        
        final String HOST = "localhost"; //Nombre o direccion del servidor
        final int Puerto = 2000; //Puerto al que queremos conectarnos
        
        Scanner teclado = new Scanner(System.in); //creamos el objeto teclado que recoge lo que introducimos por la entrada estandar.
        String mensajeEviar;  //en esta variable guardamos lo que introducimos por consola.
        String mensaje; //en esta variable guardamos el mensaje que recibimos por el DataInputStream.

        try {
            Socket soketCliente = new Socket(HOST, Puerto); //crea el socket (nombre del host, puerto al que se quiere conectar)

            InputStream iStream = soketCliente.getInputStream(); //crea el flujo de entrada
            DataInputStream flujoEntrada = new DataInputStream(iStream);
            
            OutputStream oStream = soketCliente.getOutputStream(); //crea el flujo de salida
            DataOutputStream flujoSalida = new DataOutputStream(oStream);

            while(true) {
                mensaje = flujoEntrada.readUTF(); //lee el mensaje que recibe del servidor
                
                /*
                - Si el mensaje recibiod por el servidor empieza por la cadena "***", habilita al cliente para introducir informacion por la entrada estandar.
                - Si el mensaje recibiod por el servidor NO empieza por la cadena "***", imprime el mensaje por consola.
                */
                if (mensaje.startsWith("***")) {        
                    mensajeEviar = teclado.nextLine();  //guardamos en la variable mensajeEnviar lo que introducimos por la entrada estandar.
                    flujoSalida.writeUTF(mensajeEviar); //envia al servidor el numero que tenemos en la variable numero
                } else {
                    System.out.println(mensaje);        //imprimimos el mensaje
                }
                   
                if (mensaje.contains("FIN")) { //Si el mensaje contiene la paralabra "FIN", sale del bucle while y termina el programa.
                    break;
                }
            }//Fin while(true).

            soketCliente.close(); //cierro el socket.

        } catch (Exception e) {
            System.out.println("ERROR ---" + e.getMessage());
        }
        
        teclado.close(); //cierro Scanner.
    }
}
