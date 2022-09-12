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
public class Domicilio 
{
    private String calle;
    private int numero;
    private int piso;
    private char letra;
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto
     */
    public Domicilio(){}
    
    /**
     * Constructor de copia.
     * @param domicilio Domicilio del que se obtiene la información.
     */
    public Domicilio(Domicilio domicilio)
    {
        this.calle = domicilio.calle;
        this.numero = domicilio.numero;
        this.piso = domicilio.piso;
        this.letra = domicilio.letra;
    }        
    
    /**
     * Crea un objeto de tipo domicilio.
     * @param calle     Calle del domicilio.
     * @param numero    Número del domicilio.
     * @param piso      Planta, si la hay. Escribir null en caso contrario.
     * @param letra     Letra, si la hay. Escribir null en caso contrario.
     */
    public Domicilio(String calle, int numero, int piso, char letra) 
    {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    /**
     * Devuelve el nombre de la calle de un domicilio.
     * @return Cadena de caracteres con el nombre de la calle. 
     */
    public String getCalle() {
        return calle;
    }


    /**
     * Establece una nueva calle para el domicilio.
     * @param calle Nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

     /**
     * Devuelve el número de la calle de un domicilio.
     * @return Cadena de caracteres con el número de la calle. 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece un nuevo número para el domicilio.
     * @param numero    Nuevo número.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Devuelve la planta del domicilio.
     * @return Cadena de caracteres con la planta del domicilio. 
     */
    public int getPiso() {
        return piso;
    }

    /**
     * Establece un nuevo piso/planta para el domicilio.
     * @param piso Nuevo piso/planta.
     */
    public void setPiso(int piso) {
        this.piso = piso;
    }

    /**
     * Devuelve la letra del domicilio.
     * @return Cadena de caracteres con la letra del domicilio. 
     */
    public char getLetra() {
        return letra;
    }

    /**
     * Establece una nueva letra para el domicilio.
     * @param letra Nueva letra.
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     * Devuelve toda la información del objeto en formato String.
     * @return La información del domicilio en formato String.
     */
    @Override
    public String toString() {
        return "Domicilio{" + "calle=" + calle + ", numero=" + numero 
                + ", piso=" + piso + ", letra=" + letra + '}';
    }

    /**
     * /**
     * Este método viene a complementar al método equals y sirve para comparar objetos de una forma más rápida
     * en estructuras Hash ya que únicamente nos devuelve un número entero.
     * @return Un valor entero calculado a partir de los valores almacenados en cada uno de los atributos.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.calle);
        hash = 59 * hash + this.numero;
        hash = 59 * hash + this.piso;
        hash = 59 * hash + this.letra;
        return hash;
    }

    /**
     * Comprueba si dos domicilios son el mismo.
     * @param obj   Domicilio con el que comparar.
     * @return Devuelve true si ambos domicilios son el mismo y false en caso contrario.
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
        final Domicilio other = (Domicilio) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.piso != other.piso) {
            return false;
        }
        if (this.letra != other.letra) {
            return false;
        }
        if (!Objects.equals(this.calle, other.calle)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
