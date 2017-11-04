
package oblm3a;

public class OBLM3A {

    public static void main(String[] args) {
        // TODO code application logic here
        Sistema S = new Sistema();
        S.crearSistemaReservas(4);
        prueba P = new prueba();
        prueba1(S,P);
        
    }
    
    static void prueba1(Sistema s, prueba p){
           p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
           p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Se intentoagregar Montevideo que ya existe");
           p.ver(s.registrarCiudad("Punta del Este").resultado, Retorno.Resultado.OK, "Se agrego Punta del Este");
           p.ver(s.registrarCiudad("La Paloma").resultado, Retorno.Resultado.OK, "Se agrego La Paloma");
           p.ver(s.registrarCiudad("Maldonado").resultado, Retorno.Resultado.ERROR_2, "Se intento agregar Maldonado pero el sistema esta completo");
           p.ver(s.registrarCrucero("Maldonado", "Crucero X", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
           p.ver(s.registrarCrucero("Maldonado", "Crucero y", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
           p.ver(s.registrarCrucero("Maldonado", "Crucero Z", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
           p.ver(s.registrarCrucero("La Paloma", "Crucero paloma Z", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a La Paloma");
           s.LC.mostrar();
           listarcurcerociudad(s);
           
                      
           p.imprimirResultadosPrueba();
    }

static void listarcurcerociudad(Sistema s){
    NodoListaCiudad aux=s.LC.getInicio();
    while (aux !=null){
        System.out.println(aux.getNombreCiudad());
        aux.getLcrucero().mostrar();
        aux=aux.getSig();
        
    }
  
}
        
    
    
}
