package entorno_grafico;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*

-Creamos laminas.
-Creamos Texto dentro de la lamina.

*/

public class TextoMarco {
    public static void main(String[] args) {
        
        MarcoConTexto miMarco = new MarcoConTexto();
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //metodo para cerrar el programa al cerrar la ventana
    }
    
}



class MarcoConTexto extends JFrame{

    public MarcoConTexto(){
        setVisible(true);
        setSize(600, 450);
        setLocation(400, 200);
        setTitle("primer texto");

        Lamina miLamina = new Lamina();
        add(miLamina); //añade la lamina al marco

    }
}

class Lamina extends JPanel{

    public void paintComponent(Graphics g){//sobrescrivimos el metodo. pasamos por parametro un objeto de tipo Graphics
        super.paintComponent(g); //llamamos al metodo de la clase JPanel
        g.drawString("Estamos aprendiendo Swing", 100, 100); //creamos el texto
    }
}
