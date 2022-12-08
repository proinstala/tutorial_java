
package DAM_2.psp.ut2.semaforoRecurso;

public class HiloEjemploSemaforo extends Thread {
    
    private Recurso r;
    
    public HiloEjemploSemaforo(Recurso pRecurso) {
        this.r = pRecurso;
    }
    
    @Override
    public void run() {
       r.lock();
    }
}
