package DAM_2.acceso_datos.TareaAD02_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TareaAD02_1 {

    public static final String ROJO = "\u001B[31m";
    public static final String CYAN = "\u001B[36m"; 
    public static final String BLANCO = "\u001B[37m";
    

    public static void main(String[] args) {
        
        int menu = 0;
        String ficheroBuscar;
        
        //En la tarea pide que el nombre del direcctorio padre sea david_jimenez. Adaptando el ejemplo a VScode he puesto de nombre aux_tareaAD02.
        File raiz = new File("src\\DAM_2\\acceso_datos\\TareaAD02_1\\aux_tareaAD02"); //Ruta que contiene todos los fihceros en los que se puede trabajar.
                
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Tarea para AD02 \n");
        
        do {
            try {
                System.out.println("");
                listarMain(raiz);
                System.out.print("Escribe el nombre del fichero para trabajar o salir para finalizar: ");
                ficheroBuscar = teclado.nextLine();
                if(ficheroBuscar.contentEquals("salir")){
                    System.out.println("Adios!!!!");
                    break;
                }

                System.out.println("fihero elegido: " + ficheroBuscar);
                File ficheroSeleccionado = buscarFichero(raiz, ficheroBuscar);
                if (ficheroSeleccionado == null){
                    System.out.println("El nombre del fichero insertado no coincide con ninguno dentro del directorio david_jimenez.");
                    continue;
                } else {
                    System.out.println("nombre del fichero seleccionado: " + ficheroSeleccionado.getName());
                    System.out.println("ruta absoluta de fichero seleccionado: " + ficheroSeleccionado.getAbsolutePath()); 
                }

                System.out.println("\nMenu de opciones: \n"
                        + "1. Listar todos los nombres de los archivos y directorios de un directorio \n" 
                        + "2. Conocer si un fichero es un archivo o un directorio \n" 
                        + "3. Mostrar los permisos que tiene un fichero: RWX \n"
                        + "4. Mostrar el tamaño de un fichero \n"
                        + "5. Mostrar la ruta canónica de un fichero \n"
                        + "6. Mostrar todos los ficheros que contienen una palabra \n"
                        + "7. Insertar una línea de texto dentro de un archivo \n"
                        + "8. Mostrar el contenido de un archivo \n"
                        + "9. Salir");

                System.out.print("Elige una opción: ");
                
                menu = teclado.nextInt();
                teclado.nextLine(); //para correjir error de entrada.

                switch(menu) {

                     //Listar todos los nombres de los archivos y directorios de un directorio.
                     case 1 -> {
                        if (ficheroSeleccionado.isDirectory()) {
                            System.out.println("\nHas elegido: Listar todos los nombres de los archivos y directorios de un directorio.");
                            String [] dir = ficheroSeleccionado.list();   //creamos un array de String con el nombre de los archivos en la ruta especificada.
                            System.out.println("vemos lo que hay dentro del directorio " + ficheroSeleccionado.getName() + ":");
                            if (dir.length > 0) {
                                for (String s : dir) {
                                System.out.println(s);
                            }
                            } else {
                                System.out.println("El directorio esta vacío!!!");
                            }
                            
                        } else {
                            System.out.println(ficheroSeleccionado.getName() + " NO es un directorio.");
                        }
                    }

                    //Conocer si un fichero es un archivo o un directorio.
                    case 2 -> {
                        System.out.println("\nHas elegido: Conocer si un fichero es un archivo o un directorio.");
                        if (ficheroSeleccionado.isDirectory()){
                            System.out.println(ficheroSeleccionado.getName() + " es un directorio");
                        }
                        if(ficheroSeleccionado.isFile()){
                            System.out.println(ficheroSeleccionado.getName() + " es un archivo");
                        }
                    }

                    //Mostrar los permisos que tiene un fichero: RWX.
                    case 3 -> {
                        System.out.println("\nHas elegido: Mostrar los permisos que tiene un fichero: RWX.");
                        String permisos = "";
                         
                        if (ficheroSeleccionado.canRead()){
                            permisos = "r";
                        } else {
                            permisos = "*";
                        }

                        if (ficheroSeleccionado.canWrite()) {
                            permisos = permisos.concat("w");
                        } else {
                            permisos = permisos.concat("*");
                        }

                        if (ficheroSeleccionado.canExecute()){
                            permisos = permisos.concat("x");
                        } else {
                            permisos = permisos.concat("*");
                        }

                        System.out.println("Los permisos de " + ficheroSeleccionado.getName() + " son: " + permisos);
                    }

                    //Mostrar el tamaño de un fichero.
                    case 4 -> {
                        System.out.println("\nHas elegido: Mostrar el tamaño de un fichero.");
                        System.out.println("El fichero " + ficheroSeleccionado.getName() + " tiene " + ficheroSeleccionado.length() + " bytes");
                    }

                    //Mostrar la ruta canónica de un fichero.
                    case 5 -> {
                        System.out.println("\nHas elegido: Mostrar la ruta canónica de un fichero.");
                        System.out.println("ruta canonica de " + ficheroSeleccionado.getName() + ": " + ficheroSeleccionado.getCanonicalPath());
                    }

                    //Mostrar todos los ficheros que contienen una palabra.
                    case 6 ->{
                        System.out.println("\nHas elegido: Mostrar todos los ficheros que contienen una palabra.");
                        System.out.print("¿Busacar en el directorio seleccionado(1) o en todos(cualquier tecla)?: ");
                        String aux = teclado.nextLine();
                        
                        System.out.print("Escribe la palabra: ");
                        String palabraFiltrado = teclado.nextLine();
                        FilenameFilter filtrado = new FilenameFilter() {
                            @Override
                            public boolean accept(File dir, String name) {
                                if(name.contains(palabraFiltrado)){
                                    return true;
                                }
                                return false;
                            }
                        };
                        
                        if (aux.contentEquals("1")){
                            if (ficheroSeleccionado.isDirectory()) {
                                System.out.println("Filtrado -----------------");
                                for(String s : ficheroSeleccionado.list(filtrado)){
                                    System.out.println(s);
                                }
                                System.out.println("---------------------------");
                            } else {
                                System.out.println(ficheroSeleccionado.getName() + " No es un directorio en el que poder buscar.");
                            } 
                  
                        }  else {
                            listarFiltrado(raiz, filtrado);
                        }
                    } 

                     //Insertar una línea de texto dentro de un archivo
                     case 7 -> {
                        System.out.println("\nHas elegido: Insertar una línea de texto dentro de un archivo.");
                        if (ficheroSeleccionado.isFile()) {
                            FileWriter archvio = new FileWriter(ficheroSeleccionado, true); //abro el stream. crea el fichero si no existe. 2 parametro es para agregar el texto al final.
                            PrintWriter pw = new PrintWriter(archvio) ;
                            System.out.print("Escribe el texto a insertar: ");
                            String lineaTexto = teclado.nextLine();
                            pw.println(lineaTexto); //escribo en el fihcero    
                            archvio.close();        //Cierro el stream
                            System.out.println("Linea insertada.");
                          
                        } else {
                            System.out.println(ficheroSeleccionado.getName() + " NO es un archivo.");
                        }
                    }

                    //Mostrar el contenido de un archivo.
                    case 8 -> {
                        System.out.println("\nHas elegido: Mostrar el contenido de un archivo.");
                        if (ficheroSeleccionado.isFile()) {
                            int numLineas = 0;
                            int posicion = 0;
                            String linea;
                            String ficheros[];
                            FileReader entrada1 = new FileReader(ficheroSeleccionado);
                            FileReader entrada2 = new FileReader(ficheroSeleccionado);

                            BufferedReader miBuffer1 = new BufferedReader(entrada1);
                            BufferedReader miBuffer2 = new BufferedReader(entrada2);

                            while ((linea = miBuffer1.readLine()) != null) { 
                                numLineas++;
                            }
                            ficheros = new String[numLineas];
                            
                            while((linea = miBuffer2.readLine()) != null) {
                                ficheros[posicion] = linea;
                                posicion++;
                            }
                            
                            if (numLineas > 0) {
                                System.out.println("El contenido de " + ficheroSeleccionado.getName() + " es:");
                                for (String s : ficheros) {
                                    System.out.println(s);
                                }
                            } else {
                                System.out.println("El archivo " + ficheroSeleccionado.getName() + " esta vacio.");
                            }
                            miBuffer1.close();
                            miBuffer2.close();
                            
                        } else {
                            System.out.println(ficheroSeleccionado.getName() + " NO es un archivo.");
                        }
                    } 

                    case 9 -> //Salir
                        System.out.println("\n Has elegido: Salir" + " Adios!!!!");

                    default -> System.out.println("\nDeves introducir un valor entre 1 y 9\n");
                }
            
            } catch (InputMismatchException e){
                System.out.println("\n" + ROJO + "-ERROR- El valor esperado no corresponde con el insertado" + BLANCO + "\n");
                teclado.nextLine();

            } catch (FileNotFoundException e) {
                System.out.println("\n" + ROJO + "-ERROR- ha ocurrido un error: " + e + BLANCO + "\n");

            } catch (IOException e){
                System.out.println("\n" + ROJO + "-ERROR- ha ocurrido un error al intentar hacer la operacion seleccionada: " + e + BLANCO + "\n");

            } catch (NullPointerException e) {
                System.out.println("\n " + ROJO + "-ERROR- ha ocurrido un error: " + e + BLANCO + "\n");

            } catch (Exception e) {
                System.out.println("\n" + ROJO + "-ERROR- ha ocurrido un error: " + e + BLANCO + "\n");
            }

        } while (menu != 9);
        teclado.close();

    }//Fin main

    //Metodo para listar todos los ficheros del directorio raiz (david_jimenez)
    public static void listarMain(File main) {
        System.out.println(CYAN + "Directorio: aux_tareaAD02 --------------------------");
        for (File nivel1 : main.listFiles()) {
            System.out.println(nivel1.getName());
            if(nivel1.isDirectory()) {
                for (File nivel2 : nivel1.listFiles()) {
                    System.out.println("\t" + nivel2.getName());
                    if(nivel2.isDirectory()) {
                        for (File nivel3 : nivel2.listFiles()) {
                            System.out.println("\t \t" + nivel3.getName());
                        }
                    }
                    
                }
            }
        }
        System.out.println("----------------------------------------------------" + BLANCO);
    }


    //Metodo que devuelve la ruta del fichero que se pasa el nombre como parametro
    public static File buscarFichero(File main, String nombre) {
        String encontrado;
        for(File nivel1 : main.listFiles()) {
            if (nombre.equals(nivel1.getName())) {
                encontrado = nivel1.getAbsolutePath();
                return new File(encontrado);
            }
            
            if (nivel1.isDirectory()) {
                for(File nivel2 : nivel1.listFiles()){
                    if (nombre.equals(nivel2.getName())) {
                        encontrado = nivel2.getAbsolutePath();
                        return new File(encontrado);
                    }
                    
                    if (nivel2.isDirectory()) {
                        for(File nivel3 : nivel2.listFiles()) {
                            if (nombre.equals(nivel3.getName())){
                                encontrado = nivel3.getAbsolutePath();
                                return new File(encontrado);
                            }
                            
                        }
                        
                    }
                        
                }
            
            }
        
        }
        
        return null;
    }


    //Metodo que lista todos los ficheros dentro del directorio aux_tareaAD02 filtrando con el objeto filtro.
    public static void listarFiltrado(File main, FilenameFilter filtro){
        System.out.println("Filtrado -----------------");
        for(String s : main.list(filtro)){
            System.out.println(s);
        }
        
        for(File nivel1 : main.listFiles()){
            if (nivel1.isDirectory()){
                for(String s : nivel1.list(filtro)){
                    System.out.println(s);
                }
                for(File nivel2 : nivel1.listFiles()){
                    if (nivel2.isDirectory()){
                        for(String s : nivel2.list(filtro)){
                            System.out.println(s);
                        }
                    }
                        
                }
            
            }
        
        }
        
        System.out.println("------------------------- ");
    }

}//fin clase TareaAD02_1
