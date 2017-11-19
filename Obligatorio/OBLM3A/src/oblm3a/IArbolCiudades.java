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
public interface IArbolCiudades {
    public boolean esVacio();
    public Boolean insertar(String unaCiudad);
    public boolean existe(String ciudad); 
    //public ArbolCiudades buscar(String ciudad);
    public int cantidadNodos(NodoArbolCiudad raiz);
    public Integer getMaximo();  
    public void setMaximo(Integer maximo);        
    
}
