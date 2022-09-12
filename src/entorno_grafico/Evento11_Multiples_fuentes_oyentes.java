package entorno_grafico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*; //interfaz ActionListener

/*
- programa que crea con un boton ventanas y con otro boton cierra todas las ventanas creadas

*/


public class Evento11_Multiples_fuentes_oyentes {
    public static void main(String[] args) {
        
        MarcoEvento11 Marco11 = new MarcoEvento11();
        Marco11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Marco11.setVisible(true);
    }
}


class MarcoEvento11 extends JFrame{

    public MarcoEvento11(){
        setTitle("varias fuentes y ollentes");
        setBounds(1300, 100, 300, 200);
        PanelEvento11 Panel11 = new PanelEvento11();
        add(Panel11);
    }
}


class PanelEvento11 extends JPanel{

    JButton boton_cerrar;

    public PanelEvento11(){
        JButton boton_nuevo = new JButton("Nuevo");
        boton_cerrar = new JButton("Cerrar todo");
        add(boton_nuevo);
        add(boton_cerrar);

        boton_nuevo.addActionListener(new OyenteNuevo()); //le indicamos quien es el oyente del boton_nuevo
    }

    private class OyenteNuevo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MarcoEmergente Marco_e = new MarcoEmergente(boton_cerrar);
            Marco_e.setVisible(true);
            
        }

    }
}


class MarcoEmergente extends JFrame{ //clase que crea las ventanas generadas por el boton ("Nuevo")

    private static int contador = 0; //esta variable es comun para todas las instancias de esta clase

    public MarcoEmergente(JButton boton_close){ //recibe como parametro un objeto de tipo JButton
        contador++;
        setTitle("Ventana" + contador);
        setBounds(40*contador, 40*contador, 300, 150);

        boton_close.addActionListener(new CierraTodos());
    }

    private class CierraTodos implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); //cierra todas las ventanas creadas por esta clase
            contador = 0; //ponemos la variable a 0 para que empieze a construir las ventanas en la misma posicion y desde numero 1
        }
        
    }
}
