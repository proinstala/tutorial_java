package Ejercicio_barajaCartas;

public abstract class CartaConPalo extends Carta {
    
    protected Palo palo;

    protected CartaConPalo(Palo palo) {
        super();
        this.palo = palo;
    }

    public abstract void mostrar();

}
