package entorno_grafico;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/*
- Lamina
- figuras con Graphics2D
- cClores
- Crear colores

*/

public class Dibujo3_color {
    public static void main(String[] args) {

        MarcoDibujo3 Dibujo3 = new MarcoDibujo3();
        Dibujo3.setVisible(true);
        Dibujo3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoDibujo3 extends JFrame{

    public MarcoDibujo3(){
        setTitle("prueba de dibujo");
        setSize(400, 400);
        Lamina4 miLamina4 = new Lamina4();
        add(miLamina4);
        miLamina4.setBackground(Color.pink); //Color de fondo
        //miLamina4.setBackground(SystemColor.window); //Color de fondo del sistema windows
        miLamina4.setForeground(Color.CYAN); //metodo para seleccionar el color por defecto de todos los elementos
    }
}

class Lamina4 extends JPanel{

    public void paintComponent(Graphics g){ //sobrescrivimos el metodo. pasamos por parametro un objeto de tipo Graphics
        super.paintComponent(g); //llamamos al metodo de la clase JPanel
        
        Graphics2D g2 = (Graphics2D) g; //Refundicion. Convertimos un objeto de tipo Graphics a Graphics2D.
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150); //instancimaos la clase Rectangle2D
        g2.setPaint(Color.BLUE); //indica el color con el que vamos a dibujar
        //g2.draw(rectangulo); //dibujamos el rectangulo
        g2.fill(rectangulo); //dibujamos el rectangulo con relleno

        Ellipse2D elipse = new Ellipse2D.Double(); //intanciamos la clase Eclipse2D
        elipse.setFrame(rectangulo); //damos parametros a la eclipse
        g2.setPaint(new Color(0, 154, 250)); //indica el color con el que vamos a dibujar
        g2.draw(elipse); //dibuja el eclipse

        //Crear un color
        Color miColor = new Color(130, 250, 57); // instanciamos la clase Color
        g2.setPaint(miColor);

        /*
        darker()
        brighter()
        
        - metodos que se aplican para hacer mas oscuro o mas claro el color.
        ejemplo: g2.setPaint(Color.BLUE.darker());

        - se pueden aplicar varias veces.
        ejemplo: g2.setPaint(Color.BLUE.darker().darker().darker());

        */
        
        
    }
}