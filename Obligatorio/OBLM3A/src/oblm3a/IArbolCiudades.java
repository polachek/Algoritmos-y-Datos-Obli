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
public interface IArbolCiudades {
    public boolean esVacio();
    public Retorno.Resultado insertar(String unaCiudad);
    public void preOrder();
    public void inOrder();
    public void posOrder();
    public boolean existe(String ciudad);
    public int cantidad();
    public int altura();    
    public ArbolCiudades buscar(String ciudad);
    public String buscarMin();
    public String buscarMax();
    public boolean esHoja();
    public void eliminar(String ciudad);
}
