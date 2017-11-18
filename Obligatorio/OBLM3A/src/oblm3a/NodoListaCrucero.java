
package oblm3a;

public class NodoListaCrucero{
    private Crucero miCrucero;
    private NodoListaCrucero sig;


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
    
    public int getEstrellas() {
        return this.miCrucero.getEstrellas();
    }
    
    public int getRanking() {
        return this.miCrucero.getRanking();
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
