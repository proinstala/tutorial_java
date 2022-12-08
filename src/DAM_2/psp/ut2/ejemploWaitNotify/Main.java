
package DAM_2.psp.ut2.ejemploWaitNotify;

public class Main {

    public static void main(String[] args) {
        
        Saludo s = new Saludo(); // Objeto en comun, se encarga del wait y notify
       
        /* Instancio los hilos y le paso como parametros:
         *
         * El Nombre del Hilo(en este caso es el nombre del empleado)
         * ----El objeto en comun (Saludo)----
         * Un booleano para verificar si es jefe o empleados
         *
        */       
        Empleado Empleado1 = new Empleado("Pepe", s, false);
        Empleado Empleado2 = new Empleado("José", s, false);
        Empleado Empleado3 = new Empleado("Pedro", s, false);
        Empleado Jefe1 = new Empleado("JEFE", s, true);
       
        //Lanzo los hilos       
        Empleado1.start();           
        Empleado2.start();           
        Empleado3.start();           
        Jefe1.start();
    }
    
}
