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
public class ListaServicio {
    private NodoListaServicio inicio;
    private NodoListaServicio fin;
    private int cantelementos;

    //Constructor
    public void Lista(){
        this.inicio=null;
        this.fin=null;
        this.cantelementos=0;
    }

    //Inicio
    public void setInicio(NodoListaServicio i){
        inicio=i;
    }
    public NodoListaServicio getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaServicio f){
        fin=f;
    }
    public NodoListaServicio getFin(){
        return fin;
    }

    public int getCantelementos() {
        return cantelementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantelementos = cantelementos;
    }

    
    

 /**************Métodos Básicos*******************/
/***********************************************/
    //PRE:
    //POS: Retorna true si la lista no tiene nodos
    public boolean esVacia(){
        return (this.inicio==null);       
      }

    //PRE: 
    //POS: Agrega un nuevo Nodo al principio de la lista
    public void agregarInicio(String servicio){
        NodoListaServicio nuevo= new NodoListaServicio(servicio);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        
        this.cantelementos=this.cantelementos+1;
        }
    
     //PRE:
    //POS: Borra el primer nodo
     public void borrarInicio(){
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
            this.cantelementos=this.cantelementos-1;
        }
    }
 //PRE:
    //POS: elimina todos los nodos de una lista dada
     public void vaciar(){
             this.inicio=null;
             this.fin=null;
             this.cantelementos=0;
    }
   
         //PRE:
    //POS: Recorre y muestra los datos de lista
   public void mostrar(){
        if (this.esVacia())
            System.out.println("Lista es vacía");
        else  {
            NodoListaServicio aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getServicio());
                aux=aux.getSig();
            }
        }
    }


    //PRE: lista ordenada
    //POS: Borra la primer ocurrencia de un elemento dado
    public void borrarElemento(int n){
        // implementar el metodo
    }
    
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos(){    
        return this.cantelementos;
    }

    //PRE: //POS:
   //PRE: //POS:
    public NodoListaServicio obtenerElemento(String servicio){
        NodoListaServicio aux=this.inicio;
        while (aux!=null && aux.getServicio()!=servicio)
            aux=aux.getSig();
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }
    
}
