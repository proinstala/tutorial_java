package entorno_grafico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.*; //interfaz ActionListener


/*
 - Clase JTextArea
 - Esta clase crea un area de texto.
 - hereda de javax.swing.text.JTextComponent
 - Tiene sobrecarga de constructor.
 - CONSTRUCTOR: 
    JTextArea()                            Constructs a new TextArea.
    JTextArea​(int rows, int columns)	    Constructs a new empty TextArea with the specified number of rows and columns.
    JTextArea​(String text)	                Constructs a new TextArea with the specified text displayed.
    JTextArea​(Document doc)	            Constructs a new JTextArea with the given document model, and defaults for all of the other arguments (null, 0, 0).
    JTextArea​(String text, int rows, int columns)	                Constructs a new TextArea with the specified text and number of rows and columns.
    JTextArea​(Document doc, String text, int rows, int columns)	Constructs a new JTextArea with the specified number of rows and columns, and the given model.

 - este programa es un ejemplo de un area de texto. si pulsas el boton "Dale" el texto que esta en el area de texto se imprime en la consola.
*/

public class Componentes2_AreaTexto {
    public static void main(String[] args) {

        MarcoArea MarArea1 = new MarcoArea();
        MarArea1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}


class MarcoArea extends JFrame{

    public MarcoArea(){
        setBounds(500, 300, 500, 350);
        LaminaArea LamArea1 = new LaminaArea();
        add(LamArea1);
        setVisible(true);
    }
}


class LaminaArea extends JPanel{

    private JTextArea miArea1; //Cramos el objeto area de texto fuera del constructor para acceder a el desde toda la clase

    public LaminaArea(){

        miArea1 = new JTextArea(8, 20); //Instanciamos el objeto area de texto
        JScrollPane LamAreaBarras = new JScrollPane(miArea1); //creamos un Panel con barras de scroll y añadimos el objeto miArea1 a ese panel
        miArea1.setLineWrap(true); //Con esto le decimos que el area de texto no crezca a lo ancho. Hace un salto de linea.
        JButton miBoton = new JButton("Dale");
        miBoton.addActionListener(new GestionArea()); //Le decimos quien es el oyente de miBoton
        add(LamAreaBarras); //añadimos el panel LamAreaBarras al panel principal
        add(miBoton); //añadimos miBoton al panel
    }


    private class GestionArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String miTexto = miArea1.getText(); //Guardamos el contenido de el area de texto en miTexto
            System.out.println(miTexto); //Imprimimos por consola el contenido de miTexto
        }
        
    }
}
