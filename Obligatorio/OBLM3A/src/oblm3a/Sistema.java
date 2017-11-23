package oblm3a;

import oblm3a.Retorno.Resultado;

public class Sistema implements ISistema {
    public ArbolCiudades AC;
    public ListaCiudades MatrizCiudades;
    public ListaClientes LClientes;
    public ListaCruceros LGralCru;
    public int contadorCiudades = 0;

    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {
        AC = new ArbolCiudades();
        MatrizCiudades = new ListaCiudades();
        LClientes = new ListaClientes();
        LGralCru = new ListaCruceros();
        Retorno ret = new Retorno();   
        
        int[][] mat = new int[][] {
			{0,10,25,15,30,0},
			{10,0,20,0,0,0},
			{25,20,0,0,0,40},
			{15,0,0,0,0,45},
			{30,0,0,0,0,25},
			{0,0,40,45,25,0}
        };
        
        if(cantCiudades < 0)
            ret.resultado = Resultado.ERROR_1;
        else if(cantCiudades > 0)
        {
            AC.setMaximo(cantCiudades); 
            ret.resultado = Resultado.OK;
        }
        else
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
                    Ciudad laCiudad = AC.buscar(ciudad).getCiudad();
                    laCiudad.setCodCiudad(contadorCiudades);
                    MatrizCiudades.agregarInicio(laCiudad);                    
                    contadorCiudades++;
                    ret.resultado = Resultado.OK; 
                }
                else 
                    ret.resultado = Retorno.Resultado.ERROR_1;               
           }
           else
           {
                if (!existeCiudad) {
                    AC.insertar(ciudad);
                    Ciudad laCiudad = MatrizCiudades.buscarCiudadPorNombre(ciudad);
                    laCiudad.setCodCiudad(contadorCiudades);
                    MatrizCiudades.agregarInicio(laCiudad); 
                    contadorCiudades++;                    
                    ret.resultado = Resultado.OK;                
                }
                else 
                    ret.resultado = Retorno.Resultado.ERROR_1;                
           }
           return ret;
    }

    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
            Retorno ret = new Retorno();
            Crucero miCrucero = new Crucero(nombre);
            miCrucero.setCapacidad(capacidad);
            miCrucero.setEstrellas(estrellas);

            if(!AC.existe(ciudad))
                ret.resultado = Resultado.ERROR_4;
            else if(estrellas <= 0 || estrellas > 5)
                ret.resultado = Resultado.ERROR_1;
            else if(capacidad < 0)
                ret.resultado = Resultado.ERROR_2;
            else if(AC.buscar(ciudad).getLcrucero().buscarCrucero(nombre))
                ret.resultado = Resultado.ERROR_3;
            else{
                LGralCru.agregarInicio(miCrucero);
                AC.buscar(ciudad).getLcrucero().agregarInicio(miCrucero);                 
                ret.resultado = Resultado.OK;
            }
            return ret;
    }

    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
            Retorno ret = new Retorno();

            if(!AC.existe(ciudad))
                ret.resultado = Resultado.ERROR_2;
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero))
                ret.resultado = Resultado.ERROR_1;
            else
            {
                Crucero miCrucero = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero); 
                if(miCrucero.getLservicio().existeServicio(servicio))
                    ret.resultado = Resultado.ERROR_3;
                else
                {
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
        if(!AC.existe(ciudad))
            ret.resultado = Resultado.ERROR_2;
        else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero))
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
                        
            if(!AC.existe(ciudad))
                ret.resultado = Resultado.ERROR_3;
            else if(!AC.buscar(ciudad).getLcrucero().buscarCrucero(crucero))
                ret.resultado = Resultado.ERROR_1;
            else
            {
                Crucero cru = AC.buscar(ciudad).getLcrucero().buscarCruceroXNombre(crucero);
                ListaReservas reservas = cru.getLReservas();
                ColaEspera esperas = cru.getCEspera();              
                if(reservas.existeReserva(cliente))
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
                else if(esperas.existeEspera(cliente)){
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

        if(!AC.existe(ciudad))
            ret.resultado = Resultado.ERROR_1;
        else
        {
            ListaCruceros misCruceros = AC.buscar(ciudad).getLcrucero();
            if(misCruceros.esVacia()){
                ret.resultado = Resultado.OK;
                System.out.println("No existen Cruceros registrados en " + ciudad);
            }
            else if(misCruceros.cantElementos() == 1)
            {
                System.out.println("Cruceros en " + ciudad);
                NodoListaCrucero aux = misCruceros.getInicio();
                System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                ret.resultado = Resultado.OK;

            }
            else
            {
                ListaCruceros crucerosOrdenados = new ListaCruceros();
                crucerosOrdenados = misCruceros.ordenarPorNombre();
                AC.buscar(ciudad).setLcrucero(crucerosOrdenados);
                NodoListaCrucero aux = crucerosOrdenados.getInicio();
                System.out.println("Cruceros en " + ciudad);
                while (aux !=null){
                    System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                    aux=aux.getSig();
                }
                ret.resultado = Resultado.OK;

            }

        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingAsc(String ciudad) {
        Retorno ret = new Retorno();

        if(!AC.existe(ciudad)){
            ret.resultado = Resultado.ERROR_1;
        }else{
            ListaCruceros misCruceros = AC.buscar(ciudad).getLcrucero();
            if(misCruceros.esVacia()){
                ret.resultado = Resultado.OK;
                System.out.println("No existen Cruceros registrados en " + ciudad);

            }
            else if(misCruceros.cantElementos() == 1)
            {
                System.out.println("Cruceros en " + ciudad);
                NodoListaCrucero aux = misCruceros.getInicio();
                System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                ret.resultado = Resultado.OK;

            }
            else
            {
                ListaCruceros crucerosOrdenados = new ListaCruceros();
                crucerosOrdenados = misCruceros.ordenarPorRanking();
                AC.buscar(ciudad).setLcrucero(crucerosOrdenados);
                NodoListaCrucero aux = crucerosOrdenados.getFin();
                System.out.println("Cruceros en " + ciudad);
                while (aux !=null){
                    System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                    aux=aux.getAnt();
                }                
                ret.resultado = Resultado.OK;
            }

        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRankingDesc(String ciudad) {
        Retorno ret = new Retorno();

        if(!AC.existe(ciudad)){
            ret.resultado = Resultado.ERROR_1;
        }else{
            ListaCruceros misCruceros = AC.buscar(ciudad).getLcrucero();
            if(misCruceros.esVacia()){
                ret.resultado = Resultado.OK;
                System.out.println("No existen Cruceros registrados en " + ciudad);

            }
            else if(misCruceros.cantElementos() == 1)
            {
                System.out.println("Cruceros en " + ciudad);
                NodoListaCrucero aux = misCruceros.getInicio();
                System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                ret.resultado = Resultado.OK;

            }
            else{
                ListaCruceros crucerosOrdenados = new ListaCruceros();
                crucerosOrdenados = misCruceros.ordenarPorRanking();
                AC.buscar(ciudad).setLcrucero(crucerosOrdenados);

                NodoListaCrucero aux = crucerosOrdenados.getInicio();
                System.out.println("Cruceros en " + ciudad);
                while (aux !=null){
                    System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                    aux=aux.getSig();
                }                
                ret.resultado = Resultado.OK;
            }

        }
        return ret;
    }

    @Override
    public Retorno listarCrucerosRanking() {
        Retorno ret = new Retorno();
        
        if(LGralCru.esVacia())
            System.out.println("No existen Cruceros registrados en el Sistema");
        else if(LGralCru.cantElementos() == 1)
        {
            System.out.println("Cruceros ordenados por Ranking Global");
            NodoListaCrucero aux = LGralCru.getInicio();
            System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
            ret.resultado = Resultado.OK;
        }
        else{
            LGralCru = LGralCru.ordenarPorRanking();
            NodoListaCrucero aux = LGralCru.getInicio();
            System.out.println("Cruceros ordenados por Ranking Global");
            while (aux !=null){
                System.out.println(aux.getNombre() + " " + aux.getEstrellas() + " " +aux.getRanking());
                aux=aux.getSig();
            }            
            ret.resultado = Resultado.OK;
        }
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
        ret.valorString = "No se cargaron las distancias";
        
        int filas = ciudades.length;
        int col = ciudades[0].length;
        int largo = filas*col;
        int cantCiudadesEnSistema = AC.getMaximo()-1;
               
        if(filas == cantCiudadesEnSistema){
           ret.resultado = Resultado.OK;
           ret.valorString = "Las distancias se cargaron correctamente."; 

        }
        return ret;
    }

    @Override
    public Retorno buscarCamino(int[][] m, String origen, String destino) {
        Retorno ret = new Retorno();
        int columnas=m[0].length;
        int escala = 0;
        int distancia = Integer.MAX_VALUE;
        int aux;
       
        Ciudad ciudadOrigen = MatrizCiudades.buscarCiudadPorNombre(origen);
        Ciudad ciudadDestino = MatrizCiudades.buscarCiudadPorNombre(destino);
        int o = ciudadOrigen.getCodCiudad();       
        int d = ciudadDestino.getCodCiudad();
       
        for (int i = 0; i < columnas; i++) {
            aux=m[o][i] + m[d][i];
            if (m[o][i] != 0 && m[d][i] != 0 && aux < distancia) {
               distancia=aux;
               escala=i;             
            }
        }
       System.out.println("escala: " + escala);
       
       Ciudad escalaCiudad = MatrizCiudades.buscarCiudadPorCodigo(escala);
       
       System.out.println("escalaCiudad: " + escalaCiudad.getNombre());
        
       // System.out.println("escala: " + escalaCiudad.getCiudad().getNombre());
       System.out.println("escala: " + escala);
    
        /*ret.valorString = "El camino mas corto desde " + ciudadOrigen.getCiudad().getNombre() + " hasta " + ciudadDestino.getCiudad().getNombre() + " es con escala en "+ escalaCiudad +" y la distancia es " + distancia;*/

        System.out.println("El valor de ciudadOrigen es: "+ciudadOrigen.getNombre()+" y el valor de ciudadDestino es: "+ciudadDestino.getNombre());         
  
        System.out.println("El valor de o es: "+o+" y el valor de d es: "+d);        
        System.out.println("Este es m[o][d]"+m[o][d]);
        if (m[o][d] != 0 && distancia > m[o][d]){
            System.out.println("El camino es directo desde " + ciudadOrigen.getNombre() +" a " + ciudadDestino.getNombre() + " y la distancia es " + m[o][d]);
        }else{
            System.out.println("No entro en el IF");
        }
        ret.resultado = ret.resultado.OK;
        return ret;
    }
}
