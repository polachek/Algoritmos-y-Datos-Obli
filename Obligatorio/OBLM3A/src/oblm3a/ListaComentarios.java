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
public class ListaComentarios implements IListaComentarios {
    private NodoListaComentario inicio;
    private NodoListaComentario fin;
    private int cantElementos;

    //Constructor
    public ListaComentarios(){
        this.inicio=null;
        this.fin=null;
        this.cantElementos=0;
    }

    //Inicio
    public void setInicio(NodoListaComentario i){
        inicio=i;
    }
    public NodoListaComentario getInicio(){
        return inicio;
    }

    public int getCantelementos() {
        return cantElementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantElementos = cantelementos;
    }
    
    @Override
    public boolean esVacia() {
        return (this.inicio==null);               
    }

    @Override
    public void agregarInicio(String ciudad, Crucero miCrucero, String Comentario, int Ranking) {
        NodoListaComentario nuevo = new NodoListaComentario(ciudad, miCrucero, Comentario, Ranking);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        
        this.cantElementos=this.cantElementos+1;        
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
            this.cantElementos=this.cantElementos-1;
        }        
    }

    @Override
    public void vaciar() {
        this.inicio=null;
        this.fin=null;
        this.cantElementos=0;        
    }

    @Override
    public void mostrar() {
        if (this.esVacia())
            System.out.println("La lista está vacía");
        else  {
            NodoListaComentario aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getRanking());
                aux=aux.getSig();
            }
        }        
    }

    @Override
    public int cantElementos() {
        return this.cantElementos;        
    }
}
