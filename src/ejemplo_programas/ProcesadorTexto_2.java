package ejemplo_programas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.event.*; //interfaz ActionListener
import java.awt.Font;

public class ProcesadorTexto_2 {
    public static void main(String[] args) {
        MarcoProcesador2 Marco1 = new MarcoProcesador2();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoProcesador2 extends JFrame{

    public MarcoProcesador2(){
        setBounds(500, 300, 550, 400);
        PanelProcesador2 Panel1 = new PanelProcesador2();
        add(Panel1);
        setVisible(true);
    }
}


class PanelProcesador2 extends JPanel{

    JTextPane miArea;
    JMenu fuente, estilo, tamagno;
    Font letras;

    public PanelProcesador2(){
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

        if(menu == "fuente") fuente.add(elem_menu);
        else if(menu == "estilo") estilo.add(elem_menu);
        else if(menu == "tamaño") tamagno.add(elem_menu);

        elem_menu.addActionListener(new GestionaEventos(rotulo, tipo_letra, estilos, tam));
    }

    private class GestionaEventos implements ActionListener{

        String tipo_texto, menu;
        int estilo_letra, tamagno_letra;

        public GestionaEventos(String elemento, String texto2, int estilo2, int tam_letra){
            menu = elemento;
            tipo_texto = texto2;
            estilo_letra = estilo2;
            tamagno_letra = tam_letra;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            letras = miArea.getFont();
            if(menu == "Arial" || menu == "Courier" || menu == "Verdana"){
                estilo_letra = letras.getStyle();
                tamagno_letra = letras.getSize();
            }
            else if(menu == "Cursiva" || menu == "Negrita"){
                if(letras.getStyle() == 1 || letras.getStyle() == 2) estilo_letra = 3;
                tipo_texto = letras.getFontName();
                tamagno_letra = letras.getSize();
            }
            else if(menu == "12" || menu == "16" || menu == "20"|| menu == "24"){
                estilo_letra = letras.getStyle();
                tipo_texto = letras.getFontName();
            }
            miArea.setFont(new Font(tipo_texto, estilo_letra, tamagno_letra));
            System.out.println("Tipo: " + tipo_texto + " Estilo: " + estilo_letra + " Tamaño: " + tamagno_letra);
            
        }
        
    }
}