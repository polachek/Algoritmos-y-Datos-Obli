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
public class ColaEspera implements IColaEspera {
    int cantElementos;
    NodoColaEspera primero;
    NodoColaEspera ultimo;

    public ColaEspera() {
        this.cantElementos = 0;        
        this.primero = null;
        this.ultimo = null;
    }

    public int getCantElementos() {
        return cantElementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantElementos = cantelementos;
    }

    public NodoColaEspera getPrimero() {
        return primero;
    }

    public void setPrimero(NodoColaEspera primero) {
        this.primero = primero;
    }

    public NodoColaEspera getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoColaEspera ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public void encolar(Reserva dato) {
        NodoColaEspera nuevo = new NodoColaEspera(dato);
        
        if (!this.estaVacia()){
            this.ultimo.siguiente=nuevo;
            this.ultimo=nuevo;                
        }
        else{
            this.primero=nuevo;
            this.ultimo=nuevo;
        }
        this.cantElementos=this.cantElementos+1;         
    }

    @Override
    public void desencolar() {
        if (!this.estaVacia()&& this.cantElementos>=1){
           this.primero=this.primero.siguiente;
           this.cantElementos=this.cantElementos-1;
        }
        else{
           this.primero=null;
           this.ultimo=null;
           this.cantElementos=0;
        }    
    }

    @Override
    public Reserva frente() {
        if (!this.estaVacia())
            return this.primero.reserva;
     
        return null;
    }

    @Override
    public boolean estaVacia() {
        return (this.primero==null);
    }

    @Override
    public int elementos() {
        return this.cantElementos;
    }
    
}
