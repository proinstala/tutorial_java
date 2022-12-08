
package DAM_2.psp.ut2.jardinesSincronizado;


public class Main {

    public static void main(String[] args) {

        RecursoJardin jardin = new RecursoJardin(); //crea un objeto RecursoJardín
        
        for (int i = 1; i <= 10; i++) { //entrada de 10 hilos al jardín
            (new Entra_Jardin(i +" Entra ", jardin)).start();
        }

        for (int i = 1; i <= 15; i++) { //salida de 15 hilos al jardín
            (new Sale_Jardin(i + " Sale ", jardin)).start();
        }
    }
}

