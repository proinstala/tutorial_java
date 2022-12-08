package DAM_2.acceso_datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author Profesor
 */
public class AD01 {
 

    //static final String BASE = "f:\\AD\\";

    static final String SEPARADOR = System.getProperty("file.separator");// '/'
    static final String BASE = System.getProperty("user.dir") + SEPARADOR + "AD01" + SEPARADOR;
    
    

    private static void espera() {

        System.out.println("Pulsa una tecla para continuar");

        Scanner teclado = new Scanner(System.in);

        teclado.nextLine();

    }

    

    private static void ejemploFile() {

        File fich1 = new File(BASE+"file1.txt"); 
        File fich2 = new File(BASE+"file2.txt");      

        try{
            fich1.createNewFile();
        } catch(IOException ex){
            System.err.println("No se ha podido crear el fichero "+fich1.getName());
        }

        System.out.println("Existe el fichero 1? "+fich1.exists());
        System.out.println("Existe el fichero 2? "+fich2.exists());
        System.out.println(""); 

        System.out.println("Creación de un fichero file3.txt");
        File fich3 = new File(BASE+"file3.txt");
        
        try{
            fich3.createNewFile();
        } catch(IOException ex){
            System.out.println("No se ha podido crear el fichero" + fich3.getName());
        }

        System.out.println("Creación de un directorio y dos ficheros dentro");
        File dir1 = new File (BASE+"dir1");
        dir1.mkdir();


        File fich4 = new File(BASE+"dir1/fich4.txt");
        try {
            fich4.createNewFile();
        } catch(IOException ex){
            System.out.println("No se ha podido crear el fichero");
        }

        File fich5 = new File(BASE+"dir1/fich5.txt");
        try {
            fich5.createNewFile();
        } catch(IOException ex){
           System.out.println("No se ha podido crear el fichero");
        }

        //Indica si existen los archivos
        System.out.println("Existencia: ");
        System.out.println("fich1 "+fich1.exists());
        System.out.println("dir1 "+dir1.exists());

        //Indica si son directorios
        System.out.println("¿Son directorios?: ");
        System.out.println("fich1 "+fich1.isDirectory());
        System.out.println("dir1 "+dir1.isDirectory());
        System.out.println("");

        //Indica si son ficheros
        System.out.println("¿Son ficheros?: ");
        System.out.println("fich1 "+fich1.isFile());
        System.out.println("dir1 "+dir1.isFile());
        System.out.println("");

        //Indica la ruta absoluta del fichero o directorio
        System.out.println("Ruta absoluta: ");
        System.out.println("fich1 "+fich1.getAbsolutePath());
        System.out.println("dir1 "+dir1.getAbsolutePath());
        System.out.println("");

        //Indica si se puede leer
        System.out.println("¿Se pueden leer?:");
        System.out.println("fich1 "+fich1.canRead());
        System.out.println("dir1 "+dir1.canRead());
        System.out.println("");

        //Indica si se puede escribir
        System.out.println("¿Se pueden escribir?:");
        System.out.println("fich1 "+fich1.canWrite());
        System.out.println("dir1 "+dir1.canWrite());
        System.out.println("");

        //Indica si se puede ejecutar
        System.out.println("¿Se pueden ejecutar?:");
        System.out.println("fich1 "+fich1.canExecute());
        System.out.println("dir1 "+dir1.canExecute());
        System.out.println("");

        //Indica el nombre sin rutas
        System.out.println("Nombres sin rutas: ");
        System.out.println("fich1 "+fich1.getName());
        System.out.println("dir1 "+dir1.getName());
        System.out.println("");

        //Indica el nombre del directorio padre
        System.out.println("Nombre del directorio padre: ");
        System.out.println("fich1 "+fich1.getParent());
        System.out.println("dir1 "+dir1.getParent());
        System.out.println("");

        //Guarda en un array de File los directorios hijos, solo con directorios
        System.out.println("Nombre de los objetos File dentro de un array");
        File lista[]=dir1.listFiles();
        for (File f : lista) 
            System.out.println(f);
        System.out.println("");

        //Guarda en un array de String los directorios hijos, solo con directorios
        System.out.println("	\n" +
        "Devuelve un array de String con el nombre de los archivos "
        + "y directorios que contiene el directorio indicado en el objeto File.");

        String listaString[]=dir1.list();
        for(String nombre : listaString)
            System.out.println(nombre);
        System.out.println("");  
    }//ejemploFile

    /** FIN EJEMPLOFILE **/
    

    private static void ejemploEscrituraLectura() {
        String nombreFichero = BASE+"ejStream.txt";
        try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw = new FileWriter(nombreFichero);
            //Escribimos en el fichero un String y un caracter
            fw.write("PRUEBA ");
            fw.write(65); //A
            fw.write("\nescribo más");
            fw.flush();

            //Cierro el stream
            fw.close(); 

            //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader(nombreFichero);
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
            System.out.println("\n\n");

            //Cerramos el stream
            fr.close();
        }catch(IOException e){
            System.err.println("Error E/S: "+e);
        }

        try{
            //Abro stream, crea el fichero si no existe
            //el 2º parámetro con valor true hace que no se elimine el contenido del fichero, sino que se añada al final
            FileWriter fw=new FileWriter(nombreFichero, true);
            //Escribimos en el fichero un String y un caracter
            fw.write("\nQuiero escribir al final del archivo");    
            fw.flush();
            //Cierro el stream
            fw.close(); 

            //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader(nombreFichero);

            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }

            //Cerramos el stream
            fr.close();
            
            //Salto de línea
            System.out.println("");
            
        }catch(IOException e){
            System.err.println("Error E/S: "+e);
        }
    }//ejemploEscrituraLectura
 
    private static void leeFichero(String nombreFichero) throws FileNotFoundException {
        BufferedReader buffer = new BufferedReader(new FileReader(new File(nombreFichero)));         
        try {
            String linea;
            while ((linea = buffer.readLine()) != null)
                System.out.println(linea);
        } catch(IOException ioe)  {
            System.err.println();
        }
    }

    private static void ejemploFileWriter() {
        String nombreFichero = BASE+"fileWriter.txt";
       
        System.out.println("Creando el fichero");
        File f = new File(nombreFichero);
        System.out.println("Path: "+f.getAbsolutePath());

        try {
            if (f.createNewFile())
                System.out.println("El fichero se ha creado correctamente");
            else
                System.out.println("No ha podido ser creado el fichero");
       
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw) ;
            pw.println("Esto es una linea del fichero1");
            pw.println("Esto es una linea del fichero2");
            fw.close();
            System.out.println("LECTURA FICHERO");
            leeFichero(nombreFichero);
            System.out.println("FIN LECTURA FICHERO");         

            System.out.println("Después de cerrar el fichero, escribo, ¿se ha escrito?");
            pw.println("Esto es una linea del fichero3");
            System.out.println("LECTURA FICHERO");
            leeFichero(nombreFichero);
            System.out.println("FIN LECTURA FICHERO");          

            System.out.println("Vuelvo a crear los FileWriter y PrintWriter y escribo de nuevo. ¿Qué pasa?");
            fw = new FileWriter(f);
            pw = new PrintWriter(fw) ;
            pw.println("Esto es una linea del fichero4");
            fw.close();

            System.out.println("LECTURA FICHERO");
            leeFichero(nombreFichero);
            System.out.println("FIN LECTURA FICHERO");       

            System.out.println("Vuelvo a crear los FileWriter y PrintWriter y escribo de nuevo. ¿Qué pasa?");
            fw = new FileWriter(f, true);//append
            pw = new PrintWriter(fw) ;
            pw.println("Esto es una linea del fichero5");
            fw.close();

            System.out.println("LECTURA FICHERO");
            leeFichero(nombreFichero);
            System.out.println("FIN LECTURA FICHERO");   
        } catch(IOException ioe) {  }

    }    

         

   

    

    public static void main(String[] args) {    

        
       /* NUEVO - PROPIEDADES */
       
       /*System.out.println("La carpeta de mi usuario es: " + System.getProperty("user.home"));
       System.out.println("Separador en la ruta: " + System.getProperty("file.separator"));
       System.out.println("Ruta del usuario: " + System.getProperty("user.dir"));
       System.out.println("Carácter que separa las líneas de un fichero de texto: " 
               + "A" + System.getProperty("line.separator") + "B");*/
       
       
        ejemploFile();

        //ejemploEscrituraLectura();

        //ejemploFileWriter();

        

    }

}
