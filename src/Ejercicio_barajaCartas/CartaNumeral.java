package Ejercicio_barajaCartas;

public class CartaNumeral extends CartaConPalo {
    
    private int numero;

    public CartaNumeral(int numero, Palo palo) {
        super(palo);
        this.numero = numero;
    }

    public void mostrar() {
        System.out.println(toString()); 
    }

    @Override
    public String toString() {
        return "CartaNumeral [palo=" + super.palo + " numero=" + numero + "]";
    }

    
}
