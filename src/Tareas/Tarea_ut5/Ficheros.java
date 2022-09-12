/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tareas.Tarea_ut5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import javax.sound.sampled.SourceDataLine;


public class Ficheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        /* fila - columna - contagiado */

        String datos[] ;
        
        /* Extraemos los datos del fichero a un vector de String*/
        String fichero = "src\\Tareas\\Tarea_ut5\\poblacion.txt";
        String linea;
        int posicion = 0;
        int numLineas=0;
        
        FileReader fr = new FileReader(fichero);
        FileReader fr2 = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        BufferedReader br2 = new BufferedReader(fr2);

        /* Leemos cuantas líneas tiene el fichero */

        while ((linea = br.readLine()) != null) {
           
            numLineas++;
        }
        
        /* Creamos el vector que almacena el texto leído del fichero */
        
        datos = new String[numLineas];
        
        /* Leemos las líneas y las almacenamos en el vector */
        
        while ((linea = br2.readLine()) != null) {
            datos[posicion] = linea;
            posicion++;
        }
        
        /* Se cierran todos los buffers */
        
        br.close();
        br2.close();
        fr.close();
        fr2.close();

        //System.out.println(Arrays.asList(datos)); //hecho por david

        //MI CODIGO --------------------------------------------------------------------------------------
        HashMap<String, String> mapa1 = new HashMap<String, String>();

        for(int i =0; i<datos.length;i++){
            String cad1 = datos[i];
            String nombre= cad1.substring(0, cad1.indexOf('\t'));
            String poblacion = cad1.substring(cad1.indexOf('\t'));
            System.out.println(nombre + "\t" + poblacion);
            mapa1.put(nombre, poblacion);
        }

        LinkedList<String> municipio = new LinkedList<String>();
        
        for(int i=0;i< mapa1.size();i++){
            //personas.add("pepe");
        }
}
}
