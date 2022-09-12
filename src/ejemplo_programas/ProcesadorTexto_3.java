package ejemplo_programas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.text.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class ProcesadorTexto_3 {
    public static void main(String[] args) {
        MarcoProcesador3 Marco1 = new MarcoProcesador3();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoProcesador3 extends JFrame{

    public MarcoProcesador3(){
        setBounds(500, 300, 550, 400);
        PanelProcesador3 Panel1 = new PanelProcesador3();
        add(Panel1);
        setVisible(true);
    }
}


class PanelProcesador3 extends JPanel{

    JTextPane miArea;
    JMenu fuente, estilo, tamagno;
    Font letras;

    public PanelProcesador3(){
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

        configura_menu("Negrita", "estilo", "", Font.BOLD, 1);
        configura_menu("Cursiva", "estilo", "", Font.ITALIC, 1);

        configura_menu("12", "tamaño", "", 9, 12);
        configura_menu("16", "tamaño", "", 9, 16);
        configura_menu("20", "tamaño", "", 9, 20);
        configura_menu("24", "tamaño", "", 9, 24);
        

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
        else if(menu == "estilo"){
            estilo.add(elem_menu);
            if(estilos == Font.BOLD) elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            else if(estilos == Font.ITALIC) elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
        } 
        else if(menu == "tamaño"){
            tamagno.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("cambia tamaño", tam)); //pasamos como argumento un nombre para la accion y el tamaño de la fuente que queremos poner
        }
    }
}