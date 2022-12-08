/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAM_1.UT5_DAW;

import java.util.Scanner;

/**
 *
 * @author lucasjosemoraleschacon
 */
public class Ut5_1 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        
        //Asignación de valores estáticamente
        int v1[] = {1,2,3,4,5};
        int v2[] = new int[5];
        int i;
        
        
        //Mostrar todos los valores de v1
        for(i=0; i<v1.length;i++)
        {
            System.out.println("v1[" + i + "]= " + v1[i]);
        }    
        
        //Asignar valores al vector v2
        for(i=0; i<v2.length;i++)
        {
            System.out.println("Inserta el valor para la posición " + i );
            v2[i] = teclado.nextInt();
        }
        
        for(i=0; i<v2.length;i++)
        {
            System.out.println("v1[" + i + "]= " + v2[i]);
        } 
        
        //Suma y media de los valores de v2
        int suma=0;
        float media=0.0f;
        
        for(i=0; i<v2.length;i++)
        {
            suma = suma + v2[i];
        }    
        
        media =  ((float) suma / v2.length);
        System.out.println("La suma es: " + suma);
        System.out.println("La media es: " + media);
        
        //Comprobar si un elemento se encuentra dentro del vector
        int x,pos=-1;
        boolean encontrado=false;
        System.out.println("Introduce el valor a buscar en v2");
        x = teclado.nextInt();
        
        i=0;
        while ((i<v2.length) && (!encontrado))
        {
            if (v2[i] == x)
            {
               encontrado=true;
               pos = i;
            }  
            
            i++;
                
        } 
               
        if (encontrado)
            System.out.println("El valor " + x + " se encuentra en v2 en la posición " + (pos));
        else
            System.out.println("El valor " + x + " NO se encuentra en v2 en la posición");

        
        /** VECTORES DE OBJETOS **/
        DRedIPv4 vIP[] = new DRedIPv4[3];
        int octetos[] = new int[4];
        
        //Asignar valores al vector con el constructor por defecto
        for(i=0; i<vIP.length; i++)
        {
            for(int j=0; j<octetos.length; j++)
            {
                System.out.println("Introduce el número del octeto " + (j+1) + " de la IP " + (i+1));
                octetos[j] = teclado.nextInt();
            }    
            
            vIP[i] = new DRedIPv4(octetos[0],octetos[1],octetos[2],octetos[3]);
        } 
        
        //Mostrar todas las IPs
        for(i=0; i<vIP.length; i++)
        {
            System.out.println("vIP[" + i + "]= " + vIP[i]);
        }
        
        vIP[0].setOcteto1(191);
        System.out.println("");
        
        
        //Mostrar todas las IPs
        for(i=0; i<vIP.length; i++)
        {
            System.out.println("vIP[" + i + "]= " + vIP[i]);
        }
        

    }



           
    
}
