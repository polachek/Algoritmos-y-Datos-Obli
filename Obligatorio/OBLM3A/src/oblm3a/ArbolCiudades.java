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

    public class NodoArbolCiudad {

        public String nombre;
        private ListaCrucero LCrucero;
        public ArbolCiudades izq;
        public ArbolCiudades der;

        public void NodoArbolCiudad() {
            this.nombre = null;
            this.izq = null;
            this.der = null;
            this.LCrucero = new ListaCrucero();
        }
    }

    public NodoArbolCiudad raiz;

    public ArbolCiudades() {
        NodoArbolCiudad raiz = new NodoArbolCiudad();
    }

    public ListaCrucero getLcrucero() {
        return raiz.LCrucero;
    }

    public void setLcrucero(ListaCrucero Lcrucero) {
        this.raiz.LCrucero = Lcrucero;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public Retorno.Resultado insertar(String unaCiudad) {
        Retorno.Resultado ret;
        if (esVacio()) {
            NodoArbolCiudad nuevo = new NodoArbolCiudad();
            nuevo.nombre = unaCiudad;
            nuevo.izq = new ArbolCiudades();
            nuevo.der = new ArbolCiudades();
            nuevo.LCrucero = new ListaCrucero();
            raiz = nuevo;
            ret = Retorno.Resultado.OK;
        } else {
            if (unaCiudad.compareTo(raiz.nombre) < 0) {
                raiz.izq.insertar(unaCiudad);
                ret = Retorno.Resultado.OK;
            } else {
                raiz.der.insertar(unaCiudad);
                ret = Retorno.Resultado.OK;
            }
        }
        return ret;
    }

    public void preOrder() {
        if (!esVacio()) {
            System.out.print(raiz.nombre + ", ");
            raiz.izq.preOrder();
            raiz.izq.preOrder();
        }
    }

    public void inOrder() {
        if (!esVacio()) {
            raiz.izq.inOrder();
            System.out.print(raiz.nombre + ", ");
            raiz.der.inOrder();
        }
    }

    public void posOrder() {
        if (!esVacio()) {
            raiz.der.posOrder();
            raiz.izq.posOrder();
            System.out.print(raiz.nombre + ", ");

        }
    }

    public boolean existe(String ciudad) {
        boolean ret = false;
        
        if (!this.esVacio()) {
            if (ciudad.compareTo(raiz.nombre) == 0) {
                ret = true;
            } else {
                if (raiz.nombre != null && ciudad.compareTo(raiz.nombre) < 0) {
                    raiz.izq.existe(ciudad);
                } else if (raiz.nombre != null && ciudad.compareTo(raiz.nombre) > 0) {
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
            if (ciudad.compareTo(raiz.nombre) == 0) {
                return this;
            } else {
                if (ciudad.compareTo(raiz.nombre) < 0) {
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
        String devuelvo = arbolActual.raiz.nombre;
        arbolActual.raiz = null;
        return devuelvo;
    }

    public String buscarMax() {
        ArbolCiudades arbolActual = this;
        while (!arbolActual.raiz.der.esVacio()) {
            arbolActual = arbolActual.raiz.der;
        }
        String devuelvo = arbolActual.raiz.nombre;
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

    public void eliminar(String ciudad) {
        ArbolCiudades paraEliminar = buscar(ciudad);
        if (!paraEliminar.esVacio()) {
            if (paraEliminar.esHoja()) {
                paraEliminar.raiz = null;
            } else {
                if (!paraEliminar.raiz.izq.esVacio() && !paraEliminar.raiz.der.esVacio()) {
                    paraEliminar.raiz.nombre = paraEliminar.raiz.der.buscarMin();
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
}
