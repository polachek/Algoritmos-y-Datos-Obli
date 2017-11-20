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
    public void setInicio(NodoListaReserva i);
    public NodoListaReserva getInicio();
    public void setFin(NodoListaReserva f);
    public NodoListaReserva getFin();   
    public int getCantelementos();    
    public void setCantElementos(int cantElementos);    
    public boolean esVacia();
    public void vaciar();    
    public void agregarReserva(Reserva dato);
    public void borrarInicio();
    public void mostrar();
    public NodoListaReserva obtenerElemento(Reserva dato);
    public boolean existeReserva(int id);
    public void borrarReserva(int id);
}
