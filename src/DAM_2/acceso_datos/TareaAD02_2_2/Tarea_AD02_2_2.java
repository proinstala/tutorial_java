package DAM_2.acceso_datos.TareaAD02_2_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author David Jimenez Alonso
 */
public class Tarea_AD02_2_2 {

    static final String NEGRO_FONDO = "\u001B[40m";
    static final String ROJO_FONDO = "\u001B[41m";
    static final String SEPARADOR = System.getProperty("file.separator");// '/'
    static final String BASE = rutaBase();
    
    public static void main(String[] args) {
        
        int menu = 0;
        int inicio = 0;
        String[] datosAlumno = new String[5];
        String nombre;
        File inputFile;
        Document doc = null;
        
        Scanner teclado = new Scanner(System.in);
        
        do {
            try {
                // -----------------------------------------------------------------
                if (inicio == 0) {
                    inputFile = new File(BASE + "clase.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    doc = dBuilder.parse(inputFile);
                    doc.getDocumentElement().normalize();
                    
                    inicio++;
                }      
                // -----------------------------------------------------------------

                
                System.out.println("\nMenu de opciones: \n"
                        + "1. Mostrar el tipo del elemento Root \n"
                        + "2. Mostrar todos los elementos \"Alumno\" \n"
                        + "3. Añadir un nuevo elemento \"Alumno\" \n"
                        + "4. Guardar en un fichero toda la información del DOM \n"
                        + "5. Salir \n");

                System.out.print("Elige una opción: ");

                menu = teclado.nextInt();
                teclado.nextLine(); //para correjir error de entrada.

                switch (menu) {

                    //Mostrar el tipo del elemento Root.
                    case 1 -> {
                        System.out.println("\nHas elegido: Mostrar el tipo del elemento Root");
                        mostrarRoot(doc);
                    }

                    //Mostrar todos los elementos \"Alumno\" \n" 
                    case 2 -> {
                        System.out.println("\nHas elegido: Mostrar todos los elementos \"Alumno\"");
                        mostrarAlumnos(doc);
                    }

                    //Añadir un nuevo elemento \"Alumno\"
                    case 3 -> {
                        System.out.println("\nHas elegido: Añadir un nuevo elemento \"Alumno\"");
                        System.out.println("Inserta los datos del nuevo elemento");
                        System.out.print("Numero: ");
                        datosAlumno[0] = teclado.nextLine();
                        System.out.print("Nombre: ");
                        datosAlumno[1] = teclado.nextLine();
                        System.out.print("Apellido: ");
                        datosAlumno[2] = teclado.nextLine();
                        System.out.print("Apodo: ");
                        datosAlumno[3] = teclado.nextLine();
                        System.out.print("Marcas: ");
                        datosAlumno[4] = teclado.nextLine();
                       
                        nuevoElemento(doc, datosAlumno);
                        System.out.println("Creado nuevo Alumno.");
                    }

                    //Guardar en un fichero toda la información del DOM
                    case 4 -> {
                        System.out.println("\nHas elegido: Guardar en un fichero toda la información del DOM");
                        System.out.println("Nota: no hace falta poner la extensión al nombre insertado.");
                        System.out.print("Inseta el nombre para el nuevo archivo XML: ");
                        nombre = teclado.nextLine();
                        guardarDom(doc, nombre);
                        System.out.println("Información guardad.");
                    }

                    //Salir
                    case 5 -> {
                        System.out.println("\nHas elegido: Salir" + " Adios!!!!");
                    }

                    default ->
                        System.out.println("\nDeves introducir un valor entre 1 y 9\n");
                }

            } catch (InputMismatchException e){
                System.out.println("\n" + ROJO_FONDO + "-ERROR- El valor esperado no corresponde con el insertado" + NEGRO_FONDO + "\n");
                teclado.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            } catch (FileNotFoundException e) {
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            } catch (IOException e){
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            } catch (ParserConfigurationException e){
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            } catch (TransformerConfigurationException e) {
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            } catch (TransformerException e) {
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            } catch (Exception e) {
                System.out.println("\n" + ROJO_FONDO + "-ERROR- ha ocurrido un error: " + e + NEGRO_FONDO + "\n");
            }

        } while (menu != 5);

    }//Main
    
    
    /**
     * funcion que obtiene la ruta donde esta ubicado el proyecto y cambia las 
     * barras separadoras segun el sistema operativo que se este usando.
     * 
     * @return String de la ruta base donde guardar los datos generados de este proyecto.
     */
    private static String rutaBase() {
        String ruta = System.getProperty("user.dir");
        ruta = ruta + SEPARADOR + "src\\DAM_2\\acceso_datos\\TareaAD02_2_2" + SEPARADOR;
        String osName = System.getProperty("os.name");
        
        if (osName.toUpperCase().contains("WIN")){ //Windows
            ruta = ruta.replace("\\", "\\\\");
        }
        
        return ruta;
    }
    
    
    /**
     * Muestra el elemento Root del DOM.
     * 
     * @param doc objeto que representa al DOM.
     */
    private static void mostrarRoot(Document doc) {
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
    }
    
    
    /**
     * Muestra la información que tenemos en el DOM.
     * 
     * @param doc objeto que representa al DOM.
     */
    private static void mostrarAlumnos(Document doc) {
        NodeList nList = doc.getElementsByTagName("alumno");
        System.out.print("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("numero de alumno : " + eElement.getAttribute("numero"));
                System.out.println("nombre : " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("apellido :" + eElement.getElementsByTagName("apellido").item(0).getTextContent());
                System.out.println("apodo : " + eElement.getElementsByTagName("apodo").item(0).getTextContent());
                System.out.println("marcas : " + eElement.getElementsByTagName("marcas").item(0).getTextContent());
            }

        }
    }
    
    
    /**
     * Crea un nuevo elemento y sus elementos hijos con todos sus atributos.
     * 
     * @param doc   objeto que representa al DOM.
     * @param datos Información para la creación del elemento alumno.
     */
    private static void nuevoElemento(Document doc, String[] datos) {
        Element raiz = doc.getDocumentElement();

        //Elemento Alumno
        Element nuevoAlumno = doc.createElement("alumno");
        raiz.appendChild(nuevoAlumno);

        //Atributo número
        Attr numero = doc.createAttribute("numero");
        numero.setValue(datos[0]);
        nuevoAlumno.setAttributeNode(numero);

        //Nombre
        Element nombre = doc.createElement("nombre");
        nombre.setTextContent(datos[1]);
        nuevoAlumno.appendChild(nombre);

        //Apellido
        Element apellido = doc.createElement("apellido");
        apellido.setTextContent(datos[2]);
        nuevoAlumno.appendChild(apellido);

        //Apodo
        Element apodo = doc.createElement("apodo");
        apodo.setTextContent(datos[3]);
        nuevoAlumno.appendChild(apodo);

        //Marcas
        Element marcas = doc.createElement("marcas");
        marcas.setTextContent(datos[4]);
        nuevoAlumno.appendChild(marcas);
    }
    
    
    /**
     * Guarda la informacion del DOM en un archivo XML.
     * 
     * 
     * @param doc objeto que representa al DOM.
     * @throws TransformerConfigurationException
     * @throws TransformerException 
     */
    private static void guardarDom(Document doc, String nombre) throws TransformerConfigurationException, TransformerException {
        File outputFile = new File(BASE + nombre + ".xml");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(outputFile);
        transformer.transform(source, result);
    }
    
}//Clase
