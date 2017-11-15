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
public class ListaReservas implements IListaReservas {
    private NodoListaReserva inicio;
    private NodoListaReserva fin;
    private int cantElementos;
    
    //Constructor
    public ListaReservas() {
        this.inicio = null;
    }

    //Inicio
    public void setInicio(NodoListaReserva i){
        inicio=i;
    }
    public NodoListaReserva getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaReserva f){
        fin=f;
    }
    public NodoListaReserva getFin(){
        return fin;
    }

    public int getCantelementos() {
        return cantElementos;
    }

    public void setCantElementos(int cantElementos) {
        this.cantElementos = cantElementos;
    }
    
    /**************Métodos Básicos*******************/
    /***********************************************/
    
    @Override
    public boolean esVacia(){
        return (this.inicio==null);       
    }
    
    @Override
    public void agregarInicio(Reserva dato) {
        NodoListaReserva nuevo = new NodoListaReserva(dato);
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
            NodoListaReserva aux = this.inicio;
            while (aux != null)  {
                System.out.println(aux.getReserva());
                aux=aux.getSig();
            }
        }
    }

    @Override
    public NodoListaReserva obtenerElemento(Reserva dato) {
        NodoListaReserva aux = this.inicio;
        while (aux!=null && aux.getReserva()!=dato)
            aux=aux.getSig();
        //encontró dato o llegó al final
        return aux;
    }


}
