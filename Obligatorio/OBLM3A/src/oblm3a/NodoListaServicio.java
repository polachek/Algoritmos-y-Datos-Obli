/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblm3a;

/**
 * @author Sebastián Villar - 177751
 * @author Guillermo Polachek - 153924
 */

public class NodoListaServicio {
    private String Servicio;
    private NodoListaServicio sig;
    private NodoListaServicio ant;

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public NodoListaServicio(String Servicio) {
        this.Servicio = Servicio;
        this.sig = null;
        this.ant = null;
    }

    public NodoListaServicio getSig() {
        return sig;
    }

    public void setSig(NodoListaServicio sig) {
        this.sig = sig;
    }
    
    public NodoListaServicio getAnt() {
        return ant;
    }

    public void setAnt(NodoListaServicio ant) {
        this.ant = ant;
    }
}