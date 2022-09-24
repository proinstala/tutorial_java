package tutorial;

import java.util.*;
/*
Los datos de tipo enumerados son constantes.
Se suele usar cuando tienes unas constantes que estan relacionadas.
Se puede crear una clase con un enumeral con constructor y metods getter.
Los valores en mayúsculas se definen como "Constantes enumeradas". No son Arrays.

METODOS:
    .ordinal()  = devuelve la posicion del enumerado en la lista de enumerados empezando por 0. ejemplo: Talla.MEDIANA.ordinal();
    .toString() = devuelve el enumerado en forma de texto. ejemplo: Talla.MEDIANA.toString();

*/

public class clase_enum {

    enum Talla {PEQUEÑA, MEDIANA, GRANDE, MUY_GRANDE};



    enum Nota{
        DO("C"), RE("D"), MI("E"), FA("F"), SOL("G"), LA("A"), SI("B");
        private String acorde;
        private Nota(String acorde){ //constructor de enum. Solo puede ser privado
            this.acorde = acorde;
        }

        public String getAcorde(){ //GETTER
            return acorde;
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);


        System.out.println("EJEMPLO 1 -------------------------------"); //EJEMPLO 1 ------------------------------------------------------------------

        Talla s = Talla.PEQUEÑA;
        Talla m = Talla.MEDIANA;
        Talla l = Talla.GRANDE;
        Talla xl = Talla.MUY_GRANDE;
        
        System.out.println(m);




        System.out.println("\nEJEMPLO 2 -------------------------------"); //EJEMPLO 2 ------------------------------------------------------------------

        //Guardar los valores de un enumerado en un arrayList().

        Talla[] tallas = Talla.values();
        for (int i = 0; i < tallas.length; i++) {
            System.out.println(i+ ") " + tallas[i]);
        }




        System.out.println("\nEJEMPLO 3 -------------------------------"); //EJEMPLO 3 ------------------------------------------------------------------

        int posicion = Nota.RE.ordinal();

        System.out.println("posicion de RE: " + (posicion+=1)); //imprime la posicion de RE en enumerado Nota. le sumamos 1 por que empieza en 0

        System.out.print("Escribe una nota: ");
        String entrada_datos = entrada.nextLine().toUpperCase(); //guardamos los datos introducidos por consola y pasamos a mayusculas.

        Nota notas_musicales = Enum.valueOf(Nota.class, entrada_datos); //parametro 1: Clase | parametro 2: dato a procesar

        System.out.print("Nota: " + notas_musicales);
        System.out.println("  |  Nombre Americano: " + notas_musicales.getAcorde());

        entrada.close();
    }
}
