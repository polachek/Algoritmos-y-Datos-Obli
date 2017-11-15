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
public class NodoListaCliente {

    public Cliente miCliente;
    private NodoListaCliente sig;


    public NodoListaCliente(Cliente miCliente) {
        this.miCliente = miCliente;
        this.sig = null;
    }
    
    public Cliente getCliente() {
        return miCliente;
    }

    public void setCliente(Cliente miCliente) {
        this.miCliente = miCliente;
    }

    public NodoListaCliente getSig() {
        return sig;
    }

    public void setSig(NodoListaCliente sig) {
        this.sig = sig;
    }    
    
}
