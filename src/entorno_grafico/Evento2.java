package entorno_grafico;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.*; //interfaz ActionListener

/*
- Crear botones
- Crear eventos al pulsar botones
- crear clase interna con metodo de interfaz ActionListener
*/


public class Evento2 {
    public static void main(String[] args) {
        
        MarcoEvento2 Marco_2 = new MarcoEvento2();
        Marco_2.setVisible(true);
        Marco_2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoEvento2 extends JFrame{

    public MarcoEvento2(){
        setTitle("Botones y Eventos");
        setBounds(700, 300, 500, 300);
        Panel1 panel1_1 = new Panel1();
        add(panel1_1);
    }
}

class Panel1 extends JPanel{

    JButton BotonAzul = new JButton("Azul"); //creamos botones
    JButton BotonAmarillo = new JButton("Amarillo");
    JButton BotonRojo = new JButton("Rojo");

    public Panel1(){
        add(BotonAzul); //añadimos los botones al Panel1
        add(BotonAmarillo);
        add(BotonRojo);

        ColorFondo Azul = new ColorFondo(Color.BLUE); //creamos objetos de la clase ColorFondo
        ColorFondo Amarillo = new ColorFondo(Color.YELLOW);
        ColorFondo Rojo = new ColorFondo(Color.RED);

        BotonAzul.addActionListener(Azul); //le indicamos quien es el oyente del boton.
        BotonAmarillo.addActionListener(Amarillo);
        BotonRojo.addActionListener(Rojo);
    }

    class ColorFondo implements ActionListener{ //clase interna que implementa la interfaz ActionListener

        private Color colorDeFondo;
    
        public ColorFondo(Color c){ //este contructor recibe por parametro un objeto de tipo Color
            colorDeFondo = c;
        }
    
        public void actionPerformed(ActionEvent e){
            setBackground(colorDeFondo);
        }
    }
}




