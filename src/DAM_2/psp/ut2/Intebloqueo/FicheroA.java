
package DAM_2.psp.ut2.Intebloqueo;

class FicheroA {

 /******************************************************************************
  *  métodoA: simula el acceso al ficheroA con exclusión mutua. Duerme al hilo y
  * después invoca al método que le permitirá o intentará el acceso al ficheroB
  */
  public synchronized void metodoA(FicheroB b) {
    String name = Thread.currentThread().getName();
    System.out.println("Hilo " + name + " entra en fichero_A"); //imprime en la salida el nombre del hilo que ejecuta el método

    try {
      Thread.sleep(1000);
    } catch (Exception e) {}

    System.out.println("Hilo " + name + " intentando acceder a fichero_B");
    b.metodoB(this);
  }

  public synchronized void syn2() {
    System.out.println("Dentro de A.syn2");
  }
}
