package DAM_2.psp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Lenguaje {
    public static void main(String[] args) {
        int longCaadena = 10;
        String miCadena;
        int numeroLineas;
        
        //Comprobamos si estamos recibiendo argumentos en la línea de comandos
        if (args.length == 1){
            numeroLineas = Integer.parseInt(args[0]);
            try{
                //Rediregimos salida y error estándar a un fichero
                PrintStream ps = new PrintStream(
                                new BufferedOutputStream(new FileOutputStream(
                                new File("javalog.txt"),true)), true);
                System.setOut(ps);
                System.setErr(ps);
            }catch(Exception e){
                System.err.println("Proceso con " + numeroLineas + " lineas. No he podido redirigir salidas.");
            } 
        } else {
            System.out.println("El numero de parametros pasado por argumento no es el correcto");
        }

        

        miCadena = cadenaAleatoria(longCaadena);

        
        System.out.println(miCadena);
    }


    
    public static String cadenaAleatoria(int longitudCadena) {
        String textoAleatorio="";
        String caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        
        for (int i = 0; i < longitudCadena; i++) {
            int aleatorio = (int)(Math.random()*caracteres.length());
            textoAleatorio = textoAleatorio + caracteres.charAt(aleatorio);
        }

        return textoAleatorio;
    }
}
