package entorno_grafico;

import javax.swing.JFrame;
import java.awt.event.*;

/*
- EVENTOS DE VENTANA
- Eventos que se desencadenan al modificar el estado de la ventana
- Interfaz WindowStateListener
- Desencadena evento cada vez que se modifca el estado de la ventana.

*/


public class Evento5 {
    public static void main(String[] args) {
        
        MarcoEvento5 Marco_5 = new MarcoEvento5();
        Marco_5.setTitle("Ventana 1");
        Marco_5.setBounds(200, 300, 500, 350);
        Marco_5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra el programa
    }
}

class MarcoEvento5 extends JFrame{

    public MarcoEvento5(){
        //setTitle("Eventos Ventanas");
        //setBounds(300, 300, 500, 350);
        setVisible(true);
        EventVentana3 EventoVentana3 = new EventVentana3(); //Instanciamos la clase
        addWindowStateListener(EventoVentana3); //Le indicamos quien es el oyente

        //addWindowStateListener(new EventVentana3()); //esto funciona igual que si instanciamos la clase
    }
}

class EventVentana3 implements WindowStateListener{
    
    public void windowStateChanged(WindowEvent e){ //este evento se desencadena cuando la ventana cambia de estado
        System.out.println("El estado de la ventana a cambiado");
        System.out.println(e.getNewState()); //devuelve un entero indicando el nuevo estado de la ventana
        if(e.getNewState() == java.awt.Frame.MAXIMIZED_BOTH) System.out.println("ventana maximizada: " + e.getNewState());
    }
}
