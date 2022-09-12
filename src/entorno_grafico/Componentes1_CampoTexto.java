package entorno_grafico;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.*; //interfaz ActionListener
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/*
 - Clase JTextField
 - Esta clase crea un campo de texto.
 - hereda de javax.swing.text.JTextComponent
 - Tiene sobrecarga de constructor.
 - CONSTRUCTOR: 
    JTextField()
    JTextField​(int columns)
    JTextField​(String text)
    JTextField​(String text, int columns)
    JTextField​(Document doc, String text, int columns)


 - Clase JLabel
 - Esta clase crea una etiqueta o texto.
 - Tiene sobrecarga de constructor.
 - CONSTRUCTOR: 
    JLabel()  
    JLabel​(String text)
    JLabel​(String text, int horizontalAlignment)
    JLabel​(String text, Icon icon, int horizontalAlignment)
    JLabel​(Icon image, int horizontalAlignment)
 	


 - DESCRIPCION DE PROGRAMA:
    Este programa de ejemplo tiene un marco con una lamina principal con diposicion BorderLayout.
    Dentro de la lamina principal, en la zona norte hay una lamina con disposicion FlowLayout.
    El programa tiene un campo de texto para introducir una direccion de email y comprobar si tiene arroba.
    Al pulsar el boton de comprobacion, sale una etiqueta con el texto correcto si esta bien o incorrecto si esta mal.
 
*/

public class Componentes1_CampoTexto {
    public static void main(String[] args) {
        
        MarcoTexto MarcoText = new MarcoTexto();
        MarcoText.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MarcoText.setVisible(true);
    }
}


class MarcoTexto extends JFrame{

    public MarcoTexto(){
        setBounds(600, 300, 600, 350);
        LaminaTexto LaminaText = new LaminaTexto();
        add(LaminaText);
        setVisible(true);
    }
}


class LaminaTexto extends JPanel{

    private JTextField campo1;
    private JLabel textoCorrecto;

    public LaminaTexto(){
        setLayout(new BorderLayout());
        JPanel LaminaText2 = new JPanel();
        LaminaText2.setLayout(new FlowLayout());
        JLabel texto1 = new JLabel("Email:"); 
        textoCorrecto = new JLabel("", JLabel.CENTER);
        campo1 = new JTextField(20); //Cramos campo1 con un tamaño de 20
        JButton boton1 = new JButton("Comprobar");
        DameTexto miEvento = new DameTexto();
        boton1.addActionListener(miEvento);
        LaminaText2.add(texto1);
        LaminaText2.add(campo1);
        add(textoCorrecto, BorderLayout.CENTER);
        LaminaText2.add(boton1);
        add(LaminaText2, BorderLayout.NORTH);
    }

    private class DameTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int correcto = 0;
            String email = campo1.getText().trim();
            for(int i=0; i < email.length(); i++){
                if(email.charAt(i) == '@'){
                    correcto++;
                }
            }

            if(correcto != 1){
                textoCorrecto.setText("Incorrecto");
            }
            else{
                textoCorrecto.setText("Correcto");
            }

            System.out.println(campo1.getText().trim()); //imprimimos por consola lo que hay en campo1 quitandole si hubiese espacio en blanco antes del primer caracter    
        }
    }
}



