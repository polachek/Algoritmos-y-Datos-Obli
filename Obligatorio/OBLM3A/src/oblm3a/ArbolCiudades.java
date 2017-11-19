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
public class ArbolCiudades implements IArbolCiudades{

    private NodoArbolCiudad raiz;
    private Integer cantNodosMax;

    public ArbolCiudades() {
        raiz = null;
    }
    
    
   public NodoArbolCiudad getRaiz() {
        return raiz;
    }    
   
    @Override
    public Integer getMaximo() {
        return this.cantNodosMax;
    }   

    @Override
    public void setMaximo(Integer maximo) {
        this.cantNodosMax = maximo;
    }
    
    public boolean esVacio() {
        return (raiz == null);
    }
    
    public void vaciar(){
        raiz = null;
    }

    public Boolean insertar(String unaCiudad){
        Boolean ret = false;
        if(this.esVacio()){
            NodoArbolCiudad nuevo = new NodoArbolCiudad();
            this.raiz = nuevo;
            Ciudad miCiudad = new Ciudad(unaCiudad);
            nuevo.ciudad = miCiudad;
            nuevo.LCrucero = new ListaCruceros(); 
            ret = true;
        }else{
            ArbolCiudades aux = new ArbolCiudades();
            if (unaCiudad.compareTo(this.raiz.ciudad.getNombre()) < 0){
                aux.raiz = this.raiz.getIzq();
                aux.insertar(unaCiudad);
                
                this.raiz.setIzq(aux.raiz);
                ret = true;
                
            }
            else if (unaCiudad.compareTo(this.raiz.ciudad.getNombre()) > 0){
                aux.raiz = this.raiz.getDer();
                aux.insertar(unaCiudad);
                this.raiz.setDer(aux.raiz);
                ret = true;
            }
        }        
        return ret;
    }

    public NodoArbolCiudad buscar(String ciudad){
        NodoArbolCiudad ret = null;
        if(!this.esVacio()){
            ArbolCiudades aux = new ArbolCiudades();
            if (ciudad.compareTo(this.raiz.ciudad.getNombre()) == 0){
                ret =  this.raiz;
            }
            if (ciudad.compareTo(this.raiz.ciudad.getNombre())<0){
                if(this.raiz.getIzq() == null){
                    ret = null;                    
                }else{
                    aux.raiz = this.raiz.getIzq();
                    ret = aux.buscar(ciudad);
                } 
            }
            if (ciudad.compareTo(this.raiz.ciudad.getNombre())>0){
                if(this.raiz.getDer() == null){
                    ret = null;                    
                }else{
                    aux.raiz = this.raiz.getDer();
                    ret = aux.buscar(ciudad);
                }                
            }
            
        }else{
            ret =  null;
        }     
        return ret;
    }
    
    //Obtiene el nodo del menor elemento del árbol
    public NodoArbolCiudad Minimo( ) {
        return Minimo( raiz ) ;
    }

    //Obtiene el nodo del mayor elemento del árbol
    public NodoArbolCiudad Maximo( ) {
        return Maximo( raiz ) ;
    }
    
    //retorna nodo del mínimo elemento
    private NodoArbolCiudad Minimo( NodoArbolCiudad nodo )
    {
        if(nodo != null )
            while( nodo.izq != null )
                nodo = nodo.izq;
        return nodo;
    }
    //retorna nodo del máximo elemento
    private NodoArbolCiudad Maximo( NodoArbolCiudad nodo )
    {
        if(nodo != null )
            while( nodo.der != null )
                nodo = nodo.der;
        return nodo;
    }
    
    /*public String buscarMin() {
        ArbolCiudades arbolActual = this;
        while (!arbolActual.raiz.izq.esVacio()) {
            arbolActual = arbolActual.raiz.izq;
        }
        String devuelvo = arbolActual.raiz.ciudad.getNombre();
        arbolActual.raiz = null;
        return devuelvo;
    }

    public String buscarMax() {
        ArbolCiudades arbolActual = this;
        while (!arbolActual.raiz.der.esVacio()) {
            arbolActual = arbolActual.raiz.der;
        }
        String devuelvo = arbolActual.raiz.ciudad.getNombre();
        arbolActual.raiz = null;
        return devuelvo;
    }


    public boolean esHoja() {
        boolean hoja = false;
        if ((raiz.izq).esVacio() && (raiz.der).esVacio()) {
            hoja = true;
        }
        return hoja;
    }
    */
       
    public boolean existe(String ciudad){
        if(!this.esVacio()){
            ArbolCiudades aux = new ArbolCiudades();
            if (ciudad.compareTo(this.raiz.ciudad.getNombre()) == 0){
                return true;
            }
            if (ciudad.compareTo(this.raiz.ciudad.getNombre())<0){
                aux.raiz = this.raiz.getIzq();
            }
            if (ciudad.compareTo(this.raiz.ciudad.getNombre())>0){
                aux.raiz = this.raiz.getDer();
            }
          return aux.existe(ciudad);
        }
        return false;
    }

    @Override
    public int cantidadNodos(NodoArbolCiudad raiz) {
        if(raiz != null)
        {
            return 1 + cantidadNodos(raiz.izq) + cantidadNodos(raiz.der); 
        }
        return 0;
    }
    
}
