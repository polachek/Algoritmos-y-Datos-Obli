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
    private ListaServicios Lservicio;
    private ListaReservas LReservas;

    
    public Crucero(String nombre, int estrellas, int capacidad) {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.capacidad = capacidad;
        this.Lservicio=new ListaServicios();
        this.LReservas = new ListaReservas();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public ListaServicios getLservicio() {
        return Lservicio;
    }

    public void setListaServicio(ListaServicios Lservicio) {
        this.Lservicio = Lservicio;
    }
    
    public ListaReservas getLReservas() {
        return LReservas;
    }

    public void setListaReservas(ListaReservas LReservas) {
        this.LReservas = LReservas;
    }
  
}
