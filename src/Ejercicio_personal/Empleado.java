package Ejercicio_personal;

import java.time.LocalDate;

public abstract class Empleado {
    
    private String dni;
    private String nombre;
    private String apellido;
    private int anioIngreso;

    protected Empleado(String dni, String nombre, String apellido, int anioIngreso) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioIngreso = anioIngreso;
    }

    public int atiguedadEnAnios() {
        int anioActual = LocalDate.now().getYear();
        return anioActual - anioIngreso;
    }

    public String nombreCompleto() {
        return nombre + " " + apellido;
    }

    public abstract double getSalario();

}
