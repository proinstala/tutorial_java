package entorno_grafico;

import java.awt.Toolkit;
import java.awt.*;
import javax.swing.JFrame;
import java.util.*;
import java.awt.GraphicsEnvironment;


//PROGRAMA DE HERRAMIENTAS PARA CONSTRUCCION DE GUI (INTERFACES GRAFICAS DE USUARIO)


public class Herramientas {
    public static void main(String[] args) {

        int selector1 = 0;

        DatosPantalla misDatos = new DatosPantalla();

        Scanner entrada = new Scanner(System.in); //instanciamos la clase y creamos un objeto de tipo Scanner para introducir datos por consola

        System.out.println("--- HERRAMIENTAS ---" + "\n");
        System.out.println("Funciones:");
        System.out.println("(1) - Resolución pantalla");
        System.out.println("(2) - Listado de fuentes instaladas");
        System.out.println("(3) - ");
        System.out.println("(4) - " + "\n");

        System.out.print("Elige función: ");
        selector1 = entrada.nextInt();

        switch(selector1){
            case 1:
            System.out.println("\n" + "Resolución pantalla:");
            System.out.println(misDatos.dimensionPantalla());
            break;

            case 2:
            String nombreFuentes [] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

            int cont1 = 0;
            for(String i: nombreFuentes){
                System.out.println(cont1 + ": " + i);
                cont1++;
            }

            break;

            default:
            System.out.println("La opción no es correcta.");
        }

        System.out.println("\n" + "----- FIN DE PROGRAMA -----" + "\n");

        
        
  
    }
}


class DatosPantalla extends JFrame{

    private int alturaPantalla;
    private int anchoPantalla;

    public DatosPantalla(){
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit(); //creamos un objeto de tipo Toolkit

        Dimension tamanoPantalla = miPantalla.getScreenSize();
        alturaPantalla = tamanoPantalla.height;
        anchoPantalla = tamanoPantalla.width;
    }



    public String dimensionPantalla(){
        return "alto: " + alturaPantalla + " ancho: " + anchoPantalla;
    }
}
