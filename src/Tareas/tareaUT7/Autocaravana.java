/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas.tareaUT7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


/**
 *
 * @author David Jimenez Alonso
 */
public class Autocaravana extends Alojamiento{
    
    private TIPO_AUTOCARAVANA tipoAC;
    public static final int ANCHO_STD = 235;
    
    //Constructor sin parametros
    public Autocaravana() {
        super();
    }
    
    
    //Constructor con parametros
    public Autocaravana(String modelo, int longitud, int ancho, boolean tieneAseo, TIPO_AUTOCARAVANA tipoAC) {
        super(modelo, longitud, ancho, tieneAseo);
        this.tipoAC = tipoAC;
      
    }
    
    
    //Constructor de copia
    public Autocaravana(Autocaravana c) {
        super(c.modelo, c.longitud, c.ancho, c.tieneAseo);
        tipoAC = c.tipoAC;
        
    }
    
    
    //Getters ans Setters
    public TIPO_AUTOCARAVANA getTipoAC() {
        return this.tipoAC;
    }
    
    public void setTipoAC(TIPO_AUTOCARAVANA tipoAC) {
        this.tipoAC = tipoAC;
    }
    
    //maxLongitud: este método estático, recibe como parámetro una lista con elementos de tipo Autocaravana, y devuelve aquella que tiene la mayor longitud.
    public static Autocaravana maxLongitud(ArrayList<Autocaravana> lista){
        Iterator<Autocaravana> mi_iterador = lista.iterator();
        int aux = 0;
        int posicion = 0;
        int medida_iterador = 0;
        int medida = 0;
        while(mi_iterador.hasNext()){
            medida_iterador = mi_iterador.next().longitud;
            if(medida < medida_iterador){
                medida = medida_iterador;
                posicion = aux;
            }
            aux++;
        }
        return lista.get(posicion);
    }

    @Override
    public String toString() {
        return "Autocaravana{modelo=" + super.modelo + ", longitud=" + super.longitud + ", ancho=" + super.ancho + ", tieneAseo=" + super.tieneAseo + " tipoAC=" + tipoAC + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.tipoAC);
        hash = 67 * hash + Objects.hashCode(this.modelo);
        hash = 67 * hash + this.longitud;
        hash = 67 * hash + this.ancho;
        hash = 67 * hash + (this.tieneAseo ? 1 : 0);
        return hash;
    }

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
        final Autocaravana other = (Autocaravana) obj;
        if (this.tipoAC != other.tipoAC) {
            return false;
        }
         if (this.ancho != other.ancho) {
            return false;
        }
        if (this.tieneAseo != other.tieneAseo) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        return true;
    }
    

    

    
    
    
    
}


