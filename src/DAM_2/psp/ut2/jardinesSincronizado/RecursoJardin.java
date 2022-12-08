
package DAM_2.psp.ut2.jardinesSincronizado;

//clase que simula las entradas y las salidas al Jardín
public class RecursoJardin {

    private int cuenta; //para contar las entradas y salidas al Jardín

    public RecursoJardin() {
        cuenta = 100; //inicalmente hay 100 personas en le jardín
    }

    //método que increamenta en 1 la varibale cuenta
    public synchronized void incrementaCuenta() {
        System.out.println("hilo " + Thread.currentThread().getName() + "----- Entra en Jardín"); //muestra el hilo que entra en el método
        cuenta++;
        System.out.println(cuenta + " en jardín"); //cuenta cada acceso al jardín y muestra el número de accesos
    }

    //método que decrementa en 1 la varibale cuenta
    public synchronized void  decrementaCuenta() {
        System.out.println("hilo " + Thread.currentThread().getName() + "----- Sale de Jardín"); //muestra el hilo que sale en el método
        cuenta--;
        System.out.println(cuenta + " en jardín"); //cuenta cada acceso al jardín y muestra el número de accesos
    }
}
