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
public class ArbolCiudades implements IArbolCiudades {

    public NodoArbolCiudad raiz;

    public ArbolCiudades() {
        NodoArbolCiudad raiz = new NodoArbolCiudad();
    }

    public ListaCruceros getLcrucero() {
        return raiz.LCrucero;
    }

    public void setLcrucero(ListaCruceros Lcrucero) {
        this.raiz.LCrucero = Lcrucero;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public Retorno.Resultado insertar(String unaCiudad) {
        Retorno.Resultado ret;
        if (esVacio()) {
            NodoArbolCiudad nuevo = new NodoArbolCiudad();
            nuevo.ciudad.setNombre(unaCiudad);
            nuevo.izq = new ArbolCiudades();
            nuevo.der = new ArbolCiudades();
            nuevo.LCrucero = new ListaCruceros();
            raiz = nuevo;
            ret = Retorno.Resultado.OK;
        }
        else {
            if (unaCiudad.compareTo(raiz.ciudad.getNombre()) > 0){
                raiz.izq.insertar(unaCiudad);
                ret = Retorno.Resultado.OK;      
            } 
            else{
                raiz.der.insertar(unaCiudad);
                ret = Retorno.Resultado.OK;
            }                
        }
        return ret;
    }

    public void preOrder() {
        if (!esVacio()) {
            System.out.print(raiz.ciudad.getNombre() + ", ");
            raiz.izq.preOrder();
            raiz.izq.preOrder();
        }
    }

    public void inOrder() {
        if (!esVacio()) {
            raiz.izq.inOrder();
            System.out.print(raiz.ciudad.getNombre() + ", ");
            raiz.der.inOrder();
        }
    }

    public void posOrder() {
        if (!esVacio()) {
            raiz.der.posOrder();
            raiz.izq.posOrder();
            System.out.print(raiz.ciudad.getNombre() + ", ");

        }
    }
    
    public boolean existe(String ciudad){
        boolean ret = false;
        
        if (!this.esVacio()) {
            if (ciudad == raiz.ciudad.getNombre()) {
                ret = true;
            }
            else {
                if (raiz.ciudad.getNombre() != null && ciudad.compareTo(raiz.ciudad.getNombre()) < 0) {
                    raiz.izq.existe(ciudad);
                } else if (raiz.ciudad.getNombre() != null && ciudad.compareTo(raiz.ciudad.getNombre()) > 0) {
                    raiz.der.existe(ciudad);
                }
            }
        }
        return ret;
    }

    public int cantidad() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + raiz.der.cantidad() + raiz.izq.cantidad());
        }
    }

    public int altura() {
        if (esVacio()) {
            return 0;
        } else {
            return (1 + Math.max(((raiz.izq).altura()), ((raiz.der).altura())));
        }
    }

    public ArbolCiudades buscar(String ciudad) {
        ArbolCiudades arbolito = null;
        if (!esVacio()) {
            if (ciudad.compareTo(raiz.ciudad.getNombre()) == 0) {
                return this;
            } else {
                if (ciudad.compareTo(raiz.ciudad.getNombre()) < 0) {
                    arbolito = raiz.izq.buscar(ciudad);
                } else {
                    arbolito = raiz.der.buscar(ciudad);
                }
            }
        }
        return arbolito;
    }

    public String buscarMin() {
        ArbolCiudades arbolActual = this;
        while (!arbolActual.raiz.izq.esVacio()) {
            arbolActual = arbolActual.raiz.izq;
        }
        String devuelvo = arbolActual.raiz.ciudad.getNombre();
        arbolActual.raiz = null;
        return devuelvo;
    }

    public String buscarMax() {
        ArbolCiudades arbolActual = this;
        while (!arbolActual.raiz.der.esVacio()) {
            arbolActual = arbolActual.raiz.der;
        }
        String devuelvo = arbolActual.raiz.ciudad.getNombre();
        arbolActual.raiz = null;
        return devuelvo;
    }

    public boolean esHoja() {
        boolean hoja = false;
        if ((raiz.izq).esVacio() && (raiz.der).esVacio()) {
            hoja = true;
        }
        return hoja;
    }
    
    /*
    public void eliminar(String ciudad) {
        ArbolCiudades paraEliminar = buscar(ciudad);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            } else {
                if (!paraEliminar.raiz.izq.esVacio() && !paraEliminar.raiz.der.esVacio()) {
                    paraEliminar.raiz.ciudad.getNombre() = paraEliminar.raiz.der.buscarMin();
                } else {
                    if (paraEliminar.raiz.izq.esVacio()) {
                        paraEliminar.raiz = paraEliminar.raiz.der.raiz;
                    } else {
                        paraEliminar.raiz = paraEliminar.raiz.izq.raiz;
                    }
                }
            }
        }
    }
    */
    
}
