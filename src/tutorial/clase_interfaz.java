package tutorial;

//Interfaz

/*
- Los metodos de una interfaz tiene que ser siempre publicos y abstractos
- Si no ponemos el modificador de acceso public abstract, la interfaz los pone por defecto. El metodo siempre es publico y abstracto
- Por convención, no se pone el modificador public abstrac en la declaracion del metodo.
- En las interfaces no hay variables, hay constantes y todas llevan el modificador de acceso public static final. La interfaz los pone por defecto.
*/

public interface clase_interfaz {
    //Esta interfaz de sonidos de animales se podria llamar SonidoAnimal

    //declaramos las constantes. No es necesario poner el modificador de acceso public static final
    public static final String PERRO = "waauuu";
    public static final String BACA = "muuuuu";

    public abstract String sonido();
}
