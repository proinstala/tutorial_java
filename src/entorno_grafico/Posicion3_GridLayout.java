package entorno_grafico;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
- POSICIONAMIENTO GridLayout
- CONSTRUCTOR: gridLayout() - GridLayout​(int rows, int cols) - GridLayout​(int rows, int cols, int hgap, int vgap)
*/

public class Posicion3_GridLayout {
    public static void main(String[] args) {

        MarcoLayout3 MarcoL3 = new MarcoLayout3();
        MarcoL3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoL3.setVisible(true);
        
    }
}


class MarcoLayout3 extends JFrame{

    public MarcoLayout3(){
        setTitle("Pruebas");
        setBounds(600, 350, 600, 300);
        PanelLayout3 PanelL3 = new PanelLayout3();
        add(PanelL3); //añadimos el Panel al Marco
    }
}


class PanelLayout3 extends JPanel{

    public PanelLayout3(){
        setLayout(new GridLayout(3, 4));
        add(new JButton("1"));
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(new JButton("9"));

    }
}
