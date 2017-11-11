
package oblm3a;

public class NodoListaCiudad{
	private Object NombreCiudad;
        private ListaCrucero Lcrucero;
        private NodoListaCiudad sig;

    public Object getNombreCiudad() {
        return NombreCiudad;
    }

    public void setNombreCiudad(Object NombreCiudad) {
        this.NombreCiudad = NombreCiudad;
    }

    public ListaCrucero getLcrucero() {
        return Lcrucero;
    }

    public void setLcrucero(ListaCrucero Lcrucero) {
        this.Lcrucero = Lcrucero;
    }
	

    public NodoListaCiudad(Object NombreCiudad) {
        this.NombreCiudad = NombreCiudad;
        this.Lcrucero=new ListaCrucero();
        this.sig = null;
    }

    public Object getDato() {
        return NombreCiudad;
    }

    public void setDato(Object NombreCiudad) {
        this.NombreCiudad = NombreCiudad;
    }

    public NodoListaCiudad getSig() {
        return sig;
    }

    public void setSig(NodoListaCiudad sig) {
        this.sig = sig;
    }

 
}
