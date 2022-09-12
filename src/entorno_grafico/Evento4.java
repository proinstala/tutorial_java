package entorno_grafico;

import javax.swing.JFrame;
import java.awt.event.*;

/*
- EVENTOS DE VENTANA
- Eventos que se desencadenan al modificar el estado de la ventana
- Clase adaptadora WindowAdapter Interfaz WindowListener
- Usando WindowAdapter podemos usar cualquier metodo de la interfaz WindowListener sin tener que implementarla

*/


public class Evento4 {
    public static void main(String[] args) {
        
        MarcoEvento4 Marco_4 = new MarcoEvento4();
        Marco_4.setTitle("Ventana 1");
        Marco_4.setBounds(200, 300, 500, 350);
        Marco_4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra el programa

        MarcoEvento4 Marco_44 = new MarcoEvento4();
        Marco_44.setTitle("Ventana 2");
        Marco_44.setBounds(800, 300, 500, 350);
        Marco_44.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cierra esta ventana
    }
}

class MarcoEvento4 extends JFrame{

    public MarcoEvento4(){
        //setTitle("Eventos Ventanas");
        //setBounds(300, 300, 500, 350);
        setVisible(true);
        EventVentana2 EventoVentana2 = new EventVentana2(); //Instanciamos la clase
        addWindowListener(EventoVentana2); //Le indicamos quien es el oyente

        //addWindowListener(new EventVentana2()); //esto funciona igual que si instanciamos la clase
    }
}

class EventVentana2 extends WindowAdapter{
//La clase WindowAdapter hece que puedas usar cualquier metodo de la interfaz WindowListener sin tener que implementar la interfaz 

    public void windowActivated(WindowEvent e){
        System.out.println("Foco en ventana");
    }
    /*
    public void windowClosed(WindowEvent e){
        System.out.println("Ventana Cerrada");
    }
    
    public void windowClosing(WindowEvent e){
        System.out.println("Cerrando ventana");
    }
    */
    public void windowDeactivated(WindowEvent e){
        System.out.println("Ventana desenfocada");
    }

    public void windowDeiconified(WindowEvent e){
        System.out.println("Ventana restaurada");
    }

    public void windowIconified(WindowEvent e){
        System.out.println("Ventana minimizada");
    }
    /*
    public void windowOpened(WindowEvent e){
        System.out.println("Ventana abierta");
    }
    */
}
