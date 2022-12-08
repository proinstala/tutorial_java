
package DAM_1.Tareas.tareaUT7;

import java.util.Objects;

/**
 *
 * @author David Jimenez Alonso
 */
public abstract class Alojamiento implements Suitable{
    
    protected String modelo;
    protected int longitud;
    protected int ancho;
    protected boolean tieneAseo;
    
    
    //Contructor sin parametros
    protected Alojamiento(){}
    
    
    //Constructor con parametros
    protected Alojamiento(String modelo, int longitud, int ancho, boolean tieneAseo){
        this.modelo = modelo;
        this.longitud = longitud;
        this.ancho = ancho;
        this.tieneAseo = tieneAseo;
    }
    
    
    //Constructor de copia
    protected Alojamiento(Alojamiento a){
        modelo = a.modelo;
        longitud = a.longitud;
        ancho = a.ancho;
        tieneAseo = a.tieneAseo;
    }
    
    
    //Getter y Setter
    public String getModelo(){
        return modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public int getLongitud(){
        return longitud;
    }
    
    public void setLongitud(int longitud){
        this.longitud = longitud;
    }
    
    public int getAncho(){
        return ancho;
    }
    
    public void setAncho(int ancho){
        this.ancho = ancho;
    }
    
    public boolean getTieneAseo(){
        return tieneAseo;
    }
    
    public void setTieneAseo(boolean tieneAseo){
        this.tieneAseo = tieneAseo;
    }

    @Override
    public String toString() {
        return "Alojamiento{" + "modelo=" + modelo + ", longitud=" + longitud + ", ancho=" + ancho + ", tieneAseo=" + tieneAseo + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.modelo);
        hash = 89 * hash + this.longitud;
        hash = 89 * hash + this.ancho;
        hash = 89 * hash + (this.tieneAseo ? 1 : 0);
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
        final Alojamiento other = (Alojamiento) obj;
        if (this.longitud != other.longitud) {
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
    
    
    
    @Override
    public boolean cabeEnParcela(int anchoParcela, int largoParcela, int anchoAlojamiento, int largoAlojamiento) throws AlojamientoInvalidoException {
        if(anchoParcela < anchoAlojamiento || largoParcela < largoAlojamiento){
            throw new AlojamientoInvalidoException(AlojamientoInvalidoException.ALOJAMIENTO_DEMASIADO_GRANDE);
        }
        else{
            return true;
        }
        
    }
    
    
}//FIN CLASE
