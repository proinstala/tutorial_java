
package DAM_2.psp.ut2.prioridadHilos;


public class Hilo extends Thread {

    public Hilo() {} //constructor por defecto

    public Hilo(int prioridad) { //Constructor con parametros
        this.setPriority(prioridad); //establece la prioridad indicada
    }

    @Override
    public void run() {

        String strCadena = "";

        //agrega 30000 caracteres a una cadena vacía
        for (int i = 0; i < 20000; ++i) {
            //imprime el valor en la Salida
            strCadena += "A";
            Hilo.yield(); //yield()sugiere al planficador Java que puede seleccionar otro hilo,       
        }

        System.out.println("Hilo de prioridad " + this.getPriority() + " termina ahora");
    }
}
