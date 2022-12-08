package DAM_2.psp.ut2.ejemploWaitNotify;

public class Empleado extends Thread {

    String nombre;
    Saludo saludo;
    boolean esJefe;

    public Empleado(String nombre, Saludo salu, boolean esJefe) {
        this.nombre = nombre;
        this.saludo = salu;
        this.esJefe = esJefe;
    }

    @Override
    public void run() {
        System.out.println(nombre + " llegó.");
        //Verifico si es personal que esta es jefe o no
        if (esJefe) {
            saludo.saludoJefe(nombre);
        } else {
            saludo.saludoEmpleado(nombre);
        }

    }
}
