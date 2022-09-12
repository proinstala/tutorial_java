package entorno_grafico;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.*; //interfaz ActionListener
import java.awt.Font;


/*
 - Clase JComboBox
 - CONTRUCTOR:
    JComboBox()	                           Creates a JComboBox with a default data model.
    JComboBox​(E[] items)	                Creates a JComboBox that contains the elements in the specified array.
    JComboBox​(Vector<E> items)	            Creates a JComboBox that contains the elements in the specified Vector.
    JComboBox​(ComboBoxModel<E> aModel)	    Creates a JComboBox that takes its items from an existing ComboBoxModel.

 - DESCRIPCION DE PROGRAMA:
    Este programa de ejemplo modifica el tipo de fuente del texto de la etiqueta (texto).
    Hay un marco (Marco1) con un panel principal (Panel1) con disposicion BorderLayout.
    La etiqueta a la que modificamos la fuente del texto se encuentra en la parte central de Panel1.
    Hay un panel (PanelNorte) que se encuentra en la parte norte del panel principal (Panel1).
    El panelNorte contien un ojeto de tipo JComboBox (miCombo).
    Con el objeto miCombo modificamos la fuente del texto de la etiqueta texto.

*/

public class Componentes7_ComboBox {
    public static void main(String[] args) {
        MarcoCombo1 Marco1 = new MarcoCombo1();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoCombo1 extends JFrame{

    public MarcoCombo1(){
        setBounds(550, 300, 550, 400);
        PanelCombo1 Panel1 = new PanelCombo1();
        add(Panel1);
        setVisible(true);
    }
}


class PanelCombo1 extends JPanel{

    private JLabel texto;       //Creamos el objeto texto de clase JLabel
    private JComboBox miCombo;  //Creamos el objeto miCombo de la clase JComboBox

    public PanelCombo1(){
        setLayout(new BorderLayout()); //Damos disposicion al panel
        texto = new JLabel("En un lugar de la mancha de cuyo nombe..."); //Instanciamos y ponemos el texto a la etiqueta
        texto.setFont(new Font("Serif", Font.PLAIN, 18)); //Le damos un formato inicial 
        add(texto, BorderLayout.CENTER);    //Añadimos el objeto texto al panel en la parte central
        JPanel PanelNorte = new JPanel();   //Creamos e instanciamos el panel PanelNorte 
        miCombo = new JComboBox<>();    //Instaciamos el objeto miCombo
        //miCombo.setEditable(true);    //Este metodo habilata la edicion y podemos intruducir texto en el ComboBox
        miCombo.addItem("Serif");       //Añadimos un item seleccionable
        miCombo.addItem("Rockwell");   //Añadimos un item seleccionable
        miCombo.addItem("Monospaced");  //Añadimos un item seleccionable
        miCombo.addItem("Yu Gothic UI Light");      //Añadimos un item seleccionable
        PanelNorte.add(miCombo);        //Añadimos el objeto miCombo al panel PanelNorte
        miCombo.addActionListener(new EventoCombo1()); //Ponemos a la escucha de micombo al evento new EventoCombo1()
        add(PanelNorte, BorderLayout.NORTH); //Añadimos el PanelNorte al Panel principal (Panel1) en la zona NORTE
    }

    private class EventoCombo1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //texto.setFont(new Font((String)miCombo.getSelectedItem(), Font.PLAIN, 18)); //hacemos refundicion con el metodo miCombo.getSelectedItem() porque devueve un objeto de tipo Object y necesitamos un String  
            texto.setFont(new Font(miCombo.getSelectedItem().toString(), Font.PLAIN, 18));
        }
        
    }
}
