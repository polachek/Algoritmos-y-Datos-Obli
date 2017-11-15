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
public class Crucero {
    private String nombre;
    private int estrellas;
    private int capacidad;
    private int ranking;
    private ListaServicio Lservicio;
    
    public Crucero(String nombre, int estrellas, int capacidad) {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.capacidad = capacidad;
        this.Lservicio=new ListaServicio();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ListaServicio getLservicio() {
        return Lservicio;
    }

    public void setListaServicio(ListaServicio Lservicio) {
        this.Lservicio = Lservicio;
    }

   
}
