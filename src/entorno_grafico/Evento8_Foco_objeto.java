package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

/*
- EVENTOS DE FOCO   

- Interfaz FocusListener (foco objeto)
- clase FocusEvent

- Clase adaptadora FocusAdapter

*/

public class Evento8_Foco_objeto {
    public static void main(String[] args) {
        
        EventFoco EventoFoco = new EventFoco();
        EventoFoco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class EventFoco extends JFrame{

    public EventFoco(){

        setVisible(true);
        setBounds(300, 300, 600, 450);
        add(new LaminaFoco());
    }
}

class LaminaFoco extends JPanel implements FocusListener{

    JTextField cuadro1; //creamos el objeto cuadro1 de tipo JTextField
    JTextField cuadro2;

    public void paintComponent(Graphics g){ //sobrescrivimos el metodo. pasamos por parametro un objeto de tipo Graphics
        super.paintComponent(g); //llamamos al metodo de la clase JPanel
        setLayout(null);
        cuadro1 = new JTextField(); //instanciamos la clase JTextField
        cuadro2 = new JTextField();
        cuadro1.setBounds(120, 10, 150, 20); //damos posicion y dimension al cuadro de texto
        cuadro2.setBounds(120, 50, 150, 20);
        add(cuadro1); //añadimos el cuadro de texto a la lamina
        add(cuadro2);
        
        //cuadro1.addFocusListener(new objetoFoco()); //ponemos oyente
        cuadro1.addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e){ //evento desencadenado al cojer el foco
            
    }

    @Override
    public void focusLost(FocusEvent e){ //evento desencadenado al perder el foco
        //cuadro1 = (JTextField) e.getSource(); //con esto, cuando redimensionamos la ventana sigue funcionando
        System.out.println("has perdido el foco");
        String email = cuadro1.getText();
        System.out.println(email);
        
    }

    /*
    //se puede crear una clase interna y usar la clase adaptadora FocusAdapter 
    private class objetoFoco  implements FocusListener{ 
        //hacemos esta clase interna dentro de la clase LaminaFoco para acceder a los campos de clase de LaminaFoco
        /*
        @Override
        public void focusGained(FocusEvent e){ //evento desencadenado al cojer el foco
            
        }
    
        @Override
        public void focusLost(FocusEvent e){ //evento desencadenado al perder el foco
            System.out.println("has perdido el foco");
            
        }
    }*/
}


