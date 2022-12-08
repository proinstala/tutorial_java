
package DAM_1.Tareas.tareaUT7;

import java.util.Objects;

/**
 *
 * @author David
 */
public class Reserva {
    
    private int numReserva;
    private Cliente cliente;
    private int numParcela;
    private Fecha fechaInicio;
    private Fecha fechaFin;
    
    //Construcot sin parametros.
    public Reserva(){}
    
    //Constuctor con parametros.
    public Reserva(int numReserva, Cliente cliente, int numParcela, Fecha fechaInicio, Fecha fechaFin){
        this.numReserva = numReserva;
        this.cliente = cliente;
        this.numParcela = numParcela;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
    
    //Constuctor de copia.
    public Reserva(Reserva r){
        numReserva = r.numReserva;
        cliente = r.cliente;
        numParcela = r.numParcela;
        fechaInicio = r.fechaInicio;
        fechaFin = r.fechaFin;
    }

    
    //setters y getters
    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public Cliente getCliente() {
        return new Cliente(cliente);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }

    public Fecha getFechaInicio() {
        return new Fecha(fechaInicio);
    }

    public void setFechaInicio(Fecha fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Fecha getFechaFin() {
        return new Fecha(fechaFin);
    }

    public void setFechaFin(Fecha fechaFin) {
        this.fechaFin = fechaFin;
    }


    @Override
    public String toString() {
        return "Reserva{numReserva=" + numReserva + ", numParcela=" + numParcela + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", " + cliente + '}';
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numReserva;
        hash = 83 * hash + Objects.hashCode(this.cliente);
        hash = 83 * hash + this.numParcela;
        hash = 83 * hash + Objects.hashCode(this.fechaInicio);
        hash = 83 * hash + Objects.hashCode(this.fechaFin);
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
        final Reserva other = (Reserva) obj;
        if (this.numReserva != other.numReserva) {
            return false;
        }
        if (this.numParcela != other.numParcela) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicio, other.fechaInicio)) {
            return false;
        }
        if (!Objects.equals(this.fechaFin, other.fechaFin)) {
            return false;
        }
        return true;
    }
    
    
    
}//FIN CLASE Reserva
