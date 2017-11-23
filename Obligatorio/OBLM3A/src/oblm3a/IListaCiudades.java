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
public interface IListaCiudades {
    public boolean esVacia();
    public void agregarInicio(Ciudad dato);
    public void borrarInicio();
    public Ciudad buscarCiudadPorCodigo(int codigo);
    public Ciudad buscarCiudadPorNombre(String Nombre);    
}
