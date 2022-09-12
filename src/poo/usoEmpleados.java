package poo;

public class usoEmpleados {
    public static void main(String[] args) {
        /*
        -constante de clase 'final'
        -variable de clase 'static'
        -metodo setter
        -metodo getter
        -metodo getter estatico
        */
        
        Empledos trabajador1 = new Empledos("David");
        Empledos trabajador2 = new Empledos("Ana");

        trabajador1.setSeccion("RRHH");

        System.out.println(trabajador1.getDatos());
        System.out.println(trabajador2.getDatos());

        System.out.println(Empledos.getIdSiguiente());

        Empledos trabajador3 = new Empledos("Fran");
        System.out.println(trabajador3.getDatos());
    }
}





//CLASES ----------------------------------------------------------------------------------


class Empledos{

    private final String nombre; //con 'final' indicamos que es una constante y no se puede modificar su valor una vez asignado.
    private String seccion;
    private int id;
    private static int idSiguiente = 1; //con 'static' le indicamos que esta variable es solo de la clase Empleado

    public Empledos(String nom){ //CONSTRUCTOR

        nombre = nom;
        seccion = "Administración";
        id = idSiguiente;
        idSiguiente++;
    }

    public void setSeccion(String seccion){ //Metodo SETTER
        this.seccion = seccion;
    }

    //Este metodo no compila por que la variable nombre de la clase se a declarado como constante y se a iniciado en el constructor. no se puede modificar
    /*
    public void setNombre(String nombre){ //Metodo SETTER
        this.nombre = nombre;
    }*/

    public static String getIdSiguiente(){ //Metodo GETTER estatico
        return "El Id siguiente es: " + idSiguiente;
    }

    public String getDatos(){ //Metodo GETTER
        return "El nombre es: " + nombre + ". La sección es: " + seccion + ". El id es: " + id;
    }
}
