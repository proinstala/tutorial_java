package entorno_grafico;

import javax.swing.JFrame;
import java.awt.event.*;

/*
- EVENTOS DE RATON

- Interfaz MouseMotionListener (mover el raton) 
- Clase adaptadora MouseMotionAdapter
- La clase adaptadora de la interfaz MouseMotionListener es MouseMotionAdapter 
- Esta comentada al final de este codigo

- Interfaz MouseListener (pulsar el raton)
- Clase adaptadora MouseAdapter
- La clase adaptadora de la interfaz MouseListener es MouseAdapter 
- Esta comentada al final de este codigo

- Clase MouseEvent

*/
public class Evento7_Raton {
    public static void main(String[] args) {
        
        MarcoEvento7 Marco_7 = new MarcoEvento7();
        Marco_7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoEvento7 extends JFrame{

    public MarcoEvento7(){
        setVisible(true);
        setBounds(700, 300, 600, 450);

        addMouseListener(new EventVentana5()); //Indicamos quien es el objeto oyente
        addMouseMotionListener(new EventVentana5()); //Indicamos quien es el objeto oyente
    }
}


class EventVentana5 implements MouseListener, MouseMotionListener{ //implementado interfaz MouseListener y MouseMotionListener

    public void mouseClicked(MouseEvent e){ //Evento desencadenado al hacer click cualquier boton del raton
        System.out.println("Has hecho click con boton: " + e.getButton()); //metodo que devuelve el boton pulsado.
        
        System.out.println("Numero de veces: " + e.getClickCount()); //metodo que cuenta los click seguidos
    }

    public void mouseEntered(MouseEvent e){ //Evento desencadenado al entrar con el raton en el area del objeto 
        System.out.println("Has entrado en el marco");
    }

    public void mouseExited(MouseEvent e){ //Evento desencadenado al salir con el raton del area del objeto
        System.out.println("Has salido en el marco");
    }

    public void mouseReleased(MouseEvent e){ //Evento desencadenado al soltar cualquier boton pusado del raton
        System.out.println("Boton soltado");
    }

    public void mousePressed(MouseEvent e){ //Evento desencadenado al pulsar cualquier boton del raton
        if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) System.out.print("has pulsado el boton izquierdo"); //metodo que devuelve una constante de clase
        if(e.getModifiersEx() == MouseEvent.BUTTON2_DOWN_MASK) System.out.print("has pulsado en la ruleta");
        if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) System.out.print("has pulsado el boton derecho");
        System.out.println(" ----- Coordenadas X: " + e.getX() + " Coordenadas Y: " + e.getY()); //metodos que devuelvel las cordenadas relativas a la ventana
    }


    //EVENTOS DE INTERFAZ MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Estas arrastrando ------------------");  
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("--------------- Estas moviendo el raton");
    }
}


//CLASE ADAPATADORA MouseAdapter
/*
class EventVentana5 extends MouseAdapter{ //Clase adaptadora MouseAdapter

    public void mouseEntered(MouseEvent e){ //Evento desencadenado al entrar con el raton en el area del objeto 
        System.out.println("Has entrado en el marco");
    }

    public void mouseExited(MouseEvent e){ //Evento desencadenado al salir con el raton del area del objeto
        System.out.println("Has salido en el marco");
    }
}
*/

//CLASE ADAPATADORA MouseMotionAdapter 
/*
class EventVentana5 extends MouseMotionAdapter{ //Clase adaptadora MouseMotionAdapter

    public void mouseMoved(MouseEvent e) {
        System.out.println("--------------- Estas moviendo el raton");
    }
}
*/