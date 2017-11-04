
package oblm3a;

public class NodoListaCrucero{
	private Object Nombre;
        private int estrellas;
	private NodoListaCrucero sig;

    public NodoListaCrucero(Object Nombre) {
        this.Nombre = Nombre;
        this.sig = null;
    }

    public Object getDato() {
        return Nombre;
    }

    public void setDato(Object Nombre) {
        this.Nombre = Nombre;
    }

    public NodoListaCrucero getSig() {
        return sig;
    }

    public void setSig(NodoListaCrucero sig) {
        this.sig = sig;
    }

 
}
