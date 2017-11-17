
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
        /*
        p.ver(s.crearSistemaReservas(20).resultado, Retorno.Resultado.OK, "Se intento crear Sistema de Reserva con 20 Ciudades");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se agrego Montevideo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "NO Se agrego Montevideo");
        p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se agrego Rocha");
        p.ver(s.registrarCrucero("Montevideo", "Crucero X", 1, 20).resultado, Retorno.Resultado.OK, "Se agrego crucero 1 a Maldonado");
        */
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");
        //p.ver(s.listarCrucerosCiudad("New York").resultado, Retorno.Resultado.ERROR_1, "Listado de cruceros de New York");
        //p.ver(s.registrarCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_2, "Se sobrepasa el límite de ciudades gestionados por el sistema");
        p.ver(s.registrarCrucero("New York", "Royal Caribbean Int.", 5, 3000).resultado, Retorno.Resultado.OK, "Se agrego curcero Royal Caribbean a nueva york");
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800).resultado, Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1).resultado, Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("New York", "Royal Caribbean Int.", 4, 3100).resultado, Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200).resultado, Retorno.Resultado.ERROR_4, "La ciudad no existe");
        //p.ver(s.listarCrucerosCiudad("New York").resultado, Retorno.Resultado.ERROR_1, "Listado de cruceros de New York");
        p.ver(s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.OK, "Servicio wifi");
        p.ver(s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.ERROR_1, "Servicio repetido");
       
/*
        p.ver(s.realizarReserva(1, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 1 para el Royal Caribbean Int. de New york");

        p.ver(s.realizarReserva(2, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 2 para el Royal Caribbean Int. de New York");

        p.ver(s.realizarReserva(3, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 3 para el Royal Caribbean Int. New York");

        p.ver(s.realizarReserva(4, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 4 para el Royal Caribbean Int. New York");

        p.ver(s.cancelarReserva(1, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se canceló la reserva del cliente 1 para el Royal Caribbean Int. de New York, pasa el cliente 4 de a lista de espera");

        p.ver(s.listarServicios("New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_1, "servicios de Royal Caribbean Int. new york");

*/
        
        
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
