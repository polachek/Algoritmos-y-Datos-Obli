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
public class Ciudad {
    
    private String nombre;
    private int codigoCiudad;
    
    public Ciudad(String nombre) {
        this.nombre = nombre;
        this.codigoCiudad = codigoCiudad;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCodCiudad() {
        return this.codigoCiudad;
    }
    
    public void setCodCiudad(int codigoCiudad){
        this.codigoCiudad = codigoCiudad;
    }
    
    
}
