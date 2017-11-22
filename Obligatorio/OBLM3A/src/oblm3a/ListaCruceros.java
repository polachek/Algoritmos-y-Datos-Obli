package oblm3a;

public class ListaCruceros implements IListaCrucero {

    private NodoListaCrucero inicio;
    private NodoListaCrucero fin;
    private int cantElementos;

    //Constructor
    public ListaCruceros(){
        this.inicio = null;
        this.fin = null;
        this.cantElementos = 0;
    }

    //Inicio
    public void setInicio(NodoListaCrucero i){
        inicio = i;
    }
    
    public NodoListaCrucero getInicio(){
        return inicio;
    }

    //Fin
    public void setFin(NodoListaCrucero f){
        fin = f;
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
        if (this.esVacia()){
            this.setInicio(nuevo);
            this.setFin(nuevo);
        }
        else{
            nuevo.setSig(inicio);
            this.inicio.setAnt(nuevo);
            this.setInicio(nuevo);
        }
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
    public ListaCruceros ordenarPorNombre()
    {
        ListaCruceros listaCruceros = this;
        ListaCruceros auxLiCru = new ListaCruceros();
        int cantidad = listaCruceros.getCantelementos();
        NodoListaCrucero inicio = this.getInicio();
        NodoListaCrucero siguiente = inicio.getSig();
        NodoListaCrucero aux = null;
      
        
        for(int i=0;i<cantidad-1;i++){
         
            for(int j=i+1;j<cantidad;j++){
           
                if(inicio.getNombre().compareTo(siguiente.getNombre())>0){

                    if(siguiente.getSig() == null){
                        aux = inicio;
                        
                        if(inicio.getSig() == siguiente){
                            inicio = siguiente;
                            siguiente = aux;
                            inicio.setSig(siguiente);
                            siguiente.setSig(null);                            
                        }else{
                            inicio = siguiente;
                            inicio.setSig(aux.getSig());
                            siguiente.getAnt().setSig(aux);
                            siguiente = aux;
                            siguiente.setSig(null);
                        }
                   }
                   else
                   {

                        aux = inicio;
                        
                        if(inicio.getSig() == siguiente){
                            
                        NodoListaCrucero auxDos = inicio.getSig().getSig();
                        inicio = siguiente;
                        inicio.setSig(aux);
                        siguiente = aux;
                        siguiente.setSig(auxDos);
                        siguiente.setAnt(inicio);
                        siguiente.getSig().setAnt(siguiente);
                        
                                                                                             
                        siguiente = siguiente.getSig();
                        }
                        else{
                        NodoListaCrucero auxDos = siguiente.getSig();
                        inicio = siguiente;
                        siguiente = aux;
                        inicio.setSig(aux.getSig());
    
                        inicio.getAnt().setSig(siguiente);
                        siguiente.setAnt(inicio.getAnt());
                        siguiente.setSig(auxDos);
                        siguiente.getSig().setAnt(siguiente);

                        
                        siguiente = siguiente.getSig();
                        }
                        
                    }
                } 
                else
                {
                    if(siguiente.getSig() != null)
                        siguiente = siguiente.getSig();
                }
                if(i == 0 && j == 1)
                    inicio.setAnt(null);
            }
                auxLiCru.agregarInicio(inicio.getCrucero());
                
                inicio = inicio.getSig();
                 if(inicio.getSig() == null){
                      auxLiCru.agregarInicio(inicio.getCrucero());
                      i = cantidad;
                      //listaCruceros.setInicio(inicio);
                 }else{
                     siguiente = inicio.getSig();
                 }
       
        }
        return auxLiCru;
       
    }
    
    @Override
    public ListaCruceros ordenarPorRanking()
    {
        ListaCruceros liCru = new ListaCruceros();
        liCru = this;
        ListaCruceros auxLiCru = new ListaCruceros();
        int cantidad = liCru.getCantelementos();
        NodoListaCrucero inicio = this.getInicio();
        NodoListaCrucero siguiente = inicio.getSig();
        NodoListaCrucero aux = null;
      
        
        for(int i=0;i<cantidad-1;i++){
         
            for(int j=i+1;j<cantidad;j++){
           
                if(inicio.getRanking() > siguiente.getRanking()){

                   if(siguiente.getSig() == null){
                        aux = inicio;
                        if(inicio.getSig() == siguiente){
                            inicio = siguiente;
                            siguiente = aux;
                            inicio.setSig(siguiente);
                            siguiente.setSig(null);                            
                        }else{
                            inicio = siguiente;
                            inicio.setSig(aux.getSig());
                            siguiente.getAnt().setSig(aux);
                            siguiente = aux;
                            siguiente.setSig(null);
                        }
                    }
                    else
                    {
                        aux = inicio;
                        if(inicio.getSig() == siguiente){
                            NodoListaCrucero auxDos = inicio.getSig().getSig();
                            inicio = siguiente;
                            inicio.setSig(aux);
                            siguiente = aux;
                            siguiente.setSig(auxDos);
                            siguiente.setAnt(inicio);
                            siguiente.getSig().setAnt(siguiente); 
                            siguiente = siguiente.getSig();
                            //Si es la primera iteración, y hago el cambio, seteo el puntero anterior de inicio igual nulo 
                            if(i == 0 && j == 1)
                                inicio.setAnt(null);
                        }
                        else{
                            NodoListaCrucero auxDos = siguiente.getSig();
                            inicio = siguiente;
                            siguiente = aux;
                            inicio.setSig(aux.getSig());

                            inicio.getAnt().setSig(siguiente);
                            siguiente.setAnt(inicio.getAnt());
                            siguiente.setSig(auxDos);
                            siguiente.getSig().setAnt(siguiente);
                            siguiente = siguiente.getSig();
                        }
                    }
                } 
                else{
                    if(siguiente.getSig() != null){
                        siguiente = siguiente.getSig();
                    }
                }
            }
            auxLiCru.agregarInicio(inicio.getCrucero());
            inicio = inicio.getSig();
            if(inicio.getSig() == null){
                auxLiCru.agregarInicio(inicio.getCrucero());
                i = cantidad;
            }else
                siguiente = inicio.getSig();
        }
        return auxLiCru;
    }     
}