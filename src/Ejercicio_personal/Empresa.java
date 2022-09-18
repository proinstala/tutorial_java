package Ejercicio_personal;

import java.util.ArrayList;

public class Empresa {
    
    private ArrayList<Empleado> empleados;

    public Empresa() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        this.empleados.add(e);
    }

    public void mostrarSalarios(){
        for (Empleado empleado : empleados) {
            System.out.println(empleado.nombreCompleto() + "  salario: " + empleado.getSalario());   
        }
    }

    public Empleado empleadosConMasClientes() {
        int clientesCaptados = -1;
        int pos = -1;
        Empleado conMasClientes = null;
        for (Empleado e : empleados) {
            if (e.getClass() == EmpleadoAComision.class) {
                EmpleadoAComision emp = (EmpleadoAComision) e;
                if (clientesCaptados < emp.getCantidadClientesCaptados()) {
                    clientesCaptados = emp.getCantidadClientesCaptados();
                    conMasClientes = e;
                }
            }
        }
        return conMasClientes; //PENDIENTE
    }
}
