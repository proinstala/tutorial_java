package DAM_2.psp.tareaUT4.ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

//Puertos conocidos   [0, 1023]      Son puertos reservados a aplicaciones de uso estándar
//Puertos registrados [1024, 49151]  Estos puertos pueden ser utilizados por los usuarios libremente.
//Puertos dinámicos   [49152, 65535] Este rango de puertos no puede ser registrado y su uso se establece para conexiones temporales entre aplicaciones.

/*
Progrma que simula un servidor que atiende peticiones concurrentes. 
Implementa una maquina de estados para controlar la información que envia y recive del los clientes conectados.
*/

/**
 *
 * @author David Jimenez Alonso
 */
public class ServidorTarea_PSO4_2 extends Thread {

    private static final File MADRID = new File("madrid.txt");
    private static final File CARTAGENA = new File("cartagena.txt");
    private static final File BARCELONA = new File("barcelona.txt");
    
    private Socket sClienteHilo;
    
    /**
     * Crea un nuevo objeto de tipo Tarea_PSP_04_1_servidor
     * @param sCliente Socket para este hilo.
     */
    public ServidorTarea_PSO4_2(Socket sCliente) {
        this.sClienteHilo = sCliente;
    }


    public static void main(String[] args) {
        ServerSocket skServidor = null;
        final int Puerto = 2000; //puerto en el que queremos escuchar.
        
        while (true) {
            try {
                if(skServidor == null) { //si el serverSoket no a sido inicializado, se inicia.
                    skServidor = new ServerSocket(Puerto);
                    System.out.println("Soy el servidor TCP esperando a que alguien se conecte en el puerto " + Puerto);
                }
                
                //Esperando a que se conecte un nuevo jugador
                Socket sCliente = skServidor.accept();
                
                //Se conecta un cliente
                System.out.println(sCliente.getPort() + ": ¡Se ha conectado un nuevo Cliente!");
        
                //creo un nuevo hilo para atender a el cliente pasandole como parametro el socket con el que se ha conectado
                new ServidorTarea_PSO4_2(sCliente).start();

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
    }//Fin main.

    @Override
    public void run() {
        try {
            int estado = 0;                 //variable del estado de la maquina de estados.
            String comandoRecivido = "";    //variable donde guardamos el mensaje recivido por el cliente.
            String lineaArchivo;            //variable auxiliar para la lectura de los archivos de las alineaciones de equipos.
            
            int puertoCliente = sClienteHilo.getPort(); //puerto del cliente.

            // Creo flujo de salida
            OutputStream aux1 = sClienteHilo.getOutputStream();
            DataOutputStream flujo_salida = new DataOutputStream(aux1);

            // Creo flujo de entrada
            InputStream aux2 = sClienteHilo.getInputStream();
            DataInputStream flujo_entrada = new DataInputStream(aux2);
            
            
            //MAQUINA DE ESTADOS
            do {
                switch(estado){
                    case 0:
                        flujo_salida.writeUTF("Introduce clave acceso"); //mandamos mensaje al cliente
                        flujo_salida.writeUTF("***"); //con esto, pedimos al cliente que nos envie un mensaje.
                        comandoRecivido = flujo_entrada.readUTF(); //espera a que tenga datos en la entrada.
                        System.out.println(puertoCliente + " recibido: " + comandoRecivido); //mostramos por consola lo que el cliente ha enviado.
                        if(comandoRecivido.equals("1234")) estado = 1; //si el mensaje recivido es "1234", cambiamos la variable de la maquina de estados a 1.
                        break;
                        
                    case 1:
                        flujo_salida.writeUTF("Introduce ver o exit"); //mandamos mensaje al cliente
                        flujo_salida.writeUTF("***"); //con esto, pedimos al cliente que nos envie un mensaje.
                        comandoRecivido = flujo_entrada.readUTF(); //espera a que tenga datos en la entrada.
                        System.out.println(puertoCliente + " recibido: " + comandoRecivido); //mostramos por consola lo que el cliente ha enviado.
                        
                        if (comandoRecivido.equals("ver")) {  //si el mensaje recivido es "ver", cambiamos la variable de la maquina de estados a 2.
                            estado = 2;
                        } else if(comandoRecivido.equals("exit")) { //si el mensaje recivido es "exit", cambiamos la variable de la maquina de estados a -1.
                            estado = -1;
                        } else {
                        }
                        break;
                        
                    case 2:
                        flujo_salida.writeUTF("Introduce el nombre del equipo: CARTAGENA, BARCELONA, MADRID");
                        flujo_salida.writeUTF("***"); //con esto, pedimos al cliente que nos envie un mensaje.
                        comandoRecivido = flujo_entrada.readUTF(); //espera a que tenga datos en la entrada.
                        System.out.println(puertoCliente + " recibido: " + comandoRecivido); //mostramos por consola lo que el cliente ha enviado.
                        
                        if (comandoRecivido.equalsIgnoreCase("cartagena") || comandoRecivido.equalsIgnoreCase("barcelona") || comandoRecivido.equalsIgnoreCase("madrid")) {
                            estado = 3;
                        } else {
                            flujo_salida.writeUTF("No se dispone de la alineación"); //si el mensaje del cliente no coincide con las comparaciones anteriores, envia este mensaje al cliente.
                        }
                        
                        break;
                        
                    case 3:
                        flujo_salida.writeUTF("ALINEACIÓN DEL EQUIPO SOLICITADO");
                        try {
                            if (comandoRecivido.equalsIgnoreCase("cartagena")) {
                            BufferedReader miBuffer1 = new BufferedReader(new FileReader(CARTAGENA.getName())); //creamos un objeto de tipo BufferedReader para leer el archivo.
                            while ((lineaArchivo = miBuffer1.readLine()) != null) { 
                                flujo_salida.writeUTF(lineaArchivo); //envia al cliente la linea leida del archivo
                            }
                        } else if (comandoRecivido.equalsIgnoreCase("barcelona")) {
                            BufferedReader miBuffer1 = new BufferedReader(new FileReader(BARCELONA.getName())); //creamos un objeto de tipo BufferedReader para leer el archivo.
                            while ((lineaArchivo = miBuffer1.readLine()) != null) { 
                                flujo_salida.writeUTF(lineaArchivo); //envia al cliente la linea leida del archivo
                            }
                        } else if (comandoRecivido.equalsIgnoreCase("madrid")) {
                            BufferedReader miBuffer1 = new BufferedReader(new FileReader(MADRID.getName())); //creamos un objeto de tipo BufferedReader para leer el archivo.
                            while ((lineaArchivo = miBuffer1.readLine()) != null) { 
                                flujo_salida.writeUTF(lineaArchivo); //envia al cliente la linea leida del archivo
                            }
                        }
                        } catch (IOException e) {
                            System.out.println("ERROR --- " + e.getMessage());
                            flujo_salida.writeUTF("- ERROR EN SERVIDOR -"); 
                            estado = 1; //ponemos a 1 la maquina de estados.    
                        }
                       
                        flujo_salida.writeUTF(""); 
                        estado = 1; //ponemos a 1 la maquina de estados.
                        break;
                }
            } while(estado != -1);
            
            flujo_salida.writeUTF("FIN");

            System.out.println(puertoCliente + " Cliente desconectado");
            sClienteHilo.close(); //cierro el Socket.
            
        } catch (IOException e) {
            System.out.println("ERROR --- " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR inesperado --- " + e);
        } 
       
    }//Fin run.
}
