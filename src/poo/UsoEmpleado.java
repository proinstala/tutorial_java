package poo;

import java.util.*;

//Programa con clases incorporadas en este fichero.

public class UsoEmpleado {
    public static void main(String[] args) {
        /*
        - bucle for
        - bucle for each
        - sobrecarga constructor
        - metodo getter 
        - metodo setter
        - metodo getter final
        - clase final
        - polimorfismo
        - sobreescritura de metodo
        - refundicion o casting
        - Uso del metodo Arrays.sort() que obliga a implementar la interfaz Comparable 
        - Uso de interfaz Comparable
        - Uso de interfaza propia I_Jefes
        */


        /*
        //FORMA 1 --------------------------------------------------------------------
        Empleado empleado1 = new Empleado("David Jimenez", 85000, 1990, 12, 17);
        Empleado empleado2 = new Empleado("Ana López", 95000, 1995, 06, 02);
        Empleado empleado3 = new Empleado("Maria Martín", 105000, 2002, 03, 15);

        empleado1.setSubeSueldo(5);
        empleado2.setSubeSueldo(5);
        empleado3.setSubeSueldo(5);

        System.out.println("Nombre: " + empleado1.getNombre() + " Sueldo: " + empleado1.getSueldo()
        + " Fecha de alta: " + empleado1.getFechaContrato());

        System.out.println("Nombre: " + empleado2.getNombre() + " Sueldo: " + empleado2.getSueldo()
        + " Fecha de alta: " + empleado2.getFechaContrato());

        System.out.println("Nombre: " + empleado3.getNombre() + " Sueldo: " + empleado3.getSueldo()
        + " Fecha de alta: " + empleado3.getFechaContrato());
        */

        //FORMA 2 ---------------------------------------------------------------------
        Empleado misEmpleados[] = new Empleado[5];
        misEmpleados[0] = new Empleado("David Jimenez", 85000, 1990, 12, 17);
        misEmpleados[1] = new Empleado("Ana López", 95000, 1995, 06, 02);
        misEmpleados[2] = new Empleado("Maria Martín", 105000, 2002, 03, 15);
        misEmpleados[3] = new Empleado("Juan Lopez");
        misEmpleados[4] = new Jefatura("Eva Conesa", 150000, 1989, 2, 25); //POLIMORFISMO

        /*
        //BUCLE FOR 
        for(int i=0; i<misEmpleados.length; i++){
            misEmpleados[i].setSubeSueldo(5);
            System.out.println("Nombere: " + misEmpleados[i].getNombre() + " Sueldo: " + misEmpleados[i].getSueldo()
            + " Fecha de alta: " + misEmpleados[i].getFechaContrato());
        }*/

        Arrays.sort(misEmpleados); //metodo para ordenar arrays. obliga a implementar la interfaz Comparable

        System.out.println(misEmpleados[1].getNombre() + " Tiene un bonus de: " + misEmpleados[0].setBonus(500)); //metodo de interfaz I_Trabajadores

        //BUCLE FOR EACH
        for(Empleado i: misEmpleados){ 
            i.setSubeSueldo(5);
            System.out.println("Nombere: " + i.getNombre() + " Sueldo: " + i.getSueldo()
            + " Fecha de alta: " + i.getFechaContrato());
        }

        Jefatura Jefe_1 = new Jefatura("Alberto", 200000, 1986, 1, 9);
        Jefe_1.setIncentivo(1000);
        System.out.println("Incetivo Jefe_1: " + Jefe_1.getIncentivo());

        Jefatura Jefe_2 = (Jefatura)misEmpleados[4]; //REFUNDICION O CASTING
        Jefe_2.setIncentivo(700);
        System.out.println("Incentivo Jefe_2: " + Jefe_2.getIncentivo());
        System.out.println("Nombere: " + Jefe_2.getNombre() + " Sueldo: " + Jefe_2.getSueldo()
            + " Fecha de alta: " + Jefe_2.getFechaContrato());

        System.out.println(Jefe_1.tomarDecisiones("Dar mas días de vacaciones a los empleados")); //metodo de la interfaz I_Jefes
    }
}


class Empleado implements Comparable, I_Trabajadores{ //clase que implementa la interfaz Comparable y la interfaz I_Trabajadores

    private String nombre;
    private double sueldo;
    private Date alta_contrato;

    public Empleado(String nom, double sue, int anio, int mes, int dia){ //CONSTRUCTOR
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
        alta_contrato = calendario.getTime();

    }

    public Empleado(String nom){ //Sobrecarga de constructor.
        this(nom, 0, 2000, 01, 01); //llama al constructor que conincida con el numero de parametros que estamos especificando
    }

    public String getNombre(){ //GETTER
        return nombre;
    }

    public double getSueldo(){ //GETTER
        return sueldo;
    }

    public Date getFechaContrato(){   //GETTER
        return alta_contrato;
    }

    public void setSubeSueldo(double porcentaje){ //SETTER
        double aumento = sueldo * porcentaje/100;
        sueldo+=aumento;
    }

    public int compareTo(Object miObjeto){ //metodo de la interfaz Comparable
        Empleado otroEmpleado = (Empleado)miObjeto; //REFUNDICION
        if(this.sueldo<otroEmpleado.sueldo){
            return -1;
        }
        if(this.sueldo>otroEmpleado.sueldo){
            return 1;
        }
        return 0;
    }

    public double setBonus(double gratificacion){ //metodo de la interfaz I_Trabajador
        return I_Trabajadores.bonus_base + gratificacion;
    }
}

final class Jefatura extends Empleado implements I_Jefes{ //con final le indicamos que no sepuede heredar de la clase Jefatura
    //implementamos la interfaz I_Jefes

    private double incentivo;

    public Jefatura(String nom, double sue, int anio, int mes, int dia){
        super(nom, sue, anio, mes, dia); //llamamos al constructor de la clase padre
    }

    public void setIncentivo(double incentivo){ //SETTER
        this.incentivo = incentivo;
    }

    public final double getIncentivo(){ //GETTER   con final indicamos que cuando se herede la clase Jefatura, este metodo no se puede sobreescrivir.
        return incentivo;
    }

    public double getSueldo(){ //GETTER sobrescribiendo el metodo de getSueldo() de la clase empleado (PADRE)
        double sueldoJefe = super.getSueldo(); //llamando a metodo de clase Empleado (PADRE)
        return sueldoJefe + incentivo;
    }

    public String tomarDecisiones(String decision){ //metodo de la interfaz I_Jefes
        return "Un miembro de la dirección a tomado la decisión: " + decision;
    }

    public double setBonus(double gratificacion){ //metodo de la interfaz I_Trabajadores
        double prima = 2000;
        return I_Trabajadores.bonus_base + gratificacion + prima;
    }
}

