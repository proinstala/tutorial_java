package entorno_grafico;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/*
- EVENTOS DE FOCO
- Interfaz WindowFocusListener (foco ventana)

*/

public class Evento9_Foco_objeto_ventana extends JFrame implements WindowFocusListener{
    
    public static void main(String[] args) {
        
        Evento9_Foco_objeto_ventana miVentana = new Evento9_Foco_objeto_ventana();
        miVentana.iniciar();
    }

    Evento9_Foco_objeto_ventana marco1;
    Evento9_Foco_objeto_ventana marco2;

    public void iniciar(){

        marco1 = new Evento9_Foco_objeto_ventana();
        marco2 = new Evento9_Foco_objeto_ventana();
        marco1.setVisible(true);
        marco2.setVisible(true);
        marco1.setBounds(300, 100, 600, 350);
        marco2.setBounds(1200, 100, 600, 350);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco1.addWindowFocusListener(this);
        marco2.addWindowFocusListener(this);

    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        if(e.getSource() == marco1){
            marco1.setTitle("Tengo el foco!!");
        }
        else{
            marco2.setTitle("Tengo el foco!!");
        }
        
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        if(e.getSource() == marco1){
            marco1.setTitle("");
        }
        else{
            marco2.setTitle("");
        }
        
    }
}
