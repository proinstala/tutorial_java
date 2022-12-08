package DAM_1.Examen_EV1_DAM1_verano;

import java.util.InputMismatchException;
import java.util.Scanner;

public class examen_ev1_verano_eje1 {
    public static void main(String[] args) {
        
        //APARTADO 1 -------------------------------------------------------------------------

        // 1. Crea dos variables de tipo DRedIPv4 llamadas ip1 y ip2
        DRedIPv4 ip1;
        DRedIPv4 ip2;

        // 2. Usa el constructor por defecto para ip1.
        ip1 = new DRedIPv4();
        
        // 3. Asigna a ip2 usando el constructor con párametros una IP de la red APIPA.
        ip2 = new DRedIPv4(169, 254, 10, 1);

        // 4. Muestra los 4 octetos de ip1.
        System.out.println("Octeto1: " + ip1.getOcteto1());
        System.out.println("Octeto2: " + ip1.getOcteto2());
        System.out.println("Octeto3: " + ip1.getOcteto3());
        System.out.println("Octeto4: " + ip1.getOcteto4());

        // 5. Muestra la dirección ip1 con el formato IP/Máscara todo en decimal.
        System.out.println(ip1.toString() + "/" + ip1.getMascaraDecimal());

        // 6. Muestra la dirección ip2 con el formato IP/Máscara todo en binario.
        System.out.println(ip2.getIPv4BinarioPuntos() + "/" + ip2.getMascaraBinario());

        // 7. Muestra la clase de ip1 y ip2
        System.out.println(ip1.toString() + " Clase:" + ip1.getClase());
        System.out.println(ip2.toString() + " Clase:" + ip2.getClase());

        // 8. Actualiza los campos d ip1 para que sea también una IP de la Red APIPA
        ip1.setOcteto1(169);
        ip1.setOcteto2(254);
        ip1.setOcteto3(1);
        ip1.setOcteto4(2);
        System.out.println(ip1.toString());

        // 9. Muestra la si ip1 y ip2 estan en la misma red
        if(ip1.mismaRed(ip2)){
            System.out.println(ip1.toString() + " y " + ip2.toString() + " están en la misma red");
        }
        else{
            System.out.println(ip1.toString() + " y " + ip2.toString() + " NO están en la misma red");
        }

        // 10. Muestra si 127.0.0.1 es una dirección de Loopback
        DRedIPv4 ip3 = new DRedIPv4();
        if(ip3.direccionLoopBack()){
            System.out.println(ip3.toString() + " Es una dirección de loopback");
        }
        else{
            System.out.println(ip3.toString() + " NO es una dirección de loopback");
        }


        //APARTADO 2 -------------------------------------------------------------------------
        Scanner teclado = new Scanner(System.in);
        DRedIPv4 ip4;

        try {
            System.out.print("Introduce el octeto 1: ");
            int o1 = teclado.nextInt();

            System.out.print("Introduce el octeto 2: ");
            int o2 = teclado.nextInt();

            System.out.print("Introduce el octeto 3: ");
            int o3 = teclado.nextInt();

            System.out.print("Introduce el octeto 4: ");
            int o4 = teclado.nextInt();

            ip4 = new DRedIPv4(o1, o2, o3, o4);

            System.out.println("ip original: " + ip4.toString());
            System.out.println("ip en binario con puntos: " + ip4.getIPv4BinarioPuntos());
            System.out.println("ip en binario sin puntos: " + ip4.getIPv4BinarioPuntos().replaceAll("\\.", ""));

            String cad1 = ip4.getIPv4BinarioPuntos().replaceAll("\\.", "");
            int ceros = 0;
            int unos = 0;
            for (int i = 0; i < cad1.length(); i++) {
                if(cad1.charAt(i) == '0'){
                    ceros++;
                }
                else{
                    unos++;
                }
            }
            
            System.out.println("Numero de 0s: " + ceros + "    Número de 1s: " + unos);
            

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Uno de los valores introducidos no es un valor entero");
        }

    }//FIN MAIN
}//FIN CLASE
