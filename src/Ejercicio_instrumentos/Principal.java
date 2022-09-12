package Ejercicio_instrumentos;

public class Principal {
    public static void main(String[] args) {

        

        Fabrica f = new Fabrica();
        cargarFabrica(f);
        f.listaInstrumentos();
        //System.out.println(f.instrumentosPorTipo(TIPO_INSTRUMENTO.VIENTO)); 
        //System.out.println("borrar instrumento: " + f.borrarInstrumento("8"));
        //f.listaInstrumentos();

        double[] porc = f.porcInstrumentosPorTipo("Sucursal A");
        System.out.println("porcentajes. cuerda: " + porc[0] + "  viento: " + porc[1] + "  percusion: " + porc[2]);
       

    }

    public static void cargarFabrica(Fabrica f){
        Sucursal s1 = new Sucursal("Sucursal A");
        Sucursal s2 = new Sucursal("Sucursal B");

        s1.agregarInstrumentos(new Instrumento("01", 20.0, TIPO_INSTRUMENTO.CUERDA));
        s1.agregarInstrumentos(new Instrumento("02", 30.5, TIPO_INSTRUMENTO.PERCUSION));
        s1.agregarInstrumentos(new Instrumento("03", 65.7, TIPO_INSTRUMENTO.VIENTO));
        s1.agregarInstrumentos(new Instrumento("07", 99.9, TIPO_INSTRUMENTO.VIENTO));
        //s1.agregarInstrumentos(new Instrumento("08", 36.4, TIPO_INSTRUMENTO.VIENTO));

        s2.agregarInstrumentos(new Instrumento("04", 27.0, TIPO_INSTRUMENTO.CUERDA));
        s2.agregarInstrumentos(new Instrumento("05", 87.5, TIPO_INSTRUMENTO.PERCUSION));
        s2.agregarInstrumentos(new Instrumento("06", 69.7, TIPO_INSTRUMENTO.VIENTO));

        f.agregarSucursal(s1);
        f.agregarSucursal(s2);

    }
}
