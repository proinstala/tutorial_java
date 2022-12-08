
package DAM_2.psp.ut2.Intebloqueo;

class FicheroB  {

  /****************************************************************************
   métodoB: simula el acceso al ficheroB con exclusión mutua. Duerme al hilo y
   * después invoca al método que le permitirá o intentará el acceso al ficheroA
   */

  public synchronized void metodoB(FicheroA a) {
    String name = Thread.currentThread().getName();
    System.out.println("Hilo " + name + " entra en fichero_B");  //imprime en la salida el nombre del hilo que ejecuta el método

    try {
      Thread.sleep(1000); //lo duerme durante 1s
    } catch (Exception e) {}
    
    System.out.println("Hilo " + name + " intentando entrar en fichero_A"); //imprime en la Salida el intento de llamada al método metodoA() del objeto a
    a.metodoA(this);
  }
}
  
 