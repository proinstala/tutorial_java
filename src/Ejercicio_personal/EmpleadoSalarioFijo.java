package Ejercicio_personal;

public class EmpleadoSalarioFijo extends Empleado {
    
    private static final double PORC_1 = 0.05;
    private static final double PORC_2 = 0.1;
    private static final int TRAMO_1 = 2;
    private static final int TRAMO_2 = 5;
    private double sueldoBasico;

    public EmpleadoSalarioFijo(String dni, String nombre, String apellido, int anioIngreso, double sueldoBasico) {
        super(dni, nombre, apellido, anioIngreso);
        this.sueldoBasico = sueldoBasico;
    }


    private double porcAdicional() {
        int antiguedad = atiguedadEnAnios();
        double procentaje = 0;
        if (antiguedad > TRAMO_2) {
            procentaje = PORC_2;
        } else if (antiguedad >= TRAMO_1) {
            procentaje = PORC_1;
        }

        return procentaje;
    }

    @Override
    public double getSalario() {
        return sueldoBasico + sueldoBasico * porcAdicional();
    }
}
