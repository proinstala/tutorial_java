package poo;

public class UsoVehiculo {
    public static void main(String[] args) {
        
        Coche Renault = new Coche(); //Instanciar o Ejemplarizar una clase. 

        System.out.println(Renault.getLargoCoche());

        Renault.setEstableceColor("rojo");

        System.out.println(Renault.getColorCoche());

        Furgoneta Dacia = new Furgoneta(3, 600);
        Dacia.setEstableceColor("verde");

        System.out.println(Dacia.getColorCoche());
        System.out.println(Dacia.getDatosFurgoneta());
    }
    
}
