
package oblm3a;

public class OBLM3A {

    public static void main(String[] args) {

        Sistema S = new Sistema();
        prueba P = new prueba();
        prueba(S,P);      
    }
    
    static void prueba(Sistema s, prueba p){
        System.out.println("########################################");
        System.out.println("####### TEST SISTEMA DE RESERVAS #######");
        System.out.println("########################################");
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades igual a 0");                
        p.ver(s.crearSistemaReservas(4).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades menor a 0");                
        p.ver(s.crearSistemaReservas(-1).resultado, Retorno.Resultado.ERROR_1, "No se crea el sistema de reservas");
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades mayor a 0");                
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST REGISTRO DE CIUDADES ######");
        System.out.println("#######################################");
        
        System.out.println();        
        System.out.println("PRUEBA: ciudad ingresada correctamente.");         
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Rocha").resultado, Retorno.Resultado.OK, "Se ingresa Rocha");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");        
        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York");        
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad a ingresar ya existe en el sistema.");                 
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        
        System.out.println();        
        System.out.println("PRUEBA: el sistema ya tiene todas las ciudades ingresadas.");          
        p.ver(s.registrarCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "Se sobrepasa el límite de ciudades gestionados por el sistema");
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST REGISTRO DE CRUCEROS ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: el crucero se ingresó correctamente.");                  
        p.ver(s.registrarCrucero("New York", "Royal Caribbean Int.", 5, 3000).resultado, Retorno.Resultado.OK, "Se agregó crucero Royal Caribbean a nueva york");
        p.ver(s.registrarCrucero("Montevideo", "Crucer", 3, 2800).resultado, Retorno.Resultado.OK, "Se agregó crucero Crucer a Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Carnival", 2, 2800).resultado, Retorno.Resultado.OK, "Se agregó crucero Carnival a Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Papa Mobil", 4, 500).resultado, Retorno.Resultado.OK, "Se agregó crucero Papa Mobil a Montevideo");
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: se ingresa crucero con cantidad de estrellas menor a uno o mayor a 5");         
        p.ver(s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800).resultado, Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: se ingresa crucero con capacidad menor a 0");                 
        p.ver(s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1).resultado, Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: en la ciudad ingresada ya existe un crucero con el nombre ingresado.");                         
        p.ver(s.registrarCrucero("New York", "Royal Caribbean Int.", 4, 3100).resultado, Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        System.out.println();        

        System.out.println();        
        System.out.println("PRUEBA: No existe la ciudad donde se intenta ingresar el crucero.");                                 
        p.ver(s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200).resultado, Retorno.Resultado.ERROR_4, "La ciudad no existe");
        
        System.out.println();

        
        System.out.println("#######################################");
        System.out.println("###### TEST INGRESO DE SERVICIOS ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: se ingresó servicio exitosamente.");          
        p.ver(s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.OK, "Servicio wifi");
        p.ver(s.ingresarServicio("New York", "Royal Caribbean Int.", "Spa").resultado, Retorno.Resultado.OK, "Servicio Spa");
        p.ver(s.ingresarServicio("New York", "Royal Caribbean Int.", "Discoteca").resultado, Retorno.Resultado.OK, "Servicio de Discoteca");
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: ya existe un servicio con el nombre ingresado.");
        p.ver(s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.ERROR_3, "Servicio repetido");
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: en la ciudad ingresada no existe un crucero con el nombre ingresado.");        
        p.ver(s.ingresarServicio("New York", "No Crucero", "Discoteca").resultado, Retorno.Resultado.ERROR_1, "No existe el Crucero para la Ciudad");
        System.out.println();

        System.out.println();        
        System.out.println("PRUEBA: no existe una ciudad con el nombre ingresado.");                
        p.ver(s.ingresarServicio("No Ciudad", "Royal Caribbean Int.", "Servicio de cuarto").resultado, Retorno.Resultado.ERROR_2, "No existe la Ciudad");
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST BORRAR SERVICIO ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: el servicio se borró exitosamente."); 
        p.ver(s.borrarServicio("New York", "Royal Caribbean Int.", "Spa").resultado, Retorno.Resultado.OK, "Borramos Servicio Spa");
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        p.ver(s.borrarServicio("New York", "No Crucero", "Discoteca").resultado, Retorno.Resultado.ERROR_1, "No existe el Crucero para la Ciudad");
        System.out.println();   
        
        System.out.println();        
        System.out.println("PRUEBA: el servicio que se intenta borrar no existe.");        
        p.ver(s.borrarServicio("New York", "Royal Caribbean Int.", "Choripan").resultado, Retorno.Resultado.ERROR_2, "No existe el Servicio");
        System.out.println();        
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");       
        p.ver(s.borrarServicio("No Ciudad", "Royal Caribbean Int.", "Discoteca").resultado, Retorno.Resultado.ERROR_3, "No existe la Ciudad");
        System.out.println();
        

        System.out.println("####################################");
        System.out.println("###### TEST REALIZAR RESERVAS ######");
        System.out.println("####################################");
        
        System.out.println();        
        System.out.println("PRUEBA: la reserva se realizó exitosamente."); 
        p.ver(s.realizarReserva(1, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 1 para el Royal Caribbean Int. de New york");
        p.ver(s.realizarReserva(2, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 2 para el Royal Caribbean Int. de New York");
        p.ver(s.realizarReserva(3, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 3 para el Royal Caribbean Int. New York");
        p.ver(s.realizarReserva(4, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realizó la reserva del cliente 4 para el Royal Caribbean Int. New York");
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        p.ver(s.realizarReserva(6, "New York", "NO CRUCERO").resultado,Retorno.Resultado.ERROR_1, "No existe el Crucero para la Ciudad");        
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        p.ver(s.realizarReserva(5, "NO CIUDAD", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "No existe la Ciudad");
        System.out.println();
        

        System.out.println("####################################");
        System.out.println("###### TEST CANCELAR RESERVAS ######");
        System.out.println("####################################"); 
        
        System.out.println();
        System.out.println("PRUEBA: la cancelación se realizó exitosamente.");
        System.out.println("Cantidad de Reservas antes de la cancelación: " + s.AC.buscar("New York").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());        
        p.ver(s.cancelarReserva(1, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se canceló la reserva del cliente 1 para el Royal Caribbean Int. New York");                
        p.ver(s.cancelarReserva(2, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se canceló la reserva del cliente 2 para el Royal Caribbean Int. New York");                        
        System.out.println("Cantidad de Reservas después de la cancelación: " + s.AC.buscar("New York").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        p.ver(s.cancelarReserva(1, "New York", "No crucero").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero en la ciudad ingresada.");                        
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: el cliente no tiene reservas para el crucero ingresado.");
        p.ver(s.cancelarReserva(45, "New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "El cliente no tiene reservas para el crucero ingresado");                        
        System.out.println();
             
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        p.ver(s.cancelarReserva(1, "No ciudad", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_3, "La ciudad ingresada no existe.");                        
        System.out.println();                
        
        System.out.println("######################################");
        System.out.println("###### TEST INGRESAR COMENTARIO ######");
        System.out.println("######################################");
        System.out.println();        
        System.out.println("PRUEBA: el comentario se ingresó exitosamente.");        
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "Muy lindo el crucero", 5).resultado,Retorno.Resultado.OK, "Comentario OK");
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "No estuvo mal", 3).resultado,Retorno.Resultado.OK, "Comentario OK");
        System.out.println(); 

        System.out.println();         
        System.out.println("PRUEBA: el ranking asignado es menor a 0 o mayor a 5.");        
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "Bonitazo el crucero", 10).resultado,Retorno.Resultado.ERROR_1, "Ranking > 5");
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "FEO el crucero", -8).resultado,Retorno.Resultado.ERROR_1, "Ranking < 0");
        System.out.println(); 

        System.out.println();         
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");        
        p.ver(s.ingresarComentario("New York", "NO CRUCERO", "Bonitazo el crucero", 5).resultado,Retorno.Resultado.ERROR_2, "No existe el crucero");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Bonitazo el crucero", 5).resultado,Retorno.Resultado.ERROR_2, "El crucero es de otra ciudad");
        System.out.println();        

        System.out.println();         
        System.out.println("PRUEBA: la ciudad ingresada no existe.");        
        p.ver(s.ingresarComentario("NO CIUDAD", "Royal Caribbean Int.", "Bonitazo el crucero", 5).resultado,Retorno.Resultado.ERROR_3, "No existe la ciudad");
        System.out.println();

        System.out.println("#####################################");
        System.out.println("###### TEST LISTA DE SERVICIOS ######");
        System.out.println("#####################################");
        
        System.out.println();        
        System.out.println("PRUEBA: listado de servicios.");
        p.ver(s.listarServicios("New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Listado de Servicios OK");
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: listado de servicios para un crucero sin servicios registrados.");        
        p.ver(s.listarServicios("Montevideo", "Crucer").resultado, Retorno.Resultado.OK, "Listado OK de Crucero sin servicios registrados");
        System.out.println();        
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");                
        p.ver(s.listarServicios("Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_1, "El Crucero no está registrado en la Ciudad");
        System.out.println();        

        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");       
        p.ver(s.listarServicios("NO CIUDAD", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad");
        
        
        
        System.out.println("#################################################");
        System.out.println("###### TEST LISTADO DE CRUCEROS POR CIUDAD ######");
        System.out.println("#################################################");
        System.out.println();        
        System.out.println("PRUEBA: listado de cruceros por ciudad.");  
        p.ver(s.listarCrucerosCiudad("Santiago").resultado, Retorno.Resultado.OK, "Listado OK de Ciudad sin Cruceros");
        p.ver(s.listarCrucerosCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Listado de cruceros de Montevideo");
        p.ver(s.listarCrucerosCiudad("New York").resultado, Retorno.Resultado.OK, "Listado de cruceros de New York");        
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        p.ver(s.listarCrucerosCiudad("NO CIUDAD").resultado, Retorno.Resultado.ERROR_1, "No existe ciudad");        
        System.out.println();
        
        System.out.println("###################################################################");
        System.out.println("###### TEST LISTADO DE CRUCEROS POR RANKING PARA UNA CIUDAD ######");
        System.out.println("###################################################################");
        System.out.println();        
        System.out.println("PRUEBA: listado de cruceros por ranking para una ciudad en orden ascendente.");  
        p.ver(s.listarCrucerosRankingAsc("Santiago").resultado, Retorno.Resultado.OK, "Listado OK de Ciudad sin Cruceros");
        p.ver(s.listarCrucerosRankingAsc("Montevideo").resultado, Retorno.Resultado.OK, "Listado de cruceros de Montevideo");
        p.ver(s.listarCrucerosRankingAsc("New York").resultado, Retorno.Resultado.OK, "Listado de cruceros de New York");        
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        p.ver(s.listarCrucerosRankingAsc("NO CIUDAD").resultado, Retorno.Resultado.ERROR_1, "No existe ciudad");        
        System.out.println();   
        
        System.out.println();        
        System.out.println("PRUEBA: listado de cruceros por ranking para una ciudad en orden descendente.");  
        p.ver(s.listarCrucerosRankingDesc("Santiago").resultado, Retorno.Resultado.OK, "Listado OK de Ciudad sin Cruceros");
        p.ver(s.listarCrucerosRankingDesc("Montevideo").resultado, Retorno.Resultado.OK, "Listado de cruceros de Montevideo");
        p.ver(s.listarCrucerosRankingDesc("New York").resultado, Retorno.Resultado.OK, "Listado de cruceros de New York");        
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        p.ver(s.listarCrucerosRankingDesc("NO CIUDAD").resultado, Retorno.Resultado.ERROR_1, "No existe ciudad");        
        System.out.println();           

        System.out.println("###################################################################");
        System.out.println("###### TEST LISTADO DE CRUCEROS POR RANKING                  ######");
        System.out.println("###################################################################");
        System.out.println();        
        System.out.println("PRUEBA: listado de cruceros por ranking general (TODAS LAS CIUDADES).");  
        p.ver(s.listarCrucerosRanking().resultado, Retorno.Resultado.OK, "Listado de cruceros para todas las ciudades");
        System.out.println();         
        
        
        System.out.println("####################################################");
        System.out.println("###### TEST LISTADO DE COMENTARIOS POR CIUDAD ######");
        System.out.println("####################################################");
        System.out.println();        
        System.out.println("PRUEBA: listado de comentarios.");          
        p.ver(s.listarComentarios("Montevideo", "Crucer").resultado, Retorno.Resultado.OK, "El crucero es de otra ciudad");
        p.ver(s.listarComentarios("New York", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "El crucero es de otra ciudad");
        System.out.println();

        System.out.println();          
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");          
        p.ver(s.listarComentarios("Montevideo", "No crucero").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero en la ciudad ingresada.");
        System.out.println(); 

        System.out.println();          
        System.out.println("PRUEBA: la ciudad ingresada no existe.");          
        p.ver(s.listarComentarios("No ciudad", "Crucer").resultado, Retorno.Resultado.ERROR_2, "La ciudad ingresada no existe.");
        System.out.println();         

        System.out.println("#####################################");
        System.out.println("####### TEST DESTRUIR SISTEMA #######");
        System.out.println("#####################################");
        System.out.println();  
       System.out.println("PRUEBA: destruir el sistema de reservas.");           
        p.ver(s.destruirSistemaReservas().resultado, Retorno.Resultado.OK, "Se destruye el sistema de reservas");
        System.out.println();         
        
        p.imprimirResultadosPrueba();
    }
}
