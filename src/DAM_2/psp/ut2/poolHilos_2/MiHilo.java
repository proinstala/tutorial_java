package DAM_2.psp.ut2.poolHilos_2;


//Clase que implementa el interfaz Runnable y que representa a un hilo que realiza una determinada tarea mediante su método run().

public class MiHilo implements Runnable {
    
    int id;
    
    public MiHilo(int pId) {
        this.id = pId;
    }
    
    @Override
    public void run() { //Cada hilo imprime un mensaje y espera un tiempo aleatorio.
        
        System.out.println("El hilo " + this.id + " coge el pool " + Thread.currentThread().getName()); // Mostramos un mensaje indicando el nombre del hilo
        
        // Bloqueamos el hilo un tiempo aleatorio
        try {
            Thread.sleep((int)(Math.random()*200+100));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("El hilo " + this.id + " deja el pool " + Thread.currentThread().getName());  // Mensaje indicando que va a dejar el pool
    }
    
}
