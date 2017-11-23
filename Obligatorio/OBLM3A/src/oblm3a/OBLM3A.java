
package oblm3a;

public class OBLM3A {

    public static void main(String[] args) {
        Sistema S = new Sistema();
        Sistema SistMatriz = new Sistema();        
        prueba P = new prueba();
        pruebaObligatorio(S,P);
        pruebaMatriz(SistMatriz,P);
    }
    
    static void pruebaObligatorio(Sistema s, prueba p){
        

        
        System.out.println("########################################");
        System.out.println("####### TEST SISTEMA DE RESERVAS #######");
        System.out.println("########################################");
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades igual a 0");
        Retorno r1 = s.crearSistemaReservas(0);
        p.ver(r1.resultado, Retorno.Resultado.OK, r1.valorString);
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades menor a 0"); 
        Retorno r2 = s.crearSistemaReservas(-1);        
        p.ver(r2.resultado, Retorno.Resultado.ERROR_1, r2.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: cantidad de ciudades mayor a 0");  
        Retorno r3 = s.crearSistemaReservas(5);
        p.ver(r3.resultado, Retorno.Resultado.OK, r3.valorString);
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST REGISTRO DE CIUDADES ######");
        System.out.println("#######################################");
        
        System.out.println();        
        System.out.println("PRUEBA: ciudad ingresada correctamente.");
        Retorno r4 = s.registrarCiudad("Montevideo");
        p.ver(r4.resultado, Retorno.Resultado.OK,r4.valorString );
        Retorno r5 = s.registrarCiudad("Rocha");
        p.ver(r5.resultado, Retorno.Resultado.OK, r5.valorString);
        Retorno r6 = s.registrarCiudad("Santiago");
        p.ver(r6.resultado, Retorno.Resultado.OK, r6.valorString);
        Retorno r7 = s.registrarCiudad("San Pablo");
        p.ver(r7.resultado, Retorno.Resultado.OK, r7.valorString);
        Retorno r8 = s.registrarCiudad("New York"); 
        p.ver(r8.resultado, Retorno.Resultado.OK, r8.valorString);        
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad a ingresar ya existe en el sistema.");                 
        Retorno r9 = s.registrarCiudad("Montevideo");
        p.ver(r9.resultado, Retorno.Resultado.ERROR_1, r9.valorString);
        
        System.out.println();        
        System.out.println("PRUEBA: el sistema ya tiene todas las ciudades ingresadas.");          
        Retorno r10 = s.registrarCiudad("Buenos Aires"); 
        p.ver(r10.resultado, Retorno.Resultado.ERROR_1, r10.valorString);
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST REGISTRO DE CRUCEROS ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: el crucero se ingresó correctamente."); 
        Retorno r11 = s.registrarCrucero("New York", "Royal Caribbean Int.", 5, 3000);
        p.ver(r11.resultado, Retorno.Resultado.OK, r11.valorString);
        Retorno r12 = s.registrarCrucero("Montevideo", "Crucer", 3, 2800);
        p.ver(r12.resultado, Retorno.Resultado.OK, r12.valorString);
        Retorno r13 = s.registrarCrucero("Montevideo", "Carnival", 2, 2800);
        p.ver(r13.resultado, Retorno.Resultado.OK, r13.valorString);
        Retorno r14 = s.registrarCrucero("Montevideo", "Papa Mobil", 4, 500); 
        p.ver(r14.resultado, Retorno.Resultado.OK, r14.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: se ingresa crucero con cantidad de estrellas menor a uno o mayor a 5");         
        Retorno r15 = s.registrarCrucero("Santiago", "Carnival Cruise Lines", 6, 2800); 
        p.ver(r15.resultado, Retorno.Resultado.ERROR_1, r15.valorString);
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: se ingresa crucero con capacidad menor a 0");
        Retorno r16 = s.registrarCrucero("Santiago", "Royal Caribbean Int.", 5, -1);
        p.ver(r16.resultado, Retorno.Resultado.ERROR_2, r16.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: en la ciudad ingresada ya existe un crucero con el nombre ingresado.");                         
        Retorno r17 = s.registrarCrucero("New York", "Royal Caribbean Int.", 4, 3);
        p.ver(r17.resultado, Retorno.Resultado.ERROR_3, r17.valorString);
        System.out.println();        

        System.out.println();        
        System.out.println("PRUEBA: No existe la ciudad donde se intenta ingresar el crucero.");                                 
        Retorno r18 = s.registrarCrucero("Lima", "Disney Cruise Line", 5, 2200);
        p.ver(r18.resultado, Retorno.Resultado.ERROR_4, r18.valorString);        
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST INGRESO DE SERVICIOS ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: se ingresó servicio exitosamente.");          
        Retorno r19 = s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi"); 
        p.ver(r19.resultado, Retorno.Resultado.OK, r19.valorString);
        Retorno r20 = s.ingresarServicio("New York", "Royal Caribbean Int.", "Spa");
        p.ver(r20.resultado, Retorno.Resultado.OK, r20.valorString);
        Retorno r21 =s.ingresarServicio("New York", "Royal Caribbean Int.", "Discoteca"); 
        p.ver(r21.resultado, Retorno.Resultado.OK, r21.valorString);
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: ya existe un servicio con el nombre ingresado.");
        Retorno r22 = s.ingresarServicio("New York", "Royal Caribbean Int.", "Wifi"); 
        p.ver(r22.resultado, Retorno.Resultado.ERROR_3, r22.valorString);
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: en la ciudad ingresada no existe un crucero con el nombre ingresado.");        
        Retorno r23 = s.ingresarServicio("New York", "No Crucero", "Discoteca");
        p.ver(r23.resultado, Retorno.Resultado.ERROR_1, r23.valorString);
        System.out.println();

        System.out.println();        
        System.out.println("PRUEBA: no existe una ciudad con el nombre ingresado.");                
        Retorno r24 = s.ingresarServicio("No Ciudad", "Royal Caribbean Int.", "Servicio de cuarto");
        p.ver(r24.resultado, Retorno.Resultado.ERROR_2, r24.valorString);
        System.out.println();
        
        System.out.println("#######################################");
        System.out.println("###### TEST BORRAR SERVICIO ######");
        System.out.println("#######################################");
        System.out.println();        
        System.out.println("PRUEBA: el servicio se borró exitosamente."); 
        Retorno r25 = s.borrarServicio("New York", "Royal Caribbean Int.", "Spa");
        p.ver(r25.resultado, Retorno.Resultado.OK, r25.valorString);
        System.out.println(); 
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        Retorno r26 = s.borrarServicio("New York", "No Crucero", "Discoteca");
        p.ver(r26.resultado, Retorno.Resultado.ERROR_1, r26.valorString);
        System.out.println();   
        
        System.out.println();        
        System.out.println("PRUEBA: el servicio que se intenta borrar no existe.");
        Retorno r27 = s.borrarServicio("New York", "Royal Caribbean Int.", "Choripan");
        p.ver(r27.resultado, Retorno.Resultado.ERROR_2, r27.valorString);
        System.out.println();        
        
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        Retorno r28 = s.borrarServicio("No Ciudad", "Royal Caribbean Int.", "Discoteca"); 
        p.ver(r28.resultado, Retorno.Resultado.ERROR_3, r28.valorString);
        System.out.println();
        

        System.out.println("####################################");
        System.out.println("###### TEST REALIZAR RESERVAS ######");
        System.out.println("####################################");
        
        System.out.println();        
        System.out.println("PRUEBA: la reserva se realizó exitosamente."); 
        Retorno r29 = s.realizarReserva(1, "New York", "Royal Caribbean Int.");
        p.ver(r29.resultado, Retorno.Resultado.OK, r29.valorString);
        Retorno r30 = s.realizarReserva(2, "New York", "Royal Caribbean Int.");
        p.ver(r30.resultado, Retorno.Resultado.OK, r30.valorString);
        Retorno r31 = s.realizarReserva(3, "New York", "Royal Caribbean Int.");
        p.ver(r31.resultado, Retorno.Resultado.OK, r31.valorString);
        Retorno r32 = s.realizarReserva(4, "New York", "Royal Caribbean Int.");
        p.ver(r32.resultado, Retorno.Resultado.OK, r32.valorString);
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        Retorno r33 = s.realizarReserva(6, "New York", "NO CRUCERO"); 
        p.ver(r33.resultado,Retorno.Resultado.ERROR_1, r33.valorString);        
        System.out.println();
        
        System.out.println();
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        Retorno r34 = s.realizarReserva(5, "NO CIUDAD", "Royal Caribbean Int."); 
        p.ver(r34.resultado, Retorno.Resultado.ERROR_2, r34.valorString);
        System.out.println();
        

        System.out.println("####################################");
        System.out.println("###### TEST CANCELAR RESERVAS ######");
        System.out.println("####################################"); 
        
        System.out.println();
        System.out.println("PRUEBA: la cancelación se realizó exitosamente.");        
        System.out.println("Cantidad de Reservas antes de la cancelación: " + s.AC.buscar("New York").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());        
        Retorno r35 = s.cancelarReserva(1, "New York", "Royal Caribbean Int."); 
        p.ver(r35.resultado, Retorno.Resultado.OK, r35.valorString);                
        Retorno r36 = s.cancelarReserva(2, "New York", "Royal Caribbean Int.");
        p.ver(r36.resultado, Retorno.Resultado.OK, r36.valorString);                        
        System.out.println("Cantidad de Reservas después de la cancelación: " + s.AC.buscar("New York").getLcrucero().buscarCruceroXNombre("Royal Caribbean Int.").getLReservas().getCantelementos());
        
        System.out.println();        
        System.out.println("PRUEBA: no existe un crucero en la ciudad ingresada.");
        Retorno r37 = s.cancelarReserva(1, "New York", "No crucero");
        p.ver(r37.resultado, Retorno.Resultado.ERROR_1, r37.valorString);                        
        System.out.println();
        
        System.out.println();        
        System.out.println("PRUEBA: el cliente no tiene reservas para el crucero ingresado.");
        Retorno r38 = s.cancelarReserva(45, "New York", "Royal Caribbean Int.");
        p.ver(r38.resultado, Retorno.Resultado.ERROR_2, r38.valorString);                        
        System.out.println();
             
        System.out.println();        
        System.out.println("PRUEBA: la ciudad ingresada no existe.");
        Retorno r39 = s.cancelarReserva(1, "No ciudad", "Royal Caribbean Int.");
        p.ver(r39.resultado, Retorno.Resultado.ERROR_3, r39.valorString);                        
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
}
