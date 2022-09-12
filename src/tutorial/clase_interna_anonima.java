package tutorial;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;

/*
 - CLASE:   JSpinner
 - PAQUETE: javax.swing.SpinnerDateModel;
 - CONSTRUCTOR:
    JSpinner()                         Constructs a spinner with an Integer SpinnerNumberModel with initial value 0 and no minimum or maximum limits.
    JSpinner​(SpinnerModel model)       Constructs a spinner for the given model.


 - CLASE:   SpinnerNumberModel
 - PAQUETE: javax.swing.SpinnerNumberModel
 - CONSTRUCTOR:
    SpinnerNumberModel()	        Constructs a SpinnerNumberModel with no minimum or maximum value, stepSize equal to one, and an initial value of zero.
    SpinnerNumberModel​(double value, double minimum, double maximum, double stepSize)	                Constructs a SpinnerNumberModel with the specified value, minimum/maximum bounds, and stepSize.
    SpinnerNumberModel​(int value, int minimum, int maximum, int stepSize)	                            Constructs a SpinnerNumberModel with the specified value, minimum/maximum bounds, and stepSize.
    SpinnerNumberModel​(Number value, Comparable<?> minimum, Comparable<?> maximum, Number stepSize)	Constructs a SpinnerModel that represents a closed sequence of numbers from minimum to maximum.


 - CLASE:   Dimension
 - PAQUETE: java.awt.Dimension;
 - CONSTRUCTOR:
    Dimension()	                           Creates an instance of Dimension with a width of zero and a height of zero.
    Dimension​(int width, int height)	    Constructs a Dimension and initializes it to the specified width and specified height.
    Dimension​(Dimension d)	                Creates an instance of Dimension whose width and height are the same as for the specified dimension.


 - DIMENSIONES DE OBJETOS:
    Para dar dimensiones a los objetos de tipo JSpinner se usa el metodo setPreferredSize(Dimension)
    ejemplo:    objeto_JSpinner.setPreferredSize(new Dimension(100, 30));


 - DESCRIPCION DE PROGRAMA:
    En este programa de ejemplo instanciamos una clase anonima en el constructor de otra clase.
    Creamos un marco (Marco1) que contiene un panel (Panel1). En el panel hay un objeto de tipo JSpinner.
    cuando instanciamos el objeto de tipo JSpinner le pasamos por parametros la instancia al objeto SpinnerNumberModel y creando la clase dentro del constructor
    de la clase JSpinner.
    Con este programa cambiamos el comportamiento por defecto de los botones del objeto control1 de tipo JSpinner.

*/

public class clase_interna_anonima {
    public static void main(String[] args) {
        MarcoSpinner2 Marco1 = new MarcoSpinner2();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    

class MarcoSpinner2 extends JFrame{

    public MarcoSpinner2(){
        setBounds(500, 350, 550, 350);
        add(new PanelSpinner2());
        setVisible(true);
    }
}


class PanelSpinner2 extends JPanel{

    public PanelSpinner2(){
        Dimension d = new Dimension(100, 20);     //Intanciamos la clase Dimension. Con esto, tenemos un objeto que proporciona dimensiones para otros objetos
        JSpinner control1 = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1){ //Instanciamos la clase Jspinner y le pasamos por parametros la instancia de la clase SpinnerNumberModel(int value, int minimum, int maximum, int stepSize). Abrimos llaves para hacer metodos.
            
            public Object getNextValue(){
                return super.getPreviousValue();
            }
    
            public Object getPreviousValue(){
                return super.getNextValue();
            }
        }); 
        
        control1.setPreferredSize(d); //Damos dimensiones al objeto control3
        add(control1); //añadimos al panel
    }
}
