package Acceso_fichero;

import java.io.IOException;

public class LeyendoFichero {
    public static void main(String[] args) {
        
        LeerFichero leerF = new LeerFichero();

        try {
            leerF.leer();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
