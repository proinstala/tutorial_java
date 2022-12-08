
package DAM_2.psp.ut2.Intebloqueo;

public class Hilo2 extends Thread {

  //Declara dos objetos del tipos de cada fichero
  FicheroA a;
  FicheroB b;

  /****************************************************************************
   * constructor
   * 
   * @param a: ficheroA
   * @param b: ficheroB
   */
  Hilo2(FicheroA a, FicheroB b) {
    this.a = a;
    this.b = b;
  }

  /******************************************************************************
   * Tarea del hilo: acceder al ficheroB
   */
  @Override
  public void run() {
    b.metodoB(a); //el hilo accede al ficheroB.
    
  }
}
