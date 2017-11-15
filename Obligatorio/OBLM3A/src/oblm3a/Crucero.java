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
<<<<<<< HEAD
    private ListaServicio Lservicio;
=======
    private ListaReservas LReservas;
>>>>>>> ea0851ce88a96422022016addd25323843d16b75
    
    public Crucero(String nombre, int estrellas, int capacidad) {
        this.nombre = nombre;
        this.estrellas = estrellas;
        this.capacidad = capacidad;
<<<<<<< HEAD
        this.Lservicio=new ListaServicio();
=======
        this.LReservas = new ListaReservas();
>>>>>>> ea0851ce88a96422022016addd25323843d16b75
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
