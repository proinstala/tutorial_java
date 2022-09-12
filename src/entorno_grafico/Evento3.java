package entorno_grafico;

import javax.swing.JFrame;
import java.awt.event.*;

/*
- EVENTOS DE VENTANA
- Eventos que se desencadenan al modificar el estado de la ventana
- Interfaz WindowListener

*/


public class Evento3 {
    public static void main(String[] args) {
        
        MarcoEvento3 Marco_3 = new MarcoEvento3();
        Marco_3.setTitle("Ventana 1");
        Marco_3.setBounds(200, 300, 500, 350);
        Marco_3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra el programa

        MarcoEvento3 Marco_33 = new MarcoEvento3();
        Marco_33.setTitle("Ventana 2");
        Marco_33.setBounds(800, 300, 500, 350);
        Marco_33.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Cierra esta ventana
    }
}

class MarcoEvento3 extends JFrame{

    public MarcoEvento3(){
        //setTitle("Eventos Ventanas");
        //setBounds(300, 300, 500, 350);
        setVisible(true);
        EventVentana1 EventoVentana1 = new EventVentana1(); //Instanciamos la clase
        addWindowListener(EventoVentana1); //Le indicamos quien es el oyente

        //addWindowListener(new EventVentana1()); //esto funciona igual que si instanciamos la clase
    }
}

class EventVentana1 implements WindowListener{
    //Hay que implementar todos los metodos

    public void windowActivated(WindowEvent e){
        System.out.println("Foco en ventana");
    }

    public void windowClosed(WindowEvent e){
        System.out.println("Ventana Cerrada");
    }

    public void windowClosing(WindowEvent e){
        System.out.println("Cerrando ventana");
    }

    public void windowDeactivated(WindowEvent e){
        System.out.println("Ventana desenfocada");
    }

    public void windowDeiconified(WindowEvent e){
        System.out.println("Ventana restaurada");
    }

    public void windowIconified(WindowEvent e){
        System.out.println("Ventana minimizada");
    }

    public void windowOpened(WindowEvent e){
        System.out.println("Ventana abierta");
    }

}
