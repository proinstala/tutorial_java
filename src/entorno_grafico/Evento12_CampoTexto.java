package entorno_grafico;

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


/*
 - Interfaz DocumentListener
    - Package javax.swing.event
    - Metodos:
        void changedUpdate​(DocumentEvent e)	Gives notification that an attribute or set of attributes changed.
        void insertUpdate​(DocumentEvent e)	    Gives notification that there was an insert into the document.
        void removeUpdate​(DocumentEvent e)	    Gives notification that a portion of the document has been removed.

*/

public class Evento12_CampoTexto {
    public static void main(String[] args) {
        
        MarcoTexto2 MarcoText2 = new MarcoTexto2();
        MarcoText2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoTexto2 extends JFrame{

    public MarcoTexto2(){
        setBounds(500, 300, 500, 350);

        LaminaTexto2 LaminaText3 = new LaminaTexto2();
        add(LaminaText3);
        setVisible(true);
    }
}


class LaminaTexto2 extends JPanel{

    public LaminaTexto2(){
        JTextField campo2 = new JTextField(20);
        add(campo2);

        Document midoc = campo2.getDocument();

        midoc.addDocumentListener(new EscuchaTexto());
    }

    private class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("has insetado texto");
            
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            System.out.println("has borrado texto");
            
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }
}