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
public class NodoListaCiudad {
    private Ciudad miCiudad;
    private NodoListaCiudad sig;
    
    public NodoListaCiudad(Ciudad ciudad) {
        this.miCiudad = ciudad;
    }
    
    public Ciudad getCiudad() {
        return miCiudad;
    }
    
    public void setCiudad(Ciudad miCiudad) {
        this.miCiudad = miCiudad;
    }

    public NodoListaCiudad getSig() {
        return sig;
    }

    public void setSig(NodoListaCiudad sig) {
        this.sig = sig;
    }
}
