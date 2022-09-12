package Ejercicio_barajaCartas;

public enum Palo {
    DIAMANTE(Color.ROJO),
    CORAZON(Color.ROJO),
    PICA(Color.NEGRO),
    TREBOL(Color.NEGRO);

    private Color color;

    private Palo(Color c){
        this.color = c;
    }

}
