
package DAM_2.psp.ut2.semaforoHilos;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        
        Semaphore sema = new Semaphore(5); //semáforo que permite que un máximo de 5 hilos utilicen a la vez la BD
       
        for(int i=1; i<=2;i++){
            new Escritor("Escritor " + i, sema).start(); //crea e inicia 2 hilos escritores
        }
           
        for(int i=1; i<=5;i++){
            new Lector("Lector " + i, sema).start(); //crea e inicia 5 hilos lectores     
        }
    }

}
