package tutorial;

import java.util.ArrayList;

public class colecciones {
    public static void main(String[] args) {
        

        //EJEMPLO 1 --------------------------------------------------------------------------------------
        System.out.println("EJEMPLO 1 --------------------------------------------------------------------");
        ArrayList<String> MiArrayList = new ArrayList<>(); //instanciamos ArrayList<>()

        MiArrayList.add("Pablo"); //añade el string "Pablo" a miArrayList
        MiArrayList.add("Juan");
        MiArrayList.add("David");

        for(int i=0; i<MiArrayList.size(); i++){
            String aux = MiArrayList.get(i); //obtiene el objeto que esta en la posicion 'i' de miArrayList
            System.out.println(aux);
        }

        //EJEMPLO 2 --------------------------------------------------------------------------------------
        System.out.println("\nEJEMPLO 2 --------------------------------------------------------------------");
        ArrayList<Integer> lista_enteros = new ArrayList<>();

        lista_enteros.add(1);
        lista_enteros.add(3);
        lista_enteros.add(2);

        for (int i : lista_enteros) {
            System.out.println("numero: " + i);
        }
    }
}
