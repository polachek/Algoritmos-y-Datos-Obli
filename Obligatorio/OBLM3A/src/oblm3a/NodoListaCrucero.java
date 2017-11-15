
package oblm3a;

public class NodoListaCrucero{
<<<<<<< HEAD
	private Crucero miCrucero;
	private NodoListaCrucero sig;
=======
    private Crucero miCrucero;
    private NodoListaCrucero sig;
    private ListaServicio Lservicio;
>>>>>>> ea0851ce88a96422022016addd25323843d16b75

    public NodoListaCrucero(Crucero miCrucero) {
        this.miCrucero = miCrucero;
        this.sig = null;
    }
    
    public Crucero getCrucero() {
        return miCrucero;
    }
    
    public String getNombre() {
        return this.miCrucero.getNombre();
    }

    public void setCrucero(Crucero miCrucero) {
        this.miCrucero = miCrucero;
    }

    public NodoListaCrucero getSig() {
        return sig;
    }

    public void setSig(NodoListaCrucero sig) {
        this.sig = sig;
    }

 
}
