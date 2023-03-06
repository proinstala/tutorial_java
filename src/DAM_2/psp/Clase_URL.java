package DAM_2.psp;

import java.net.MalformedURLException;
import java.net.URL;

/* NOTA:
Las URLs son objetos de una sola escritura. 
Lo que significa, que una vez que has creado un objeto URL no se puede cambiar ninguno de sus atributos 
(protocolo, nombre del host, nombre del fichero ni número de puerto).
 */

/* MalformedURLException:
 Cada uno de los constructores de URL puede lanzar una MalformedURLException si los argumentos del constructor son nulos o el protocolo es desconocido. 
 Lo normal, es capturar y manejar esta excepción mediante un bloque try- catch.
 */

/* Metodos:
 - getProtocol(). Obtiene el protocolo de la URL.
 - getHost(). Obtiene el host de la URL.
 - getPort(). Obtiene el puerto de la URL, si no se ha especificado obtiene -1. 
 - getDefaultPort(). Obtiene el puerto por defecto asociado a la URL, si no lo tiene obtiene -1.
 - getFile(). Obtiene el fichero de la URL o una cadena vacía si no existe.
 - getRef(). Obtiene la referencia de la URL o null si no la tiene.
 */

public class Clase_URL {
    public static void main(String[] args) {
        
        try {
            System.out.println("-- EJEMPLO USO METODOS URL -------------------- ");
            URL direccion = new URL("http://localhost/");
            System.out.println("protocolo: " + direccion.getProtocol());
            System.out.println("Host: " + direccion.getHost()); 
            System.out.println("puerto: " + direccion.getPort());
            System.out.println("puerto por defecto: " + direccion.getDefaultPort());
            System.out.println("file: " + direccion.getFile());
            System.out.println("referencia: " + direccion.getRef());
            System.out.println("path: " + direccion.getPath());
            System.out.println("UserInfo: " + direccion.getUserInfo());
            
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        
    }
}
