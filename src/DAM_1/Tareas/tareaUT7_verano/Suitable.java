package DAM_1.Tareas.tareaUT7_verano;

public interface Suitable {
    
    public static final int PARCELA_LARGO = 10;
    public static final int PARCELA_ANCHO = 5;

    public abstract boolean cabeEnParcela(int alojamientoLargo, int AlojamientoAncho) throws AlojamientoInvalidoException;
}
