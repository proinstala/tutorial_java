package pruebas;


public class usoPajaro {
    public static void main(String[] args) {
        
        Pajaro aguila = new Pajaro("lolo", 50, 50);
        double v = aguila.volar(50, 50);
        System.out.println("el desplazamiento es: " + v);
    }
}

class Pajaro{

    private String nombre;
    private int posX;
    private int posY;
    private double desplazamiento;

    public Pajaro(){};


    public Pajaro(String nombre, int posX, int posY){
        
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;    
    }

    double volar(int posX, int posY){
        double desplazamiento = Math.sqrt(posX * posX + posY * posY);
        this.posX = posX;
        this.posY = posY;

        return desplazamiento;
    }

    public void setVolar(int posX, int posY){
        double desplazamiento = Math.sqrt(posX * posX + posY * posY);
        this.posX = posX;
        this.posY = posY;
        System.out.println("el desplazamiento es: " + desplazamiento);

    }

    public String getEstado(){
        return "estado: " + desplazamiento;
    }
}


