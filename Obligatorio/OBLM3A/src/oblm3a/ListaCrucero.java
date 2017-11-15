package oblm3a;

public class ListaCrucero implements IListaCrucero {
    private NodoListaCrucero inicio;
    private NodoListaCrucero fin;
    private int cantelementos;

    //Constructor
    public ListaCrucero(){
        this.inicio=null;
        this.fin=null;
        this.cantelementos=0;
    }

    //Inicio
    public void setInicio(NodoListaCrucero i){
        inicio=i;
    }
    public NodoListaCrucero getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaCrucero f){
        fin=f;
    }
    public NodoListaCrucero getFin(){
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
    public void agregarInicio(Crucero dato){
        NodoListaCrucero nuevo = new NodoListaCrucero(dato);
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
            System.out.println("La lista está vacía");
        else  {
            NodoListaCrucero aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getCrucero());
                aux=aux.getSig();
            }
        }
    }
     
     
 /*Variantes agregadas a los metodos basicos.*/
   
    //PRE:
    //POS: Agrega un nuevo Nodo al final de la lista
 public void agregarFinal(Crucero dato){
        //NodoListaCrucero nuevo= new NodoListaCrucero(n);
        if (this.esVacia())
            this.agregarInicio(dato); // el agregar inicio suma 1 a cantelementos
        
        else
        {
           NodoListaCrucero nuevo= new NodoListaCrucero(dato); 
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
                NodoListaCrucero aux = this.inicio;
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
    public void agregarOrd(Crucero dato){
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
//        NodoListaCrucero aux=this.inicio;
//        while (aux.getSig()!=null && aux.getSig().getDato() < n)
//           ;
//        NodoListaCrucero nuevo=new NodoListaCrucero(n);
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
    public NodoListaCrucero obtenerElemento(Crucero dato){
        NodoListaCrucero aux=this.inicio;
        while (aux != null && aux.getCrucero()!=dato)
            aux=aux.getSig();
        //encontrÃ© dato o lleguÃ© al final
        return aux;
    }
    
    public boolean buscarCrucero(String Nombre){
       NodoListaCrucero aux = this.inicio;
       boolean retorno= false;
         while (aux!=null){
             if (aux.getNombre().equals(Nombre))
                  retorno =true;
             
             aux=aux.getSig();
         }
        return retorno;
    }
    
    public Crucero buscarCruceroXNombre(String Nombre){
       NodoListaCrucero aux= this.inicio;
       Crucero elCrucero = null;
         while (aux!=null){
             if (aux.getNombre().equals(Nombre))
                  elCrucero = aux.getCrucero();
             
             aux=aux.getSig();
         }
        return elCrucero;
    }


    
    /*****  para resolver en forma recursiva Métodos RECURSIVOS  *****/

 //PRE:
    //POS: muestra los datos de la lista en orden de enlace
    public void mostrarREC(NodoListaCrucero l){
        if(l!=null){
            System.out.println(l.getCrucero());
            mostrarREC(l.getSig());
            
            
        }
    }


}