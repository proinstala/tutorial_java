package DAM_2.psp.tareaUT2.ejercicio_2;


/**
 * Clase que representa una clinica veterinaria.
 * @author David Jimenez Alonso
 */
public class Clinica {
    
    //Campos de clase.
    private int numAnimalesPreoperatorio = 0;   //Indica el numero de animales en preoperatorio.
    private int numPerrosOperacion = 0;         //Indica el numero de perros en quirófano.
    private int numeroGatosOperacion = 0;       //Indica el numero de gatos en quirófano.


    /**
     * Metodo sincronizado para controlar el acceso al preoperatorio.
     * A este metodo solo puede acceder un hilo a la vez.
     * Al preoperatorio pueden estar 3 animales a la vez.
     */
    public synchronized void accesoPreoperatorio(){
        
        //mandamos un mensaje indicando que el animal quiere entrar en el preoperatorio.
        System.out.println(Thread.currentThread().getName() + " quiere entrar en el preoperatorio" + "  || Animales en preoperatorio: " + numAnimalesPreoperatorio);
        
        //mientras que en el preoperatorio hayan 3 animales, dejamos a los hilos a la espera de que algun animal salga del preoperatorio.
        while(numAnimalesPreoperatorio >= 3) {
            try {
                System.out.println(Thread.currentThread().getName() + " esperando a entrar en preoperatorio");
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        //Si hay menos de tres animales en el preoperatorio, entra en el preoperatorio.
        numAnimalesPreoperatorio++; //aumentamos en 1 el numero de animales en el preoperatorio y mandamos un mensaje como que el animal esta en el preoperatorio.
        System.out.println(" --ENTRA en PREOPERATORIO " + Thread.currentThread().getName() + "  || Animales en preoperatorio: " + numAnimalesPreoperatorio);
    }


    /**
     * Metodo sincronizado para controlar la salida del preoperatorio.
     * A este metodo solo puede acceder un hilo a la vez.
     */
    public synchronized void salePreoperatorio(){

        numAnimalesPreoperatorio--; //descontamos 1 al contador de animales en preoperatorio y mandamos el mensaje de que salimos del preoperatorio.
        System.out.println(" --SALE del PREOPERATORIO " + Thread.currentThread().getName() + "  || Animales en preoperatorio: " + numAnimalesPreoperatorio);
        notifyAll(); //Notificamos a todos lo hilos que pueden reactivarse y comprobar si puden acceder al preoperatorio o seguir con su ejecución.
    }


    /**
     * Metodo sincronizado para controlar el acceso al quirófano.
     * A este metodo solo puede acceder un hilo a la vez.
     */
    public synchronized void accesoQuirofano(){

        //creo una instacia del animal que esta ejecutando el hilo para saber que tipo de animal es(Gato o Perro).
        Animal animal = ((Animal) Thread.currentThread()); 

        //Mandamos un mesaje de que que el animal quiere entrar en quirófano.
        System.out.println(animal.getName() + " quiere entrar en el quirófano" + "  || En quirofano(Gatos: " + numeroGatosOperacion + " | Perros: " + numPerrosOperacion + ")");
        
        
        if(animal.getTipoAnimal() == TIPO_ANIMAL.GATO) { //Si el animal es un gato.
           
            while(numeroGatosOperacion > 0 || numPerrosOperacion > 0){ //Si hay algun animal ya en quirofano, espera.
                System.out.println(animal.getName() + " esperando a entrar en quirófano");
                try {
                    wait(); //decimos al hilo que espere asta un nuevo mensaje de notificación de activación.
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            //si puede entrar al quirofano, aumenta en 1 el contador de gatos en quirofano.
            numeroGatosOperacion++;
        }

        if(animal.getTipoAnimal() == TIPO_ANIMAL.PERRO) { //Si el animal es un perro.
           
            while(numeroGatosOperacion > 0 || numPerrosOperacion >= 2){ //Si hay algun gato o 2 perros ya en quirofano, espera.
                System.out.println(animal.getName() + " esperando a entrar en quirófano");
                try {
                    wait(); //decimos al hilo que espere asta un nuevo mensaje de notificacion de activación..
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            //si puede entrar al quirofano, aumenta en 1 el contador de perros en quirofano.
            numPerrosOperacion++;
        }

        //Mandamos el mensaje de que el animal entra en quirófano.
        System.out.println(" --ENTRA en QUIRÓFANO " + animal.getName() + "  || En quirófano(Gatos: " + numeroGatosOperacion + " | Perros: " + numPerrosOperacion + ")");
    }


    /**
     * Metodo sincronizado para controlar la salida del quirófano.
     * A este metodo solo puede acceder un hilo a la vez.
     */
    public synchronized void saleQuirofano(){
        
        //creo una instacia del animal que esta ejecutando el hilo para saber que tipo de animal es(Gato o Perro).
        Animal animal = ((Animal) Thread.currentThread());

        if(animal.getTipoAnimal() == TIPO_ANIMAL.GATO) { //Si el animal es un gato.
            numeroGatosOperacion--; //Descuento uno al contador de gatos en quirófano.
        }

        if(animal.getTipoAnimal() == TIPO_ANIMAL.PERRO) { //Si el animal es un perro.
            numPerrosOperacion--; //Descuento uno al contador de perros en quirófano
        }
        
        //Mando el mensaje de que el animal sale del quirófano.
        System.out.println(" --SALE del QUIRÓFANO " + animal.getName() + "  || En quirofano(Gatos: " + numeroGatosOperacion + " | Perros: " + numPerrosOperacion + ")");
        notifyAll(); //Notificamos a todos lo hilos que pueden reactivarse y comprobar si puden acceder al quirófano o seguir con su ejecución.
    }

}
