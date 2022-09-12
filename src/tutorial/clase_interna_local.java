package tutorial;


import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


/*

- Si la clase es interna local(se encuentra dentro de un metodo) no tiene que llevar modificador de acceso.
- Solo se puede instanciar una vez.
- puede acceder a las variables de la variables locales de la clase que la engloba.
- si la clase interna local se le pasan parametros a traves del metodo que la contiene, las varibles tiene que ser final.

ESTRRUCTURA:

    Public class Clase_1{
        public void método(){
            class Clase_2{
                Código de la Clase_2
            }
            código del metodo
        }
    Código de la clase_1
    }

*/

public class clase_interna_local {
    public static void main(String[] args) {
        
    Reloj_2 MiReloj = new Reloj_2(3000);
    MiReloj.setMarcha(true);
    JOptionPane.showMessageDialog(null, "Pulsa Aceptar para finalizar programa");
    }
}


class Reloj_2{

    private int intervalo;

    public Reloj_2(int intervalo){
        this.intervalo = intervalo;
    }

    public void setMarcha(final boolean sonido){

        class DameHora2 implements ActionListener{ //clase interna local
        
            public void actionPerformed(ActionEvent e){
                Date ahora = new Date();
                System.out.println("Hora actual: " + ahora);
                if(sonido) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener oyente = new DameHora2();
        Timer Temporizador2 = new Timer(intervalo, oyente);
        Temporizador2.start();
    }

    
}
