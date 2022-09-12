package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Font;


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
    En este ejemplo creamos un objeto de tipo Slider (control deslizante)
*/

public class Componentes8_JSlider {
    public static void main(String[] args) {
        MarcoJSlider1 Marco1 = new MarcoJSlider1();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoJSlider1 extends JFrame{

    public MarcoJSlider1(){
        setBounds(550, 400, 550, 350);
        PanelJSlider1 Panel1 = new PanelJSlider1();
        add(Panel1);
        setVisible(true);
    }
}


class PanelJSlider1 extends JPanel{

    public PanelJSlider1(){
        JSlider control = new JSlider(0, 100, 50); //Instanciamos el objeto JSlider y le pasamos al constuctor (valor puto inicial, valor punto final, posicion inicial)
        control.setPaintTicks(true); //Habilitamos las marcas visuales orientadoras
        control.setMajorTickSpacing(25);    //Separacion marcas grandes
        control.setMinorTickSpacing(5);     //Separacion marcas pequeñas
        control.setFont(new Font("Serif", Font.ITALIC, 12));    //Fuente de las marcas numericas
        control.setPaintLabels(true);   //Insertamos las marcas numericas
        control.setSnapToTicks(true);   //con esto la posicion de el slider no se queda en puntos intermedios. Se queda en las marcas.
        add(control); //añadimos el objeto control a la lamina
    }
}
