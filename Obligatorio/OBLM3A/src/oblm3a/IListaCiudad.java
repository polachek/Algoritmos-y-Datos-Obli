
package oblm3a;

interface IListaCiudad {
    //metodos de la interfaz
    public boolean esVacia();
    public Retorno.Resultado agregarInicio(Object dato);
    public void borrarInicio();
    public void agregarFinal(Object dato);
    public void borrarFin();
    public void vaciar();
    public void mostrar();
    public void agregarOrd(Object dato);
    public NodoListaCiudad obtenerElemento(Object dato);
    
}
