package Ejercicio_instrumentos;

public class Instrumento {
    
    private String id;
    private Double precio;
    private TIPO_INSTRUMENTO tipo;
    
    public Instrumento(String id, Double precio, TIPO_INSTRUMENTO tipo) {
        this.id = id;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public TIPO_INSTRUMENTO getTipo() {
        return tipo;
    }


    public void setTipo(TIPO_INSTRUMENTO tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Instrumento [id=" + id + ", precio=" + precio + ", tipo=" + tipo + "]";
    }

}
