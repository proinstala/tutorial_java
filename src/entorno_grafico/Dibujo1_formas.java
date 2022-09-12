package entorno_grafico;

import java.awt.*;
import javax.swing.*;


/*

- Lamina
- objeto Graphics
- dibujar formas
*/

public class Dibujo1_formas {
    public static void main(String[] args) {
        
        MarcoDibujo Dibujo1 = new MarcoDibujo();
        Dibujo1.setVisible(true);
        Dibujo1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoDibujo extends JFrame{

    public MarcoDibujo(){
        setTitle("prueba de dibujo");
        setSize(400, 400);
        Lamina2 miLamina2 = new Lamina2();
        add(miLamina2);
    }
}

class Lamina2 extends JPanel{

    public void paintComponent(Graphics g){ //sobrescrivimos el metodo. pasamos por parametro un objeto de tipo Graphics
        super.paintComponent(g); //llamamos al metodo de la clase JPanel
        g.drawLine(10, 15, 10, 65); //dibuja una linea
        g.drawRect(15, 15, 50, 50); // dibuja un rectangulo
        g.drawArc(80, 30, 100, 100, 100, 100); // dibuja un arco
        
    }
}
