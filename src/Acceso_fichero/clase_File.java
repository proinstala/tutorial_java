package Acceso_fichero;

import java.io.File;
import java.io.IOException;


/*
La clase File se usa para obtener información sobre archivos y directorios.
Además la clase File permite crear y eliminar archivos y directorios.
Un objeto de la clase Java File representa un archivo o directorio.

CONSTRUCTORES.
La clase proporciona los siguientes constructores para crear objetos File:
    public File(String nombreFichero|path);
    public File(String path, String nombreFichero|path);
    public File(File path, String nombreFichero|path); 



ENLACE A TUTORIAL:
http://puntocomnoesunlenguaje.blogspot.com/2013/05/clase-file-java.html

ENLACE A API JAVA 14:
https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/File.html

*/


public class clase_File {
    
    public static void main(String[] args) {
        
        File f = new File("tutorial_java\\src\\Acceso_fichero\\pildoras.txt");
        File ruta2 = new File("tutorial_java\\src\\Acceso_fichero");

        System.out.println("nombre del archivo: " + f.getName());               //Devuelve el nombre del fichero o directorio.
        System.out.println("ruta del archivo: " + f.getAbsolutePath());         //Devuelve la ruta absoluta asociada al objeto File.
        try {
            System.out.println("ruta del archivo: " + f.getCanonicalPath());    //DEvuelve la ruta canonica asociada al objeto File.
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("existe el archivo?: " + f.exists());                //Devuelve true si el fichero o directorio existe.
        System.out.println("se puede leer el archivo?: " + f.canRead());        //Devuelve true si se puede leer el fichero
        System.out.println("se puede escribir en el archivo?: " + f.canWrite());//Devuelve true si se puede escribir en el fichero
        System.out.println("tamaño del archivo: " + f.length() + " bytes.");    //Devuelve el tamaño en bytes del fichero.
        System.out.println("es un directorio: " + f.isDirectory());             //devuelve true si es un directorio
        System.out.println("es un archivo: " + f.isFile());                     //devuelve true si es un archivo

        //createNewFile()   //Crea el fichero asociado al objeto File. Devuelve true si se ha podido crear. Para poder crearlo el fichero no debe existir. Lanza una excepción del tipo IOException.
        
        //si ejecutamos la siguiente lienea crea una carpeta en el directorio especificado en la ruta.
        //System.out.println(ruta1.mkdir()); //devuelve true si ha podido crearlo.

        String [] dir = ruta2.list();   //creamos un array de String con el nombre de los archivos en la ruta especificada.
        System.out.println("\nvemos lo que hay dentro del directorio " + ruta2.getName() + ":");
        for (String s : dir) {
            System.out.println(s);
        }


        File [] dirFile = ruta2.listFiles(); //creamos un array de File con las rutas de los archivos en la ruta especificada.
        System.out.println("\nvemos las rutas de los archivos que hay dentro del directorio " + ruta2.getName() + ":");
        for (File file : dirFile) {
            System.out.println(file.getAbsolutePath());
        }

    }//Fin main
    
}
