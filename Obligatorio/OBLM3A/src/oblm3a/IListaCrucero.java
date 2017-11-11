
package oblm3a;

interface IListaCrucero {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Crucero dato);
    public void borrarInicio();
    public void agregarFinal(Crucero dato);
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public void agregarOrd(Crucero dato);
    public NodoListaCrucero obtenerElemento(Crucero dato);   
}
