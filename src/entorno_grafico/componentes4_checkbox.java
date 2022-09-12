package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.*; //interfaz ActionListener


/*
 - Clase JCheckBox
 - Constructor:
    JCheckBox()                                            Creates an initially unselected check box button with no text, no icon.
    JCheckBox​(String text)	                                Creates an initially unselected check box with text.
    JCheckBox​(String text, boolean selected)	            Creates a check box with text and specifies whether or not it is initially selected.
    JCheckBox​(String text, Icon icon)	                    Creates an initially unselected check box with the specified text and icon.
    JCheckBox​(String text, Icon icon, boolean selected)	Creates a check box with text and icon, and specifies whether or not it is initially selected.
    JCheckBox​(Action a)	                                Creates a check box where properties are taken from the Action supplied.
    JCheckBox​(Icon icon)	                                Creates an initially unselected check box with an icon.
    JCheckBox​(Icon icon, boolean selected)	                Creates a check box with an icon and specifies whether or not it is initially selected.


*/

public class componentes4_checkbox {
    public static void main(String[] args) {
        
        MarcoCheck1 MarcoCh1 = new MarcoCheck1();
        MarcoCh1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoCheck1 extends JFrame{

    public MarcoCheck1(){
        setBounds(550, 300, 550, 350);
        PanelCheck1 PanelCh1 = new PanelCheck1();
        add(PanelCh1);
        setVisible(true);
        
    }
}


class PanelCheck1 extends JPanel{

    private JLabel texto; //Creamos el objeto texto
    private JCheckBox check1, check2; //Creamos los objetos check1 y check2

    public PanelCheck1(){
        setLayout(new BorderLayout()); //ponemos la disposicion de la lamina
        Font miLetra = new Font("Serif", Font.PLAIN, 24); //creamos e instancimos el objeto miLetra de tipo Font y le pasamos los argumentos
        texto = new JLabel("En un lugar de la mancha"); //iniciamos el objeto texto
        texto.setFont(miLetra);             //le damos formato al texto que contiene el objeto texto
        JPanel PanelInternoTexto = new JPanel();   //creamos otro panel para incluirlo dentro del panel principal 
        PanelInternoTexto.add(texto);              //agregamos a la lamina el objeto texto
        add(PanelInternoTexto, BorderLayout.CENTER); //agregamos el panel PanelTexto al Panel principal en la zona central
        check1 = new JCheckBox("Negrita");
        check2 = new JCheckBox("Cursiva");

        check1.addActionListener(new ControlCheck());
        check2.addActionListener(new ControlCheck());

        JPanel PanelInternoCh = new JPanel();
        PanelInternoCh.add(check1);
        PanelInternoCh.add(check2);
        add(PanelInternoCh, BorderLayout.SOUTH);

    }

    private class ControlCheck implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            int tipo = 0;
            if(check1.isSelected()) tipo += Font.BOLD; //sumamos 1 a la variable tipo si marcamos la casilla check1
            if(check2.isSelected()) tipo += Font.ITALIC; //sumamos 2 a la variable tipo si marcamos la casilla check2
            texto.setFont(new Font("serif", tipo, 24)); //damos formato al objeto texto. Si tipo vale 3 combina los dos formatos
        }

    }
}
