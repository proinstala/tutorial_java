package entorno_grafico;

import java.awt.*;
import java.io.File;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

/*
- Imagenes
- Guardar ruta en objeto tipo File
- Guardar imagen en objeto tipo Image
*/

public class Dibujo5_imagen {
    public static void main(String[] args) {
        
        MarcoDibujo5 Dibujo5 = new MarcoDibujo5();
        Dibujo5.setVisible(true);
        Dibujo5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class MarcoDibujo5 extends JFrame{

    public MarcoDibujo5(){
        setTitle("Marco con imagen");
        setBounds(500, 300, 500, 300); // tamaño y posicion de la ventana (x, y, width, height)
        Lamina6 miLamina6 = new Lamina6();
        add(miLamina6);
    }
}

class Lamina6 extends JPanel{

    private Image imagen1; //creamos un objeto de tipo image
    private Image imagen2;

    public void paintComponent(Graphics g){ //sobrescrivimos el metodo. pasamos por parametro un objeto de tipo Graphics
        super.paintComponent(g); //llamamos al metodo de la clase JPanel
        
        File ruta1 = new File("logo_relleno_168.png"); //metodo para crear un objeto de tipo File que contiene una ruta a un archivo

        //el metodo ImageIO.read() necesita estar en un capturador de excepción
        try{
            imagen1 = ImageIO.read(ruta1); //metodo para guardar la imagen en el objeto imagen1
            imagen2 = ImageIO.read(new File("logo1_42.png")); //instanciamos directamente el objeto File
        }
        catch(IOException e){
            System.out.println("Ruta de imagen no valida");
        }

        g.drawImage(imagen1, 5, 5, null); //dibujamos la imagen en la lamina en las cordenadas especifivadas
        g.drawImage(imagen2, 200, 5, null); //dibujamos la imagen en la lamina en las cordenadas especifivadas


        int anchoImagen2 = imagen2.getWidth(this); //metodo para guardar el ancho que tiene la imagen 
        int altoImagen2 =imagen2.getHeight(this); //metod para guardar el alto que tiene la imagen

        g.copyArea(200, 5, anchoImagen2, altoImagen2, 42, 0); //con este metodo copiamos un area de la lamina y la dibujamos en otra area
        // los parametros son g.copyArea(x, y, width, height, dx, dy); 
        // los parametros dx y dy son cordenadas relativas y empiezan a contar desde los dos primeros parametro x e y
    }
}
