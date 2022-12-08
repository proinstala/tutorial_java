
package DAM_2.psp.tareaUT1.ejercicio_2;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * Programa que genera cadenas de texto aleatorias de 10 letras y las guarda en un archivo de texto.
 * El numero de cadenas de texto a generas se pasa como primer argumento.
 * El nombre del archivo donde se guardas las cadenas de texto se pasa como segundo argumento.
 * 
 * @author David Jimenez Alonso
 */
public class Lenguaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int longCaadena = 10;
        int numeroLineas = 0;
        String miCadena="";
        String rutaArchivo="";
        boolean correcto = false;
        
        if (args.length == 2){ //comprobamos si los argumentos pasados como parametros son correctos.
            try{
                numeroLineas = Integer.parseInt(args[0]);
                rutaArchivo = args[1];
                
                if (rutaArchivo.endsWith(".txt")) {
                    correcto= true;
                } else {
                    System.out.println("el segundo argumento pasado como parametro no es correcto");
                }
                
            } catch(NumberFormatException e){ //capturamos la excepcion si se introduce un dato no valido
                System.out.println("Error: solo se admiten numeros enteros en el primer argumento");
                System.err.println(e.getMessage());
            } catch(Exception e){
                System.out.println("ERROR: se ha producido un error.");
                System.out.println(e.getMessage());
            }
            
        } else {
            System.out.println("El numero de parametros pasado por argumento no es el correcto");
        }
        
        
        
        if(correcto) {
            for (int i = 0; i < numeroLineas; i++) {
            miCadena = cadenaAleatoria(longCaadena); //llama al metodo cadenaAleatoria y guardamos en miCadena la cadena devuelta. 
            
            //llamamos al metodo escribirArchivo para escribir los datos en el archivo
            escribirArchivo(rutaArchivo, miCadena); //pasamos por parametros la ruta del archivo y la cadena a escribir
            }
            
        }
        
    }//Fin main
    
    
    /**
     * metodo publico y estatico que genera una cadena de letras aleatorias.
     * la longitud de la cadena generada se pasa como parametro al metodo.
     * 
     * @param longitudCadena int que indica la longitud de la cadena
     * @return Un String de letras aleatorio del tamaño que se le indica por parametro
     */
    public static String cadenaAleatoria(int longitudCadena) {
        String textoAleatorio="";
        String caracteres = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        
        for (int i = 0; i < longitudCadena; i++) {
            int aleatorio = (int)(Math.random()*caracteres.length());
            textoAleatorio = textoAleatorio + caracteres.charAt(aleatorio);
        }

        return textoAleatorio;
    }
    
    
    
    /**
     * metodo publico y estatico que añade una nueva linea de texto a un archivo indicado.
     * 
     * @param nombreArchivo ruta del archivo en el que se va a escribir
     * @param dato cadena de texto que se va a escribir en el archivo
     */
    public static void escribirArchivo(String nombreArchivo, String dato){
        File archivo = new File(nombreArchivo); //creamos el objeto file con la ruta del archivo
        RandomAccessFile raf = null;
        FileLock bloqueo = null;
            try{
                raf = new RandomAccessFile(archivo,"rwd"); //Abrimos el fichero. si no existe, lo crea.
                //***************
                //Sección crítica
               
                //bloqueamos el canal de acceso al fichero.
                bloqueo = raf.getChannel().lock(); //Obtenemos el objeto que representa el bloqueo para después poder liberarlo.
                
                raf.seek(archivo.length()); //posiciona el cursor de inserción de datos al final del archivo
                if(archivo.length() > 0) {
                    raf.writeBytes("\n" + dato);
                } else {
                    raf.writeBytes(dato);
                }
               
                bloqueo.release(); //Liberamos el bloqueo del canal del fichero
                bloqueo = null;
                
                //Fin sección crítica
                //*******************
            } catch(Exception e) {
                System.err.println(e.toString());
            } finally {
                try {
                    if( null != raf ) raf.close();
                    if( null != bloqueo) bloqueo.release();
                } catch (Exception e2) {
                    System.err.println(e2.toString());
                    System.exit(1);  //Si hay error, finalizamos
                }
            }
        
    }//Fin metodo escribirArchivo.
    
}
