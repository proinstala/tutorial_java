package tutorial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* En esta clase de ejemplo, se muestra como serializar un objeto y guardarlo en un archivo y como recuperarlo desde el archivo serializado.
 * 
 * Hay que implementar la interfaz Serializable en el objeto que se quiere serializar.
 * Esta clase no obliga a sobrescribir nigun metodo.
 * 
 * Para desarrollar este ejemplo, se ha creado una clase interna anidada llamada Persona que implementa la interfaz Serializable.
 * Esta definida despues de la clase SerializarObjeto.
 */

public class SerializarObjeto {

    public static void main(String[] args) {
        // Creación de un objeto Persona
        Persona persona = new Persona("Juan", 30);

        boolean crear_serializable = false;  //Variable para condicionar la ejecución del codigo que serializa y guarda el objeto.
        boolean leer_serializable = true;   //Variable para condicionar la ejecución del codigo que lee el archvio y recuprea el objeto.

        try {

            if(crear_serializable) {
                // Creamos un FileOutputStream para escribir el archivo donde se guardará el objeto serializado
                FileOutputStream archivoSalida = new FileOutputStream("persona.ser");

                // Creamos un ObjectOutputStream para escribir objetos en el FileOutputStream
                ObjectOutputStream objetoSalida = new ObjectOutputStream(archivoSalida);

                // Escribimos el objeto en el ObjectOutputStream, que lo serializa y lo guarda en el archivo
                objetoSalida.writeObject(persona);

                // Cerramos los flujos
                objetoSalida.close();
                archivoSalida.close();

                System.out.println("Objeto serializado y guardado en persona.ser.");
            }

            if(leer_serializable) {
                // Llamamos al método para deserializar y leer el archivo
                Persona persona_rescatada = leerArchivoSerializado("persona.ser");
                
                // Verificamos si se ha leído correctamente y mostramos los datos
                if (persona_rescatada != null) {
                    System.out.println("\nrecuperamos el objeto persona:");
                    System.out.println("Nombre: " + persona_rescatada.getNombre());
                    System.out.println("Edad: " + persona_rescatada.getEdad());
                } else {
                    System.out.println("No se pudo leer el archivo.");
                }
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//Fin main.


    // Método para deserializar y leer el archivo
    public static Persona leerArchivoSerializado(String nombreArchivo) {
        try {
            // Creamos un FileInputStream para leer el archivo
            FileInputStream archivoEntrada = new FileInputStream(nombreArchivo);

            // Creamos un ObjectInputStream para leer objetos desde el FileInputStream
            ObjectInputStream objetoEntrada = new ObjectInputStream(archivoEntrada);

            // Leemos el objeto desde el ObjectInputStream y lo deserializamos
            Persona persona = (Persona) objetoEntrada.readObject();

            // Cerramos los flujos
            objetoEntrada.close();
            archivoEntrada.close();

            return persona; // Devolvemos el objeto deserializado
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}//Fin SerializarObjeto.


//----------------------------------------------------------------------------------------------
// Clase Persona que implementa Serializable
class Persona implements Serializable {
    private String nombre;
    private int edad;

    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

