package entorno_grafico;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/*
 - CLASE:   JMenuBar
 - PAQUETE: javax.swing.JMenuBar
 - DESCRIPCION: Crea la barra de menu
 - CONSTRUCTOR:
    JMenuBar()	    Creates a new menu bar.


 - CLASE:   JMenu
 - PAQUETE: javax.swing.JMenu
 - DESCRIPCION: Crea los campos de la barra de menu
 - CONSTRUCTOR:
    JMenu()	                       Constructs a new JMenu with no text.
    JMenu​(String s)                Constructs a new JMenu with the supplied string as its text.
    JMenu​(String s, boolean b)	    Constructs a new JMenu with the supplied string as its text and specified as a tear-off menu or not.
    JMenu​(Action a)	            Constructs a menu whose properties are taken from the Action supplied.


 - CLASE:   JMenuItem
 - PAQUETE: javax.swing.JMenuItem
 - DESCRIPCION: Crea los items de la barra de menu
 - CONSTRUCTOR:
    JMenuItem()	                           Creates a JMenuItem with no set text or icon.
    JMenuItem​(String text)	                Creates a JMenuItem with the specified text.
    JMenuItem​(String text, int mnemonic)	Creates a JMenuItem with the specified text and keyboard mnemonic.
    JMenuItem​(String text, Icon icon)	    Creates a JMenuItem with the specified text and icon.
    JMenuItem​(Action a)	                Creates a menu item whose properties are taken from the specified Action.
    JMenuItem​(Icon icon)	                Creates a JMenuItem with the specified icon.


 - DESCRIPCION DE PROGRAMA:
    En este programa de ejemplo creamos una barra de menus con varios campos y items en su interior.
    Ponemos imagenes en los items del campo de menu edicion

*/

public class Componentes12_JMenuBar {
    public static void main(String[] args) {
        MarcoJMenuBar1 Marco1 = new MarcoJMenuBar1();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoJMenuBar1 extends JFrame{

    public MarcoJMenuBar1(){
        setBounds(500, 300, 550, 400);
        PanelJMenuBar1 Panel1 = new PanelJMenuBar1();
        add(Panel1);
        setVisible(true);
    }
}


class PanelJMenuBar1 extends JPanel{

    public PanelJMenuBar1(){
        JMenuBar Barra1 = new JMenuBar(); //Creamos la barra de menus (Barra1)

        JMenu archivo = new JMenu("Archivo"); //Creamos el campo archivo 
        JMenu edicion = new JMenu("Edicion"); //Creamos el campo edicion
        JMenu herramientas = new JMenu("Herramientas"); //Creamos el campo herramientas
        JMenu opciones = new JMenu("Opciones"); //Creamos el campo opciones

        JMenuItem guardar = new JMenuItem("Guardar"); //Creamos el item guardar
        JMenuItem guardarComo = new JMenuItem("Guardar como"); //Creamos el item guardarComo
        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("cortar_menu.png")); //Creamos el item cortar y le añadimos una imagen
        JMenuItem Copiar = new JMenuItem("Copiar", new ImageIcon("copiar_menu.png")); //Creamos el item copiar y le añadimos una imagen
        JMenuItem Pegar = new JMenuItem("Pegar", new ImageIcon("pegar_menu.png")); //Creamos el item pegar y le añadimos una imagen
        Pegar.setHorizontalTextPosition(SwingConstants.LEFT); //posicionamos el texto a la izquierda del icono
        JMenuItem generales = new JMenuItem("Generales"); //Creamos el item generales
        JMenuItem opcion1 = new JMenuItem("Opcion 1"); //Creamos el item opcion1
        JMenuItem opcion2 = new JMenuItem("Opcion 2"); //Creamos el item opcion2

        archivo.add(guardar);       //Añadimos el item guardar al campo archivo
        archivo.add(guardarComo);   //Añadimos el item guardarComo al campo archivo
        edicion.add(cortar);        //Añadimos el item cotar al campo edicion
        edicion.add(Copiar);        //Añadimos el item copiar al campo edicion
        edicion.add(Pegar);         //Añadimos el item pegar al campo edicion
        edicion.addSeparator();     //Añadimos una barra separadora al campo edicion
        edicion.add(opciones);      //Añadimos el campo opciones al campo edcicion
        herramientas.add(generales);//Añadimos el item generales al campo herramientas
        opciones.add(opcion1);      //Añadimos el item opciones1 al campo opciones
        opciones.add(opcion2);      //Añadimos el item opciones2 al campo opciones

        Barra1.add(archivo);        //añadimos el campo archivo a la barra1
        Barra1.add(edicion);        //añadimos el campo edicion a la barra1
        Barra1.add(herramientas);   //añadimos el campo herramientas a la barra1
        add(Barra1);    //añadimos la barra1 al panel
    }
}