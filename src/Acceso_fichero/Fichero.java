package Acceso_fichero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*  Usando la clase FileReader o FileWriter, lanzan una excepción si hay algun error.
    hay que capturar la excepcion bien en el propio metodo que creamos o en la llamada al metodo.
*/

//ruta relativa desde pc: src\\Acceso_fichero\\pildoras.txt
//ruta relativa desde portatil: tutorial_java\\src\\Acceso_fichero\\pildoras.txt

public class Fichero {
    
    public void leer1() throws IOException {
        FileReader entrada = new FileReader("src/Acceso_fichero/pildoras.txt"); //ruta relativa en pc
        int c=0;
        while(c != -1){
            c = entrada.read();     //guardamos el caracter en la variable c. se guarda su numero.
            char letra = (char)c;   //convertimos el numero a char
            System.out.print(letra);
        }
        entrada.close();
    }


    public void escribir1() throws IOException {
        //si elfichero no existe, lo crea.
        //añadiendo el segundo argumento (true) añadimos al fichero esistente la informacion.
        FileWriter archivo = new FileWriter("src\\Acceso_fichero\\pildoras.txt", true); //ruta relativa en pc
        String frase = "\nfrase de prueba";
        archivo.write(frase);
        archivo.close();
    }


    public void escribir2() throws IOException {
        //si no añadimos el segundo argumento(true) creara otra vez el archivo borrando el existente
        FileWriter fichero = new FileWriter("archivo_prueba.txt", true);   //ruta del archivo. si no existe lo crea. 
        PrintWriter escritor = new PrintWriter(fichero) ;
        
        escritor.println("Esto es una linea del fichero");
        escritor.println("segunda linea");
        fichero.close();
    }



    public void leerFicheroGrande() throws IOException {
        String linea;
        String fichero[];
        int posicion = 0;
        int numLineas=0;
        String ruta = "src\\Acceso_fichero\\ficheroGrande.txt";

        FileReader entrada1 = new FileReader(ruta);
        FileReader entrada2 = new FileReader(ruta);

        BufferedReader miBuffer1 = new BufferedReader(entrada1);
        BufferedReader miBuffer2 = new BufferedReader(entrada2);

        while ((linea = miBuffer1.readLine()) != null) { 
            //System.out.println(linea);  aqui podemos imprimir o guardar las lineas todas en un string.
            numLineas++;
        }
        fichero = new String[numLineas];

        while((linea = miBuffer2.readLine()) != null) {
            fichero[posicion] = linea;
            posicion++;
        }

        //una forma de imprimir el array
        /* 
        for (String s : fichero) {
            System.out.println(s);
        }
        */

        //imprimimos el array por consola
        for (int i = 0; i < fichero.length; i++) {
            System.out.println(i + "| " + fichero[i]);
        }

        miBuffer1.close();
        miBuffer1.close();
        entrada1.close();
        entrada2.close();
    }

}
