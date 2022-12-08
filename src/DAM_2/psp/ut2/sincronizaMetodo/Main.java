
package DAM_2.psp.ut2.sincronizaMetodo;

public class Main {

    public static void main(String[] args) {

        ServidorWeb servidor = new ServidorWeb(); //crea un objeto ServidorWeb
        
        //Se crean cuatro hilos
        Hilo_Terminal hterminal1 = new Hilo_Terminal(servidor);
        Hilo_Terminal hterminal2 = new Hilo_Terminal(servidor);
        Hilo_Terminal hterminal3 = new Hilo_Terminal(servidor);
        Hilo_Terminal hterminal4 = new Hilo_Terminal(servidor);
        
        //se inician los cuatro hilos
        hterminal1.start();
        hterminal2.start();
        hterminal3.start();
        hterminal4.start();
        
    }
}
