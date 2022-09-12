package entorno_grafico;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
- PROGRAMA DE EJEMPLO.
- Agregamos dos laminas con distinto podicionamiento al marco
*/

public class Posicion4 {
    public static void main(String[] args) {

        MarcoLayout4 MarcoL4 = new MarcoLayout4();
        MarcoL4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoL4.setVisible(true);
        
    }
}


class MarcoLayout4 extends JFrame{

    public MarcoLayout4(){
        setTitle("Pruebas");
        setBounds(600, 350, 600, 300);
        PanelLayout4 PanelL4 = new PanelLayout4();
        PanelLayout42 PanelL42 = new PanelLayout42();
        add(PanelL4, BorderLayout.NORTH); //añadimos el Panel al Marco
        add(PanelL42, BorderLayout.SOUTH); //añadimos el Panel al Marco
    }
}


class PanelLayout4 extends JPanel{

    public PanelLayout4(){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
    }
}


class PanelLayout42 extends JPanel{

    public PanelLayout42(){
        setLayout(new BorderLayout());
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro"), BorderLayout.CENTER);
    }
}
