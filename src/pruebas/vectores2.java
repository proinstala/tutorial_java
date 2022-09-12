package pruebas;

public class vectores2 {

    public static final String MENSAJE_NO_POSITIVO = "El numero NO puede ser negativo";

    public static void main(String[] args) {
        
        try {
            int numero = 20202;
            int[] miNumero = new int[cantidadCifras(numero)];
            miNumero = numeroDescompuesto(numero);
            if(esCapicua(miNumero)){
                System.out.println("Es capicua");
            }
            else{
                System.out.println("no es capicua");
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }//FIN MAIN.

    //Funcion que devuelve la cantida de cifras del numero pasado por parametro.
    public static int cantidadCifras(int numero){ 
        if(numero <= 0){
            throw new IllegalArgumentException(MENSAJE_NO_POSITIVO);
        }
        int contador = 0;
        while(numero > 0){
            numero = numero/10;
            contador++;
        }

        return contador;
    }


    //Funcion que devuelve el numero pasado por parametro, descompuesto por cada cifra en un array.
    public static int[] numeroDescompuesto(int numero){
        if(numero <= 0){
            throw new IllegalArgumentException(MENSAJE_NO_POSITIVO);
        }
        
        int[] salida = new int[cantidadCifras(numero)]; 
        int cont = 0;

        while(numero > 0){
            salida[salida.length - (cont + 1)] = numero%10;
            numero = numero/10;
            cont++;
            
        }

        return salida;
    }


    //Funcion que devuelve un true si el oreden de los numeros que contiene el array es capicua
    public static Boolean esCapicua(int[] numero){
        for (int i = 0; i < numero.length/2; i++) {
            if(numero[i] != numero[numero.length - (i +1)]){
                return false;
            }
        }

        return true;
    }


}//FIN CLASE.
