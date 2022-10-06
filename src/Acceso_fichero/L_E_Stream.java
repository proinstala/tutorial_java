package Acceso_fichero;

import java.io.*;

/*
 NOTA:  tengo creada la clase MiStream que tiene los metodos copiarDatos y volcarDatos
        que contienen el codigo de este ejemplo pero ordenado en los metodos.
 */

public class L_E_Stream {
    
    public static void main(String[] args) {
        
        File imagen1 = new File("another.jpg");
        int contador = 0;
        int pesoImagen1 = (int) imagen1.length();
        int datos_entrada[] = new int[pesoImagen1];
        //long length()

        try {

            
            FileInputStream archivo_lectura = new FileInputStream(imagen1);
            boolean fin = false;

            while (!fin) {
                int byte_entrada = archivo_lectura.read(); //devuelve el siguiente byte del dato o -1 si se llega al final del archivo.

                if (byte_entrada != -1) { //si no es -1
                    datos_entrada[contador] = byte_entrada; //guarda el byte en el array 
                    contador++;
                
                } else {
                    fin = true; //si devuelve -1 salimos del bucle while   
                }

                //System.out.println(byte_entrada);
            }
           
            archivo_lectura.close();
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        crear_fichero(datos_entrada); //llamamos al metodo que crea el fichero y pasamos los datos del fichero a crear
        
    }

    static void  crear_fichero(int datos_nuevo_fichero[]){

        try {
            FileOutputStream fichero_nuevo = new FileOutputStream("another_copia.jpg"); //creamos el Stream de salida de datos con el nombre y ruta donde se va crear el archivo nuevo.
            for (int i = 0; i < datos_nuevo_fichero.length; i++) {
                fichero_nuevo.write(datos_nuevo_fichero[i]); //Escribe el dato i de la matriz en este flujo de salida de archivo.
            }
            fichero_nuevo.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
