
package DAM_2.psp.ut2.sincronizaMetodo;

//clase derivada de Thread que define un hilo
public class Hilo_Terminal extends Thread {

    private ServidorWeb servidor;

    public Hilo_Terminal(ServidorWeb s) {
        this.servidor = s;
    }

    @Override
    public void run() { //método que incrementa la cuenta de accesos
        for (int i = 1; i <= 10; i++) {
            servidor.incrementaCuenta(); //se simulan 10 accesos
            Hilo_Terminal.yield();
        }       
    }
        
}
