package Ejercicio_personal;

public class Principal {
    
    public static void main(String[] args) {
        
        Empresa empresa = new Empresa();

        empresa.agregarEmpleado(new EmpleadoSalarioFijo("123", "Ana", "López", 2021, 45000));
        empresa.agregarEmpleado(new EmpleadoAComision("123", "Pepe", "Gómez", 2021, 30000, 100, 500));
        empresa.agregarEmpleado(new EmpleadoSalarioFijo("123", "Luis", "Gámez", 2019, 50000));
        empresa.agregarEmpleado(new EmpleadoAComision("123", "Leo", "Torres", 2017, 30000, 200, 100));
        empresa.agregarEmpleado(new EmpleadoSalarioFijo("123", "María", "Pérez", 2014, 100000));

        empresa.mostrarSalarios();

        System.out.println(empresa.empleadosConMasClientes().nombreCompleto());
    }
}
