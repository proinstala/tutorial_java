package tutorial;

public class cadenas_builder {
    public static void main(String[] args) {
        
        /*
        reverse()           - da la vuelta a la cadena
        append(cadena)      - inserta un carater o cadena al final de la cadena.
        insert(pos, cadena) - inserta un caracter o cadena en la posicion especificada.
        delete(inicio, final)         - elimina los caracteres que se encuentran en el rango especificado.
        replace(inici, final, cadena) - reemplaza ls caracteres que se encuentran en entre la posicion indicada por el caracter o cadena que se pasa por agumento.
        */

        //cremaos un objeto de tipo StringBuilder
        StringBuilder cad1 = new StringBuilder("hoal muuundo");
        System.out.println(cad1);

        //eliminamos 2 u de la cadena
        System.out.println("\nDELETE ----------------");
        cad1.delete(6, 8);
        System.out.println(cad1);

        //añadimos al final de la cadena el simbolo de exclamación
        System.out.println("\nAPPEND ----------------");
        cad1.append("!");
        System.out.println(cad1);

        //insertamos en la posicion 0 de la cadena el simbolo de exclamación
        System.out.println("\nINSERT ----------------");
        cad1.insert(0, "¡");
        System.out.println(cad1);

        //reemplazamos los carateres 'al' por 'la'
        System.out.println("\nREMPLACE ----------------");
        cad1.replace(3, 5, "la");
        System.out.println(cad1);

        //da la vuelta a la cadena
        System.out.println("\nREVERSE ----------------");
        cad1.reverse();
        System.out.println(cad1);
    }
}
