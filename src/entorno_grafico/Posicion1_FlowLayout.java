package entorno_grafico;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
- POSICIONAMIENTO FlowLayout
- CONTRUCTOR: FlowLayout() - FlowLayout​(int align) - FlowLayout​(int align, int hgap, int vgap)

*/

public class Posicion1_FlowLayout {
    public static void main(String[] args) {

        MarcoLayout1 MarcoL1 = new MarcoLayout1();
        MarcoL1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoL1.setVisible(true);
        
    }
}


class MarcoLayout1 extends JFrame{

    public MarcoLayout1(){
        setTitle("Pruebas");
        setBounds(600, 350, 600, 300);
        PanelLayout1 PanelL1 = new PanelLayout1();

        //FlowLayout disposicion = new FlowLayout(FlowLayout.LEFT); //creamos una instancia de la clase FlowLayout
        //PanelL1.setLayout(disposicion);

        PanelL1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 30)); //ponemos los objetos del PanelL1 con disposicion FlowLayout.LEFT
        add(PanelL1); //añadimos el Panel al Marco
    }
}


class PanelLayout1 extends JPanel{

    public PanelLayout1(){
        add(new JButton("Amarillo"));
        add(new JButton("Rojo"));
        add(new JButton("Azul"));
    }
}
