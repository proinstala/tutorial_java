package Ejercicio_instrumentos;

import java.util.ArrayList;

public class Fabrica {
    
    private ArrayList<Sucursal> listaSucursales;

    public Fabrica() {
        this.listaSucursales = new ArrayList<>();
    }


    public void agregarSucursal(Sucursal s) {
        this.listaSucursales.add(s);
    }

    public void listarSucursales(){
        for (Sucursal s : listaSucursales) {
            System.out.println(s.toString());
        }
    }

    public void listaInstrumentos() {
        for (Sucursal sucursal : listaSucursales) {
            System.out.println(sucursal.getNombre());    
            sucursal.listarIntrumentos();
        }
    }

    public ArrayList<Instrumento> instrumentosPorTipo(TIPO_INSTRUMENTO tipo) {
        ArrayList<Instrumento> instrumentosEncontrados = new ArrayList<>();
        for (Sucursal s : listaSucursales) {
            instrumentosEncontrados.addAll(s.instrumentosPorTipo(tipo));
        }
        
        return instrumentosEncontrados;
    }

    // La explotación del método borrarInstrumento que reciba un ID y elimine el instrumento asociado a tal ID de la sucursal donde se encuentre.
    public Instrumento borrarInstrumento(String id) {
        Instrumento instBorrado = null;
        for (Sucursal s : listaSucursales) {
            instBorrado = s.borrarInstrumento(id);
            if (instBorrado != null) {
                return instBorrado;
            }
        }

        return instBorrado;
    }

    // La explotación del método porcInstrumentosPorTipo que reciba el nombre de una sucursal 
    // y retorne los porcentajes de instrumentos por tipo que hay para tal sucursal.

    public double[] porcInstrumentosPorTipo(String nombre) {
        double[] porcentajes = new double[3];
        int cuerda = 0;
        int viento = 0;
        int percusion = 0;
        int total = 0;
        for (Sucursal s : listaSucursales) {
            if (s.getNombre().equals(nombre)){
                cuerda = s.instrumentosPorTipo(TIPO_INSTRUMENTO.CUERDA).size();
                viento = s.instrumentosPorTipo(TIPO_INSTRUMENTO.VIENTO).size();
                percusion = s.instrumentosPorTipo(TIPO_INSTRUMENTO.PERCUSION).size();
            }
        }
        total = cuerda + viento + percusion;
        porcentajes[0] = (double) ((cuerda * 100)/total);
        porcentajes[1] = (double) ((viento * 100)/total);
        porcentajes[2] = (double) ((percusion * 100)/total);

        return porcentajes;
        //return porcentajeCuerda, porcentajeViento, porcentajePercusion;
    }

}
