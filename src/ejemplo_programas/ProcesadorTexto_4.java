package ejemplo_programas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.text.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class ProcesadorTexto_4 {
    public static void main(String[] args) {
        MarcoProcesador4 Marco1 = new MarcoProcesador4();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoProcesador4 extends JFrame{

    public MarcoProcesador4(){
        setBounds(500, 300, 550, 400);
        PanelProcesador4 Panel1 = new PanelProcesador4();
        add(Panel1);
        setVisible(true);
    }
}


class PanelProcesador4 extends JPanel{

    JTextPane miArea;
    JMenu fuente, estilo, tamagno;
    Font letras;

    public PanelProcesador4(){
        setLayout(new BorderLayout());
        miArea = new JTextPane();
        JPanel laminaMenu = new JPanel();
        JMenuBar miBarra = new JMenuBar();
        fuente = new JMenu("Fuente");
        estilo = new JMenu("Estilo");
        tamagno = new JMenu("Tamaño");

        configura_menu("Arial", "fuente", "Arial", 9, 10);
        configura_menu("Courier", "fuente", "Courier", 9, 10);
        configura_menu("Verdana", "fuente", "Verdana", 9, 10);

        JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita");
        JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva");
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        estilo.add(negrita);
        estilo.add(cursiva);

        ButtonGroup tamagno_letra = new ButtonGroup();
        JRadioButtonMenuItem n12 = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem n16 = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem n20 = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem n24 = new JRadioButtonMenuItem("24");
        n12.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 12));
        n16.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 16));
        n20.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 20));
        n24.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", 24));
        tamagno_letra.add(n12);
        tamagno_letra.add(n16);
        tamagno_letra.add(n20);
        tamagno_letra.add(n24);
        tamagno.add(n12);
        tamagno.add(n16);
        tamagno.add(n20);
        tamagno.add(n24);

        miBarra.add(fuente);
        miBarra.add(estilo);
        miBarra.add(tamagno);

        laminaMenu.add(miBarra);
        add(laminaMenu, BorderLayout.NORTH);
        add(miArea, BorderLayout.CENTER);
       
    }

    public void configura_menu(String rotulo, String menu, String tipo_letra, int estilos, int tam){
        JMenuItem elem_menu = new JMenuItem(rotulo);

        if(menu == "fuente"){
            fuente.add(elem_menu);
            if(tipo_letra == "Arial") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra", "Arial"));
            if(tipo_letra == "Courier") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra", "Courier"));
            if(tipo_letra == "Verdana") elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("cambia letra", "Verdana"));
        } 
    }
}