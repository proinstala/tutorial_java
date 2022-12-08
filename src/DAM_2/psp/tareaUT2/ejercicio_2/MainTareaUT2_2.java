package DAM_2.psp.tareaUT2.ejercicio_2;


/**
 * En este programa vamos a simular la llegada de 2 gatos y cinco perros a una clinica veterinaria
 * para que sean operados. Se va a controlar la ejecucion de los hilos de cada animal para 
 * respetar las condiciones de entrada al peroperatorio y al quirófano.
 * 
 * @author David Jimenez Alonso
 */
public class MainTareaUT2_2 {
    public static void main(String[] args) {

        Clinica clinica = new Clinica(); //Creo una instancia del objeto clinica para pasarsela a todos los hilos.
        
        //Creo las instancias de los gatos y perros
        Animal gato1 = new Animal("gato 1", clinica, TIPO_ANIMAL.GATO); 
        Animal gato2 = new Animal("gato 2", clinica, TIPO_ANIMAL.GATO);
        
        Animal perro1 = new Animal("perro 1", clinica, TIPO_ANIMAL.PERRO);
        Animal perro2 = new Animal("perro 2", clinica, TIPO_ANIMAL.PERRO);
        Animal perro3 = new Animal("perro 3", clinica, TIPO_ANIMAL.PERRO);
        Animal perro4 = new Animal("perro 4", clinica, TIPO_ANIMAL.PERRO);
        Animal perro5 = new Animal("perro 5", clinica, TIPO_ANIMAL.PERRO);

        //Asigno las prioridades a cada hilo
        gato1.setPriority(Thread.MIN_PRIORITY); //Se da minima prioridad (1)
        gato2.setPriority(Thread.MAX_PRIORITY); //Se da maxima prioridad (10)

        perro1.setPriority(Thread.MIN_PRIORITY);
        perro2.setPriority(Thread.MIN_PRIORITY);
        perro3.setPriority(Thread.MAX_PRIORITY);
        perro4.setPriority(Thread.MIN_PRIORITY);
        perro5.setPriority(Thread.MIN_PRIORITY);

        
        //Inicio los hilos llamando al metod start().
        gato1.start(); 
        gato2.start();

        perro1.start();
        perro2.start();
        perro3.start();
        perro4.start();
        perro5.start();
    }
}
