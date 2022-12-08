
package DAM_2.psp.ut2.sincronizaSegmentoJardines;

//clase derivada de Thread que define un hilo
public class Sale_Jardin extends Thread {

    private RecursoJardin jardin;

    public Sale_Jardin(String nombre, RecursoJardin j) {
        this.setName(nombre);
        this.jardin = j;
    }

    @Override
    public void run() {
        synchronized (jardin) {//segmento sincronizado
            jardin.decrementaCuenta(); //invoca al método que decrementa la cuenta de accesos al jardín
        }
    }
}
