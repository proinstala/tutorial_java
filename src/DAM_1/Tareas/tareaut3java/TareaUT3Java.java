/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM_1.Tareas.tareaut3java;

import java.util.Scanner;

/**
 *
 * @author PROFESOR PROGRAMACIÓN
 */
public class TareaUT3Java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        /* Estas son las variables que debes usar en el programa. Es posible que necesites crear más. */
        
        Domicilio pri, seg;
        Persona p1, p2, p3, pPruebaEquals;
        
        /* 1. Solicita por teclado toda la información acerca de un domicilio. 
        Asigna toda la información a la variable pri haciendo uso del constructor */
        
        
        /* 2. Solicita por teclado toda la información acerca de otro domicilio.
        Asigna toda la información a la variable seg haciendo uso de los métodos setters.
        */
        
        /* 3. Muestra toda la información de la variable pri usando los métodos getters */
        
        
        /* 4. Crea tres objetos de tipo Persona que sean diferentes. 
        No pidas información por teclado, simplemente 
        asignale los valores desde en editor de textos. */
        
        /* 5.  Asigna a p1, p2 y p3 como primera residencia pri y como segunda residencia seg */
        
        /* 6. Usando el constructor de copia de la clase Persona, guarda en pPruebaEquals una copia de p1 */
        
        /* 7. Comprueba si p1 y p2 son la misma persona */
        
        /* 8. Comprueba si p1 y pPruebaEquals son la misma persona */
        
        /* 9. Muestra usando el método toString toda la información de p1 */
        
        /* 10. Muestra usando el método toString toda la información del domicilio pri */
        
        Scanner teclado = new Scanner(System.in);


        //EJERCICIO 1 ------------------------------------
        String calle;
        int numero;
        int piso;
        char letra;

        System.out.println("EJERCICIO 1");
        System.out.print("Introduce el nombre de la calle: ");
        calle = teclado.nextLine();

        System.out.print("Introduce el número del domicilio: ");
        numero = teclado.nextInt();

        System.out.print("Introduce el número de planta: ");
        piso = teclado.nextInt();

        System. out.print("Introduce la letra del domicilio: ");
        letra = teclado.next().charAt(0);

        pri = new Domicilio(calle, numero, piso, letra);
    

        //EJERCICIO 2 ------------------------------------
        System.out.println("\nEJERCICIO 2");
        seg = new Domicilio();

        System.out.print("Introduce el nombre de la calle: ");
        seg.setCalle(teclado.next());

        System.out.print("Introduce el número del domicilio: ");
        seg.setNumero(teclado.nextInt());

        System.out.print("Introduce el número de planta: ");
        seg.setPiso(teclado.nextInt());

        System. out.print("Introduce la letra del domicilio: ");
        seg.setLetra(teclado.next().charAt(0));


        //EJERCICIO 3 ------------------------------------
        System.out.println("\nObtencion de datos por metos getter de domicilio pri: ");
        System.out.println("Datos domicilio pri\n");
        System.out.println("Nombre de calle: " + pri.getCalle());
        System.out.println("Número de domicilio: " + pri.getNumero());
        System.out.println("Número de piso: " + pri.getPiso());
        System.out.println("Letra de piso: " + pri.getLetra());


        //EJERCICIO 4 ------------------------------------
        p1 = new Persona("David", "Jimenez", "Alonso", "48506163Z", "09-01-1986", Sexo.HOMBRE, "david@gmail.com");
        p2 = new Persona("Beatriz", "Navarro", "Sanchez", "49506163B", "21-04-2000", Sexo.MUJER, "beatriz@gmail.com");
        p3 = new Persona("Lucia", "jimenez", "Navarro ", "50506163L", "16-11-2017", Sexo.MUJER, "lucia@gmail.com");
        
        
        //EJERCICIO 5 ------------------------------------
        p1.setPrimeraResidencia(pri);
        p1.setSegundaResidencia(seg);

        p2.setPrimeraResidencia(pri);
        p2.setSegundaResidencia(seg);

        p3.setPrimeraResidencia(pri);
        p3.setSegundaResidencia(seg);
        

        //EJERCICIO 6 ------------------------------------
        pPruebaEquals = new Persona(p1);


        //EJERCICIO 7 ------------------------------------
        System.out.print("\nComprobación si p1 es igual a p2: ");
        System.out.println(p1.equals(p2));


        //EJERCICIO 8 ------------------------------------
        System.out.print("\nComprobación si p1 es igual a pPruebaEquals: ");
        System.out.println(p1.equals(pPruebaEquals));


        //EJERCICIO 9 ------------------------------------
        System.out.println("\nInformacion de persona p1:");
        System.out.println(p1);


        //EJERCICIO 10 ------------------------------------
        System.out.println("\nInformacion de domicilio pri:");
        System.out.println(pri);


        System.out.println("\n---FIN-------");
    }
    
}
