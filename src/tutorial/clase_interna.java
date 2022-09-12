package tutorial;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.Toolkit;


/*
- Una clase interna es una clase que esta detro de otra clase.
- Pueden acceder alas variables de la clase que la engloba.
- Las clases normales solo admiten el modificador public o el modificador por defecto
- Las clases internas pueden tenter el modificador de acceso private

ESTRRUCTURA:
    Public class Clase_1{
        class Clase_2{
            Código de la Clase_2
        }
    Código de la clase_1
    }


*/

public class clase_interna {
    public static void main(String[] args) {
        
        Reloj MiReloj = new Reloj(3000, true);
        MiReloj.setMarcha();

        JOptionPane.showMessageDialog(null, "Pulsa Aceptar para finalizar programa");
    }
}


class Reloj{

    private int intervalo;
    private boolean sonido;

    public Reloj(int intervalo, boolean sonido){
        this.intervalo = intervalo;
        this.sonido = sonido;
    }

    public void setMarcha(){
        ActionListener oyente = new DameHora2();
        Timer Temporizador2 = new Timer(intervalo, oyente);
        Temporizador2.start();
    }

    private class DameHora2 implements ActionListener{ //clase interna
        
        public void actionPerformed(ActionEvent e){
            Date ahora = new Date();
            System.out.println("Hora actual: " + ahora);
            if(sonido) Toolkit.getDefaultToolkit().beep();
        }
    }
}