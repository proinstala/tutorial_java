package Acceso_fichero;

import java.io.IOException;

public class PrincipalFichero {
    public static void main(String[] args) {
        
        Fichero leerF = new Fichero();


        try {
            leerF.escribir();
        } catch (IOException e) {
            // TODO: handle exception
        }

        try {
            leerF.leer();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
