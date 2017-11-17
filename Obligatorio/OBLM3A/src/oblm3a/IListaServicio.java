/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblm3a;

/**
 *
 * @author User
 */
interface IListaServicio {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(String servicio);
    public void borrarInicio();
    public void vaciar();
    public void mostrar();
    public NodoListaServicio obtenerElemento(String Servicio);
    public boolean existeServicio(String Servicio);
}
