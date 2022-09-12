package Tareas.tareaUT7_verano;

public class Reserva {

    private Cliente cliente;
    private int numParcela;
    private Fecha fechaInicio;
    private Fecha fechaFin;

    /* CONSTRUCTORES */

    /**
     * Constructor sin parametros
     */
    public Reserva() {
    }

    /**
     * Crea un objeto de tipo Reserva
     * 
     * @param cliente     Cliente propietario de la reserva
     * @param numParcela  Numero de la parcela alquilada
     * @param fechaInicio Fecha inicio de la reserva
     * @param fechaFin    Fecha fin de la resreva
     */
    public Reserva(Cliente cliente, int numParcela, Fecha fechaInicio, Fecha fechaFin) {
        this.cliente = cliente;
        this.setNumParcela(numParcela);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     * Constructor de copia
     * 
     * @param r Objeto del que se obtiene la información
     */
    public Reserva(Reserva r) {
        this.cliente = r.cliente;
        this.numParcela = r.numParcela;
        this.fechaInicio = r.fechaInicio;
        this.fechaFin = r.fechaFin;
    }

    /* GETTERS AND SETTERS */

    /**
     * Devuelve el cliente de la reserva
     * 
     * @return Cliente de la reserva
     */
    public Cliente getCliente() {
        return new Cliente(cliente);
    }

    /**
     * Establece un nuevo cliente para la reserva
     * 
     * @param cliente Nuevo cliente para la reserva
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Devuelve el numero de parcela de la reserva
     * 
     * @return Numero de parcela de la reserva
     */
    public int getNumParcela() {
        return numParcela;
    }

    /**
     * Establece un nuevo valor para el numero de parcela
     * 
     * @param numParcela Nuevo numero de parcela
     * @throws IllegalArgumentException Lanza la excepción IllegalArgumentException
     *                                  si el valor que se pasa como parametros es
     *                                  menor de 1 o mayor de 5
     */
    public void setNumParcela(int numParcela) throws IllegalArgumentException {
        if (numParcela > 0 && numParcela <= 5) {
            this.numParcela = numParcela;
        } else {
            throw new IllegalArgumentException("El valor de numero de parcela tiene que estar entre 1 y 5");
        }
    }

    /**
     * Devuelve la Fecha de inicio de la reserva
     * 
     * @return Fecha inicio de la reserva
     */
    public Fecha getFechaInicio() {
        return new Fecha(fechaInicio);
    }

    /**
     * Establece una nueva fecha de inicio de reserva
     * 
     * @param fechaInicio Nueva fecha de inicio de reserva
     */
    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Devuelve la Fehca de fin de la resreva
     * 
     * @return Fecha fin de reserva
     */
    public Fecha getFechaFin() {
        return new Fecha(fechaFin);
    }

    /**
     * Establece una nueva fecha de fin de reserva
     * 
     * @param fechaFin Nueva fecha fin de reserva
     */
    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    /* METODO toString */

    /**
     * Transforma toda la información del objeto en un String
     * 
     * @return Toda la información del objeto en formato String
     */
    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", fechaFin=" + fechaFin + ", fechaInicio=" + fechaInicio
                + ", numParcela=" + numParcela + "]";
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
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((fechaFin == null) ? 0 : fechaFin.hashCode());
        result = prime * result + ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
        result = prime * result + numParcela;
        return result;
    }

    /**
     * Comprueba si dos objetos representan a la misma reserva.
     * 
     * @param obj Objeto con el que comparar
     * @return Devuelve verdadero si los objetos coinciden en el valor de
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
        Reserva other = (Reserva) obj;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (fechaFin == null) {
            if (other.fechaFin != null)
                return false;
        } else if (!fechaFin.equals(other.fechaFin))
            return false;
        if (fechaInicio == null) {
            if (other.fechaInicio != null)
                return false;
        } else if (!fechaInicio.equals(other.fechaInicio))
            return false;
        if (numParcela != other.numParcela)
            return false;
        return true;
    }

}
