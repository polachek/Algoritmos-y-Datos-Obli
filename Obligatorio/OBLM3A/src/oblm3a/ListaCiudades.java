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
public class ListaCiudades implements IListaCiudades{
    private NodoListaCiudad inicio;
    
    //Constructor
    public ListaCiudades(){
        this.inicio = null;
    }    
    
    //Inicio
    public void setInicio(NodoListaCiudad i){
        inicio = i;
    }
    
    public NodoListaCiudad getInicio(){
        return inicio;
    }    
    
    @Override
    public boolean esVacia() {
        return (this.inicio==null);               
    }
    
    @Override
    public void agregarInicio(Ciudad dato) {
        NodoListaCiudad nuevo = new NodoListaCiudad (dato);
        if (this.esVacia()){
            this.setInicio(nuevo);
        }
        else{
            nuevo.setSig(inicio);
            this.setInicio(nuevo);
        }       
    }
    
    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
        }        
    }    
    
    @Override
    public Ciudad buscarCiudadPorCodigo(int codigo) {
       NodoListaCiudad aux = this.inicio;
       Ciudad laCiudad = null;
         while (aux!=null){
             if (aux.getCiudad().getCodCiudad() == codigo)
                  laCiudad = aux.getCiudad();
             aux=aux.getSig();
         }
        return laCiudad;        
    }    
    
    @Override
    public Ciudad buscarCiudadPorNombre(String Nombre) {
       NodoListaCiudad aux = this.inicio;
       Ciudad laCiudad = null;
         while (aux!=null){
            if (aux.getCiudad().getNombre().equals(Nombre))
                 laCiudad = aux.getCiudad();

            aux=aux.getSig();
         }
        return laCiudad;        
    }    

    
}
