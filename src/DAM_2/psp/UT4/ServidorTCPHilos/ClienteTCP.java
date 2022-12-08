/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM_2.psp.UT4.ServidorTCPHilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author alumno
 */
public class ClienteTCP {

    static final String HOST = "localhost";
    static final int Puerto = 2000;

    public ClienteTCP() {
        try {
            Socket skCliente = new Socket(HOST, Puerto);
            // Creo los flujos de entrada y salida
            DataInputStream flujo_entrada = new DataInputStream(skCliente.getInputStream());
            DataOutputStream flujo_salida = new DataOutputStream(skCliente.getOutputStream());

            // TAREAS QUE REALIZA EL CLIENTE
            String datos = flujo_entrada.readUTF();
            System.out.println(datos);
            String mensaje = "Hola mundo";
            flujo_salida.writeUTF(mensaje);

            skCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] arg) {
        new ClienteTCP();
    }

}
