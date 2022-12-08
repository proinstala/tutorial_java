package DAM_2.psp.tareaUT2.ejercicio_2;


/**
 *
 * @author David Jimenez Alonso
 */
public class Animal extends Thread {
    
    //Campos de clase
    private Clinica clinica;
    private TIPO_ANIMAL tipoAnimal;

    
    /**
     * Crea un objeto de tipo animal.
     * 
     * @param nombre    Nombre del animal
     * @param clinica   Clinica veterinaria donde operan a los animales.
     * @param tipo      Tipo de animal(Gato o Perro)
     */
    public Animal(String nombre, Clinica clinica, TIPO_ANIMAL tipo) {
        super(nombre);
        this.clinica = clinica;
        this.tipoAnimal = tipo;
    }

    /**
     * Devuelve el tipo de animal(Gato o Perro).
     * @return Tipo de animal.
     */
    public TIPO_ANIMAL getTipoAnimal() {
        return tipoAnimal;
    }

    /**
     * Metodo para lanzar la ejecucion de un hilo de esta clase.
     */
    @Override
    public void run(){
        System.out.println(getName() + " llega a la clinca"); 
        clinica.accesoPreoperatorio(); //llamamos al metodo para acceder al preoperatorio.

        //Una vez que tenemos acceso al preoperatorio, simulamos el tiempo que el animal permanece en el preoperatorio.
        //Si el animal es un gato, domimos el hilo 3 segundo.
        //Si el animal es un perro, domimos el hilo 2 segundos.
        try {
            if(this.getTipoAnimal() == TIPO_ANIMAL.GATO) {
                Thread.sleep(3000);
            } else {
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
       
        clinica.salePreoperatorio(); //llamamos al metodo para indicar que el animal sale del preoperatorio y dejar el sitio libre.

        clinica.accesoQuirofano(); //llamamos al metodo para acceder al quirófano.

        //Una vez que tenemos acceso al quirófano, simulamos el tiempo que el animal permanece en el quirofano.
        //Si el animal es un gato, domimos el hilo 2 segundo.
        //Si el animal es un perro, domimos el hilo 1 segundos.
        try {
            if(this.getTipoAnimal() == TIPO_ANIMAL.GATO) {
                Thread.sleep(2000);
            } else {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        clinica.saleQuirofano(); //llamamos al metodo para indicar que el animal sale del quirófano y dejar el sitio libre.
    }

}
