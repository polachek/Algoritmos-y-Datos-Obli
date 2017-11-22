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
    
    @Override    
    public NodoArbolCiudad getRaiz() {
        return this.raiz;
    }    
   
    @Override
    public Integer getMaximo() {
        return this.cantNodosMax;
    }   

    @Override
    public void setMaximo(Integer maximo) {
        this.cantNodosMax = maximo;
    }
    
    @Override
    public boolean esVacio() {
        return (raiz == null);
    }
    
    @Override
    public void vaciar(){
        raiz = null;
    }

    @Override
    public boolean insertar(String unaCiudad){
        Boolean ret = false; 
        ListaCruceros LCrucero = new ListaCruceros();

        if(this.esVacio())
        {
            NodoArbolCiudad nuevo = new NodoArbolCiudad();
            Ciudad miCiudad = new Ciudad(unaCiudad);            
            nuevo.setLcrucero(LCrucero);
            nuevo.setCiudad(miCiudad);
            this.raiz = nuevo;            
            ret = true;
        }
        else
        {
            String c = this.raiz.getCiudad().getNombre();        
            NodoArbolCiudad izquierda = this.raiz.getIzq();
            NodoArbolCiudad derecha = this.raiz.getDer();

            ArbolCiudades aux = new ArbolCiudades();
            if (unaCiudad.compareTo(c) < 0)
            {
                aux.raiz = izquierda;
                aux.insertar(unaCiudad);
                this.raiz.setIzq(aux.raiz);
                ret = true;
            }
            else if (unaCiudad.compareTo(c) > 0)
            {
                aux.raiz = derecha;
                aux.insertar(unaCiudad);
                this.raiz.setDer(aux.raiz);
                ret = true;
            }
        }        
        return ret;
    }

    @Override    
    public NodoArbolCiudad buscar(String ciudad){
        NodoArbolCiudad ret = null;
        String c = this.raiz.getCiudad().getNombre();
        NodoArbolCiudad izquierda = this.raiz.getIzq();
        NodoArbolCiudad derecha = this.raiz.getDer();         
        
        if(!this.esVacio())
        {
            ArbolCiudades aux = new ArbolCiudades();
            if (ciudad.compareTo(c) == 0) 
                ret = this.raiz;
            else if (ciudad.compareTo(c) < 0){
                if(izquierda == null) 
                    ret = null;                    
                else
                {
                    aux.raiz = izquierda;
                    ret = aux.buscar(ciudad);
                } 
            }
            else 
            {
                if(derecha == null) 
                    ret = null;                    
                else{
                    aux.raiz = derecha;
                    ret = aux.buscar(ciudad);
                }                
            }
        }
        else
            ret =  null;
             
        return ret;
    }

    @Override    
    public boolean existe(String ciudad){
       
        if(!this.esVacio())
        {
            String c = this.raiz.getCiudad().getNombre();
            NodoArbolCiudad izquierda = this.raiz.getIzq();
            NodoArbolCiudad derecha = this.raiz.getDer();        
            ArbolCiudades aux = new ArbolCiudades();        
            
            if (ciudad.compareTo(c) == 0)
                return true;
            else if (ciudad.compareTo(c) < 0)
                aux.raiz = izquierda;
            else
                aux.raiz = derecha;
            return aux.existe(ciudad);
        }
        else       
            return false;
    }

    @Override
    public int cantidadNodos(NodoArbolCiudad raiz) {

        if(raiz != null)
        {
            NodoArbolCiudad izquierda = raiz.getIzq();
            NodoArbolCiudad derecha = raiz.getDer();                    
            return 1 + cantidadNodos(izquierda) + cantidadNodos(derecha); 
        }
        return 0;
    }
    
}
