package Tareas.tareaUT7_verano;

/**
 * @author David Jimenez Alonso
 */
public class Cliente {

    private int numeroCliente;
    private String nombreCompleto;
    private String dni;
    private Fecha fechaNacimiento;
    private Alojamiento alojamiento;


    /* CONSTRUCTORES */

    /**
     * Constructor sin parametros
     */
    public Cliente() {
    }

    /**
     * Crea un objeto de tipo cliente
     * 
     * @param numeroCliente   Numero representativo del cliente
     * @param nombreCompleto  Nombre y apellidos del cliente
     * @param dni             DNI del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param alojamiento     Alojamiento del cliente
     */
    public Cliente(int numeroCliente, String nombreCompleto, String dni, Fecha fechaNacimiento, Alojamiento alojamiento) {
        this.numeroCliente = numeroCliente;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.alojamiento = alojamiento;
    }

    /**
     * Constructor de copia
     * 
     * @param cliente Cliente del que se obtiene la información
     */
    public Cliente(Cliente cliente) {
        this.numeroCliente = cliente.numeroCliente;
        this.nombreCompleto = cliente.nombreCompleto;
        this.dni = cliente.dni;
        this.fechaNacimiento = cliente.fechaNacimiento;
        this.alojamiento = cliente.alojamiento;
    }


    /* GETTERS AND SETTERS */

    /**
     * Devuelve el numero del cliente
     * @return Numero del cliente
     */
    public int getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * Establece un nuevo numero de cliente
     * @param numeroCliente Nuevo numero
     */
    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    /**
     * Devuelve el nombre y apellidos del cliente
     * @return Nombre y apellidos del cliente
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece un nuevo nombre y apellidos del cliente
     * @param nombreCompleto nuevo nombre completo
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Devuelve el DNI del cliente
     * @return  DNI del cliente
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece un nuevo DNI para el cliente
     * @param dni   nuevo DNI
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente
     * @return Objeto tipo Fecha
     */
    public Fecha getFechaNacimiento() {
        return new Fecha(fechaNacimiento);
    }

    /**
     * Establece una nueva fecha de nacimiento para el cliente
     * @param fechaNacimiento   Nueva fecha de nacimiento
     */
    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve el alojamiento del cliente
     * 
     * @return Objeto de tipo Caravana si en el alojamiento se ha guardado un objeto
     *         de tipo Caravana, si no, se devuelve un objeto de tipo Autocaravana
     */
    public Alojamiento getAlojamiento() {
        if (this.alojamiento.getClass() == Caravana.class) {
            return new Caravana((Caravana) alojamiento);
        } else {
            return new Autocaravana((Autocaravana) alojamiento);
        }
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }


    /* METODO toString */

    /**
     * Transforma toda la informacion del objeto en un String
     * 
     * @return Toda la información del objeto en formato String
     */
    @Override
    public String toString() {
        return "Cliente [alojamiento=" + alojamiento + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento
                + ", nombreCompleto=" + nombreCompleto + ", numeroCliente=" + numeroCliente + "]";
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
        result = prime * result + ((alojamiento == null) ? 0 : alojamiento.hashCode());
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        result = prime * result + ((fechaNacimiento == null) ? 0 : fechaNacimiento.hashCode());
        result = prime * result + ((nombreCompleto == null) ? 0 : nombreCompleto.hashCode());
        result = prime * result + numeroCliente;
        return result;
    }

    /**
     * Comprueba si dos objetos representan al mismo cliente.
     * 
     * @param obj Cliente con el que comparar
     * @return Devuelve verdadero si los dos objetos coinciden en el valor de
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
        Cliente other = (Cliente) obj;
        if (alojamiento == null) {
            if (other.alojamiento != null)
                return false;
        } else if (!alojamiento.equals(other.alojamiento))
            return false;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        if (fechaNacimiento == null) {
            if (other.fechaNacimiento != null)
                return false;
        } else if (!fechaNacimiento.equals(other.fechaNacimiento))
            return false;
        if (nombreCompleto == null) {
            if (other.nombreCompleto != null)
                return false;
        } else if (!nombreCompleto.equals(other.nombreCompleto))
            return false;
        if (numeroCliente != other.numeroCliente)
            return false;
        return true;
    }

}
