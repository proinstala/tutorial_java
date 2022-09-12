package entorno_grafico;

import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/*
- InputMap - objeto que crea el mapa para vincular objetos de entrada de fuente con objetos de accion
- KeyStroke - objeto que contiene la combinacion de teclas
- ActionMap - objeto que vincula la convinacion de teclas con una accion


- Este programa es un ejemplo de multiples fuentes a un oyente
*/

public class Evento10_Multiples_fuentes {
    public static void main(String[] args) {
        
        MarcoEvento10 Marco10 = new MarcoEvento10();
        Marco10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Marco10.setVisible(true);
    }
}

class MarcoEvento10 extends JFrame{

    public MarcoEvento10(){
        setTitle("Prueba acciones");
        setBounds(600, 350, 600, 300);
        PanelEvento10 evento10 = new PanelEvento10();
        add(evento10);
    }
}


class PanelEvento10 extends JPanel{

    public PanelEvento10(){
        AccionColor accionAmarillo = new AccionColor("Amarillo", new ImageIcon("logo1_42.png"), Color.YELLOW); //creamos un objeto de tipo AccionColor que implementa la clase abstracta AbstractAction
        AccionColor accionAzul = new AccionColor("Azul", new ImageIcon("logo1_42.png"), Color.BLUE);
        AccionColor accionRojo = new AccionColor("Rojo", new ImageIcon("logo1_42.png"), Color.RED);

        add(new JButton(accionAmarillo)); //creamos y añadimos el boton al panel
        add(new JButton(accionAzul));
        add(new JButton(accionRojo));


        //COMBINACIONES DE TECLAS
        InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW); //creamos un objeto tipo InputMap y que haga efecto cuando este enfocado este panel u objetos del panel
        
        KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A"); //creamos un objeto que lleva la combinacion de teclas (ctrl A)
        mapaEntrada.put(teclaAmarillo, "fondo_amarillo"); //añade la combinacion de teclas al mapa mapaEntrada y le asignamos el nombre fondo_amarillo

        KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B"); //creamos un objeto que lleva la combinacion de teclas (ctrl B)
        mapaEntrada.put(teclaAzul, "fondo_azul"); //añade la combinacion de teclas al mapa mapaEntrada y le asignamos el nombre fondo_azul

        KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl C"); //creamos un objeto que lleva la combinacion de teclas (ctrl C)
        mapaEntrada.put(teclaRojo, "fondo_rojo"); //añade la combinacion de teclas al mapa mapaEntrada y le asignamos el nombre fondo_rojo
        
        ActionMap mapaAccion = getActionMap(); //creamos un objeto  de tipo ActionMap
        mapaAccion.put("fondo_amarillo", accionAmarillo); //vinculamos el objeto con la convinacion de teclas a la accion accionAmarillo
        mapaAccion.put("fondo_azul", accionAzul); //vinculamos el objeto con la convinacion de teclas a la accion accionAzul
        mapaAccion.put("fondo_rojo", accionRojo); //vinculamos el objeto con la convinacion de teclas a la accion accionRojo
    }

    private class AccionColor extends AbstractAction{ //esta clase se hace interna para que acceda a las variables y objetos de PanelEvento10

        public AccionColor(String nombre, Icon icono, Color color_boton){
            putValue(Action.NAME, nombre);
            putValue(Action.SMALL_ICON, icono);
            putValue(Action.SHORT_DESCRIPTION, "Poner el Panel de color " + nombre);
            putValue("color_de_fondo", color_boton);
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            
            Color c=(Color)getValue("color_de_fondo"); //refundicion para guardar el color del objeto AccionColor en un objeto de tipo Color
            setBackground(c); //poner el fondo de la lamina en color que contenga el objeto c
            System.out.println("Nombre: " + getValue(Action.NAME)); //imprimir el nombre del objeto
        }
    }
}



