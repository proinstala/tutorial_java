package Examen_EV1_DAM1_verano;

public class OpcionException extends Exception{
    public static final String OPCION_INCORRECTA = "Esa opción no se encuentra en la lista";

    public OpcionException(){
        super(OPCION_INCORRECTA);
    };

    public OpcionException(String mensaje){
        super(mensaje);
    }
}
