/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblm3a;

/**
 *
 * @author Polachek
 */
public class NodoListaComentario {
    private Crucero miCrucero;
    private String ciudad;
    private String Comentario;
    private int Ranking;
    private NodoListaComentario sig;


    public NodoListaComentario(String ciudad, Crucero miCrucero, String Comentario, int Ranking) {
        this.ciudad = ciudad;
        this.miCrucero = miCrucero;
        this.Comentario = Comentario;
        this.Ranking = Ranking;
        this.sig = null;
    }
    
    public int getRanking() {
        return Ranking;
    }
    
    public String getComentario() {
        return Comentario;
    }


    public NodoListaComentario getSig() {
        return sig;
    }

    public void setSig(NodoListaComentario sig) {
        this.sig = sig;
    }
}
