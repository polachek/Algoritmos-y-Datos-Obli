/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblm3a;

/**
 *
 * @author sebastianvillar
 */
public class NodoListaReserva {
    private Reserva miReserva;
    private NodoListaReserva anterior;
    private NodoListaReserva sig;

    public NodoListaReserva(Reserva miReserva) {
        this.miReserva = miReserva;
        this.sig = null;
        this.anterior = null;
    }
    
    public Reserva getReserva() {
        return miReserva;
    }

    public void setReserva(Reserva miReserva) {
        this.miReserva = miReserva;
    }

    public NodoListaReserva getSig() {
        return sig;
    }

    public void setSig(NodoListaReserva sig) {
        this.sig = sig;
    }
    
    public NodoListaReserva getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaReserva ant) {
        this.anterior = ant;
    }    
}
