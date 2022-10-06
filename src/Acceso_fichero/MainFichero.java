package Acceso_fichero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainFichero {
    public static void main(String[] args) {
        
        Fichero f = new Fichero();

        //leer y escrivir en un fichero caracter a caracter.
        /* 
        try {
            f.escribir1();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        try {
            f.leer1();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        */

        /* 
        //leer un fichero grande
        try {
            f.leerFicheroGrande();
            
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        */

        
        try {
            f.escribir2();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
