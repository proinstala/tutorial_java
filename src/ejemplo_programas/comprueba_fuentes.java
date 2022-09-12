package ejemplo_programas;

import java.awt.GraphicsEnvironment;

//Programa para ver las fuentes que tenemos instaladas en el ordenador

public class comprueba_fuentes {
    public static void main(String[] args) {
        
        //Creamos un array que guarda los nombres de las fuentes que tenemos instaladas en el pc.
        String nombreFuentes [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        int cont1 = 0;
        for(String i: nombreFuentes){
            System.out.println(cont1 + ": " + i);
            cont1++;
        }
    }
}
