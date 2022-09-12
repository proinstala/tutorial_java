package Ejercicio_instrumentos;

import java.util.ArrayList;

public class Sucursal {
    
    private String nombre;
    private ArrayList<Instrumento> listaInstrumentos;

    public Sucursal(String nombre){
        this.nombre = nombre;
        this.listaInstrumentos = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void agregarInstrumentos(Instrumento i){
        this.listaInstrumentos.add(i);
    }


    public void listarIntrumentos(){
        for (Instrumento instrumento : listaInstrumentos) {
            System.out.println(instrumento.toString());
        }
    }

    public ArrayList<Instrumento> instrumentosPorTipo(TIPO_INSTRUMENTO tipo) {
        ArrayList<Instrumento> instrumentosEncontrados = new ArrayList<>();
        for (Instrumento i : listaInstrumentos) {
            if(i.getTipo() == tipo) {
                instrumentosEncontrados.add(i);
            }
        }
        
        return instrumentosEncontrados;
    }

    public Instrumento borrarInstrumento(String id){
        for (int i = 0; i < listaInstrumentos.size(); i++) {
            if (listaInstrumentos.get(i).getId().equals(id)){
                return listaInstrumentos.remove(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Sucursal [listaInstrumentos=" + listaInstrumentos + ", nombre=" + nombre + "]";
    }

    
}
