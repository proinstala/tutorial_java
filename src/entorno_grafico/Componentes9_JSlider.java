package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import java.awt.BorderLayout;

/*
 - Clase JSlider
 - CONSTRUCTOR:
    JSlider()	                           Creates a horizontal slider with the range 0 to 100 and an initial value of 50.
    JSlider​(int orientation)	            Creates a slider using the specified orientation with the range 0 to 100 and an initial value of 50.
    JSlider​(int min, int max)	            Creates a horizontal slider using the specified min and max with an initial value equal to the average of the min plus max.
    JSlider​(int min, int max, int value)	                    Creates a horizontal slider using the specified min, max and value.
    JSlider​(int orientation, int min, int max, int value)	    Creates a slider with the specified orientation and the specified minimum, maximum, and initial values.
    JSlider​(BoundedRangeModel brm)	                            Creates a horizontal slider using the specified BoundedRangeModel.

 - Orientacion: Para la orientacion horizontal o vertical hay que introducir una constante de clase. hay que importar el paquete javax.swing.SwingConstants
    Horizontal: SwingConstants.HORIZONTAL
    Vertical:   SwingConstants.VERTICAL


 - DESCRIPCION DE PROGRAMA:
    En este programa de ejemplo modificmos el tamaño de la fuente del texto de una etiqueta con un objeto de tipo Slider (control deslizante).
    Hay un marco (Marco1) que contiene un Panel principal (Panel1) con disposicion borderLayout.
    La etiqueta (rotulo) a la que modificamos el tamaño de la fuente se encuentra el la parte central del panel principal (Panel1).
    Hay un Panel (PanelSlider) que contien el objeto JSlider (control). El panel (PanelSlider) se encuentra el la parte norte del panel principal (Panel1).
    El objeto JSlider (control) tiene un valor minimo de 8, un valor maximo de 48 y una posicion inicial en el valor 12.
    Creamos una clase (EventoSlider) que implementa la interfaz ChangeListener.
    Ponemos a la escucha del objeto JSlider (control) la clase EventoSlider instanciandola directamente en el metodo addChangeListener.
*/

public class Componentes9_JSlider {
    public static void main(String[] args) {
        MarcoJSlider2 Marco1 = new MarcoJSlider2();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

class MarcoJSlider2 extends JFrame{

    public MarcoJSlider2(){
        setBounds(550, 400, 550, 350);
        PanelJSlider2 Panel1 = new PanelJSlider2();
        add(Panel1);
        setVisible(true);
    }
}


class PanelJSlider2 extends JPanel{

    private JLabel rotulo;      //Creamos el objeto rotulo de clase JLabel
    private JSlider control;    //Creamos el objeto control de clase JSlider

    public PanelJSlider2(){
        setLayout(new BorderLayout());      //Damos disposicion al panel
        rotulo = new JLabel("En un lugar de la mancha de cuyo nombre...");      //Instanciamos y ponemos el texto a la etiqueta
        add(rotulo, BorderLayout.CENTER);   //Añadimos el objeto rotulo al panel en la parte central
        control = new JSlider(8, 48, 12);   //Instanciamos el objeto JSlider y le pasamos al constuctor (valor puto inicial, valor punto final, posicion inicial)
        control.setMajorTickSpacing(20);    //Separacion marcas grandes
        control.setMinorTickSpacing(5);     //Separacion marcas pequeñas
        control.setPaintTicks(true);        //Habilitamos las marcas visuales orientadoras
        control.setPaintLabels(true);       //Insertamos las marcas numericas
        control.setFont(new Font("Serif", Font.PLAIN, 10));     //Fuente de las marcas numericas
        JPanel PanelSlider = new JPanel();      //Creamos e instanciamos el panel PanelSlider
        PanelSlider.add(control);               //añadimos el objeto control al panel PanelSlider
        add(PanelSlider, BorderLayout.NORTH);   //Añadimos el PanelSlider al Panel principal (Panel1) en la zona NORTE
        control.addChangeListener(new EventoSlider());      //Ponemos a la escucha de control al evento new EventoSlider()
    }

    private class EventoSlider implements ChangeListener{ //clase que implementa la interfaz ChangeListener

        @Override
        public void stateChanged(ChangeEvent e) {
            System.out.println("Deslizador: " + control.getValue());            //imprime por consola el valor del slider 
            rotulo.setFont(new Font("Serif", Font.PLAIN, control.getValue()));  //modifica el tamaño de la fuente de la etiqueta rotulo
            
        }
        
    }
}
