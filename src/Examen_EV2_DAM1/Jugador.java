
package Examen_EV2_DAM1;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author David Jimenez Alonso
 */
public class Jugador {
    
    private String nombre;
    private String color;
    private ArrayList<Integer> listaMovimientos;
    
    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    
    
    //Constructor sin parametros
    public Jugador(){
        this.listaMovimientos = new ArrayList<>();
    }
    
    //Constructor con parametros
    public Jugador(String nombre, String color){
        this.nombre = nombre;
        this.color = color;
        this.listaMovimientos = new ArrayList<>();
    }
    
    //Constructor de copia
    public Jugador(Jugador j){
        nombre = j.nombre;
        color = j.color;
        listaMovimientos = j.listaMovimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    //añade un movimiento a la lista
    public void añadirMovimiento(int m){
        listaMovimientos.add(m);
    }
    
    //devuelve una copia de la lista
    public ArrayList<Integer> getListaMovimientos(){
        return new ArrayList<>(listaMovimientos);
    }
    
            

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", color=" + color + ", ListaMovimientos=" + listaMovimientos + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.color);
        hash = 13 * hash + Objects.hashCode(this.listaMovimientos);
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
        final Jugador other = (Jugador) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return Objects.equals(this.listaMovimientos, other.listaMovimientos);
    }
    
    
    
}//FIN CLASE JUGADOR
