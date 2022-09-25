package Acceso_fichero;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {
    
    public void leer() throws IOException {

        //FileReader entrada = new FileReader("src\\Acceso_fichero\\pildoras.txt");
        //FileReader entrada = new FileReader("src/Acceso_fichero/pildoras.txt"); //ruta relativa
        FileReader entrada = new FileReader("tutorial_java\\src\\Acceso_fichero\\pildoras.txt");
        
        int c=0;
        while(c != -1){
            c = entrada.read();
            char letra = (char)c;
            System.out.print(letra);
        }
        entrada.close();
    }

    public void escribir() throws IOException {
        String frase = "frase de prueba";
        FileWriter archivo = new FileWriter("tutorial_java\\src\\Acceso_fichero\\pildoras.txt");
        archivo.write(frase);
        archivo.close();
    }
}
