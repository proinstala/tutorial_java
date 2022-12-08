package DAM_1.Tareas.tareaUT7_verano;

public class Caravana extends Alojamiento{
    
    private int longitudTotal;
    private boolean tieneMover;


    /* CONSTRUCTORES */

    /**
     * Constructor por defecto
     */
    public Caravana() {}

    /**
     * Crea un objeto de tipo Caravana
     * 
     * @param modelo        Modelo de la caravana
     * @param longitud      Longitud de la caravana
     * @param ancho         Ancho de la caravana
     * @param tieneAseo     Representa si tiene aseo la caravana
     * @param longitudTotal Longitud total de la caravana
     * @param tieneMover    Representa si se puede mover la caravana
     */
    public Caravana(String modelo, int longitud, int ancho, boolean tieneAseo, int longitudTotal, boolean tieneMover) {
        super(modelo, longitud, ancho, tieneAseo);
        this.longitudTotal = longitudTotal;
        this.tieneMover = tieneMover;
    }

    /**
     * Constructor de copia
     * 
     * @param c Objeto del que se obtiene la información
     */
    public Caravana(Caravana c) {
        super(c.modelo, c.longitud, c.ancho, c.tieneAseo);
        this.longitudTotal = c.longitudTotal;
        this.tieneMover = c.tieneMover;
    }


    /* GETTERS AND SETTERS */

    /**
     * Devuelve la longitud total de la caravana
     * 
     * @return Numero entero con el valor de la longitud total de la caravana
     */
    public int getLongitudTotal() {
        return longitudTotal;
    }

    /**
     * Establece un nuevo valor de longitud total
     * 
     * @param longitudTotal Nuevo valor para longitud total de caravana
     */
    public void setLongitudTotal(int longitudTotal) {
        this.longitudTotal = longitudTotal;
    }

    /**
     * Devuelve true si la caravana puede moverse, o false en caso contrario
     * 
     * @return true si la caravana puede moverse, o false en caso contrario
     */
    public boolean isTieneMover() {
        return tieneMover;
    }

    /**
     * Establece si la caravana puede moverse
     * 
     * @param tieneMover Nuevo valor
     */
    public void setTieneMover(boolean tieneMover) {
        this.tieneMover = tieneMover;
    }

    
    /* METODO toString */

    /**
     * Transforma toda la información del objeto en un String
     * 
     * @return Toda la información del objeto en formato String
     */
    @Override
    public String toString() {
        return "Caravana [ancho=" + ancho + ", longitud=" + longitud + ", modelo=" + modelo + ", tieneAseo="
                + tieneAseo + "longitudTotal=" + longitudTotal + ", tieneMover=" + tieneMover + "]";
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
        result = prime * result + longitudTotal;
        result = prime * result + (tieneMover ? 1231 : 1237);
        return result;
    }

    /**
     * Comprueba si dos objetos representan a la misma caravana.
     * 
     * @param obj Objeto con el que comparar
     * @return Devuelve verdadero si los objetos coinciden en el valor de
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
        Caravana other = (Caravana) obj;
        if (longitudTotal != other.longitudTotal)
            return false;
        if (tieneMover != other.tieneMover)
            return false;
        return true;
    }
    
}
