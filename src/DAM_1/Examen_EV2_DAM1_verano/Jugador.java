package DAM_1.Examen_EV2_DAM1_verano;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Representa a un jugador de la partida de conecta 4
 * 
 * @author David JA
 * 
 */
public class Jugador {

    private String nombre;
    private String color;
    private ArrayList<Integer> listaMovimientos;

    public static final String ROJO = "\u001B[31m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";

    /*
     * Constructor sin parametros.
     * Crea un jugador con sus valores sin definir e inicializa su lista de
     * movimientos.
     */
    public Jugador() {
        this.listaMovimientos = new ArrayList<>();
    }

    /**
     * Constructor con parametros.
     * Crea un jugador asignandole un nombre y un color.
     * 
     * @param nombre Nombre del jugador.
     * @param color  Color del texto del jugador.
     */
    public Jugador(String nombre, String color) {
        this.listaMovimientos = new ArrayList<>();
        this.nombre = nombre;
        this.color = color;
    }

    /**
     * Constructor de copia.
     * Crea un jugador copiando los parametros del jugador pasado como parametro.
     * 
     * @param j Jugador del que se va a copiar sus valores.
     */
    public Jugador(Jugador j) {
        this.listaMovimientos = j.listaMovimientos;
        this.nombre = j.nombre;
        this.color = j.color;
    }

    /**
     * Devuelve el nombre del jugador.
     * 
     * @return El nombre del jugador.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Asigna un String al parametro nombre del jugador.
     * 
     * @param nombre nombre del jugador
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el color del jugador.
     * 
     * @return El color del jugador.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Asigna un String al parametro color del jugador.
     * 
     * @param color color del jugador.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve la lista de movimientos del jugador.
     * 
     * @return la lista de movimientos del jugador.
     */
    public ArrayList<Integer> getListaMovimientos() {
        return new ArrayList<>(listaMovimientos);
    }

    /**
     * Añade un numero entero representativo de movimiento del jugador a la lista de
     * movimientos.
     * 
     * @param movimiento valor entero entre 0 y 6.
     */
    public void añadirMovimientos(int movimiento) {
        this.listaMovimientos.add(movimiento);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((listaMovimientos == null) ? 0 : listaMovimientos.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    /**
     * Comprueba si dos Jugadores son iguales.
     * 
     * @param obj El Jugador con el que comparar.
     * @return Devuelve true si son iguales y false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador other = (Jugador) obj;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (listaMovimientos == null) {
            if (other.listaMovimientos != null)
                return false;
        } else if (!listaMovimientos.equals(other.listaMovimientos))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }

    /**
     * Devuelve la descripcion del Jugador.
     * 
     * @return La descripcion del Jugador en formato String.
     */
    @Override
    public String toString() {
        return "Jugador [color=" + color + ", listaMovimientos=" + listaMovimientos + ", nombre=" + nombre + "]";
    }

}
