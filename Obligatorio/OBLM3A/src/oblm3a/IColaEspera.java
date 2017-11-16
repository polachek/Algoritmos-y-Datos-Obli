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
public interface IColaEspera {
    public void encolar(Reserva dato);
    public void desencolar();
    public Object frente();
    public boolean estaVacia();
    public int elementos();    
    
}
