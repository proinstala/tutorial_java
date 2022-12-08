
package DAM_2.psp.ut2.manejoExcepiones;

public class Main {
  
  public static void main(String[] args) {

    //se crean 5 hilos
    Hilo hilo1=new Hilo("hilo1");
    Hilo hilo2=new Hilo("hilo2");
    Hilo hilo3=new Hilo("hilo3");
    Hilo hilo4=new Hilo("hilo4");
    Hilo hilo5=new Hilo("hilo5");
       
    ManejadorExcepciones manejador=new ManejadorExcepciones(); //se crea el manejador
    
    //se asocia a cada hilo el manejador de excepciones creado
    hilo1.setUncaughtExceptionHandler(manejador);
    hilo2.setUncaughtExceptionHandler(manejador);
    hilo3.setUncaughtExceptionHandler(manejador);
    hilo4.setUncaughtExceptionHandler(manejador);
    hilo5.setUncaughtExceptionHandler(manejador);
      
    //se inician los hilos
    hilo1.start();
    hilo2.start();
    hilo3.start();
    hilo4.start();
    hilo5.start();
    
    }

}
