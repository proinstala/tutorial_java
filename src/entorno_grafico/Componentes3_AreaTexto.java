package entorno_grafico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.*; //interfaz ActionListener
import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

 - este programa es un ejemplo de un area de texto y botones para interactuar con el area.
 - El marco tiene una lamina principal con disposicion BorderLayout. Dentro de la lamina principal, en la posicion central, hay una lamina de tipo JScrollPane
   que contiene el objeto TextArea. con la lamina JScrollPane, cuando el texto sobrepasa las medidas de el area de texto salen las barras de scroll.
   En la posicion sur de la lamina principal, hay una lamina con disposicion FlowLayout qu contiene los botones de edicion del area de texto.

 - Boton Guardar: guarda el contenido del area de texto en el String miTexto.
 - Boton Borrar: borra el contenido del area de texto.
 - Boton Agregar: agrega el texto que este en la String miTexto. 
*/

public class Componentes3_AreaTexto {
    public static void main(String[] args) {

        MarcoArea1 MarArea1 = new MarcoArea1();
        MarArea1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}


class MarcoArea1 extends JFrame{

    public MarcoArea1(){
        setBounds(500, 300, 500, 350);
        LaminaArea1 LamArea1 = new LaminaArea1();
        add(LamArea1);
        
        setVisible(true);
    }
}


class LaminaArea1 extends JPanel{

    private JTextArea miArea1; //Cramos el objeto area de texto fuera del constructor para acceder a el desde toda la clase
    private JPanel misBotones;
    private JButton miBoton1;
    private JButton miBoton2;
    private JButton miBoton3;
    String miTexto = "";

    public LaminaArea1(){

        setLayout(new BorderLayout(10, 10)); //disposicion de la lamina principal
        miArea1 = new JTextArea(8, 20); //Instanciamos el objeto area de texto
        misBotones = new JPanel(); //intanciamos el panel que va a llevar los botones

        misBotones.setLayout(new FlowLayout());

        JScrollPane LamAreaBarras = new JScrollPane(miArea1); //creamos un Panel con barras de scroll y añadimos el objeto miArea1 a ese panel
        miArea1.setLineWrap(true); //Con esto le decimos que el area de texto no crezca a lo ancho. Hace un salto de linea.
        
        miBoton1 = new JButton("Guardar");  //instanciamos el objeto miBoton1
        miBoton2 = new JButton("Borrar");   //instanciamos el objeto miBoton1
        miBoton3 = new JButton("Agregar");  //instanciamos el objeto miBoton1

        miBoton1.addActionListener(new GestionArea()); //Le decimos quien es el oyente de miBoton1
        miBoton2.addActionListener(new GestionArea()); //Le decimos quien es el oyente de miBoton2
        miBoton3.addActionListener(new GestionArea()); //Le decimos quien es el oyente de miBoton3

        misBotones.add(miBoton1); //añadimos miBoton al panel misBotones
        misBotones.add(miBoton2); //añadimos miBoton al panel misBotones
        misBotones.add(miBoton3); //añadimos miBoton al panel misBotones

        add(LamAreaBarras, BorderLayout.CENTER); //añadimos el panel LamAreaBarras al panel principal en la posicon central
        add(misBotones, BorderLayout.SOUTH);     //añadimos el panel misBotones al panel principal en la posicon sur
    }


    private class GestionArea implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object BotonPulsado = e.getSource(); //guardamos en el objeto BotonPulsado la fuente que desencadena el evento
            if(BotonPulsado == miBoton1){
                miTexto = miArea1.getText(); //Guardamos el contenido de el area de texto en miTexto
                System.out.println(miTexto); //Imprimimos por consola el contenido de miTexto
            }
            if(BotonPulsado == miBoton2){
                String miTexto2 = miArea1.getText(); //Guardamos el contenido de el area de texto en miTexto2 para despues obtener la longitud del texto
                miArea1.replaceRange("", 0, miTexto2.length()); //Remplazamos el texto que hay en el area de texto. En este caso, Borra todo el contenido
                //Tambien se podria usar miArea1.setText(""); Esto borra el area de texto y inseta el texto que le pasamos.
            }
            if(BotonPulsado == miBoton3){
                //miArea1.append("En un lugar de la Mancha de cuyo nombre no quiero acordarme");
                miArea1.append(miTexto); //agregamos al area de texto el texto del String miTexto
            }
        }
        
    }
}
