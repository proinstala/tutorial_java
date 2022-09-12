package ejemplo_programas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //interfaz ActionListener

/*
 - Programa de ejemplo de una calculadora.
*/

public class Calculadora {
    public static void main(String[] args) {
        
        MarcoCalculadora MarcoCal = new MarcoCalculadora();
        MarcoCal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoCal.setVisible(true);

    }
}


class MarcoCalculadora extends JFrame{

    public MarcoCalculadora(){
        setTitle("Calculadora");
        setBounds(500, 300, 450, 300);
        LaminaCalculadora LaminaCal = new LaminaCalculadora();
        add(LaminaCal);
        pack(); //adapta el tamaño de la ventana al tamaño por defecto de los objetos
    }
}

class LaminaCalculadora extends JPanel{

    private JButton pantalla;
    private boolean principio; //variable auxiliar para borrar la pantalla
    private double resultado;
    private String ultimaOperacion;

    public LaminaCalculadora(){
        principio = true; //ponemos a true para que la primera vez que pulsemos un numero nos borre el numero 0 que hay en pantalla
        ultimaOperacion = "=";
        setLayout(new BorderLayout());
        pantalla = new JButton("0");
        pantalla.setEnabled(false); //Deshabilita el boton
        add(pantalla,BorderLayout.NORTH); //añadimos el boton pantalla que hace de display a la parte de arriba

        JPanel LaminaCal2 = new JPanel();
        LaminaCal2.setLayout(new GridLayout(4, 4));
        
        JButton boton1 = new JButton("1");
        JButton boton2 = new JButton("2");
        JButton boton3 = new JButton("3");
        JButton boton4 = new JButton("4");
        JButton boton5 = new JButton("5");
        JButton boton6 = new JButton("6");
        JButton boton7 = new JButton("7");
        JButton boton8 = new JButton("8");
        JButton boton9 = new JButton("9");
        JButton boton0 = new JButton("0");

        JButton botonIgual = new JButton("=");
        JButton botonMas = new JButton("+");
        JButton botonMenos = new JButton("-");
        JButton botonDivide = new JButton("/");
        JButton botonMultiplica = new JButton("*");
        JButton botonPunto = new JButton(".");

        LaminaCal2.add(boton1);
        LaminaCal2.add(boton2);
        LaminaCal2.add(boton3);
        LaminaCal2.add(boton4);
        LaminaCal2.add(boton5);
        LaminaCal2.add(boton6);
        LaminaCal2.add(boton7);
        LaminaCal2.add(boton8);
        LaminaCal2.add(boton9);
        LaminaCal2.add(boton0);
        LaminaCal2.add(botonIgual);
        LaminaCal2.add(botonMas);
        LaminaCal2.add(botonMenos);
        LaminaCal2.add(botonDivide);
        LaminaCal2.add(botonMultiplica);
        LaminaCal2.add(botonPunto);

        add(LaminaCal2, BorderLayout.CENTER);
        
        boton0.addActionListener(new EventoNumeros());
        boton1.addActionListener(new EventoNumeros());
        boton2.addActionListener(new EventoNumeros());
        boton3.addActionListener(new EventoNumeros());
        boton4.addActionListener(new EventoNumeros());
        boton5.addActionListener(new EventoNumeros());
        boton6.addActionListener(new EventoNumeros());
        boton7.addActionListener(new EventoNumeros());
        boton8.addActionListener(new EventoNumeros());
        boton9.addActionListener(new EventoNumeros());

        botonIgual.addActionListener(new EventoOperador());
        botonMas.addActionListener(new EventoOperador());
        botonMenos.addActionListener(new EventoOperador());
        botonDivide.addActionListener(new EventoOperador());
        botonMultiplica.addActionListener(new EventoOperador());

    }

    private class EventoNumeros implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String entrada = e.getActionCommand();
            if(principio){ //borra el texto de la pantalla al pulsar por primera vez un numero o al pulsar un boton de operador y despues un numero
                pantalla.setText("");
                principio = false;
            }
            
            pantalla.setText(pantalla.getText() + entrada); //concatena lo que hay en pantalla con el nuevo numero ingresado
            
        }
    }

    private class EventoOperador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String operacion = e.getActionCommand();
            calcular(Double.parseDouble(pantalla.getText()));
            ultimaOperacion = operacion;
            principio = true; //pone la variable a true para que cuando se pulse un numero, primero borre el texto que hay en pantalla
            
        }

        public void calcular(double x){
            if(ultimaOperacion.equals("+")){
                resultado += x;
            }

            else if(ultimaOperacion.equals("-")){
                resultado -= x;
            }
            else if(ultimaOperacion.equals("*")){
                resultado *= x;
            }
            else if(ultimaOperacion.equals("/")){
                resultado /= x;
            }
            
            else if(ultimaOperacion.equals("=")){
                resultado = x;
            }
            pantalla.setText(Double.toString(resultado)); //pasamos a string el numero que esta en double y lo ponemos en pantalla
        }
        
    }
}


