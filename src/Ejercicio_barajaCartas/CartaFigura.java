package Ejercicio_barajaCartas;

public class CartaFigura extends CartaConPalo{

    private char letra;

    public CartaFigura(char letra, Palo palo) {
        super(palo);
        this.letra = letra;
    }

    public void mostrar(){
        System.out.println(toString()); 
    }

    @Override
    public String toString() {
        return "CartaFigura [palo=" + super.palo + " letra=" + letra + "]";
    }
    
    
}
