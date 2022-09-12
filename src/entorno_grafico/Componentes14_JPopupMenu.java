package entorno_grafico;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


/*
 - CLASE:   JPopupMenu
 - PAQUETE: javax.swing.JPopupMenu
 - DESCRIPCION: Crea menu contextual
 - CONSTRUCTOR:
    JPopupMenu()	            Constructs a JPopupMenu without an "invoker".
    JPopupMenu​(String label)	 Constructs a JPopupMenu with the specified title.


 - DESCRIPCION DE PROGRAMA:
    Este progrma de ejemplo crea un menu contextual que sale al acer click con el boton derecho sobre el panel pprincipal.

*/

public class Componentes14_JPopupMenu {
    public static void main(String[] args) {
        MarcoJPopupMenu1 Marco1 = new MarcoJPopupMenu1();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}


class MarcoJPopupMenu1 extends JFrame{

    public MarcoJPopupMenu1(){
        setBounds(100, 100, 300, 250);
        add(new PanelJPopupMenu1()); 
        setVisible(true);
    }
}


class PanelJPopupMenu1 extends JPanel{

    public PanelJPopupMenu1(){
        JPopupMenu emergente = new JPopupMenu(); //cramos el menu contextual
        JMenuItem opcion1, opcion2, opcion3;     //creamos los objetos de tipo JMenuItem

        opcion1 = new JMenuItem("Opcion 1"); //instanciamos sobre el objeto opcion1 la clase JMenuItem
        opcion2 = new JMenuItem("Opcion 2"); //instanciamos sobre el objeto opcion2 la clase JMenuItem
        opcion3 = new JMenuItem("Opcion 3"); //instanciamos sobre el objeto opcion3 la clase JMenuItem

        emergente.add(opcion1); //añadimos el objeto opcion1 al menu contextual
        emergente.add(opcion2); //añadimos el objeto opcion2 al menu contextual
        emergente.add(opcion3); //añadimos el objeto opcion3 al menu contextual

        setComponentPopupMenu(emergente); //añadimos el menu contextual a la lamina
    }
}
