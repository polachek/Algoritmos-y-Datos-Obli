/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblm3a;

/**
 *
 * @author Polachek
 */
public interface IListaComentarios {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(String ciudad, Crucero miCrucero, String Comentario, int Ranking);
    public void borrarInicio();
    public void vaciar();
    public void mostrar();
    public int cantElementos();  
}
