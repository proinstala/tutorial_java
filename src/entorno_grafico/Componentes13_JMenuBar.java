package entorno_grafico;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.text.StyledEditorKit;
import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


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


 - CLASE:   JCheckBoxMenuItem
 - PAQUETE: javax.swing.JCheckBoxMenuItem
 - DESCRIPCION: Crea los items de la barra de menu de tipo JCheckBox
 - CONSTRUCTOR:
    JCheckBoxMenuItem()	                                   Creates an initially unselected check box menu item with no set text or icon.
    JCheckBoxMenuItem​(String text)	                        Creates an initially unselected check box menu item with text.
    JCheckBoxMenuItem​(String text, boolean b)	            Creates a check box menu item with the specified text and selection state.
    JCheckBoxMenuItem​(String text, Icon icon)	            Creates an initially unselected check box menu item with the specified text and icon.
    JCheckBoxMenuItem​(String text, Icon icon, boolean b)	Creates a check box menu item with the specified text, icon, and selection state.
    JCheckBoxMenuItem​(Action a)	                        Creates a menu item whose properties are taken from the Action supplied.
    JCheckBoxMenuItem​(Icon icon)	                        Creates an initially unselected check box menu item with an icon.

 - CLASE:   JRadioButtonMenuItem
 - PAQUETE: javax.swing.JRadioButtonMenuItem
 - DESCRIPCION: Crea los items de la barra de menu de tipo JRadioButton
 - CONSTRUCTOR:
    JRadioButtonMenuItem()	                                       Creates a JRadioButtonMenuItem with no set text or icon.
    JRadioButtonMenuItem​(String text)	                            Creates a JRadioButtonMenuItem with text.
    JRadioButtonMenuItem​(String text, boolean selected)	        Creates a radio button menu item with the specified text and selection state.
    JRadioButtonMenuItem​(String text, Icon icon)	                Creates a radio button menu item with the specified text and Icon.
    JRadioButtonMenuItem​(String text, Icon icon, boolean selected)	Creates a radio button menu item that has the specified text, image, and selection state.
    JRadioButtonMenuItem​(Action a)	                                Creates a radio button menu item whose properties are taken from the Action supplied.
    JRadioButtonMenuItem​(Icon icon)	                            Creates a JRadioButtonMenuItem with an icon.
    JRadioButtonMenuItem​(Icon icon, boolean selected)	            Creates a radio button menu item with the specified image and selection state, but no text.

 - CLASE:   StyledEditorKit
 - PAQUETE: javax.swing.text.StyledEditorKit
 - DESCRIPCION: Crea los items de la barra de menu de tipo JRadioButton
 - CONSTRUCTOR: StyledEditorKit()	Creates a new EditorKit used for styled documents.


 - DESCRIPCION DE PROGRAMA:
    En este programa de ejemplo creamos un campo de texto de tipo JTextPane y una barra de menus con varios campos y diferentes tipos de items en su interior 
    para modificar el texto que se a introducido en el campo de texto. 

    Hay un marco principal (Marco1) con un panel principal (Panel1) con disposicion BorderLayout.
    En la parte norte del Panel1 se encuentra el panel laminaMenu que contiene la barra de menu miBarra.
    El objeto miBarra es de tipo JMenuBar y contiene los campos de menus y items.
    hay cuatro objetos de tipo JMenu que son campos o clasificadores de los items de menu (fuente, estilo, tamagno, edicion;).
    El campo fuente (objeto tipo JMenu) contiene 3 items de tipo JMenuItem (arial, courier, verdana) que se encargar de cambiar el tipo de fuente del texto.
    La clase PanelJMenuBar2 tiene una metodo que crea los objetos del campo fuente y los pone a la escucha.
    El campo estilo contiene 2 items de tipo JCheckBoxMenuItem (negrita, cursiva) que cambian el el estilo al texto.
    El campo tamaño contien 4 items de tipo JRadioButtonMenuItem (n12, n16, n20, n24) que cambian el tamaño al texto. estos objetos estan agrupados
    con el objeto tamagno_letra de tipo ButtonGroup para que solo pueda estar seleccionado uno a la vez. Los items del campo tamaño tiene asignados
    atajos de teclado. Estos atajos se crean con el metodo setAccelerator​(KeyStroke keyStroke) de la clase JMenuItem.
    El campo edicion contien 3 items de tipo JMenuItem (cortar, copiar, pegar). Cada items tiene una imagen asociada y el item pegar tiene ivertida la 
    posicion del texto respecto a la imagen. Estpos objetos no tiene accion asociada.

    Los items de los campos fuente, estilo y tamaño tiene a la escucha la clase StyledEditorKit y sus diferentes metodos.
    Con esta clase simplifica la edicion del texto ya que los metodos para editar texto ya estan creados.
    Hay que seleccionar el texto que se quiere editar y pulsar sobre el boton que realice la accion que queremos hacer.
    Si pulsamos en un boton, el texto que ecribamos depues llevara los atributos seleccionados.

    El metodo setAccelerator​(KeyStroke keyStroke) de la clase JMenuItem nos pide que le pasemos por parametro un objeto de tipo KeyStroke.
    En el parametro, podemos pasarle el metodo getKeyStroke​(int keyCode, int modifiers) que nos pide la constante de la tecla que queramos 
    asignar y la constante del modificados que queramos usar. 
    Ejemplo:    objeto_JMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));
    KeyEvent.VK_1 = 49                  constante de de la tecla "1"
    InputEvent.CTRL_DOWN_MASK = 128     constante de la tecla "Ctrl"


*/

public class Componentes13_JMenuBar {
    public static void main(String[] args) {
        MarcoJMenuBar2 Marco1 = new  MarcoJMenuBar2();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}


class MarcoJMenuBar2 extends JFrame{

    public MarcoJMenuBar2(){
        setBounds(500, 300, 550, 400);
        PanelJMenuBar2 Panel1 = new PanelJMenuBar2();
        add(Panel1);
        setVisible(true);
    }
}


class PanelJMenuBar2 extends JPanel{

    JTextPane miArea; //creamos el panel de texto
    JMenu fuente, estilo, tamagno, edicion; //Ceamos los campos de menu

    public PanelJMenuBar2(){
        setLayout(new BorderLayout()); //ponemos disposicion a la lamina principal
        miArea = new JTextPane(); //intanciamos la clase JTextPane
        
        JPanel laminaMenu = new JPanel(); //creamos el panel de la barra de menu
        JMenuBar miBarra = new JMenuBar(); // creamos la barra de menu
        
        fuente = new JMenu("Fuente");   //creamos el campo de menu fuente
        estilo = new JMenu("Estilo");   //creamos el campo de menu estilo
        tamagno = new JMenu("Tamaño");  //creamos el campo de menu tamaño
        edicion = new JMenu("Edicion"); //creamos el campo de menu edicion

        configura_menu("Arial");    //llamamos al metodo que crea el item Arial y lo pone a la escucha
        configura_menu("Courier");  //llamamos al metodo que crea el item Courier y lo pone a la escucha
        configura_menu("Verdana");  //llamamos al metodo que crea el item Verdana y lo pone a la escucha

        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");   //cremaos el item negrita
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");   //creamos el item cursiva
        negrita.addActionListener(new StyledEditorKit.BoldAction());    //ponemos a la escucha de el item negrita la clase StyledEditorKit con el metodo BoldAction()
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());  //ponemos a la escucha de el item cursiva la clase StyledEditorKit con el metodo ItalicAction()
        estilo.add(negrita);    //añadimos el item negrita al campo estilo
        estilo.add(cursiva);    //añadimos el item cursiva al campo estilo

        ButtonGroup tamagno_letra = new ButtonGroup();  //creamos el objeto tamagno_letra que agrupa los items de tipo JRadioButtonMenuItem
        JRadioButtonMenuItem n12 = new JRadioButtonMenuItem("12");  //creamos el item n12 
        JRadioButtonMenuItem n16 = new JRadioButtonMenuItem("16");  //creamos el item n16
        JRadioButtonMenuItem n20 = new JRadioButtonMenuItem("20");  //creamos el item n20
        JRadioButtonMenuItem n24 = new JRadioButtonMenuItem("24");  //creamos el item n24
        n12.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 12));     //ponemos a la escucha de el item n12 la clase StyledEditorKit con el metodo FontSizeAction(nombre, tamaño)
        n16.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 16));     //ponemos a la escucha de el item n16 la clase StyledEditorKit con el metodo FontSizeAction(nombre, tamaño)
        n20.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 20));     //ponemos a la escucha de el item n20 la clase StyledEditorKit con el metodo FontSizeAction(nombre, tamaño)
        n24.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 24));     //ponemos a la escucha de el item n24 la clase StyledEditorKit con el metodo FontSizeAction(nombre, tamaño)
        n12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, InputEvent.CTRL_DOWN_MASK));   //asignamos atajo de teclado Ctrl+1
        n16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, InputEvent.CTRL_DOWN_MASK));   //asignamos atajo de teclado Ctrl+2
        n20.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, InputEvent.CTRL_DOWN_MASK));   //asignamos atajo de teclado Ctrl+3
        n24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.CTRL_DOWN_MASK));   //asignamos atajo de teclado Ctrl+4
        tamagno_letra.add(n12); //añadimos el item n12 al grupo tamagno_letra
        tamagno_letra.add(n16); //añadimos el item n16 al grupo tamagno_letra
        tamagno_letra.add(n20); //añadimos el item n20 al grupo tamagno_letra
        tamagno_letra.add(n24); //añadimos el item n24 al grupo tamagno_letra
        tamagno.add(n12);       //añadimos el item n12 al campo tamagno
        tamagno.add(n16);       //añadimos el item n16 al campo tamagno
        tamagno.add(n20);       //añadimos el item n20 al campo tamagno
        tamagno.add(n24);       //añadimos el item n24 al campo tamagno

        JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("cortar_menu.png"));   //Creamos el item cortar y le añadimos una imagen
        JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("copiar_menu.png"));   //Creamos el item copiar y le añadimos una imagen
        JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("pegar_menu.png"));      //Creamos el item pegar y le añadimos una imagen
        pegar.setHorizontalTextPosition(SwingConstants.LEFT); //posicionamos el texto del item pegar a la izquierda del icono
        edicion.add(cortar);    //añadimos el item cortar al campo edicion
        edicion.add(copiar);    //añadimos el item copiar al campo edicion
        edicion.add(pegar);     //añadimos el item pegar al campo edicion

        miBarra.add(fuente);    //añadimos el campo fuente a la barra de menu
        miBarra.add(estilo);    //añadimos el campo estilo a la barra de menu
        miBarra.add(tamagno);   //añadimos el campo tamagno a la barra de menu
        miBarra.add(edicion);   //añadimos el campo edicion a la barra de menu

        laminaMenu.add(miBarra);                //añadimos la barra de menu al panel laminaMenu
        add(laminaMenu, BorderLayout.NORTH);    //añadimos el panel laminaMenu al panel principal en la zona norte
        add(miArea, BorderLayout.CENTER);       //añadimos el panel miArea al panel principal en la zona centro
       
    }

    public void configura_menu(String rotulo){  //metodo SETTER que crea los elementos del campo fuente y los pone a la escucha
        JMenuItem elem_menu = new JMenuItem(rotulo); //creamos el objeto elem_menu con el nombre que le pasamos por el String rotulo
        fuente.add(elem_menu); //añadimos el item al campo fuente
        if(rotulo == "Arial") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra", "Arial"));       //ponemos a la escucha de el item Arial la clase StyledEditorKit con el metodo FontFamilyAction(nombre, nombre de fuente)
        if(rotulo == "Courier") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra", "Courier"));   //ponemos a la escucha de el item Courier la clase StyledEditorKit con el metodo FontFamilyAction(nombre, nombre de fuente)
        if(rotulo == "Verdana") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra", "Verdana"));   //ponemos a la escucha de el item Verdana la clase StyledEditorKit con el metodo FontFamilyAction(nombre, nombre de fuente)
    }
}
    
