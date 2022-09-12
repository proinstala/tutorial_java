package tutorial;
import javax.swing.*;

public class ventana_emergente {
    public static void main(String[] args) {
        /*
        - Introducir datos por ventana emergente.
        - Usamos la clase JOptionPane del paquete javax.swing. devuelve un string
        - El metodo JoptionPane.showInputDialog() es estatico. No necesita construir un objeto para su uso.
        */

        String nombre_usuario = JOptionPane.showInputDialog("Introduce tu nombre");

        String edad = JOptionPane.showInputDialog("introduce la edad: ");

        System.out.println("nombre: " + nombre_usuario);
        System.out.println("edad: " + edad);
        
    }
    
}
