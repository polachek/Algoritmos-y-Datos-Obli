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
public class NodoArbolCiudad {
    
    private Ciudad ciudad;
    private ListaCruceros LCrucero;
    private NodoArbolCiudad izq;
    private NodoArbolCiudad der;

    public NodoArbolCiudad() {
        this.ciudad = null;
        this.izq = null;
        this.der = null;
        this.LCrucero = new ListaCruceros();
    }

    public Ciudad getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(Ciudad c) {
        this.ciudad = c;
    }    

    public NodoArbolCiudad getIzq() {
        return this.izq;
    }

    public void setIzq(NodoArbolCiudad izq) {
        this.izq = izq;
    }

    public NodoArbolCiudad getDer() {
        return this.der;
    }

    public void setDer(NodoArbolCiudad der) {
        this.der = der;
    }

    public ListaCruceros getLcrucero() {
        return this.LCrucero;
    }

    public void setLcrucero(ListaCruceros Lcrucero) {
        this.LCrucero = Lcrucero;
    }
}
