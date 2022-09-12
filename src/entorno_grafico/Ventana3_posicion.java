package entorno_grafico;

import java.awt.Toolkit;

import javax.swing.JFrame;

import java.awt.*;

/*
- OBTENER LAS DIMENSIONES DEL MONITOR
- ICONO DE VENTANA

*/

public class Ventana3_posicion {
    public static void main(String[] args) {

        M_Centrado miMarco = new M_Centrado();
        System.out.println(miMarco.dimensionPantalla()); 

        miMarco.setVisible(true); //ponemos la ventana visible
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cuando se cierra la ventana, cerramos el programa
        miMarco.setBounds(500, 300, 500, 300); // tamaño y posicion de la ventana (x, y, width, height)

    }
}


class M_Centrado extends JFrame{

    private int alturaPantalla;
    private int anchoPantalla;

    public M_Centrado(){
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit(); //creamos un objeto de tipo Toolkit

        Dimension tamanoPantalla = miPantalla.getScreenSize();
        alturaPantalla = tamanoPantalla.height;
        anchoPantalla = tamanoPantalla.width;
    }


    public String dimensionPantalla(){
        return "alto: " + alturaPantalla + " ancho: " + anchoPantalla;
    }
}
