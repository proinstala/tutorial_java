package Acceso_fichero;

import java.io.*;



public class MiStream {


    /**
     * Copiar el archivo del que se le pasa la ruta.
     * 
     * @param ruta La ruta del archivo a copiar
     * @return Un array con los datos del archivo copiado.
     */
    public int[] copiarDatos(File ruta){
        File imagen1 = new File("another.jpg");
        int contador = 0;
        int pesoImagen1 = (int) imagen1.length();
        int datosAlmacenados[] = new int[pesoImagen1];

        try { 
            FileInputStream flujoEntrada = new FileInputStream(imagen1);
            boolean fin = false;

            while (!fin) {
                int byte_entrada = flujoEntrada.read(); //devuelve el siguiente byte del dato o -1 si se llega al final del archivo.

                if (byte_entrada != -1) { //si no es -1
                    datosAlmacenados[contador] = byte_entrada; //guarda el byte en el array 
                    contador++;
                
                } else {
                    fin = true; //si devuelve -1 salimos del bucle while   
                }

                //System.out.println(byte_entrada);
            }
           
            flujoEntrada.close();
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return datosAlmacenados; //devuelve un array con los datos almacenados

    } //Fin copiarDatos


    /**
     * Crea un fichero nuevo a partir de los datos pasados por parametros
     * 
     * @param datos Array con los datos del archivo a crear
     * @param ruta  Ruta donde se va ha crear el fichero
     */
    public void volcarDatos(int datos[], String ruta){  
        if(ruta == null){
            ruta = "nuevo_archivo";
        }

        try {
            FileOutputStream fichero_nuevo = new FileOutputStream("another_copia.jpg"); //creamos el Stream de salida de datos con el nombre y ruta donde se va crear el archivo nuevo.
            for (int i = 0; i < datos.length; i++) {
                fichero_nuevo.write(datos[i]); //Escribe el dato i de la matriz en este flujo de salida de archivo.
            }
            fichero_nuevo.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
