package tutorial;
import javax.swing.*;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

/*
- La clase Timer del paquete javax.swing pide que le pases por parametro un objeto que implemente la interfaz ActionListener
- dispara un evento en cada x tiempo.
*/

public class clase_timer {
    public static void main(String[] args) {
        
        DameHora oyente = new DameHora(); //Creamos un objeto de clase DameHora que implementa la interfaz ActionListener
        //ActionListener oyente = new DameHora(); //esto funciona igual que el la declaracion de la linea anterior.

        Timer Temporizador1 = new Timer(5000, oyente); //parametro 1: Tiempo en milisengundos. 2 parametro: funcion

        Temporizador1.start();

        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para detener"); //Ventana emergente

        System.exit(0); //Termina el programa
    }
}


class DameHora implements ActionListener{

    public void actionPerformed(ActionEvent e){
        Date HoraActual = new Date(); //creamos un objeto de tipo Date que al llamarlo nos muestra la fecha actual
        System.out.println("Te pongo la hora cada 5 segundos: " + HoraActual);
        Toolkit.getDefaultToolkit().beep(); //Sonido beep
    }
}
