
package oblm3a;

interface IListaCrucero {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Object dato);
    public void borrarInicio();
    public void agregarFinal(Object dato);
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public void agregarOrd(Object dato);
    public NodoListaCrucero obtenerElemento(Object dato);
    
}
