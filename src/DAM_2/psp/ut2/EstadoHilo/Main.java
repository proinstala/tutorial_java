package DAM_2.psp.ut2.EstadoHilo;

public class Main {

    public static void main(String[] args) {
        
        Hilo_Auxiliar hilo1 = new Hilo_Auxiliar(); //Crea un nuevo hilo. El hilo está en estado Nuevo (new)
        
        //Obtenemos el estado del thread hilo1 y si está vivo o no
        System.out.println("Hilo Auxiliar Nuevo: Estado=" + hilo1.getState() + ", isAlive()=" + hilo1.isAlive());
        
        hilo1.start(); //Inicia el thread hilo1 y pasa al estado Ejecutable
        
        System.out.println("Hilo Auxiliar Iniciado: Estado=" + hilo1.getState() + ", isAlive()=" + hilo1.isAlive() + "\n");
       
        try {
            hilo1.join(); //espera a que el thread hilo1 muera
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("\n Hilo Auxiliar Muerto: Estado=" + hilo1.getState() + ", isAlive()=" + hilo1.isAlive());
    }
}
