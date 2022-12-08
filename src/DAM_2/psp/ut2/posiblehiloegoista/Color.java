/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAM_2.psp.ut2.posiblehiloegoista;

/**
 *
 * @author IMCG
 */
public class Color extends Thread {
   
    String color;
    public Color (String c){
        this.color=c;
    }

    public void run(){
        
        //se imprime 100 veces el valor de: color + i
        for(int i=1;i<=100;i++) {
            System.out.println(color + i);
            Color.yield(); //hace que un hilo que está "ejecutándose" pase a "preparado" para permitir que otros hilos de la misma prioridad puedan ejecutarse.
        }
        
    }
}

