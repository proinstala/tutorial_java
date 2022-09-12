package ejemplo_programas;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;


/*
 - Ejemplo de programa para introducir nombre de usuario y contraseña.
 - El campo de introduccion de contraseña tiene unos condicionales para que te marque el campo en rojo si no cumples las regalas del password.
 - El password tiene que tener entre 8 y 12 caracteres.


*/


public class usuarioContra{
    public static void main(String[] args) {
        
        MarcoPassword MarcoPass = new MarcoPassword();
        MarcoPass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoPassword extends JFrame{

    public MarcoPassword(){
        setBounds(400, 300, 550, 400);
        LaminaPassword LaminaPass = new LaminaPassword();
        add(LaminaPass);
        setVisible(true);
    }
}


class LaminaPassword extends JPanel{

    JPasswordField c_contra; //este objeto esta declarado fuera del contructor para poder acceder a el desde toda la clase

    public LaminaPassword(){
        setLayout(new BorderLayout());
        JPanel LaminaSup = new JPanel();
        LaminaSup.setLayout(new GridLayout(2, 2));
        add(LaminaSup, BorderLayout.NORTH);

        JLabel etiqueta1 = new JLabel("Usuario");
        JLabel etiqueta2 = new JLabel("Contraseña");
        JTextField c_usuario = new JTextField(15);
        c_contra = new JPasswordField(15);

        LaminaSup.add(etiqueta1);
        LaminaSup.add(c_usuario);
        LaminaSup.add(etiqueta2);
        LaminaSup.add(c_contra);

        JButton enviar = new JButton("Enviar");
        add(enviar, BorderLayout.SOUTH);

        Document midoc = c_contra.getDocument();
        midoc.addDocumentListener(new CompruebaPass());
    }

    private class CompruebaPass implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            char contra [];
            contra = c_contra.getPassword(); // este metodo devuelve una array con los caracteres que introzcamos en el campo c_contra
            if(contra.length < 8 || contra.length > 12){
                c_contra.setBackground(Color.red);
            }
            else{
                c_contra.setBackground(Color.white);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            char contra [];
            contra = c_contra.getPassword();
            if(contra.length < 8 || contra.length > 12){
                c_contra.setBackground(Color.red);
            }
            else{
                c_contra.setBackground(Color.white);
            }
            
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }
}