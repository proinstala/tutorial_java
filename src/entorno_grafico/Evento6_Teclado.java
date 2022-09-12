package entorno_grafico;

import javax.swing.JFrame;
import java.awt.event.*;

/*
- EVENTOS DE TECLADO
- Eventos que se desencadenan al pulsar una tecla
- Interfaz KeyListener
- Desencadena evento cada vez que se pulsa en el teclado

- La clase adaptadora de la interfaz KeyListener es KeyAdapter
- Esta comentada al final de este codigo

*/


public class Evento6_Teclado {
    public static void main(String[] args) {
        
        MarcoEvento6 Marco_6 = new MarcoEvento6();
        Marco_6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cierra el programa
    }
}

class MarcoEvento6 extends JFrame{

    public MarcoEvento6(){
        //setTitle("Eventos Ventanas");
        //setBounds(300, 300, 500, 350);
        setVisible(true);
        setTitle("Ventana 1");
        setBounds(200, 300, 500, 350);
        
        addKeyListener(new EventVentana4()); //Indicamos quien es el objeto oyente
    }
}


class EventVentana4 implements KeyListener{

    public void keyPressed(KeyEvent e){ //evento desencadenado al pulsaar cualquier tecla
        int codigo = e.getKeyCode(); //metodo que devuelve el numero de la tecla pulsada
        System.out.println(codigo);
    }

    public void keyTyped(KeyEvent e){ //evento desencadenado al pulsar una tecla de una letra
        
    }

    public void keyReleased(KeyEvent e){ //evento desencadenado al soltar la tecla pulsada
        char letra = e.getKeyChar(); //metodo que devuelve el caracter de la tecla puelsada
        System.out.println(letra);
    }
}


//CLASE ADAPATADORA
/* 
class EventVentana4 extends KeyAdapter{ //Clase adaptadora KeyAdapter
    public void keyPressed(KeyEvent e){ //evento desencadenado al pulsaar cualquier tecla
        int codigo = e.getKeyCode(); //metodo que devuelve el numero de la tecla pulsada
        System.out.println(codigo);
    }
}

*/
