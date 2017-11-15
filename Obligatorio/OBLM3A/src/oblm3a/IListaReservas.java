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
public interface IListaReservas {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Reserva dato);
    public void borrarInicio();
    public void vaciar();
    public void mostrar();
    public NodoListaReserva obtenerElemento(Reserva dato); 
}
