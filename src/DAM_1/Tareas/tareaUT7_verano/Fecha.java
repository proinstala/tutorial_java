
package DAM_1.Tareas.tareaUT7_verano;

/**
 *
 * @author David
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;
    
    
    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    //Construtor de copia
    public Fecha(Fecha f){
        dia = f.dia;
        mes = f.mes;
        anio = f.anio;        
    }

    
    //setters y getters
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }

    //Método para comprobar si la fecha es correcta
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, anioCorrecto;
        anioCorrecto = anio > 0;
        mesCorrecto = mes >= 1 && mes <= 12;
        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && anioCorrecto;
    }

    //Método privado para comprobar si el año es bisiesto
    //Este método lo utiliza el método fechaCorrecta
    private boolean esBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0);
    }

    //Método que modifica la fecha cambiándola por la del día siguiente                                           
    public void diaSiguiente() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                anio++;
            }

        }
    }

    //Método toString para mostrar la fecha
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia < 10) {
            sb.append("0");
        }
        sb.append(dia);
        sb.append("-");
        if (mes < 10) {
            sb.append("0");
        }
        sb.append(mes);
        sb.append("-");
        sb.append(anio);
        return sb.toString();
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.dia;
        hash = 17 * hash + this.mes;
        hash = 17 * hash + this.anio;
        return hash;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fecha other = (Fecha) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        return true;
    }
 
}
