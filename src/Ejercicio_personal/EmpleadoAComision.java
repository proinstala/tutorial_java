package Ejercicio_personal;

public class EmpleadoAComision extends Empleado {
    
    private double salarioMinimo;
    private int cantidadClientesCaptados;
    private double montoPorCliente;

    public EmpleadoAComision(String dni, String nombre, String apellido, int anioIngreso, double salarioMinimo, int cantidadClientesCaptados, double montoPorCliente) {
        super(dni, nombre, apellido, anioIngreso);
        this.salarioMinimo = salarioMinimo;
        this.cantidadClientesCaptados = cantidadClientesCaptados;
        this.montoPorCliente = montoPorCliente;
    }


    public int getCantidadClientesCaptados() {
        return cantidadClientesCaptados;
    }

    @Override
    public double getSalario() {
        double salario = montoPorCliente * cantidadClientesCaptados;
        if (salario < salarioMinimo) {
            salario = salarioMinimo;
        }
        return salario;
    }
}
