package DAM_2.psp.ut2.ejemploWaitNotify;

public class Saludo {
    
    private boolean haLlegadoJefe;

    public Saludo() {
        this.haLlegadoJefe  = false;
    }

    /* Si no es jefe, el empleado va a quedar esperando a que llegue el jefe
    Se hace wait de el hilo que esta corriendo y se bloquea, hasta que
    se le avise que ya puede saludar*/
    public synchronized void saludoEmpleado(String nombre) {
        try {
            if (!this.haLlegadoJefe) {
                wait();
                System.out.println("\n" + nombre.toUpperCase() + "-: Buenos días jefe.");
            } else {
                System.out.println("\n" + nombre.toUpperCase() + "-: Disculpe el retraso");
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Si es jefe, saluda y luego avisa a los empleados para que saluden
    // El notifyAll despierta a todos los hilos que esten bloqueados
    public synchronized void saludoJefe(String nombre) {
        System.out.println("\n****** " + nombre + "-: Buenos días empleados. ******");
        this.haLlegadoJefe = true;
        notifyAll();
    }
}
