
package DAM_1.Examen_EV1_DAM1;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author David jimenez
 */
public class Jimenez_alonso_david_eje1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("APARTADO 1 -------------------------");

        //APARTADO 1 ---------------------------------------------
        DRedIPv4 ip1, ip2; // = new DRedIPv4();

        //APARTADO 2 ---------------------------------------------
        ip1 = new DRedIPv4();

        //APARTADO 3 ---------------------------------------------
        ip2 = new DRedIPv4(169,254,10,20);

        //APARTADO 4 ---------------------------------------------
        System.out.println("Octeto1: " + ip1.getOcteto1());
        System.out.println("Octeto2: " + ip1.getOcteto2());
        System.out.println("Octeto3: " + ip1.getOcteto3());
        System.out.println("Octeto4: " + ip1.getOcteto4());

        //APARTADO 5 ---------------------------------------------
        System.out.println(ip1.toString() + "/" + ip1.getMascaraDecimal());

        //APARTADO 6 ---------------------------------------------
        System.out.println(ip2.getIPv4BinarioPuntos() + "/" + ip2.getMascaraBinario());

        //APARTADO 7 ---------------------------------------------
        System.out.println(ip1.toString() + " Clase:" + ip1.getClase());
        System.out.println(ip2.toString() + " Clase:" + ip2.getClase());

        //APARTADO 8 ---------------------------------------------
        ip1.setOcteto1(169);
        ip1.setOcteto2(254);
        ip1.setOcteto3(10);
        ip1.setOcteto4(21);
        
        
        //APARTADO 9 ---------------------------------------------
        if(ip1.mismaRed(ip2)) System.out.println(ip1.toString() + " y " + ip2.toString() + " están en la misma red");
        else System.out.println(ip1.toString() + " y " + ip2.toString() + " no están en la misma red");

        //APARTADO 10 ---------------------------------------------
        DRedIPv4 ip3 = new DRedIPv4();

        if(ip3.direccionLoopBack()){System.out.println(ip3.toString() + " es una direccion de loopback");}
        else{System.out.println(ip3.toString() + " no es una direccion de loopback");}


        System.out.println("APARTADO 2 -------------------------");
        
        DRedIPv4 ip4;
        Scanner teclado = new Scanner(System.in);
        String cad1, cad2;
        int oc1 = 0, oc2 = 0, oc3 = 0, oc4 = 0;

        try{
            System.out.println("introduce el octeto1");
            oc1 = teclado.nextInt();

            System.out.println("introduce el octeto2");
            oc2 = teclado.nextInt();

            System.out.println("introduce el octeto3");
            oc3 = teclado.nextInt();

            System.out.println("introduce el octeto4");
            oc4 = teclado.nextInt();
        

        }catch(InputMismatchException e){
            System.out.println("uno de los valores introducidos no es un valor entero");
        }

        try{
            ip4 = new DRedIPv4(oc1, oc2, oc3, oc4);
            System.out.println("ip original:" + ip4.toString());
            System.out.println("ip en binario con puntos: " + ip4.getIPv4BinarioPuntos());
            cad1 = ip4.getIPv4BinarioPuntos();
            cad1 = cad1.replaceAll("\\.", "");
            System.out.println("ip en binario sin puntos: " + cad1);
        }catch(IllegalArgumentException e){
            System.out.println("alguno de los octetos introducidos no está en el rango [0,255]");
        }
    }
    
}
