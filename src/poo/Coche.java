package poo;

public class Coche {
    
    private int ruedas;
    private int largo;
    private int ancho;
    private int motor;
    private int peso_plataforma;
    private String color;

    public Coche(){ //CONSTRUCTOR

        ruedas = 4;
        largo = 2000;
        ancho = 300;
        motor = 1600;
        peso_plataforma = 500;

    }

    public String getRuedasCoche(){   //Metodo Getter
        return "El coche tiene " + ruedas + " ruedas";
    }

    public String getLargoCoche(){
        return "El largo del coche es " + largo;
    }

    public String getAnchoCoche(){
        return "El ancho del coche es " + ancho;
    }

    public String getPesoPlataformaCoche(){
        return "El peso del coche es " + peso_plataforma;
    }

    public String getMotorCoche(){
        return "El motor del coche es " + motor;
    }

    public void setEstableceColor(String color){  //Metodo Setter
        this.color = color; //con 'this' le decimos que la variable es de la clase
    }

    public String getColorCoche(){
        return "El color del coche es " + color;
    }

    
}
