
package oblm3a;

public class NodoListaCrucero{
	private Crucero miCrucero;
	private NodoListaCrucero sig;
        private ListaServicio Lservicio;

    public NodoListaCrucero(Crucero miCrucero) {
        this.miCrucero = miCrucero;
        this.Lservicio=new ListaServicio();
        this.sig = null;
    }
    
    public ListaServicio getLservicio() {
        return Lservicio;
    }

    public void setListaServicio(ListaServicio Lservicio) {
        this.Lservicio = Lservicio;
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
