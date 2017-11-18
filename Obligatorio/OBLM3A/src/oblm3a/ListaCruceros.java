package oblm3a;

public class ListaCruceros implements IListaCrucero {

    private NodoListaCrucero inicio;
    private NodoListaCrucero fin;
    private int cantElementos;

    //Constructor
    public ListaCruceros(){
        this.inicio=null;
        this.fin=null;
        this.cantElementos=0;
    }

    //Inicio
    public void setInicio(NodoListaCrucero i){
        inicio=i;
    }
    public NodoListaCrucero getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaCrucero f){
        fin=f;
    }
    public NodoListaCrucero getFin(){
        return fin;
    }

    public int getCantelementos() {
        return cantElementos;
    }

    public void setCantelementos(int cantelementos) {
        this.cantElementos = cantelementos;
    }
    
    @Override
    public boolean esVacia() {
        return (this.inicio==null);               
    }

    @Override
    public void agregarInicio(Crucero dato) {
        NodoListaCrucero nuevo = new NodoListaCrucero(dato);
        nuevo.setSig(inicio);
        this.inicio=nuevo;
        if(this.fin==null)//estoy insertando el primer nodo
            this.fin=nuevo;
        
        this.cantElementos=this.cantElementos+1;        
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()){
            this.inicio=this.inicio.getSig();
            this.cantElementos=this.cantElementos-1;
        }        
    }

    @Override
    public void vaciar() {
        this.inicio=null;
        this.fin=null;
        this.cantElementos=0;        
    }

    @Override
    public void mostrar() {
        if (this.esVacia())
            System.out.println("La lista está vacía");
        else  {
            NodoListaCrucero aux=this.inicio;
            while (aux!=null)  {
                System.out.println(aux.getCrucero());
                aux=aux.getSig();
            }
        }        
    }

    @Override
    public void agregarOrd(Crucero dato) {
//        //lista vacìa o primer elemento es mayor o igual => agrego al ppio
//        Object datonodo = this.inicio.getDato();
//        if (this.esVacia() || (this.inicio.getDato() > dato ){
//            this.agregarInicio(n);
//            return;
//        }
//        if (this.fin.getDato()<=n){   //ùltimo elemento es menor o igual => agrego al final
//            this.agregarFinal(n);
//            return;
//        }
//        NodoListaCrucero aux=this.inicio;
//        while (aux.getSig()!=null && aux.getSig().getDato() < n)
//           ;
//        NodoListaCrucero nuevo=new NodoListaCrucero(n);
//        nuevo.setSig(aux.getSig());
//        aux.setSig(nuevo);        
    }

    @Override
    public Crucero buscarCruceroXNombre(String Nombre) {
       NodoListaCrucero aux= this.inicio;
       Crucero elCrucero = null;
         while (aux!=null){
             if (aux.getNombre().equals(Nombre))
                  elCrucero = aux.getCrucero();
             
             aux=aux.getSig();
         }
        return elCrucero;        
    }

    @Override
    public boolean buscarCrucero(String Nombre) {
       NodoListaCrucero aux = this.inicio;
       boolean retorno= false;
         while (aux!=null){
             if (aux.getNombre().equals(Nombre))
                  retorno =true;
             
             aux=aux.getSig();
         }
        return retorno;        
    }

    @Override
    public int cantElementos() {
        return this.cantElementos;        
    }
    
    @Override
    public void ordenarPorNombre()
    {
        
    }
}