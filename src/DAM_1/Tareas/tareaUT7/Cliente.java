
package DAM_1.Tareas.tareaUT7;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Cliente {
    
    private int numCliente;
    private String nombreCompleto;
    private String dni;
    private Fecha fechaNac;
    private Alojamiento alojamiento;
    

    //Constructor sin parametros.
    public Cliente(){}
    
    
    //constructor con parametros.
    public Cliente(int numCliente, String nombreCompleto, String dni, Fecha fechaNac, Alojamiento alojamiento){
        
        this.numCliente = numCliente;
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.alojamiento = alojamiento;
    }
    
    
    //Constructor de copia.
    public Cliente(Cliente c){
        numCliente = c.numCliente;
        nombreCompleto = c.nombreCompleto;
        dni = c.dni;
        fechaNac = c.fechaNac;
        alojamiento = c.alojamiento;
    }
    
    
    //Metodos setter and getter ------------------------------------------
    public int getNumCliente(){
        return numCliente;
    }
    
    public void setNumCliente(int numCliente){
        this.numCliente = numCliente;
    }
    
    public String getNombreCompleto(){
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto){
        this.nombreCompleto = nombreCompleto;
    }
    
    public String getDni(){
        return dni;
    }
    
    public void setDni(String dni){
        this.dni = dni;
    }
    
    public Fecha getFechaNac(){
        return new Fecha(fechaNac);
    }
    
    public void setFechaNac(Fecha fechaNac){
        this.fechaNac = fechaNac;
    }
    
    public Alojamiento getAlojamiento(){
        if(alojamiento.getClass() == Caravana.class){
            return  new Caravana((Caravana)alojamiento);
        }
        else{
            return  new Autocaravana((Autocaravana)alojamiento);
        }
    }
    
    public void setAlojamiento(Alojamiento alojamiento){
        this.alojamiento = alojamiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numCliente=" + numCliente + ", nombreCompleto=" + nombreCompleto + ", dni=" + dni + ", fechaNac=" + fechaNac + ", alojamiento=" + alojamiento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.numCliente;
        hash = 89 * hash + Objects.hashCode(this.nombreCompleto);
        hash = 89 * hash + Objects.hashCode(this.dni);
        hash = 89 * hash + Objects.hashCode(this.fechaNac);
        hash = 89 * hash + Objects.hashCode(this.alojamiento);
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
        final Cliente other = (Cliente) obj;
        if (this.numCliente != other.numCliente) {
            return false;
        }
        if (!Objects.equals(this.nombreCompleto, other.nombreCompleto)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.fechaNac, other.fechaNac)) {
            return false;
        }
        if (!Objects.equals(this.alojamiento, other.alojamiento)) {
            return false;
        }
        return true;
    }
    
    
    
} //FIN CLASE Cliente
