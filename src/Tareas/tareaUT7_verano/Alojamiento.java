package Tareas.tareaUT7_verano;

/**
 * 
 * @author David Jimenez Alonso
 */

public abstract class Alojamiento implements Suitable {

    protected String modelo;
    protected int longitud;
    protected int ancho;
    protected boolean tieneAseo;


    /* CONSTRUCTORES */

    /**
     * Constuctor por defecto
     */
    protected Alojamiento() {
    };

    /**
     * Crea un objeto de tipo Alojamiento
     * 
     * @param modelo    Modelo del alojamiento.
     * @param longitud  Longitud del alojamiento
     * @param ancho     Ancho del alojamiento
     * @param tieneAseo Aseo del alojamiento. True si tiene asio o False si no tiene.
     */
    protected Alojamiento(String modelo, int longitud, int ancho, boolean tieneAseo) {
        this.modelo = modelo;
        this.longitud = longitud;
        this.ancho = ancho;
        this.tieneAseo = tieneAseo;
    }

    /**
     * Constructor de copia
     * 
     * @param alojamiento Alojamiento del que se obtiene la información.
     */
    protected Alojamiento(Alojamiento alojamiento) {
        this.modelo = alojamiento.modelo;
        this.longitud = alojamiento.longitud;
        this.ancho = alojamiento.ancho;
        this.tieneAseo = alojamiento.tieneAseo;
    }


    /* GETTERS AND SETTERS */

    /**
     * Devuelve el modelo del alojamiento
     * 
     * @return Cadena de caracteres con el modelo del alojamiento
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece un nuevo modelo para el alojamiento
     * 
     * @param modelo Nuevo modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve la longitud del alojamiento
     * 
     * @return Numero entero con la longitud del alojamiento
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Establece una nueva longitud del alojamiento
     * 
     * @param longitud Nueva longitud
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve el ancho del alojamiento
     * 
     * @return Numero entero con le ancho del alojamiento
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Establece un nuevo ancho del alojamiento
     * 
     * @param ancho Nuevo ancho
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * Devuelve true si el alojamiento tiene aseo, o false si no tiene
     * 
     * @return true si el alojamiento tiene aseo y false si no tiene aseo
     */
    public boolean isTieneAseo() {
        return tieneAseo;
    }

    /**
     * Establece si el alojameinto tiene aseo
     * 
     * @param tieneAseo Nuevo aseo
     */
    public void setTieneAseo(boolean tieneAseo) {
        this.tieneAseo = tieneAseo;
    }


    /* METODO cabeEnParcela*/

    /**
     * Compruba si el alojamiento cabe en la parcela.
     * 
     * @param alojamientoLargo Nuemero entero con la medida del largo del alojamiento
     * @param alojamientoAncho Nuemero entero con la medida del ancho del alojamiento
     * @return Devuelve verdadero si el alojamiento cabe en la parcela
     * @throws AlojamientoInvalidoException Lanza la excepción AlojamientoInvalidoException si el
     *                                      alojamiento no cabe en la parcela(10,5)
     */
    @Override
    public boolean cabeEnParcela(int alojamientoLargo, int AlojamientoAncho) throws AlojamientoInvalidoException {
        if (PARCELA_LARGO < alojamientoLargo || PARCELA_ANCHO < AlojamientoAncho) {
            throw new AlojamientoInvalidoException(AlojamientoInvalidoException.MENSAJE);
        }
        return true;
    }


    /* METODO toString */

    /**
     * Transforma toda la información del objeto en un String
     * 
     * @return Toda la información del objeto en formato String
     */
    @Override
    public String toString() {
        return "Alojamiento [ancho=" + ancho + ", longitud=" + longitud + ", modelo=" + modelo + ", tieneAseo="
                + tieneAseo + "]";
    }


    /* METODOS hasCode y equals */

    /**
     * Este método viene a complementar al método equals y sirve para comparar objetos de una forma más rápida
     * en estructuras Hash ya que únicamente nos devuelve un número entero.
     * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
     * primero invoca al método hashcode y luego el equals. Si los métodos hashcode de cada objeto
     * devuelven diferente hash no seguirá comparando y considerará a los objetos distintos. 
     * En el caso en el que ambos objetos compartan el mismo hashcode Java invocará al método equals() y revisará a
     * detalle si se cumple la igualdad. De esta forma las búsquedas quedan simplificadas en estructuras hash.
     * 
     * @return El código hash generado.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ancho;
        result = prime * result + longitud;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + (tieneAseo ? 1231 : 1237);
        return result;
    }

    /**
     * Comprueba si dos objetos representan al mismo alojamiento.
     * 
     * @param obj Alojamiento con el que comparar
     * @return Devuelve verdadero si los dos alojamientos coinciden en el valor de
     *         todos sus atributos y false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alojamiento other = (Alojamiento) obj;
        if (ancho != other.ancho)
            return false;
        if (longitud != other.longitud)
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (tieneAseo != other.tieneAseo)
            return false;
        return true;
    }

}
