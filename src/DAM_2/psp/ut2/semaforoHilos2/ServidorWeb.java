
package DAM_2.psp.ut2.semaforoHilos2;

//clase que simula los accesos a un servidor
public class ServidorWeb {

    private int cuenta;

    public ServidorWeb() {
        cuenta = 0;
    }

    public void  incrementaCuenta() {  //método sincronizado (monitor)
       
        System.out.println("hilo " + Thread.currentThread().getName() + "----- Entra en Servidor"); //muestra el hilo que entra en el Servidor.Para probar funcionamiento
        cuenta++; //se incrementa la cuenta de accesos
        System.out.println(cuenta + " accesos"); //muestra el número de accesos. Para probar funcionamiento
       
    }
}
