package oblm3a;

public class ListaCiudad implements IListaCiudad {
    private NodoListaCiudad inicio;
    private NodoListaCiudad fin;
    private int cantelementos;
    private int tope;

    //Constructor
    public void Lista(){
        this.inicio=null;
        this.fin=null;
        this.cantelementos=0;
        this.tope=0;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    //Inicio
    public void setInicio(NodoListaCiudad i){
        inicio=i;
    }
    public NodoListaCiudad getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaCiudad f){
        fin=f;
    }
    public NodoListaCiudad getFin(){
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

    //PRE: ciudad no existe
    //POS: Agrega un nuevo Nodo al principio de la lista
    public Retorno.Resultado agregarInicio(Object dato){
        NodoListaCiudad nuevo= new NodoListaCiudad(dato);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        
        this.cantelementos=this.cantelementos+1;
        
        return Retorno.Resultado.OK;
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
            NodoListaCiudad aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getDato());
                aux=aux.getSig();
            }
        }
    }
     
     
 /*Variantes agregadas a los metodos basicos.*/
   
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
 public void agregarFinal(Object dato){
        //NodoLista nuevo= new NodoLista(n);
        if (this.esVacia())
            this.agregarInicio(dato); // el agregar inicio suma 1 a cantelementos
        
        else
        {
           NodoListaCiudad nuevo= new NodoListaCiudad(dato); 
           fin.setSig(nuevo);
           fin =nuevo;
           this.cantelementos=this.cantelementos+1;  
        }
        
    }

      //PRE:
    //POS: Borra el último nodo
    public void borrarFin(){
        if (!this.esVacia()){
            if (this.inicio==this.fin)
                this.borrarInicio();  // actualiza canelementos
            else{
                NodoListaCiudad aux = this.inicio;
                while (aux.getSig().getSig() != null)
                    aux=aux.getSig();
                this.fin=aux;
                this.fin.setSig(null);
                this.cantelementos=this.cantelementos-1;
            }
        }
    }


    //PRE: lista ordenada => mantiena orden
    //POS: inserta nuevo elemento en orden ascendente
    public void agregarOrd(Object dato){
//        //lista vacìa o primer elemento es mayor o igual => agrego al ppio
//        Object datonodo = this.inicio.getDato();
//        if (this.esVacia() || (this.inicio.getDato() > dato ){
//            this.agregarInicio(n);
//            return;
//        }
//        if (this.fin.getDato()<=n){   //ùltimo elemento es menor o igual => agrego al final
//            this.agregarFinal(n);
//            return;
//        }
//        NodoLista aux=this.inicio;
//        while (aux.getSig()!=null && aux.getSig().getDato() < n)
//           ;
//        NodoLista nuevo=new NodoLista(n);
//        nuevo.setSig(aux.getSig());
//        aux.setSig(nuevo);
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
    public NodoListaCiudad obtenerElemento(Object dato){
        NodoListaCiudad aux=this.inicio;
        while (aux!=null && aux.getDato()!=dato)
            aux=aux.getSig();
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }


    
    /*****  para resolver en forma recursiva Métodos RECURSIVOS  *****/

 //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoListaCiudad l){
        if(l!=null){
            System.out.println(l.getDato());
            mostrarREC(l.getSig());
            
            
        }
    }


}