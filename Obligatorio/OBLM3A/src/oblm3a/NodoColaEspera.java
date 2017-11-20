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
public class NodoColaEspera {
    Reserva reserva;
    NodoColaEspera siguiente;
    NodoColaEspera anterior;    

    public NodoColaEspera(Object dato) {
        this.reserva = reserva;
        this.siguiente = null;
    }

    public Reserva getReservaEnEspera() {
        return reserva;
    }

    public void setReservaEnEspera(Reserva reserva) {
        this.reserva = reserva;
    }

    public NodoColaEspera getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoColaEspera siguiente) {
        this.siguiente = siguiente;
    }  
    
    public NodoColaEspera getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoColaEspera ant) {
        this.anterior = ant;
    }      
}
