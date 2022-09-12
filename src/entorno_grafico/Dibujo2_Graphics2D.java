package entorno_grafico;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/*
- Lamina
- figuras con Graphics2D

*/

public class Dibujo2_Graphics2D {
    public static void main(String[] args) {

        MarcoDibujo2 Dibujo2 = new MarcoDibujo2();
        Dibujo2.setVisible(true);
        Dibujo2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MarcoDibujo2 extends JFrame{

    public MarcoDibujo2(){
        setTitle("prueba de dibujo");
        setSize(400, 400);
        Lamina3 miLamina3 = new Lamina3();
        add(miLamina3);
    }
}

class Lamina3 extends JPanel{

    public void paintComponent(Graphics g){ //sobrescrivimos el metodo. pasamos por parametro un objeto de tipo Graphics
        super.paintComponent(g); //llamamos al metodo de la clase JPanel
        
        Graphics2D g2 = (Graphics2D) g; //Refundicion. Convertimos un objeto de tipo Graphics a Graphics2D.
        Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150); //instancimaos la clase Rectangle2D
        g2.draw(rectangulo); //dibujamos el rectangulo
        Ellipse2D elipse = new Ellipse2D.Double(); //intanciamos la clase Eclipse2D
        elipse.setFrame(rectangulo); //damos parametros a la eclipse
        g2.draw(elipse); //dibuja el eclipse
        g2.draw(new Line2D.Double(20, 20, 20, 100)); //dibuja linea instanciando el objeto dentro del metodo

        double CentroEjeX = rectangulo.getCenterX(); //dato centro del rectangulo eje X
        double CentroEjeY = rectangulo.getCenterY(); //dato centro del rectangulo eje Y
        double radio = 150; //variable 
        Ellipse2D circulo = new Ellipse2D.Double(); //instanciamos la clase
        circulo.setFrameFromCenter(CentroEjeX, CentroEjeY, CentroEjeX+radio, CentroEjeY+radio); //damos parametros al circulo
        g2.draw(circulo); //dibujamos el circulo
        
    }
}