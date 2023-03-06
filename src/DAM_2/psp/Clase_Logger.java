package DAM_2.psp;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;
import java.util.logging.*;

/*
NIVELES DE SEGURIDAD:
    7 - SEVERE (Máxima)
    6 - WARNING
    5 - INFO
    4 - CONFIG
    3 - FINE
    2 - FINER
    1 - FINEST (Mínima)

 - Todos:   Level.ALL
 - Ninguno: Level.OFF
 
 Cuando se establece un nivel de seguridad al logger, los mensajes con nivel de 
 seguridad inferior no se registraran. 
 Para registrarlos todos, establecer nivel de seguridad del logger a ALL.

TIPOS DE FORMATO DE FICHEROS LOGGER:
    Formato texto simple (SimpleFormatterSimpleFormatter).
    Formato XML (XMLFormatterXMLFormatter).
 
 */


public class Clase_Logger {
    
    public static void main(String[] args) {
        //Buscar o crear el logger que queremos utilizar.
        Logger logger = Logger.getLogger("Log-Clase_logger");
        FileHandler fh;
        try {
            //Crear el fichero.
            //true: agrega la información al fichero. 
            //false: Remplaza la infomación en el fichero.
            fh = new FileHandler("Log-Clase_logger.log", true);

            //Asociar el log a un fichero log. 
            logger.addHandler(fh);

            //Establecer si queremos visualizar los mensajes de log por pantalla.
            logger.setUseParentHandlers(true);

            //Establecer el formato del fichero. 
            SimpleFormatter formatoTxt = new SimpleFormatter();
            //XMLFormatter formatoXml = new XMLFormatter();
            fh.setFormatter(formatoTxt);

            //Establezco el nivel de seguridad de las actividades que quiero registrar.
            logger.setLevel(Level.ALL);

            logger.log(Level.WARNING, "Primer log");
            logger.log(Level.INFO, "Hola mundo"); 



        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
