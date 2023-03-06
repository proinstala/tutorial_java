package tutorial;

import java.io.File;

/* Propiedades del sistema
 
- La clase System tiene dos métodos para leer las propiedades del sistema: getPropertyy getProperties.
- tiene dos versiones diferentes de getProperty. Ambos recuperan el valor de la propiedad nombrada en la lista de argumentos. 
- El más simple de los dos getPropertymétodos toma un solo argumento, una clave de propiedad

 */

public class Propiedades_System {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.separator"));   //Carácter que separa los componentes de una ruta de archivo. Esto es " /" en UNIX y " \" en Windows.
        System.out.println(System.getProperty("java.class.path"));  //Ruta utilizada para encontrar directorios y archivos JAR que contienen archivos de clase. Los elementos de la vía de acceso de clases están separados por un carácter específico de la plataforma especificado en la path.separatorpropiedad.
        System.out.println(System.getProperty("java.home"));        //Directorio de instalación para Java Runtime Environment (JRE)
        System.out.println(System.getProperty("java.vendor"));      //Nombre del proveedor de JRE
        System.out.println(System.getProperty("java.vendor.url"));  //URL del proveedor de JRE
        System.out.println(System.getProperty("java.version"));     //Número de versión JRE
        
        //Salto de linea
        System.out.println(System.getProperty("line.separator"));   //Secuencia utilizada por el sistema operativo para separar líneas en archivos de texto
        System.out.println(System.getProperty("os.arch"));          //Arquitectura del sistema operativo
        System.out.println(System.getProperty("os.name"));          //Nombre del sistema operativo
        System.out.println(System.getProperty("os.version"));       //Versión del sistema operativo
        System.out.println(System.getProperty("path.separator"));   //Carácter separador de ruta utilizado enjava.class.path
        System.out.println(System.getProperty("user.dir"));         //Directorio de trabajo del usuario
        System.out.println(System.getProperty("user.home"));        //"user.home"
        System.out.println(System.getProperty("user.name"));        //"user.name"
        
    }

    //metodo para cambiar el separador segun sistema.
    static String separadorSistema(String ruta) {
        String separador = "\\"; //Expresion
        try {
            
            if(File.separator.equals(separador)) { //Si estamos usando windows
                separador= "/";
                //Remplaza todas las cadenas que coinciden con la expresion 
                ruta.replaceAll(separador, File.separator);
            }
        } catch (Exception e) {
            //por si ocurre una java.util.regex.PatternSyntaxException.
            return ruta.replaceAll(separador + separador, File.separator);
        }
        return ruta;
    }
}
