package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

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

*/

public class Componentes5_RadioButton {
    public static void main(String[] args) {

        MarcoRadioButton MarcoRadio1 = new MarcoRadioButton();
        MarcoRadio1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}


class MarcoRadioButton extends JFrame{

    public MarcoRadioButton(){
        setBounds(550, 300, 500, 300);
        PanelRadioButton PanelRadio1 = new PanelRadioButton();
        add(PanelRadio1);
        setVisible(true);
    }
}


class PanelRadioButton extends JPanel{

    public PanelRadioButton(){
        ButtonGroup miGrupo1 = new ButtonGroup(); 
        JRadioButton boton1 = new JRadioButton("Azul", false); //Instanciamos la clase pasandole como parametro el nombre de su etiqueta y su estado inicial (true o false)
        JRadioButton boton2 = new JRadioButton("Rojo", true);
        JRadioButton boton3 = new JRadioButton("Verde", false);
        miGrupo1.add(boton1); //añadiomos boton1 al grupo miGrupo1
        miGrupo1.add(boton2); //añadiomos boton2 al grupo miGrupo1
        miGrupo1.add(boton3); //añadiomos boton3 al grupo miGrupo1
        add(boton1); //añadiomos boton1 al la lamina
        add(boton2); //añadiomos boton2 al la lamina
        add(boton3); //añadiomos boton3 al la lamina

    }
}
