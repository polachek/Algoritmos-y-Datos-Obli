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
    private Boolean espera;
    
    public Reserva(Crucero cru, Cliente cli, Boolean espera) {
        this.cru = cru;
        this.cli = cli;
        this.espera = espera;
    }
    
}
