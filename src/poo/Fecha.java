package poo;

public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int d, int m, int a){  //CONSTRUCTOR

        dia = d;
        mes = m;
        anio = a;
    }

    @Override   //ANNOTATIONS - indicador para el copilador de que vamos a sobrescrivir una clase
    public String toString(){   //metodo para sobrescrivir el formato de fecha
        
        return dia + "/" + mes + "/" + anio;
    }

    @Override
    public boolean equals(Object o){    //metodo para sobrscrivir la comparacion de objetos fecha

        Fecha otra = (Fecha)o;
        return dia == otra.dia && mes == otra.mes && anio == otra.anio;
    }
}
