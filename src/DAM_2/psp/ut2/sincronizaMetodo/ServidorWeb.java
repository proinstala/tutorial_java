
package DAM_2.psp.ut2.sincronizaMetodo;

//clase que simula los accesos a un servidor
public class ServidorWeb {
    
    private int numeroAccesos;

    public ServidorWeb() {
        numeroAccesos = 0;
    }

    //método sincronizado (monitor)
    public synchronized void  incrementaCuenta() {
        System.out.println("hilo " + Thread.currentThread().getName() + "----- Entra en Servidor"); //muestra le hilo que entra en el método
        numeroAccesos++;
        System.out.println(numeroAccesos + " accesos"); //cuenta cada acceso al servidor y muestra el número de accesos
        
    }
}
