package DAM_1.Examen_EV1_DAM1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class examenEV1_parte1 {
    public static void main(String[] args) {

        //Apartado 1 -----------------------------------------------------------
        System.out.println("Apartado 1 -----------------------------------------");
        
        //1 --------------------------------------------------------------------
        System.out.println("\n1. Crea dos variables de tipo DRedIPv4 llamadas ip1 y ip2");
        DRedIPv4 ip1, ip2;
        
        //2 --------------------------------------------------------------------
        System.out.println("\n2. Usa el constructor por defecto para ip");
        ip1 = new DRedIPv4();
        
        //3 --------------------------------------------------------------------
        System.out.println("\n3. Asigna a ip2 usando el constructor con parámetros una IP de la red APIPA");
        //rango 169.254.0.1 a 169.254.255.254.
        //La máscara de subred se ajusta automáticamente a 255.255.0.0
        //la dirección del gateway se ajusta a 0.0.0.0.
        ip2 = new DRedIPv4(169, 254, 1, 1);
        
        //4 --------------------------------------------------------------------
        System.out.println("\n4. Muestra los 4 octetos de ip1");
        System.out.println("Octeto1: " + ip1.getOcteto1());
        System.out.println("Octeto1: " + ip1.getOcteto2());
        System.out.println("Octeto1: " + ip1.getOcteto3());
        System.out.println("Octeto1: " + ip1.getOcteto4());
        
        //5 --------------------------------------------------------------------
        System.out.println("\n5. Muestra la dirección ip1 con el formato IP/Máscara todo en decimal");
        System.out.println(ip1.getIPv4BinarioPuntos() + "/" + ip1.getMascaraBinario());
        
        //6 --------------------------------------------------------------------
        System.out.println("\n6. Muestra la dirección ip2 con el formato IP/Máscara todo en binario");
        System.out.println(ip2.getIPv4BinarioPuntos() + "/" + ip2.getMascaraBinario());
        
        //7 --------------------------------------------------------------------
        System.out.println("\n7. Muestra la clase de ip1 y ip2");
        System.out.println(ip1.toString() + " Clase: " + ip1.getClase());
        System.out.println(ip2.toString() + " Clase: " + ip2.getClase());
        
        //8 --------------------------------------------------------------------
        System.out.println("\n8. Actualiza los campos de ip1 para que sea también una IP de la Red APIPA");
        ip1.setOcteto1(169);
        ip1.setOcteto2(254);
        ip1.setOcteto3(1);
        ip1.setOcteto4(2);
        System.out.println(ip1.toString());
        
        //9 --------------------------------------------------------------------
        System.out.println("\n9. Muestra si están en la misma red ip1 y ip2");
        if(ip1.mismaRed(ip2)){
            System.out.println(ip1.toString() + " y " + ip2.toString() + " SI están en la misma red");
        }
        else{
            System.out.println(ip1.toString() + " y " + ip2.toString() + " NO están en la misma red");
        }
        
        //10 -------------------------------------------------------------------
        System.out.println("\n10. Muestra si 127.0.0.1 es una dirección de loopback");
        DRedIPv4 ip3 = new DRedIPv4();
        if(ip3.direccionLoopBack()){
            System.out.println(ip3.toString() + " SI es una dirección de loopback");
        }
        else{
            System.out.println(ip3.toString() + " NO es una dirección de loopback");
        }
        
        
        
        //Apartado 2 -----------------------------------------------------------
        System.out.println("\nApartado 2 --------------------------------------");
        DRedIPv4 ip4;
        String cad1, cad2 = "1";
        int oct1, oct2, oct3, oct4, n0 = 0, n1 = 0;
        
        Scanner teclado = new Scanner(System.in);
        
        try{
            System.out.print("Introduce el octeto1: ");
            oct1 = teclado.nextInt();

            System.out.print("Introduce el octeto2: ");
            oct2 =teclado.nextInt();

            System.out.print("Introduce el octeto3: ");
            oct3 = teclado.nextInt();

            System.out.print("Introduce el octeto4: ");
            oct4 = teclado.nextInt();
            
            ip4 = new DRedIPv4(oct1, oct2, oct3, oct4);
            System.out.println("ip original: " + ip4.toString());
            System.out.println("ip en binario con puntos: " + ip4.getIPv4BinarioPuntos());
            cad1 = ip4.getIPv4BinarioPuntos();
            cad1 = cad1.replaceAll("\\.", "");
            System.out.println("ip en binario sin puntos: " + cad1);
            
            for(int i=0; i< cad1.length(); i++){
                if(cad2.equals(cad1.substring(i, i +1))){
                    n1++;
                }
                else{
                    n0++;
                }
            }
            
            System.out.println("Número de 0s: " + n0 + " Número de 1s: " + n1);
            
        }catch(InputMismatchException e){
            System.out.println("Uno de los valores introducidos no es un valor entero");
            
        }catch(IllegalArgumentException e){
            System.out.println("alguno de los octetos introducidos no está en el rango [0,255]");
        }
        
    }//main
}//examenEV1
