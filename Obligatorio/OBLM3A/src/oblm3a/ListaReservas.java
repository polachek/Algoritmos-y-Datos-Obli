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
        this.fin = null;
        this.cantElementos = 0;
    }

    //Inicio
    @Override
    public void setInicio(NodoListaReserva i){
        this.inicio = i;
    }
    
    @Override
    public NodoListaReserva getInicio(){
        return inicio;
    }

    //Fin
    @Override
    public void setFin(NodoListaReserva f){
        this.fin = f;
    }
    
    @Override
    public NodoListaReserva getFin(){
        return this.fin;
    }

    @Override
    public int getCantelementos(){
        return this.cantElementos;
    }

    @Override
    public void setCantElementos(int cantElementos){
        this.cantElementos = cantElementos;
    }
    
    @Override
    public boolean esVacia(){
        return (this.inicio==null);       
    }
    
    @Override
    public void agregarReserva(Reserva dato) {
        NodoListaReserva nuevo = new NodoListaReserva(dato);
        if (this.esVacia()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }
        else{
            nuevo.setSig(inicio);
            this.inicio.setAnterior(nuevo);
            this.setInicio(nuevo);
        }
        this.cantElementos=this.cantElementos+1;        
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
            this.cantElementos = this.cantElementos-1;
        }   
    }
    
    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantElementos = 0;    
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
        while (aux != null && aux.getReserva() != dato)
            aux=aux.getSig();
        //encontró dato o llegó al final
        return aux;
    }
    
    @Override
    public boolean existeReserva(int id) {        
        NodoListaReserva aux = this.inicio;
        boolean retorno = false;
        while (aux != null){
            if (aux.getReserva().getCliente().getId() == id)
                retorno = true;
            aux = aux.getSig();
         }
        return retorno;        
    }
    
    @Override
    public void borrarReserva(int id)
    {
        NodoListaReserva aux = this.inicio;
        while (aux != null){
            
            if (aux.getReserva().getCliente().getId() == id){
                if(aux == this.getInicio()){
                    this.setInicio(aux.getSig());
                    aux = aux.getSig();
                    aux.setAnterior(null);
                    this.cantElementos=this.cantElementos-1;                     
                }
                else if(aux == this.getFin())
                {
                    this.setFin(aux.getAnterior());
                    aux = aux.getAnterior();
                    aux.setSig(null);
                    this.cantElementos=this.cantElementos-1;                                         
                }
                else
                {
                    aux.getAnterior().setSig(aux.getSig());
                    aux.getSig().setAnterior(aux.getAnterior());
                    this.cantElementos=this.cantElementos-1;                      
                }
            }
            aux = aux.getSig();
         }        
    }


}
