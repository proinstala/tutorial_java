package DAM_2.acceso_datos.TareaAD02_2_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class TareaAD02_2_1 {
    
    static final String SEPARADOR = System.getProperty("file.separator");// '/'
    static final String BASE = rutaBase();


    public static void main(String[] args) {
        
        System.out.println("TAREA AD02_2 PARTE 1");
        System.out.println("Ruta base: " + rutaBase());
        System.out.println("");
        
        ejemploFiles();
    }

    /**
     * funcion que obtiene la ruta donde esta ubicado el proyecto y cambia las 
     * barras separadoras segun el sistema operativo que se este usando.
     * 
     * @return String de la ruta base donde guardar los datos generados de este proyecto.
     */
    private static String rutaBase() {
        String ruta = System.getProperty("user.dir");
        ruta = ruta + SEPARADOR + "src\\DAM_2\\acceso_datos\\TareaAD02_2_1\\aux_tareaAD02_2_1" + SEPARADOR;
        String osName = System.getProperty("os.name");
        
        if (osName.toUpperCase().contains("WIN")){ //Windows
            ruta = ruta.replace("\\", "\\\\");
        }
        
        return ruta;
    }

    private static void ejemploFiles() {

        Path fich1 = Paths.get(BASE+"file1.txt");
        Path fich2 = Paths.get(BASE+"file2.txt");

        //Crea el fichero si o existe. si existe lanza una excepción. 
        try{
            Files.createFile(fich1);
        } catch(IOException e){
            System.err.println("No se ha podido crear el fichero " + fich1.getFileName());
        }

        //Comprueba si los ficheros existen.
        System.out.println("Existe el fichero 1? " + Files.exists(fich1));
        System.out.println("Existe el fichero 2? " + Files.exists(fich2));
        System.out.println(""); 

        System.out.println("Creación de un fichero file3.txt");
        Path fich3 = Paths.get(BASE+"file3.txt");
        
        try{
            Files.createFile(fich3);
        } catch(IOException e){
            System.err.println("-ERROR- No se ha podido crear el fichero " + fich3.getFileName());
        }

        //Creación de un directorio y dos ficheros dentro.
        System.out.println("Creación de un directorio y dos ficheros dentro");
        Path dir1 = Paths.get(BASE+"dir1");
        
        //crea el directorio dir1. si existe lanza una excepción. 
        try{
            Files.createDirectory(dir1);
        } catch(IOException e){
            System.err.println("-ERROR- No se ha podido crear el fichero " + dir1.getFileName());
        }

        //Crea el fichero file4.txt dentro del directorio dir1.
        Path fich4 = Paths.get(BASE+"dir1\\file4.txt");
        try{
            Files.createFile(fich4);
        } catch(IOException e){
            System.err.println("-ERROR- No se ha podido crear el fichero " + fich4.getFileName());
        }
        
        //Crea el fichero file5.txt dentro del directorio dir1.
        Path fich5 = Paths.get(BASE+"dir1\\file5.txt");
        try{
            Files.createFile(fich5);
        } catch(IOException e){
            System.err.println("-ERROR- No se ha podido crear el fichero " + fich5.getFileName());
        }

        //Indica si existen los archivos
        System.out.println("\nExistencia: ");
        System.out.println("fich1 " + Files.exists(fich1));
        System.out.println("fich1 " + Files.exists(dir1));
        
        //Indica si son directorios
        System.out.println("\n¿Son directorios?: ");
        System.out.println("fich1 " + Files.isDirectory(fich1));
        System.out.println("dir1 " + Files.isDirectory(dir1));

        //Indica si son ficheros
        System.out.println("\n¿Son ficheros?: ");
        System.out.println("fich1 " + Files.isRegularFile(fich1));
        System.out.println("dir1 " + Files.isRegularFile(dir1));
        
        //Indica la ruta absoluta del fichero o directorio
        System.out.println("\nRuta absoluta: ");
        System.out.println("fich1 " + fich1.toAbsolutePath());
        System.out.println("dir1 " + dir1.toAbsolutePath());
        
        //Indica si se puede leer
        System.out.println("\n¿Se pueden leer?:");
        System.out.println("fich1 " + Files.isReadable(fich1));
        System.out.println("dir1 " + Files.isReadable(dir1));
        
        //Indica si se puede escribir
        System.out.println("\n¿Se pueden escribir?:");
        System.out.println("fich1 " + Files.isWritable(fich1));
        System.out.println("dir1 " + Files.isWritable(dir1));
        
        //Indica si se puede ejecutar
        System.out.println("\n¿Se pueden ejecutar?:");
        System.out.println("fich1 " + Files.isExecutable(fich1));
        System.out.println("dir1 " + Files.isExecutable(dir1));

        
        //Indica el nombre sin rutas
        System.out.println("\nNombres sin rutas: ");
        System.out.println("fich1 " + fich1.getFileName());
        System.out.println("dir1 " + dir1.getFileName());
        
        //Indica el nombre del directorio padre
        System.out.println("\nNombre del directorio padre: ");
        System.out.println("fich1 " + fich1.getParent());
        System.out.println("dir1 " + dir1.getParent());

        //Guarda en un ArrayList de Path los directorios hijos, solo con directorios
        System.out.println("Ruta de los objetos Path dentro de un array");
        try {
            ArrayList<Path> listaPath1 = new ArrayList();
            Stream<Path> miStream = Files.list(dir1);
            miStream.forEach((s) -> listaPath1.add(s) );
            listaPath1.forEach(System.out::println);
            
        } catch (IOException e) {
            System.out.println("Error: " + e);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e);
        }

        //Guarda en un ArrayList de String los directorios hijos, solo con directorios
        System.out.println("\nNombre de los objetos Path dentro de un array");
        try{
            ArrayList<String> stringPath = new ArrayList();
            Files.list(dir1).forEach((f) -> stringPath.add(f.getFileName().toString()) );
            stringPath.forEach(System.out::println);
            
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }  catch (NullPointerException e) {
            System.out.println("Error: " + e);
        }
    }
}
