package entorno_grafico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.*; //interfaz ActionListener

/*
- Crear botones
- Crear eventos al pulsar botones

*/

public class Evento1 {
    public static void main(String[] args) {
        
        MarcoEvento1 Marco_1 = new MarcoEvento1();
        Marco_1.setVisible(true);
        Marco_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoEvento1 extends JFrame{


    public MarcoEvento1(){
        setTitle("Botones y Eventos");
        setBounds(700, 300, 500, 300);
        LaminaBotones1 lamina_1 = new LaminaBotones1();
        add(lamina_1);
    }
}


class LaminaBotones1 extends JPanel implements ActionListener{

    JButton BotonAzul = new JButton("Azul"); //crea un objeto de tipo JButton.
    JButton BotonAmarillo = new JButton("Amarillo");
    JButton BotonRojo = new JButton("Rojo");

    public LaminaBotones1(){
        add(BotonAzul); //añadimos el boton a la lamina
        add(BotonAmarillo);
        add(BotonRojo);

        BotonAzul.addActionListener(this); //le indicamos quien es el oyente del boton. (this) = este objeto = LaminaBotones1
        BotonAmarillo.addActionListener(this);
        BotonRojo.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){ //metodo de interfaz actionListener. evento desencadenado por BotonAzul, BotonAmarillo o BotonRojo
        
        Object BotonPulsado = e.getSource(); //guardamos en el objeto BotonPulsado la fuente que desencadena el evento
        if(BotonPulsado == BotonAzul) setBackground(Color.BLUE); //ponemos el fondo del oyente en azul
        if(BotonPulsado == BotonAmarillo) setBackground(Color.YELLOW);
        if(BotonPulsado == BotonRojo) setBackground(Color.RED);
    }

}
