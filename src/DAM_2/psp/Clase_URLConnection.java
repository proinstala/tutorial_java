package DAM_2.psp;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

//Un objeto URLConnection se puede utilizar para leer desde y escribir hacia el recurso al que hace referencia el objeto URL.

/*
 * Ejemplo de lectura de un archivo de texto usando una URL y escritura del contenido en un archivo nuevo.
 * El archivo se encuentra en la carpeta www que publica WampServer.
 * 
 * Para que funcione este programa tiene que estar WampServer activo.
 */
public class Clase_URLConnection {
    public static void main(String[] args) {
        

        try {
            URL direccion = new URL("http://localhost/texto_prueba.txt");
            String linea;
            String fichero[];
            int posicion = 0;
            int numLineas=0;

            // Volcamos lo recibido al buffer
            BufferedReader miBuffer1 = new BufferedReader(new InputStreamReader(direccion.openStream()));
            BufferedReader miBuffer2 = new BufferedReader(new InputStreamReader(direccion.openStream()));

            while ((linea = miBuffer1.readLine()) != null) { 
                System.out.println(linea);  //aqui podemos imprimir o guardar las lineas todas en un string.
                numLineas++;
            }

            fichero = new String[numLineas];

            while((linea = miBuffer2.readLine()) != null) {
                fichero[posicion] = linea;
                posicion++;
            }

            /* una forma de imprimir el array
            for (String s : fichero) {
                System.out.println(s);
            }
            */

            //imprimimos el array por consola
            System.out.println("\nImpresion FORMATEADA:");
            for (int i = 0; i < fichero.length; i++) {
                System.out.println(i + "| " + fichero[i]);
            }

            miBuffer1.close();
            miBuffer1.close();
            
            escribirArchivo(fichero);

        } catch (MalformedURLException e) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirArchivo(String texto[]) throws IOException {
        //si no añadimos el segundo argumento(true) creara otra vez el archivo borrando el existente
        FileWriter fichero = new FileWriter("archivo_prueba.txt", true);   //ruta del archivo. si no existe lo crea. 
        PrintWriter escritor = new PrintWriter(fichero) ;
        for (String s : texto) {
            escritor.println(s);
        }
        
        fichero.close();
    }
}
