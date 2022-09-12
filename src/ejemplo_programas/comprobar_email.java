package ejemplo_programas;

import javax.swing.JOptionPane;

public class comprobar_email {
    public static void main(String[] args) {
        
        int arroba = 0;
        float david = 7.5f;
        boolean punto = false;
        String email = JOptionPane.showInputDialog("Introduce E-mail");

        for(int i = 0; i < email.length(); i++){
            
            if(email.charAt(i) == '@') arroba++;
            if(email.charAt(i) == '.') punto = true;
        }
        david = david%5;
        if(arroba == 1 && punto == true){
            System.out.println("El E-mail es correcto");
        }
        else{
            System.out.println("El E-mail no es correcto");
        }
    }
}
