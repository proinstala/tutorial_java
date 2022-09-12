package Tareas.tareaUT7_verano;

public class AlojamientoInvalidoException extends Exception {
    
    public static final String MENSAJE = "El alojamiento no cabe en la parcela.";

    public AlojamientoInvalidoException(){}

    public AlojamientoInvalidoException(String msjError){
        super(msjError);
    }

}
