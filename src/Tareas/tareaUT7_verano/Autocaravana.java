package Tareas.tareaUT7_verano;

/**
 * @author David Jimenez Alonso
 */
public class Autocaravana extends Alojamiento {

    public static final int ANCHO_STD = 235;
    private TIPO_AUTOCARAVANA tipoAc;


    /* CONSTRUCTORES */

    /**
     * Constructor por defecto
     */
    public Autocaravana() {
    }

    /**
     * Crea un objeto de tipo Autocaravana
     * 
     * @param modelo    Modelo de la autocaravana
     * @param longitud  Longitud de la autocaravana
     * @param ancho     Ancho de la autocaravana
     * @param tieneAseo Aseo de la autocaravana. True si tiene o false si no tiene
     * @param tipoAc    Tipo de autocaravana
     */
    public Autocaravana(String modelo, int longitud, int ancho, boolean tieneAseo, TIPO_AUTOCARAVANA tipoAc) {
        super(modelo, longitud, ancho, tieneAseo);
        this.tipoAc = tipoAc;
    }

    /**
     * Constructor de copia
     * 
     * @param a Autocaravana de la que se obtiene la información
     */
    public Autocaravana(Autocaravana a) {
        super(a.modelo, a.longitud, a.ancho, a.tieneAseo);
        this.tipoAc = a.tipoAc;
    }


    /* GETTERS AND SETTERS */

    /**
     * Devuelve el tipo de autocaravana
     * @return Enumerado de tipo de autocaravana
     */
    public TIPO_AUTOCARAVANA getTipoAc() {
        return tipoAc;
    }

    /**
     * Establece un nuevo tipo de autocaravana
     * @param tipoAc Nuevo tipo de autocaravana
     */
    public void setTipoAc(TIPO_AUTOCARAVANA tipoAc) {
        this.tipoAc = tipoAc;
    }


    /* METODO toString */

    /**
     * Transforma toda la información del objeto en un String
     * 
     * @return Toda la información del objeto en formato String
     */
    @Override
    public String toString() {
        return "Autocaravana [ancho=" + ancho + ", longitud=" + longitud + ", modelo=" + modelo + ", tieneAseo="
                + tieneAseo + "tipoAc=" + tipoAc + "]";
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
        int result = super.hashCode();
        result = prime * result + ((tipoAc == null) ? 0 : tipoAc.hashCode());
        return result;
    }

    /**
     * Comprueba si dos objetos representan a la misma autocaravana.
     * 
     * @param obj Objeto con el que comparar
     * @return Devuelve verdadero si las dos autocaravanas coinciden en el valor de
     *         todos sus atributos y false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autocaravana other = (Autocaravana) obj;
        if (tipoAc != other.tipoAc)
            return false;
        return true;
    }
    
}
