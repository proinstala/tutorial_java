
package DAM_2.psp.ut2.sincronizaSegmentoJardines;

public class Main {

    public static void main(String[] args) {

        RecursoJardin jardin = new RecursoJardin(); //crea un objeto RecursoJardín
        
        for (int i = 1; i <= 10; i++) { //crea e inicia 10 hilos que simulan entrada al jardín
            (new Entra_Jardin(i + " Entra ", jardin)).start(); 
        }

        for (int i = 1; i <= 15; i++) { //crea e inicia 15 hilos que simulan salida del jardín
            (new Sale_Jardin(i + " Sale ", jardin)).start();
        }
    }
}

