
package oblm3a;

interface IListaCrucero {
    //metodos de la interfaz
    public boolean esVacia();
    public void agregarInicio(Crucero dato);
    public void borrarInicio();
    public void vaciar();
    public void mostrar();
    public void agregarOrd(Crucero dato);
    public Crucero buscarCruceroXNombre(String Nombre);
    public boolean buscarCrucero(String Nombre);
    public int cantElementos();  
    public ListaCruceros ordenarPorNombre();
}
