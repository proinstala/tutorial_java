package Acceso_fichero;

import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    
    public void leer() throws IOException {

        //FileReader entrada = new FileReader("src\\Acceso_fichero\\pildoras.txt");
        FileReader entrada = new FileReader("src/Acceso_fichero/pildoras.txt"); //ruta relativa
        int c = entrada.read();
        String texto;
        while(c != -1){
            c = entrada.read();
            char letra = (char)c;
            System.out.print(letra);
        }
        entrada.close();
    }
}
