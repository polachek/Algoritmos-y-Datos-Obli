package oblm3a;

import oblm3a.Retorno.Resultado;

public class Sistema implements ISistema {
    public ArbolCiudades AC;
    public ListaClientes LClientes;

    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {
        AC = new ArbolCiudades();
        LClientes = new ListaClientes();
        Retorno ret = new Retorno();       
        
        if(cantCiudades < 0)
            ret.resultado = Resultado.ERROR_1;
        else if(cantCiudades > 0)
        {
            AC.setMaximo(cantCiudades); 
            ret.resultado = Resultado.OK;
        }else
        {
            Integer maximo = null;
            AC.setMaximo(maximo);       
            ret.resultado = Resultado.OK;                
        } 
                
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno();
        if(AC != null){
            AC.vaciar();
        }                
        ret.resultado = Resultado.OK;
        return ret;
    }

    @Override
    public Retorno registrarCiudad(String ciudad) {
           Retorno ret = new Retorno();
           boolean existeCiudad = AC.existe(ciudad);
           NodoArbolCiudad r = AC.getRaiz();
           int cantCiudades = AC.cantidadNodos(r);
           Integer maxCiudades = AC.getMaximo();
           
           if(maxCiudades != null)
           {
                if (!existeCiudad && cantCiudades < maxCiudades) {
                     AC.insertar(ciudad);
                     ret.resultado = Resultado.OK;                
                }
                else 
                     ret.resultado=Retorno.Resultado.ERROR_1;               
           }
           else
           {
                if (!existeCiudad) {
                     AC.insertar(ciudad);
                     ret.resultado = Resultado.OK;                
                }
                else 
                     ret.resultado=Retorno.Resultado.ERROR_1;                
           }
           return ret;
    }

    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
            Retorno ret = new Retorno();
            Crucero miCrucero = new Crucero(nombre);
            miCrucero.setCapacidad(capacidad);
            miCrucero.setEstrellas(estrellas);

            if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_4;
            } else if(estrellas <= 0 || estrellas > 5){
                ret.resultado = Resultado.ERROR_1;
            }
            else if(capacidad < 0){
                ret.resultado = Resultado.ERROR_2;
            }
            else if(AC.buscar(ciudad).getLcrucero().buscarCrucero(nombre)){
                ret.resultado = Resultado.ERROR_3;
            }
            else{
                AC.buscar(ciudad).getLcrucero().agregarInicio(miCrucero);                 
                ret.resultado = Resultado.OK;
            }

            return ret;
    }

    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
            Retorno ret = new Retorno();

            if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_2;
            } 
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero)){
                ret.resultado = Resultado.ERROR_1;
            }
            else{
                Crucero miCrucero = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero); 
                if(miCrucero.getLservicio().existeServicio(servicio)){
                    ret.resultado = Resultado.ERROR_1;
                }
                else{
                    miCrucero.getLservicio().agregarInicio(servicio);
                    ret.resultado = Resultado.OK;
                }
            }
            
            return ret;
    }

    @Override
    public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
            Retorno ret = new Retorno();

            if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_3;
            } 
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero)){
                ret.resultado = Resultado.ERROR_1;
            }
            else if(!AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero).getLservicio().existeServicio(servicio)){
                ret.resultado = Resultado.ERROR_2;
            }
            else{
                Crucero miCrucero = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero); 
                miCrucero.getLservicio().borrarElemento(servicio);
                ret.resultado = Resultado.OK;
            }

            return ret;
    }

    @Override
    public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
        Retorno ret = new Retorno();
        boolean existeCiudad = AC.existe(ciudad);
        boolean existeCrucero = AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero);
        
        if(!existeCiudad)
            ret.resultado = Resultado.ERROR_2;
        else if(!existeCrucero)
            ret.resultado = Resultado.ERROR_1;
        else
        {
            //Reserva
            Reserva unaReserva = new Reserva();
            //Crucero
            ListaCruceros LCrucero = AC.buscar(ciudad).getLcrucero();            
            Crucero cru = LCrucero.buscarCruceroXNombre(crucero);
            int cantReservas = cru.getLReservas().getCantelementos();
            int cantHabitaciones = cru.getCapacidad();
            //Cliente
            Cliente cli = new Cliente();
            //Espera
            Boolean espera = false;
            //controlo si existe el cliente
            if(LClientes.existe(cliente))
                cli = LClientes.buscarClienteXId(cliente);        
            else
                cli.agregarCliente(cliente);
            
            //controlo si la reserva queda en espera
            if(cantReservas <= cantHabitaciones)
            {
                unaReserva.agregarReserva(cru, cli, espera);
                cru.getLReservas().agregarReserva(unaReserva);
                ret.resultado = Resultado.OK;                            
            }
            else
            {
                unaReserva.agregarReserva(cru, cli, espera);
                cru.getCEspera().encolar(unaReserva);
                ret.resultado = Resultado.OK;                                        
            }   
        }
        return ret;
    }

    @Override
    public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
            Retorno ret = new Retorno();
            Cliente cli = new Cliente();
            cli.setId(cliente);
            
            
            if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_3;
            } 
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero)){
                ret.resultado = Resultado.ERROR_1;
            }
            else
            {
                Crucero cru = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero);
                ListaReservas reservas = cru.getLReservas();
                ColaEspera esperas = cru.getCEspera();
                boolean existeEnReservas = reservas.existeReserva(cliente);
                boolean existeEnEspera = esperas.existeEspera(cliente);                
                if(existeEnReservas)
                {
                    reservas.borrarReserva(cliente);
                    if(reservas.getCantelementos() <= cru.getCapacidad() && !esperas.estaVacia())
                    {
                        Reserva miReserva = esperas.getUltimo().getReservaEnEspera();
                        reservas.agregarReserva(miReserva);
                        esperas.desencolar();
                    }
                    ret.resultado = Resultado.OK;
                }
                else if(existeEnEspera){
                    esperas.borrarEspera(cliente);                    
                    ret.resultado = Resultado.OK;
                }
                else
                    ret.resultado = Resultado.ERROR_2;
                    
            }

            return ret;
    }

    @Override
    public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
            Retorno ret = new Retorno();

            if(ranking <0 || ranking >5){
                ret.resultado = Resultado.ERROR_1;
            }
            else if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_3;
            } 
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero)){
                ret.resultado = Resultado.ERROR_2;
            }
            else{
                Crucero miCrucero = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero); 
                miCrucero.getLComentarios().agregarInicio(ciudad,miCrucero,comentario,ranking);
                ret.resultado = Resultado.OK;
            }

            return ret;
    }

    @Override
    public Retorno listarServicios(String ciudad, String crucero) {
            Retorno ret = new Retorno();
            
            if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_2;
            } 
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero)){
                ret.resultado = Resultado.ERROR_1;
            }
            else{
                Crucero miCrucero = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero);
                ListaServicios listaServ = miCrucero.getLservicio();
                if(listaServ.esVacia()){
                    System.out.println("No existen servicios registrados en el Crucero " + crucero + " " + ciudad);
                }else{
                    NodoListaServicio aux=listaServ.getInicio();
                    System.out.println("Servicios del Crucero " + crucero + " " + ciudad);
                    int cont = 1;
                    while (aux !=null){
                        System.out.println(cont + " - Servicio " + aux.getServicio());
                        cont ++;
                        aux=aux.getSig();
                    }
                }
                ret.resultado = Resultado.OK;
            }

            return ret;
    }

    @Override
    public Retorno listarCrucerosCiudad(String ciudad) {
        Retorno ret = new Retorno();

        if(!AC.existe(ciudad)){
            ret.resultado = Resultado.ERROR_1;
        }else{
            ListaCruceros misCruceros = AC.buscar(ciudad).getLcrucero();
            if(misCruceros.esVacia()){
                ret.resultado = Resultado.OK;
                System.out.println("No existen Cruceros registrados en " + ciudad);

            }else{
                misCruceros.ordenarPorNombre();
                ret.resultado = Resultado.OK;
                NodoListaCrucero aux = misCruceros.getInicio();
                System.out.println("Cruceros en " + ciudad);
                while (aux !=null){
                    System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                    aux=aux.getSig();
                }
            }

        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingAsc(String ciudad) {
            Retorno ret = new Retorno();

            ret.resultado = Resultado.NO_IMPLEMENTADA;

            return ret;
    }

    @Override
    public Retorno listarCrucerosRankingDesc(String ciudad) {
            Retorno ret = new Retorno();

            ret.resultado = Resultado.NO_IMPLEMENTADA;

            return ret;
    }

    @Override
    public Retorno listarCrucerosRanking() {
            Retorno ret = new Retorno();

            ret.resultado = Resultado.NO_IMPLEMENTADA;

            return ret;
    }

    @Override
    public Retorno listarComentarios(String ciudad, String crucero) {
            Retorno ret = new Retorno();
            
            if(!AC.existe(ciudad)){
                ret.resultado = Resultado.ERROR_2;
            } 
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero)){
                ret.resultado = Resultado.ERROR_1;
            }
            else{
                Crucero miCrucero = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero);
                ListaComentarios listaCom = miCrucero.getLComentarios();
                if(listaCom.esVacia()){
                    System.out.println("No se han agregado comentarios al Crucero " + crucero + " " + ciudad);
                }else{
                    NodoListaComentario aux = listaCom.getInicio();
                    System.out.println("Comentarios del Crucero " + crucero + " " + ciudad);
                    int cont = 1;
                    while (aux !=null){
                        System.out.println(cont + " - " + aux.getComentario()+ " - " + aux.getRanking());
                        cont ++;
                        aux=aux.getSig();
                    }
                }
                ret.resultado = Resultado.OK;
            }
            
            return ret;
    }

    @Override
    public Retorno cargarDistancias(int[][] ciudades) {
            Retorno ret = new Retorno();

            ret.resultado = Resultado.NO_IMPLEMENTADA;

            return ret;
    }

    @Override
    public Retorno buscarCamino(int[][] m, String origen, String destino) {
            Retorno ret = new Retorno();

            ret.resultado = Resultado.NO_IMPLEMENTADA;

            return ret;
    }
}
