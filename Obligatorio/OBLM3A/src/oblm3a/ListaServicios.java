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
public class ListaServicios implements IListaServicio{
    private NodoListaServicio inicio;
    private NodoListaServicio fin;
    private int cantelementos;

    //Constructor
    public ListaServicios(){
        this.inicio=null;
        this.fin=null;
        this.cantelementos=0;
    }

    //Inicio
    public void setInicio(NodoListaServicio i){
        this.inicio=i;
    }
    public NodoListaServicio getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaServicio f){
        this.fin=f;
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
        if (this.esVacia()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }
        else{
            nuevo.setSig(inicio);
            this.inicio.setAnt(nuevo);
            this.setInicio(nuevo);
        }
        this.cantelementos=this.cantelementos+1;
    }
    
     //PRE:
    //POS: Borra el primer nodo
    public void borrarInicio(){
        if (!this.esVacia())
        {
            if (inicio==fin)
            {
                this.inicio=null;
                this.fin=null;
                this.cantelementos = 0;
            }  
            else{
                this.setInicio(this.inicio.getSig());
                this.inicio.setAnt(null);
                this.cantelementos=this.cantelementos-1;
            }    
        }
    }
     
    @Override
    public void borrarFin() {
          this.fin = this.fin.getAnt();
          this.fin.setSig(null);
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
    public void borrarElemento(String Servicio){
        NodoListaServicio aux = this.obtenerElemento(Servicio);
        
        if (aux == inicio)
            this.borrarInicio();
        else if (aux == fin)
            this.borrarFin();
        else if (aux != null){
            aux.getAnt().setSig(aux.getSig());
            aux.getSig().setAnt(aux.getAnt());
            this.cantelementos = (this.cantelementos)-1;
        }
    }
    
    //PRE: 
    //POS: Retorna la cantidad de nodos que tiene la lista
    public int cantElementos(){    
        return this.cantelementos;
    }

    //PRE: //POS:
   //PRE: //POS:
    public NodoListaServicio obtenerElemento(String servicio){
        NodoListaServicio aux = this.inicio;
        NodoListaServicio ret = null;
        while (aux != null){
            if(aux.getServicio().equals(servicio))
                ret = aux;
            aux = aux.getSig();
        }
        //encontró dato o lleguó al final
        return ret;
    }
    
    @Override
    public boolean existeServicio(String Servicio) {
       NodoListaServicio aux = this.inicio;
       boolean retorno= false;
         while (aux!=null){
             if (aux.getServicio().equals(Servicio))
                  retorno =true;
             
             aux=aux.getSig();
         }
        return retorno;        
    }
    
}
