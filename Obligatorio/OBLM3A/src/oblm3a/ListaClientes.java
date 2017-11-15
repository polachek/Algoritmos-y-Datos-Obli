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
public class ListaClientes implements IListaClientes{

    private NodoListaCliente inicio;
    private NodoListaCliente fin;
   
    public ListaClientes(){
        this.inicio=null;
        this.fin=null;
    }    
    
    @Override
    public Cliente buscarClienteXId(int id) {
        NodoListaCliente aux = this.inicio;
        Cliente elCliente = null;
         while (aux != null){
             if (aux.miCliente.getId() == id)
                  elCliente = aux.getCliente();             
             aux=aux.getSig();
         }
        return elCliente; 
    }
    
}
