package tutorial;

import java.io.*;

//IllegalArgumentException  - El argunmento pasado no se corresponde con el esperado.
//NumberFormatException     - Salta cuando da error al convertir una cadena a un numero.
//InputMismatchException    - Salta si el formato que se introduce no es el esperado.
//ArithmeticException       - salta al intetar hacer una operacion que no se puede hacer. dividir por 0.
//IOException               - salta cuando se produce un error en la entrada/salida.
//ArrayIndexOutOfBoundsException - salta cuando intentamos ver o editar una posicion que excede del tamaño del array

//Nota: el finally siempre se ejecuta pero no es necesario pornerlo si no se requiere.

public class excepciones_1 {
    public static void main(String[] args) {
        
        int numero=-1;
        int intentos=0;
        String linea;
        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        do{
            try{
                System.out.print("Introduzca un número entre 0 y 100: ");
                linea = teclado.readLine();
                numero = Integer.parseInt(linea);
                lanzaExcepcion(numero); //metodo para lanzar mi excepcion
                
            }catch(IOException e){
                System.out.println("Error al leer del teclado.");
                
            }catch(NumberFormatException e){ //Salta cuando da error al convertir una cadena a un numero
                System.out.println("Debe introducir un número entre 0 y 100.");

            }catch(Mi_excepcion e){
                System.out.println("no debes introducir ese numero");
                e.printStackTrace(); //con esta instruccion nos imprime la pila de llamada
             
            }finally{ //siempre se ejecuta
                intentos++;
            }
        }while (numero < 0 || numero > 100);
        
        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);
    }

    //metodo para lanzar la excepcion creada por mi
    static void lanzaExcepcion(int numero) throws Mi_excepcion{
        if(numero == 666){
            throw new Mi_excepcion(Mi_excepcion.NUMERO_MALDITO);
        }
        
    }



    /*
    -CREACION DE UNA EXCEPCION PROPIA.-
    Creamos una clase con el nombre que queramos darle a nuestra excepcion.
    Hay que heredar de la clase Exception o de la clase IOException.
    Si heredamos de estas clases tenemos que meter nuestro codigo en un try catch.

    Podemos heredar de la clase RuntimeException si no queremos que nos obligue a meter nuestra excepcion en un bloque try catch.
    Esta clase de excepciones son excepciones no controladas.

    NOTA: Hay que importar la clase heredada.
    */
    //esta clase es estatica porque la tengo construida dentro de otra clase y la estoy utilizando.
    static class Mi_excepcion extends Exception{ 
        
        public static final String NUMERO_MALDITO = "El numero 666 no se debe introducir";
        
        //Constructor sin parametros
        public Mi_excepcion(){}

        //Constructor con parametros
        public Mi_excepcion(String msj_error){
            super(msj_error);
        }

    }
}
