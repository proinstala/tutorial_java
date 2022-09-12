package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/*
- Fuentes
- Seleccionar y crear objetos con tipos y estilos de fuente
- Dibujar texto 

*/

public class Dibujo4_fuentes {
    public static void main(String[] args) {

        MarcoDibujo4 Dibujo4 = new MarcoDibujo4();
        Dibujo4.setVisible(true);
        Dibujo4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
}

class MarcoDibujo4 extends JFrame{

    public MarcoDibujo4(){
       setTitle("Prueba con fuentes");
       setSize(400, 400);
       Lamina5 miLamina5 = new Lamina5();
       add(miLamina5);  
       miLamina5.setForeground(Color.CYAN); //metodo para seleccionar el color por defecto de todos los elementos 
    }
}

class Lamina5 extends JPanel{

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        Font miFuente1 = new Font("Arial", Font.BOLD, 26); //Instanciamos el objeto Font pasando por parametros (nombre fuente, tipo de fuente, tamaño)
        g2.setFont(miFuente1); //selecciona la fuente miFuente1
        g2.drawString("David", 100, 100); //dibuja el texto

        Font miFuente2 = new Font("Proxy 1", Font.PLAIN, 26); // PLAIN = normal (0) | BOLD = negrita (1) | ITALIC = cursiva (2)
        g2.setFont(miFuente2); //selecciona la fuente miFuente2
        g2.setPaint(Color.BLUE); //selecciona el color
        g2.drawString("David", 100, 150); //dibuja el texto

        g2.setFont(new Font("Pristina", Font.ITALIC, 26)); //instaciamos Font dentro del metodo setFont 
        g2.setPaint(new Color(150, 14, 250)); //selecciona color
        g2.drawString("David", 100, 200); //dibuja el texto
    }
}
