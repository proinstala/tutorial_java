package DAM_2.psp.UT6;

import java.io.IOException;
import java.util.logging.*;

public class EjemploLogger {
    public static void main(String[] args) {

        //Logger logger = Logger.getLogger("MyLog");
        Logger logger = Logger.getLogger("EjemploLogger");
        FileHandler fh;
    
        try {
          // Configuro el logger y establezco el formato
          fh = new FileHandler("EjemploLogger.log", true);
          logger.addHandler(fh);
          logger.setLevel(Level.ALL);
          SimpleFormatter formatter = new SimpleFormatter();
          fh.setFormatter(formatter);
    
          // Añado un mensaje al log   
          logger.log(Level.WARNING,"Mi primer log");
    
        } catch (SecurityException e) {
          e.printStackTrace() ;
        } catch (IOException e) {
          e.printStackTrace() ;
        }

    }
}

