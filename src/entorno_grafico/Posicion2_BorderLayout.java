package entorno_grafico;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
- POSICIONAMIENTO BorderLayout
- CONSTRUCTOR: BorderLayout() - BorderLayout​(int hgap, int vgap)
*/

public class Posicion2_BorderLayout {
    public static void main(String[] args) {

        MarcoLayout2 MarcoL2 = new MarcoLayout2();
        MarcoL2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoL2.setVisible(true);
        
    }
}


class MarcoLayout2 extends JFrame{

    public MarcoLayout2(){
        setTitle("Pruebas");
        setBounds(600, 350, 600, 300);
        PanelLayout2 PanelL2 = new PanelLayout2();
        add(PanelL2); //añadimos el Panel al Marco
    }
}


class PanelLayout2 extends JPanel{

    public PanelLayout2(){
        setLayout(new BorderLayout(10, 10));
        add(new JButton("Amarillo"), BorderLayout.NORTH);
        add(new JButton("Rojo"), BorderLayout.SOUTH);
        add(new JButton("Azul"), BorderLayout.WEST);
        add(new JButton("Verde"), BorderLayout.EAST);
        add(new JButton("Negro"), BorderLayout.CENTER);

    }
}
