package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.event.*; //interfaz ActionListener
import java.awt.Font;


/*
 - Clase JRadioButton
 - CONSTRUCTOR:
    JRadioButton()	                                           Creates an initially unselected radio button with no set text.
    JRadioButton​(String text)	                                Creates an unselected radio button with the specified text.
    JRadioButton​(String text, boolean selected)	            Creates a radio button with the specified text and selection state.
    JRadioButton​(String text, Icon icon)	                    Creates a radio button that has the specified text and image, and that is initially unselected.
    JRadioButton​(String text, Icon icon, boolean selected)	    Creates a radio button that has the specified text, image, and selection state.
    JRadioButton​(Action a)	                                    Creates a radiobutton where properties are taken from the Action supplied.
    JRadioButton​(Icon icon)	                                Creates an initially unselected radio button with the specified image but no text.
    JRadioButton​(Icon icon, boolean selected)	                Creates a radio button with the specified image and selection state, but no text.


 - Clase ButtonGroup
 - Esta clase sirve para vincular objetos de tipo JRadioButton y crear un grupo.
 - CONSTRUCTOR:
    ButtonGroup()	Creates a new ButtonGroup.

 
 - DESCRIPCION DE PROGRAMA:
    Este programa de ejemplo modifica el tamaño del texto de una etiqueta con 4 botones de tipo RadioButton.
    Hay un marco (MarcoRadio1) con un panel principal (PanelRadio1) con disposicion BorderLayout.
    La etiqueta a la que modificamos el texto se encuentra en la parte central del panel principal.
    Creamos un panel (PanelBotones) para agregar los RadioButton y agregamos ese panel a la parte sur del panel principal.
    Los botones estan vinculados entre si usando la clase ButtonGroup.
    Los botones se crean y se añaden a la lamina con el metodo SETTER ColocarBotones perteneciente a la clase PanelRadioButton2.
    
*/

public class Componentes6_RadioButton {
    public static void main(String[] args) {
        
        MarcoRadioButton2 MarcoRadio1 = new MarcoRadioButton2();
        MarcoRadio1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoRadioButton2 extends JFrame{

    public MarcoRadioButton2(){
        setBounds(550, 300, 500, 300);
        PanelRadioButton2 PanelRadio1 = new PanelRadioButton2();
        add(PanelRadio1);
        setVisible(true);
    }
}


class PanelRadioButton2 extends JPanel{

    private JLabel texto;
    private ButtonGroup miGrupo1;
    private JPanel PanelBotones;

    public PanelRadioButton2(){
        setLayout(new BorderLayout()); //Damos disposicion al panel
        texto = new JLabel("En un lugar de la Mancha de cuyo nombre..."); //instanciamos y ponemos el texto a la etiqueta
        texto.setFont(new Font("Serif", Font.PLAIN, 12)); //le damos un formato inicial 
        add(texto, BorderLayout.CENTER); //añadimos la etiqueta al panel principal en el centro
        PanelBotones = new JPanel(); //instanciamos el panel que contiene los botones
        miGrupo1 = new ButtonGroup(); //instanciamos el objeto que agrupa los botones de tipo RadioButton

        ColocarBotones("Pequeño", false, 10); //creamos un boton llamando al metodo ColocarBotones y pasandole los atributos por parametro
        ColocarBotones("Mediano", true, 12);
        ColocarBotones("Grande", false, 18);
        ColocarBotones("Muy grande", false, 26);

        add(PanelBotones, BorderLayout.SOUTH); //añadimos el panel PanelBotones al panel principal en la parte sur
    }

    public void ColocarBotones(String nombre, boolean seleccionado, final int tamagno){ //Metodo SETTER
        JRadioButton boton = new JRadioButton(nombre, seleccionado); //instanciamos el objeto boton pasandole los parametros
        miGrupo1.add(boton); //añadimos el boton al grupo
        PanelBotones.add(boton); //añadimos el boton al panel
        
        ActionListener miEvento = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                texto.setFont(new Font("Serif", Font.PLAIN, tamagno)); //asignamos los atributos al texto de la etiqueta
            }   
        }; //finalizamos la instruccion

        boton.addActionListener(miEvento); //ponemos el evento a la escucha
    }
}
