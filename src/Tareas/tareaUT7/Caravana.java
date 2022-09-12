
package Tareas.tareaUT7;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Caravana extends Alojamiento {
    
    private int longitudTotal;
    private boolean tieneMover;
    
    //Constructo sin parametrso
    public Caravana(){
        super();
    }
    
    
    //Consrucotor con parametros
    public Caravana(String modelo, int longitud, int ancho, boolean tieneAseo, int longitudTotal, boolean tieneMover){
        super(modelo, longitud, ancho, tieneAseo);
        this.longitudTotal = longitudTotal;
        this.tieneMover = tieneMover;
    }
    
    
    //Constructor de copia
    public Caravana(Caravana c){
        super(c.modelo, c.longitud, c.ancho, c.tieneAseo);
        longitudTotal =c.longitudTotal;
        tieneMover = c.tieneMover;       
    }
    
    
    //Getter y Setter
    public int getLongitudTotal(){
        return longitudTotal;
    }
    
    public void setLongitudTotal(int longitudTotal){
        this.longitudTotal = longitudTotal;
    }
    
    public boolean getTieneMover(){
        return tieneMover;
    }
    
    public void setTieneMover(boolean tieneMover){
        this.tieneMover = tieneMover;
    }

    @Override
    public String toString() {
        
        return "Caravana{modelo=" + super.modelo + ", longitud=" + super.longitud + ", ancho=" + super.ancho + ", tieneAseo=" + super.tieneAseo + ", longitudTotal=" + longitudTotal + ", tieneMover=" + tieneMover + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.longitudTotal;
        hash = 83 * hash + (this.tieneMover ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.modelo);
        hash = 83 * hash + this.longitud;
        hash = 83 * hash + this.ancho;
        hash = 83 * hash + (this.tieneAseo ? 1 : 0);
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
        final Caravana other = (Caravana) obj;
        if (this.longitudTotal != other.longitudTotal) {
            return false;
        }
        if (this.tieneMover != other.tieneMover) {
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
