package entorno_grafico;

import java.awt.event.*; //interfaz ActionListener
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 - Este programa crea un marco. dentro del marco crea un panel con tres botones.
 - Cada boton cambia el FlowLayout 


*/


public class PruebaPosicion {
    public static void main(String[] args) {
        MarcoJF MarcoJF1 = new MarcoJF();
        MarcoJF1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoJF1.setVisible(true);
    }
}


class MarcoJF extends JFrame{

    public MarcoJF(){
        setTitle("Pruebas");
        setBounds(600, 350, 600, 300);
        PanelJP PanelJP1 = new PanelJP();
        add(PanelJP1); //añadimos el Panel al Marco
    }
}


class PanelJP extends JPanel implements ActionListener{

    JButton BotonL = new JButton("IZQUIERDA");
    JButton BotonC = new JButton("CENTRADO");
    JButton BotonR = new JButton("DERECHA");

    public PanelJP(){
        add(BotonL);
        add(BotonC);
        add(BotonR);

        BotonL.addActionListener(this);
        BotonC.addActionListener(this);
        BotonR.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object BotonPulsado = e.getSource(); //guardamos en el objeto BotonPulsado la fuente que desencadena el evento
        if(BotonPulsado == BotonL) setLayout(new FlowLayout(FlowLayout.LEFT)); //ponemos los objetos del PanelJP1 con disposicion FlowLayout.LEFT
        if(BotonPulsado == BotonC) setLayout(new FlowLayout(FlowLayout.CENTER)); //ponemos los objetos del PanelJP1 con disposicion FlowLayout.CENTER
        if(BotonPulsado == BotonR) setLayout(new FlowLayout(FlowLayout.RIGHT)); //ponemos los objetos del PanelJP1 con disposicion FlowLayout.RIGHT
        updateUI(); //con esto refrescamos el panel
    }
}








