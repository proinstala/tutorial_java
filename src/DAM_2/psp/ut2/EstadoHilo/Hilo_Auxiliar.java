
package DAM_2.psp.ut2.EstadoHilo;

public class Hilo_Auxiliar extends Thread {

  @Override
  public void run(){  
    for(int i=10;i>=1;i--)
      System.out.print(i+",");
  }


}
