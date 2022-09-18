package Ejercicio_barajaCartas;

public class CartaJoker extends Carta {
    
    private boolean aColor;

    public CartaJoker(boolean aColor){
        super();
        this.aColor = aColor;
    }

    public void mostrar(){
        System.out.println(toString()); 
    }

    @Override
    public String toString() {
        return "CartaJoker [aColor=" + aColor + "]";
    }

    
}
