
package oblm3a;

public class OBLM3A {

    public static void main(String[] args) {
        Sistema S = new Sistema();
        Sistema SistMatriz = new Sistema();        
        prueba P = new prueba();
        
        /*####################################################################*/
        /*    OBLIGATORIO  */
        /*####################################################################*/        
        //pruebaObligatorio(S,P);
        //pruebaMatriz(SistMatriz,P);
        /*####################################################################*/
        /*    DEFENSA  */ 
        /*####################################################################*/        
        //prueba0(S,P);
        prueba9(S,P);
        
    }
    
    static void pruebaObligatorio(Sistema s, prueba p){
        
        Retorno r = new Retorno();
        
        System.out.println("########################################");
        System.out.println("####### TEST SISTEMA DE RESERVAS #######");
        System.out.println("########################################");
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades igual a 0");
        r = s.crearSistemaReservas(0);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades menor a 0"); 
        r = s.crearSistemaReservas(-1);        
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades mayor a 0");  
        r = s.crearSistemaReservas(5);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST REGISTRO DE CIUDADES ######");
        System.out.println("#######################################");
        
        System.out.println();        
        System.out.println("PRUEBA: ciudad ingresada correctamente.");
        r = s.registrarCiudad("Montevideo");
        p.ver(r.resultado, Retorno.Resultado.OK,r.valorString );
        r = s.registrarCiudad("Rocha");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.registrarCiudad("Santiago");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.registrarCiudad("San Pablo");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.registrarCiudad("New York"); 
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);        
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad a ingresar ya existe en el sistema.");                 
        r = s.registrarCiudad("Montevideo");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        
        System.out.println();        
        System.out.println("PRUEBA: el sistema ya tiene todas las ciudades ingresadas.");          
        r = s.registrarCiudad("Buenos Aires"); 
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST REGISTRO DE CRUCEROS ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: el crucero se ingresó correctamente."); 
        r = s.registrarCrucero("New York", "Royal Caribbean Int.", 5, 3000);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.registrarCrucero("Montevideo", "Crucer", 3, 2800);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.registrarCrucero("Montevideo", "Carnival", 2, 2800);
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.registrarCrucero("Montevideo", "Papa Mobil", 4, 500); 
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: se ingresa crucero con cantidad de estrellas menor a uno o mayor a 5");         
        r = s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800); 
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: se ingresa crucero con capacidad menor a 0");
        r = s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1);
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: en la ciudad ingresada ya existe un crucero con el nombre ingresado.");                         
        r = s.registrarCrucero("New York", "Royal Caribbean Int.", 4, 3);
        p.ver(r.resultado, Retorno.Resultado.ERROR_3, r.valorString);
        System.out.println();        

        System.out.println();        
        System.out.println("PRUEBA: No existe la ciudad donde se intenta ingresar el crucero.");                                 
        r = s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200);
        p.ver(r.resultado, Retorno.Resultado.ERROR_4, r.valorString);        
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST INGRESO DE SERVICIOS ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: se ingresó servicio exitosamente.");          
        r = s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi"); 
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.ingresarServicio("New York", "Royal Caribbean Int.", "Spa");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.ingresarServicio("New York", "Royal Caribbean Int.", "Discoteca"); 
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: ya existe un servicio con el nombre ingresado.");
        r = s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi"); 
        p.ver(r.resultado, Retorno.Resultado.ERROR_3, r.valorString);
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: en la ciudad ingresada no existe un crucero con el nombre ingresado.");        
        r = s.ingresarServicio("New York", "No Crucero", "Discoteca");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        System.out.println();

        System.out.println();        
        System.out.println("PRUEBA: no existe una ciudad con el nombre ingresado.");                
        r = s.ingresarServicio("No Ciudad", "Royal Caribbean Int.", "Servicio de cuarto");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST BORRAR SERVICIO ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: el servicio se borró exitosamente."); 
        r = s.borrarServicio("New York", "Royal Caribbean Int.", "Spa");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        r = s.borrarServicio("New York", "No Crucero", "Discoteca");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);
        System.out.println();   
        
        System.out.println();        
        System.out.println("PRUEBA: el servicio que se intenta borrar no existe.");
        r = s.borrarServicio("New York", "Royal Caribbean Int.", "Choripan");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        System.out.println();        
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        r = s.borrarServicio("No Ciudad", "Royal Caribbean Int.", "Discoteca"); 
        p.ver(r.resultado, Retorno.Resultado.ERROR_3, r.valorString);
        System.out.println();
        

        System.out.println("####################################");
        System.out.println("###### TEST REALIZAR RESERVAS ######");
        System.out.println("####################################");
        
        System.out.println();        
        System.out.println("PRUEBA: la reserva se realizó exitosamente."); 
        r = s.realizarReserva(1, "New York", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.realizarReserva(2, "New York", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.realizarReserva(3, "New York", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        r = s.realizarReserva(4, "New York", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        r = s.realizarReserva(6, "New York", "NO CRUCERO"); 
        p.ver(r.resultado,Retorno.Resultado.ERROR_1, r.valorString);        
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        r = s.realizarReserva(5, "NO CIUDAD", "Royal Caribbean Int."); 
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);
        System.out.println();
        

        System.out.println("####################################");
        System.out.println("###### TEST CANCELAR RESERVAS ######");
        System.out.println("####################################"); 
        
        System.out.println();
        System.out.println("PRUEBA: la cancelación se realizó exitosamente.");        
        System.out.println("Cantidad de Reservas antes de la cancelación: " + s.AC.buscar("New York").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());        
        r = s.cancelarReserva(1, "New York", "Royal Caribbean Int."); 
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);                
        r = s.cancelarReserva(2, "New York", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);                        
        System.out.println("Cantidad de Reservas después de la cancelación: " + s.AC.buscar("New York").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        r = s.cancelarReserva(1, "New York", "No crucero");
        p.ver(r.resultado, Retorno.Resultado.ERROR_1, r.valorString);                        
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: el cliente no tiene reservas para el crucero ingresado.");
        r = s.cancelarReserva(45, "New York", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.ERROR_2, r.valorString);                        
        System.out.println();
             
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        r = s.cancelarReserva(1, "No ciudad", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.ERROR_3, r.valorString);                        
        System.out.println();                
        
        System.out.println("######################################");
        System.out.println("###### TEST INGRESAR COMENTARIO ######");
        System.out.println("######################################");
                
        s.ingresarComentario("Montevideo", "Crucer", "Ho-rri-ble", 1);
        s.ingresarComentario("Montevideo", "Carnival", "Más o menos la calidad eh", 3);        
        
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
        p.ver(s.destruirSistemaReservas().resultado, Retorno.Resultado.OK, s.destruirSistemaReservas().valorString);
        System.out.println();         
                
        p.imprimirResultadosPrueba();
    }
    
    static void pruebaMatriz(Sistema s, prueba p){

        System.out.println("########################################");
        System.out.println("####### EJERCICIO COMPLEMENTARIO #######");
        System.out.println("########################################");
        
        System.out.println("####### CARGAR MATRIZ #######");
        int [][] mapa={{0,10,25,15,30,0},{10,0,20,0,0,0},{25,20,0,0,0,40},{15,0,0,0,0,45},{30,0,0,0,0,25},{0,0,40,45,25,0}};
        
        p.ver(s.crearSistemaReservas(7).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas.");
        
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo.");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago.");        
        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima.");        
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo.");                
        p.ver(s.registrarCiudad("Panamá").resultado, Retorno.Resultado.OK, "Se ingresa Panamá.");                        
        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.OK, "Se ingresa New York.");                        
        
      
        p.ver(s.cargarDistancias(mapa).resultado, Retorno.Resultado.OK, s.cargarDistancias(mapa).valorString); 
        Retorno r99 = s.buscarCamino(mapa, "Montevideo", "New York");
        p.ver(r99.resultado, Retorno.Resultado.OK,r99.valorString); 
        
        
        p.imprimirResultadosPrueba();        
    }
    
    /*#########################################################################*/
    //DEFENSA
    /*#########################################################################*/    
    public static void prueba0(Sistema s, prueba p) {
        
        System.out.println("------------------CREACION DEL SISTEMA------------------");
        p.ver(s.crearSistemaReservas(-3).resultado,Retorno.Resultado.ERROR_1,"No se crea el sistema de reservas por tener tope negativo");
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas con un tope de 5 ciudades");
        
        System.out.println("------------------INGRESO DE CIUDADES------------------");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCiudad("Santiago").resultado, Retorno.Resultado.OK, "Se ingresa Santiago");
        p.ver(s.registrarCiudad("Lima").resultado, Retorno.Resultado.OK, "Se ingresa Lima");
        p.ver(s.registrarCiudad("San Pablo").resultado, Retorno.Resultado.OK, "Se ingresa San Pablo");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.ERROR_1, "Montevideo ya existe");
        p.ver(s.registrarCiudad("Panamá").resultado, Retorno.Resultado.OK, "Se ingresa Panamá");
        p.ver(s.registrarCiudad("New York").resultado, Retorno.Resultado.ERROR_2, "No se ingresa New York, por superar el tope");
        
        System.out.println("------------------LISTO CIUDADES------------------");
        //s.LCiudad.mostrar();//listo ciudades ingresadas
        
        System.out.println("------------------REGISTRO CRUCEROS------------------");
        p.ver(s.registrarCrucero("Montevideo", "MSC Poesia", 3, 2000).resultado, Retorno.Resultado.OK, "Se registra crucero MSC a Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Carnival Cruise Line", 4, 2500).resultado, Retorno.Resultado.OK, "Se registra crucero Carnival a Montevideo");
        p.ver(s.registrarCrucero("Panamá", "Costa Cruise", 3, 3000).resultado, Retorno.Resultado.OK, "Se registra crucero Costa Cruise a Panamá");
        p.ver(s.registrarCrucero("San Pablo", "Royal Caribbean Int.", 5, 4000).resultado, Retorno.Resultado.OK, "Se registra crucero Royal Caribbean Int. a San Pablo");
        p.ver(s.registrarCrucero("Santiago", "Disney Cruise Line", 4, 3200).resultado, Retorno.Resultado.OK, "Se registra crucero Disney Cruise Line a Santiago");
        p.ver(s.registrarCrucero("Santiago", "Holland America Line", 6, 2800).resultado, Retorno.Resultado.ERROR_1, "La cantidad de estrellas no está entre 1 y 5");  
        p.ver(s.registrarCrucero("Santiago", "Princess Cruises", 5, -1).resultado, Retorno.Resultado.ERROR_2, "La capacidad es menor a 0");
        p.ver(s.registrarCrucero("Montevideo", "MSC Poesia", 4, 3100).resultado, Retorno.Resultado.ERROR_3, "Ya existe un crucero con ese nombre para Montevideo");
        p.ver(s.registrarCrucero("New York", "Norwegian Cruise Line", 5, 3000).resultado, Retorno.Resultado.ERROR_4, "La ciudad no existe");
        
        System.out.println("------------------LISTO CRUCEROS INGRESADOS------------------");
        //s.LCrucero.mostrarTodos();//listo cruceros ingresados
        
        System.out.println("------------------REGISTRO SERVICIOS------------------");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Wifi").resultado, Retorno.Resultado.OK, "Servicio wifi en MSC Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Shopping a bordo").resultado, Retorno.Resultado.OK, "Servicio Shopping a bordo en MSC Montevideo");
        p.ver(s.ingresarServicio("Montevideo", "MSC Poesia", "Guarderia").resultado, Retorno.Resultado.OK, "Servicio guarderia en MSC Montevideo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Wifi").resultado, Retorno.Resultado.OK, "Servicio wifi en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Shopping a bordo").resultado, Retorno.Resultado.OK, "Servicio Shopping a bordo en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Royal Caribbean Int.", "Guarderia").resultado, Retorno.Resultado.OK, "Servicio guarderia en Royal San Pablo");
        p.ver(s.ingresarServicio("San Pablo", "Holland America Line", "Guarderia").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.ingresarServicio("New York", "Norwegian Cruise Line", "Guarderia").resultado, Retorno.Resultado.ERROR_2, "La ciudad no existe");
    
        System.out.println("------------------ELIMINO SERVICIOS------------------");
        p.ver(s.borrarServicio("Montevideo", "MSC Poesia", "Wifi").resultado, Retorno.Resultado.OK, "Borro servicio wifi en MSC Montevideo");
        p.ver(s.borrarServicio("San Pablo", "Holland America Line", "Guarderia").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.borrarServicio("Montevideo", "MSC Poesia", "Lavanderia").resultado, Retorno.Resultado.ERROR_2, "No existe el servicio en el crucero");
        p.ver(s.borrarServicio("New York", "Norwegian Cruise Line", "Guarderia").resultado, Retorno.Resultado.ERROR_3, "La ciudad no existe");
        
        System.out.println("------------------REALIZO RESERVAS------------------");
        p.ver(s.realizarReserva(1, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Reserva en MSC Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Holland America Line").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.realizarReserva(7, "New York", "Norwegian Cruise Line").resultado, Retorno.Resultado.ERROR_2, "La ciudad no existe");

        System.out.println("------------------CANCELO RESERVAS------------------");
        p.ver(s.cancelarReserva(2, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Se elimina reserva");
        p.ver(s.cancelarReserva(8, "Montevideo", "MSC Poesia").resultado, Retorno.Resultado.ERROR_2, "El cliente no tiene reserva en el crucero");
        p.ver(s.cancelarReserva(2, "Montevideo", "Holland America Line").resultado, Retorno.Resultado.ERROR_1, "No existe ese crucero en la ciudad");
        p.ver(s.cancelarReserva(3, "New York", "Holland America Line").resultado, Retorno.Resultado.ERROR_3, "La ciudad no existe");

        System.out.println("------------------INGRESO COMENTARIO------------------");
        p.ver(s.ingresarComentario("Santiago", "Disney Cruise Line", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero Disney Cruise Line de Santiago");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Mala limpieza", 2).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Nos gusto mucho el crucero", 3).resultado, Retorno.Resultado.OK, "Se ingresa comentario a crucero MSC Poesia de Montevideo");
        p.ver(s.ingresarComentario("Montevideo", "MSC Poesia", "Muy recomendable", 10).resultado, Retorno.Resultado.ERROR_1, "Ranking mayor a 5");
        p.ver(s.ingresarComentario("Montevideo", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.ERROR_2, "No existe el crucero en la ciudad");
        p.ver(s.ingresarComentario("New York", "Royal Caribbean Int.", "Muy lindo crucero, personal muy amable", 4).resultado, Retorno.Resultado.ERROR_3, "No existe la ciudad");
        
        System.out.println("------------------LISTO SERVICIOS------------------");
        p.ver(s.listarServicios("Panamá", "Costa Cruise").resultado, Retorno.Resultado.OK, "Se listan servicios de crucero");
        p.ver(s.listarServicios("Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Se listan servicios de crucero");
        p.ver(s.listarServicios("Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe el crucero en la ciudad");
        p.ver(s.listarServicios("Buenos Aires", "MSC Poesia").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad");
       
        System.out.println("------------------LISTO CRUCEROS POR CIUDAD------------------");
        p.ver(s.listarCrucerosCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosCiudad("Lima").resultado, Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosCiudad("Panamá").resultado, Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosCiudad("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad");

        System.out.println("------------------LISTO CRUCEROS POR RANKING ASCENDENTE PARA UNA CIUDAD------------------");
        p.ver(s.listarCrucerosRankingAsc("Montevideo").resultado, Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosRankingAsc("Lima").resultado, Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosRankingAsc("Panamá").resultado, Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosRankingAsc("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad");
        
        System.out.println("------------------LISTO CRUCEROS POR RANKING DESCENDENTE PARA UNA CIUDAD------------------");
        p.ver(s.listarCrucerosRankingDesc("Montevideo").resultado, Retorno.Resultado.OK, "Lista de cruceros en Montevideo");
        p.ver(s.listarCrucerosRankingDesc("Lima").resultado, Retorno.Resultado.OK, "Lista de cruceros en Lima");
        p.ver(s.listarCrucerosRankingDesc("Panamá").resultado, Retorno.Resultado.OK, "Lista de cruceros en Panamá");
        p.ver(s.listarCrucerosRankingDesc("Buenos Aires").resultado, Retorno.Resultado.ERROR_1, "No existe la ciudad");
        
        System.out.println("------------------LISTO TODOS LOS CRUCEROS POR RANKING------------------");
        p.ver(s.listarCrucerosRanking().resultado, Retorno.Resultado.OK, "Listado de cruceros por ranking");
        
        System.out.println("------------------LISTO COMENTARIOS------------------");
        p.ver(s.listarComentarios("Montevideo", "MSC Poesia").resultado, Retorno.Resultado.OK, "Listado de comentarios");
        p.ver(s.listarComentarios("Santiago", "Disney Cruise Line").resultado, Retorno.Resultado.OK, "Listado de comentarios");
        p.ver(s.listarComentarios("Lima", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe el crucero en la ciudad");
        p.ver(s.listarComentarios("San Francisco", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_2, "No existe la ciudad");
        
        System.out.println("------------------CAMINO MAS CORTO------------------");
        int [][]ciudades = {{0,10,25,15,30,0},{10,0,20,0,0,0},{25,20,0,0,0,40},{15,0,0,0,0,45},{30,0,0,0,0,25},{0,0,40,45,25,0}};
        p.ver(s.cargarDistancias(ciudades).resultado, Retorno.Resultado.OK, "Se cargan las distancias");
        p.ver(s.buscarCamino(ciudades, "Montevideo", "Santiago").resultado, Retorno.Resultado.OK, "Buscar camino mas corto");    
        
        System.out.println("------------------SE DESTRUYE EL SISTEMA DE RESERVAS------------------");
        p.ver(s.destruirSistemaReservas().resultado,Retorno.Resultado.OK,"Se elimina el sistema de reservas");
        
        p.imprimirResultadosPrueba();
    } 

    //_realizarRerserva
    public static void prueba9(Sistema s, prueba p) {
        Retorno r = new Retorno();

        
        p.ver(s.crearSistemaReservas(5).resultado, Retorno.Resultado.OK, "Se crea el sistema de reservas");
        p.ver(s.registrarCiudad("Montevideo").resultado, Retorno.Resultado.OK, "Se ingresa Montevideo");
        p.ver(s.registrarCrucero("Montevideo", "Royal Caribbean Int.", 5, 3).resultado, Retorno.Resultado.OK, "Se ingresa Royal Caribbean Int. en Montevideo");
        p.ver(s.realizarReserva(1, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(2, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 2 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(3, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se realiza la reserva del cliente 3 para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(4, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "El cliente 4 queda en lista de espera para el Royal Caribbean Int. de Montevideo");
        p.ver(s.realizarReserva(5, "Montevideo", "Disney Cruise Line").resultado, Retorno.Resultado.ERROR_1, "No existe un crucero de nombre Disney Cruise Line en Montevideo");
        p.ver(s.realizarReserva(6, "San Pablo", "Royal Caribbean Int.").resultado, Retorno.Resultado.ERROR_2, "Se intenta agregar crucero a ciuedad que No existe la ciudad San Pablo");

        r = s.listarReserva("Montevideo", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);        
        
        System.out.println("Cantidad de Reservas antes de la cancelación: " + s.AC.buscar("Montevideo").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());        
        p.ver(s.cancelarReserva(2, "Montevideo", "Royal Caribbean Int.").resultado, Retorno.Resultado.OK, "Se cancela la reserva del cliente 1 para el Royal Caribbean Int. de Montevideo");
        
        r = s.listarReserva("Montevideo", "Royal Caribbean Int.");
        p.ver(r.resultado, Retorno.Resultado.OK, r.valorString);        
        
        p.imprimirResultadosPrueba();
    }    

    
}
