package ejemplo_programas;

import javax.swing.*;

public class acceso_clave {
    public static void main(String[] args) {
        
        String clave = "david";
        String clave_introducida = "";

        while(clave.equals(clave_introducida) == false){
            clave_introducida = JOptionPane.showInputDialog("Introduce contraseña");
            if(clave.equals(clave_introducida) == false){
                System.out.println("Contraseña incorrecta");
            }
            else {
                System.out.println("Contraseña correcta");
            }
        }
    }
}
