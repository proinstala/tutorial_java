package poo;

import java.util.*;

/*
- clase abstracta
- metodo getter abstracto


*/

public class UsoPersona {
    public static void main(String[] args) {
        
        Persona Personas[] = new Persona[2];
        Personas[0] = new Trabajador("Luis Conde", 50000, 2009, 02, 25);
        Personas[1] = new Alumno("Ana Lopez", "Biológicas");


        for(Persona i: Personas){ //BUCLE FOR EACH
            System.out.println(i.getDescripcion());
        }
    }
}

abstract class Persona{ //clase declarada como abstracta

    private String nombre;

    public Persona(String nom){
        nombre = nom;
    }

    public String getNombre(){
        return nombre;
    }

    public abstract String getDescripcion(); //GETTER  metodo abstracto 
}

class Trabajador extends Persona{ //clase Trabajador hereda de Persona

    private double sueldo;
    private Date alta_contrato;

    public Trabajador(String nom, double sue, int anio, int mes, int dia){ //CONSTRUCTOR
        super(nom); //llamamos al constructor de la clase padre(clase super)
        sueldo = sue;
        GregorianCalendar calendario = new GregorianCalendar(anio, mes-1, dia);
        alta_contrato = calendario.getTime();
    }

    public String getDescripcion(){ //GETTER - metodo abstracto de la clase super (padre)
        return  "Nombre: " + super.getNombre() + " Sueldo: " + sueldo + " Fecha contrato: " + alta_contrato;
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
}

class Alumno extends Persona{ //Clase Alumno hereda de Persona

    private String carrera;

    public Alumno(String nom, String car){
        super(nom);
        carrera = car;
    }

    public String getDescripcion(){ //GETTER - metodo abstracto de la clase super (padre)
        return "Nombre: " + super.getNombre() + " Carrera: " + carrera;
    }
}
