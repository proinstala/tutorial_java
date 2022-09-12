/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas.tareaut3java;

import java.util.Objects;

/**
 *
 * @author PROFESOR PROGRAMACIÓN
 */
public class Persona 
{
    
    /* ATRIBUTOS */

    /**
     * No se incluye información de estos campos porque son privados.
     */
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String fechaNacimiento;
    private Sexo sexo;
    private String email;
    private Domicilio primeraResidencia;
    private Domicilio segundaResidencia;

    
    /* CONSTRUCTOR */
    
    /**
     * Constructor por defecto.
     */
    public Persona(){}
    
    /**
     * Constructor de copia.
     * @param p Objeto del que se obtiene la información.
     */
    public Persona(Persona p)
    {
        this.nombre = p.nombre;
        this.apellido1 = p.apellido1;
        this.apellido2 = p.apellido2;
        this.dni = p.dni;
        this.fechaNacimiento = p.fechaNacimiento;
        this.sexo = p.getSexo();
        this.email = p.email;
    }        
        

    /**
     * Crea un objeto de tipo Persona.
     * @param nombre    Nombre de la persona a empadronar.
     * @param apellido1 Primer apellido de la persona a empadronar.
     * @param apellido2 Segundo apellido de la persona a empadronar.
     * @param dni   Documento nacional de identidad de la persona a empadronar.
     * @param fechaNacimiento Fecha de nacimiento de la persona a empadronar. Formato dd/mm/aaaa.
     * @param genero    Enumerado. Sexo de la persona. HOMBRE o MUJER.
     * @param email     Correo electrónico de la persona a empadronar.
     */
    public Persona(String nombre, String apellido1, String apellido2, String dni, 
            String fechaNacimiento, Sexo sexo, String email) {
        
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.email = email;
    }
    
    /* GETTERS AND SETTERS */

    /**
     * Devuelve el nombre de la persona empadronada.
     * @return Cadena de caracteres que incluye el nombre de la persona empadronada. 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la persona empadronada.
     * @param nombre El nuevo nombre a asignar a la persona empadronada.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el primer apellido de la persona empadronada.
     * @return Cadena de caracteres que incluye el primer apellido de la persona empadronada. 
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Establece un nuevo primer apellido para la persona empadronada.
     * @param apellido1 El nuevo primer apellido a asignar a la persona empadronada.
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

     /**
     * Devuelve el segundo apellido de la persona empadronada.
     * @return Cadena de caracteres que incluye el segundo apellido de la persona empadronada. 
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Establece un nuevo segundo apellido para la persona empadronada.
     * @param apellido2 El nuevo segundo apellido a asignar a la persona empadronada.
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

     /**
     * Devuelve el DNI de la persona empadronada.
     * @return Cadena de caracteres que incluye el DNI de la persona empadronada. 
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece un nuevo dni para la persona empadronada.
     * @param dni El nuevo dni a asignar a la persona empadronada.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

     /**
     * Devuelve la fecha de nacimiento de la persona empadronada.
     * @return Cadena de caracteres que incluye la fecha de nacimiento de la persona empadronada,
     * con el formato dd/mm/aaaa.
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece una nueva fecha de nacimiento para la persona empadronada.
     * @param fechaNacimiento  La nueva fecha de nacimiento  a asignar a la persona empadronada.
     * Formato dd/mm/aaaa.
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el sexo de la persona empadronada.
     * @return Cadena de caracteres que incluye el sexo de la persona empadronada. 
     */
    public Sexo getSexo() {
    return sexo;
    }
    
    /**
     * Establece un nuevo sexo para la persona empadronada.
     * @param sexo   El nuevo sexo a asignar a la persona empadronada.
     */
    public void setSexo(Sexo sexo) {    
        this.sexo = sexo;
    }

    /**
     * Devuelve el correo electrónico de la persona empadronada.
     * @return Cadena de caracteres que incluye el correo electrónico de la persona empadronada. 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece un nuevo correo electrónico para la persona empadronada.
     * @param email   El nuevo correo electrónico  a asignar a la persona empadronada.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve un objeto copia de la primera residencia.
     * @return Un objeto de tipo Domicilio con la información de la primera residencia.
     */
    public Domicilio getPrimeraResidencia() {
        return new Domicilio(primeraResidencia);
    }

    /**
     * Asocia el domicilio de la primera residencia con una persona que vive en ella.
     * @param primeraResidencia El domicilio que es la primera residencia de la persona que realiza la 
     * invocación al método.
     */
    public void setPrimeraResidencia(Domicilio primeraResidencia) {
        this.primeraResidencia = primeraResidencia;
    }

    /**
     * Devuelve un objeto copia de la segunda residencia.
     * @return Un objeto de tipo Domicilio con la información de la segunda residencia.
     */
    public Domicilio getSegundaResidencia() {
        return new Domicilio(segundaResidencia);
    }

    /**
     * Asocia el domicilio de la segunda residencia con una persona que vive en ella.
     * @param segundaResidencia El domicilio que es la segunda residencia de la persona que realiza la 
     * invocación al método.
     */
    public void setSegundaResidencia(Domicilio segundaResidencia) {
        this.segundaResidencia = segundaResidencia;
    }


    /* TOSTRING */

    /**
     * Transforma toda la información del objeto en un String
     * @return Toda la información de un objeto en formato String
     */
    @Override    
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 
                + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo 
                + ", email=" + email + ", primeraResidencia=" 
                + primeraResidencia + ", segundaResidencia=" + segundaResidencia + '}';
    }

    /* EQUALS */
    
    /**
     * Este método viene a complementar al método equals y sirve para comparar objetos de una forma más rápida
     * en estructuras Hash ya que únicamente nos devuelve un número entero. Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc) primero invoca
     * al método hashcode y luego el equals. Si los métodos hashcode de cada objeto devuelven diferente hash
     * no seguirá comparando y considerará a los objetos distintos. En el caso en el que ambos objetos
     * compartan el mismo hashcode Java invocará al método equals() y revisará a detalle 
     * si se cumple la igualdad. De esta forma las búsquedas quedan simplificadas en estructuras hash.
     * @return El código hash generado.
     */
    @Override    
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellido1);
        hash = 41 * hash + Objects.hashCode(this.apellido2);
        hash = 41 * hash + Objects.hashCode(this.dni);
        hash = 41 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 41 * hash + Objects.hashCode(this.sexo);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.primeraResidencia);
        hash = 41 * hash + Objects.hashCode(this.segundaResidencia);
        return hash;
    }

     /**
     * Comprueba si dos objetos representan a la misma persona.
     * @param obj   Persona con la que comparar
     * @return      Devuelve verdadero si las dos personas coinciden en el valor de todos sus atributos
     * y false en caso contrario. 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        if (!Objects.equals(this.apellido2, other.apellido2)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.primeraResidencia, other.primeraResidencia)) {
            return false;
        }
        if (!Objects.equals(this.segundaResidencia, other.segundaResidencia)) {
            return false;
        }
        return true;
    }


    
   
}
