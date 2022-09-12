package ejemplo_programas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;
import java.awt.event.*; //interfaz ActionListener
import java.awt.Font;

/*
 - DESCRIPCION DE PROGRAMA:
    Este programa de ejemplo edita el formato de texto que se encuentra dentro del area de texto al seleccionar cualquier opcion del la barra de menus.
    Hay un marco principal (Marco1) y una panel principal (Panel1) con disposicion BorderLayout. El panel principal contiene dos paneles, PanelMenu que 
    se encuentra en la zona NORTE y PanelScroll1 que se encuentra en la zona CENTRO.
    El panel PanelMenu contiene la barra de menu (Barra1). La barra de menu esta organizada en tres campos, fuente, estilo y tamano.
    El panel PanelScroll1 es de tipo JScrollPane y contiene el objeto Areatext que es de tipo JTextArea. Cuando el texto se desborda por la parte vertical
    aparece una barra de desplazamiento.

*/

public class ProcesadorTexto {
    public static void main(String[] args) {
        MarcoProcesador1 Marco1 = new MarcoProcesador1();
        Marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoProcesador1 extends JFrame{

    public MarcoProcesador1(){
        setBounds(500, 300, 550, 400);
        PanelProcesador1 Panel1 = new PanelProcesador1();
        add(Panel1);
        setVisible(true);
    }
}


class PanelProcesador1 extends JPanel{

    private JTextArea Areatext;
    private JMenuItem arial, courier, verdana, negrita, plana, cursiva, t12, t16, t18, t20;
    private int tipo = 0;
    private int auxSize = 12;
    private String auxFuente = "Arial";

    public PanelProcesador1(){
        setLayout(new BorderLayout());
        
        JPanel PanelMenu = new JPanel();    //Creamos el Panel que va a contener la barra de menu
        JMenuBar Barra1 = new JMenuBar();   //Creamos la barra de menus (Barra1)
        JMenu fuente = new JMenu("Fuente"); //Creamos el campo fuentes 
        JMenu estilo = new JMenu("Estilo"); //Creamos el campo estilo
        JMenu tamano = new JMenu("Tamaño"); //Creamos el campo tamaño

        arial = new JMenuItem("Arial");     //Creamos el item arial
        courier = new JMenuItem("Courier"); //Creamos el item courier
        verdana = new JMenuItem("Verdana"); //Creamos el item verdana
        plana = new JMenuItem("Plana");     //Creamos el item negrita
        negrita = new JMenuItem("Negrita"); //Creamos el item negrita
        cursiva = new JMenuItem("Cursiva"); //Creamos el item cursiva
        t12 = new JMenuItem("12");          //Creamos el item t12
        t16 = new JMenuItem("16");          //Creamos el item t16
        t18 = new JMenuItem("18");          //Creamos el item t18
        t20 = new JMenuItem("20");          //Creamos el item t20

        fuente.add(arial);      //agregamos el item arial al campo fuente de la barra de menu
        fuente.add(courier);    //agregamos el item courier al campo fuente de la barra de menu
        fuente.add(verdana);    //agregamos el item verdana al campo fuente de la barra de menu
        estilo.add(plana);      //agregamos el item plana al campo estilo de la barra de menu
        estilo.add(negrita);    //agregamos el item negrita al campo estilo de la barra de menu
        estilo.add(cursiva);    //agregamos el item cursiva al campo estilo de la barra de menu
        tamano.add(t12);        //agregamos el item t12 al campo tamano de la barra de menu
        tamano.add(t16);        //agregamos el item t16 al campo tamano de la barra de menu
        tamano.add(t18);        //agregamos el item t18 al campo tamano de la barra de menu
        tamano.add(t20);        //agregamos el item t20 al campo tamano de la barra de menu

        Barra1.add(fuente);     //añadimos el campo fuente a la barra
        Barra1.add(estilo);     //añadimos el campo estilo a la barra
        Barra1.add(tamano);     //añadimos el campo tamaño a la barra
        PanelMenu.add(Barra1);  //añadimos la barra al panel

        Areatext = new JTextArea(8, 10); //Creamos el objeto Areatext de tipo JTestArea. Es el area de texto.
        JScrollPane PanelScroll1 = new JScrollPane(Areatext); //creamos un Panel con barras de scroll y añadimos el objeto AreaText a ese panel
        Areatext.setLineWrap(true); //Configuramos el objeto Areatext para que no se expanda a lo ancho.

        GestionTexto1 gTexto1 = new GestionTexto1(); //intanciamos la clase GestionTexto que se encarga de escuchar y gestionar las acciones de los items.
        arial.addActionListener(gTexto1);   //ponemos a la escucha del item arial el objeto gTexto1
        courier.addActionListener(gTexto1);
        verdana.addActionListener(gTexto1);
        plana.addActionListener(gTexto1);
        negrita.addActionListener(gTexto1);
        cursiva.addActionListener(gTexto1);
        t12.addActionListener(gTexto1);
        t16.addActionListener(gTexto1);
        t18.addActionListener(gTexto1);
        t20.addActionListener(gTexto1); 

        add(PanelMenu, BorderLayout.NORTH);     //Añadimos el PanelMenu al panel principal en la zona norte.
        add(PanelScroll1, BorderLayout.CENTER); //Añadimos el PanelScroll1 al panel principal en la zona centro.
    }

    private class GestionTexto1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object cambioSelec = e.getSource(); //Guardamos en el objeto cambioSelec el objeto que a disparado la acción.
            if(cambioSelec == plana){
                tipo = 0;
            }
            else if(cambioSelec == negrita){
                if(tipo == 1 || tipo == 3) tipo--;
                else tipo += Font.BOLD; //sumamos 1 a la variable tipo  
            }
            else if(cambioSelec == cursiva){
                if(tipo == 2 || tipo == 3) tipo -=2;
                else tipo += Font.ITALIC; //sumamos 2 a la variable tipo
            }

            if(cambioSelec == arial) auxFuente = "Arial";       
            if(cambioSelec == courier) auxFuente = "Courier";
            if(cambioSelec == verdana) auxFuente = "Verdana";
   
            if(cambioSelec == t12) auxSize = 12;
            if(cambioSelec == t16) auxSize = 16;
            if(cambioSelec == t18) auxSize = 18;
            if(cambioSelec == t20) auxSize = 20;

            Areatext.setFont(new Font(auxFuente, tipo, auxSize)); //Le damos formato al texto que se encuentra en AreaText. argumentos(fuente, estilo, tamaño)
        }
        
    }
}


