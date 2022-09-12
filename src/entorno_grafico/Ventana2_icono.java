package entorno_grafico;

import java.awt.Toolkit;

import javax.swing.JFrame;

import java.awt.*;

/*
- OBTENER LAS DIMENSIONES DEL MONITOR
- ICONO DE VENTANA

*/

public class Ventana2_icono {
    public static void main(String[] args) {

        MarcoCentrado miMarco = new MarcoCentrado();

        miMarco.setVisible(true); //ponemos la ventana visible
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cuando se cierra la ventana, cerramos el programa
        miMarco.setBounds(500, 300, 500, 300); // tamaño y posicion de la ventana (x, y, width, height)


        
    }
}


class MarcoCentrado extends JFrame{

    
    public MarcoCentrado(){
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit(); //creamos un objeto de tipo Toolkit

        Image miIcono = miPantalla.getImage("logo1_84.png"); //guardomos la imagen en el objeto miIcono
        setIconImage(miIcono); //ponemos icono en la ventana
    }
}
