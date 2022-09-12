package entorno_grafico;

import java.awt.Frame;

import javax.swing.JFrame;



public class Ventana1 {
    public static void main(String[] args) {
        
        miMarco marco1 = new miMarco();
        marco1.setVisible(true); //ponemos la ventana visible
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cuando se cierra la ventana, cerramos el programa
        /*
        DO_NOTHING_ON_CLOSE (definido en WindowConstants): No hagas nada; requieren que el programa maneje la operación en el windowClosing método de un WindowListenerobjeto registrado .
        HIDE_ON_CLOSE (definido en WindowConstants): oculta automáticamente el marco después de invocar cualquier WindowListener objeto registrado .
        DISPOSE_ON_CLOSE (definido en WindowConstants): oculta y elimina automáticamente el marco después de invocar cualquier WindowListener objeto registrado .
        EXIT_ON_CLOSE (definido en WindowConstants): Salga de la aplicación utilizando el System exitmétodo. Use esto solo en aplicaciones.
        */
    }
}


class miMarco extends JFrame{
    
    public miMarco(){
        //setSize(500,300); //Tamaño de la ventana
        //setLocation(500, 300); //Posicion de la ventana
        setBounds(500, 300, 500, 300); // tamaño y posicion de la ventana (x, y, width, height)
        setResizable(false); //autorizacion para modificar el tamaño de la ventana
        setExtendedState(Frame.NORMAL); //metodo para dar estado incial a la ventana.(ventana completa, minimizada ...)
        /*
        - NORMAL = Indica que no se establecen bits de estado.
        ICONIFIED = minimazado
        MAXIMIZED_HORIZ = maximizado horizontal
        MAXIMIZED_VERT = maximizado vertical
        MAXIMIZED_BOTH = maximizado horizatal y vertical
        */
        setTitle("Mi ventana"); //Titulo de la ventana
    }
}