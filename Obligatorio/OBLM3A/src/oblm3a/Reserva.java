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
public class Reserva {
    
    private Crucero cru;
    private Cliente cli;
    private boolean espera;
    
    public Reserva() 
    {
        this.cru = cru;
        this.cli = cli;
        this.espera = espera;
    }
    
    public void agregarReserva(Crucero c, Cliente cli, Boolean e)
    {
        this.cru = c;
        this.cli = cli;
        this.espera = e;            
    }
    
    public Cliente getCliente (){
        return cli;
    }
    
}
