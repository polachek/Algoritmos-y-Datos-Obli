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
        public ArbolCiudades izq;
        public ArbolCiudades der;

        public NodoArbolCiudad() {
            this.nombre = null;
            this.izq = null;
            this.der = null;
            this.LCrucero = new ListaCruceros();
        }    
    
}
