package Acceso_fichero;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Clases_NIO {
    
    public static void main(String[] args) throws IOException {

        //Obtener el tamaño en bytes de un archivo. ejemplo archivo.txt
        byte[] fichero = Files.readAllBytes(Paths.get("archivo.txt"));
        System.out.println("Tamaño del archivo: " + fichero.length);
        
    }

}
