
package oblm3a;

public class OBLM3A {

    public static void main(String[] args) {
        // TODO code application logic here
        Sistema S = new Sistema();
        //S.crearSistemaReservas(-4);
        prueba P = new prueba();
        prueba1(S,P);
        
    }
    
    static void prueba1(Sistema s, prueba p){
           /*p.ver(s.crearSistemaReservas(-4).resultado, Retorno.Resultado.ERROR_1, "Se intento crear Sistema de Reserva con < 0");
           p.ver(s.crearSistemaReservas(20).resultado, Retorno.Resultado.OK, "Se intento crear Sistema de Reserva con 20 Ciudades");
           p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
           p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intentoagregar Montevideo que ya existe");
           p.ver(s.registrarCiudad("Punta del Este").resultado, Retorno.Resultado.OK, "Se agrego Punta del Este");
           p.ver(s.registrarCiudad("La Paloma").resultado, Retorno.Resultado.OK, "Se agrego La Paloma");
           p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.ERROR_2, "Se intento agregar Maldonado pero el sistema esta completo");
           s.LC.mostrar();
           p.ver(s.registrarCrucero("Maldonado", "Crucero X", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
           p.ver(s.registrarCrucero("Maldonado", "Crucero y", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
           p.ver(s.registrarCrucero("Maldonado", "Crucero Z", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
           p.ver(s.registrarCrucero("La Paloma", "Crucero paloma Z", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a La Paloma");
           s.LC.mostrar();
           listarcrucerociudad(s);
           p.imprimirResultadosPrueba();
        */
        /*p.ver(s.crearSistemaReservas(20).resultado, Retorno.Resultado.OK, "Se intento crear Sistema de Reserva con 20 Ciudades");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "NO Se agrego Montevideo");
        p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se agrego Rocha");
        p.ver(s.registrarCrucero("Montevideo", "Crucero X", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
        //p.ver(s.registrarCrucero("Montevideo", "Crucero X", 2, 50).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
        //AC.buscar("Montevideo").getLcrucero();
        System.out.println(s.AC.existe("Montevideo"));
        System.out.println(s.AC.existe("Rocha"));
        System.out.println(s.AC.cantidad());*/
        
        s.crearSistemaReservas(20);
        s.registrarCiudad("C");
        s.registrarCiudad("A");
        s.registrarCiudad("D");
        
        System.out.println("Cantidad en Arbol: " + s.AC.cantidad());
        System.out.println("Existe A: " + s.AC.existe("A"));
        System.out.println("Existe D: " + s.AC.existe("D"));
        System.out.println("Existe C: " + s.AC.existe("C"));
        
        System.out.println();
        System.out.println();
        
        System.out.println("Raiz Arbol: " + s.AC.raiz.nombre);
        System.out.println("Raiz IZQ: " + s.AC.raiz.izq.raiz.nombre);
        System.out.println("Raiz DER: " + s.AC.raiz.der.raiz.nombre);
        
        String ciudad = "A";
        
        if (ciudad.compareTo(s.AC.raiz.nombre) == 0) {
                System.out.println("es == 0");
        }
        else {
                if (s.AC.raiz.nombre != null && ciudad.compareTo(s.AC.raiz.nombre) < 0) {
                    System.out.println("Entra en < 0 -- Raiz es : " + s.AC.raiz.nombre + "  ------- Raiz IZQ es : " + s.AC.raiz.izq.raiz.nombre);
                    //s.AC.raiz.izq.existe(ciudad);
                } else if (s.AC.raiz.nombre != null && ciudad.compareTo(s.AC.raiz.nombre) > 0) {
                    //raiz.der.existe(ciudad);
                    System.out.println("Entra en > 0 -- Raiz es : " + s.AC.raiz.nombre + " ------   Raiz DER es : " + s.AC.raiz.der.raiz.nombre);
                }
            }
        


        

        
        
        //s.LC.mostrar();
        //listarcrucerociudad(s);
        p.imprimirResultadosPrueba();
    }

/*static void listarcrucerociudad(Sistema s){
    NodoListaCiudad aux=s.LC.getInicio();
    while (aux !=null){
        System.out.println(aux.getNombreCiudad());
        aux.getLcrucero().mostrar();
        aux=aux.getSig();
        
    }
  
}*/
       
}
