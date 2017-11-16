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
    
        public Ciudad ciudad;
        public ListaCruceros LCrucero;
        public NodoArbolCiudad izq;
        public NodoArbolCiudad der;

        public NodoArbolCiudad() {
            this.ciudad = null;
            this.izq = null;
            this.der = null;
            this.LCrucero = new ListaCruceros();
        }
        
        public NodoArbolCiudad getIzq() {
            return izq;
        }
        
        public void setIzq(NodoArbolCiudad izq) {
            this.izq = izq;
        }
        
        public NodoArbolCiudad getDer() {
            return der;
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
