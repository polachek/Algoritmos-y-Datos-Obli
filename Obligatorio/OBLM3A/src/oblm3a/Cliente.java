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
public class Cliente {
    private String nombre;
    private int clienteId;
    
    public Cliente() {
        this.clienteId = clienteId;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }    
    
    public int getId(){
        return this.clienteId;
    }
    
    public void setId(int id) {
        this.clienteId = id;
    } 
    
    public void agregarCliente(int id) {
        this.clienteId = id;
    }     
}
