package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Dimension;

/*
 - CLASE:   JSpinner
 - PAQUETE: javax.swing.SpinnerDateModel;
 - CONSTRUCTOR:
    JSpinner()                         Constructs a spinner with an Integer SpinnerNumberModel with initial value 0 and no minimum or maximum limits.
    JSpinner​(SpinnerModel model)       Constructs a spinner for the given model.


 - CLASE:    SpinnerDateModel
 - PAQUETE:  javax.swing.SpinnerDateModel
 - CONSTRUCTOR:
    SpinnerDateModel()	    Constructs a SpinnerDateModel whose initial value is the current date, calendarField is equal to Calendar.DAY_OF_MONTH, and for which there are no start/end limits.
    SpinnerDateModel​(Date value, Comparable<Date> start, Comparable<Date> end, int calendarField)	    Creates a SpinnerDateModel that represents a sequence of dates between start and end.


 - CLASE:   SpinnerListModel
 - PAQUETE: javax.swing.SpinnerListModel
 - CONSTRUCTOR:
    SpinnerListModel()	               Constructs an effectively empty SpinnerListModel.
    SpinnerListModel​(Object[] values)	Constructs a SpinnerModel whose sequence of values is defined by the specified array.
    SpinnerListModel​(List<?> values)	Constructs a SpinnerModel whose sequence of values is defined by the specified List.


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
    En este programa de ejemplo creamos varios objetos de tipo JSpinner y sus configuraciones.
    Creamos un marco (Marco1) que contiene un panel (Panel1). En el panel hay tres objetos de tipo JSpinner.

*/

public class Componentes10_JSpinner {
    public static void main(String[] args) {
        MarcoSpinner Marco1 = new MarcoSpinner();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoSpinner extends JFrame{

    public MarcoSpinner(){
        setBounds(500, 350, 550, 350);
        add(new PanelSpinner());
        setVisible(true);
    }
}


class PanelSpinner extends JPanel{

    public PanelSpinner(){
        String lista[] = {"Enero", "Febrero", "Marzo", "Abril"}; //creamos objeto Array de tipo String
        Dimension d = new Dimension(100, 20);     //Intanciamos la clase Dimension. Con esto, tenemos un objeto que proporciona dimensiones para otros objetos
    
        JSpinner control1 = new JSpinner(new SpinnerNumberModel(10, 0, 20, 1)); //Instanciamos la clase Jspinner y le pasamos por parametros la instancia de la clase SpinnerNumberModel(int value, int minimum, int maximum, int stepSize)
        JSpinner control2 = new JSpinner(new SpinnerDateModel());       //Instanciamos la clase Jspinner y le pasamos por parametros la instancia de la clase SpinnerDateModel()
        JSpinner control3 = new JSpinner(new SpinnerListModel(lista));  //Instanciamos la clase Jspinner y le pasamos por parametros la instancia de la clase SpinnerListModel() y a esa clase le pasamos el objeto lista
        
        control3.setPreferredSize(d); //Damos dimensiones al objeto control3

        add(control1); //añadimos al panel
        add(control2); //añadimos al panel
        add(control3); //añadimos al panel
    }
}