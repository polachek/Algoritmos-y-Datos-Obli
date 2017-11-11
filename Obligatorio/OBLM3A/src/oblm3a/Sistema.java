package oblm3a;

import oblm3a.Retorno.Resultado;

public class Sistema implements ISistema {
    public ArbolCiudades AC;


	@Override
	public Retorno crearSistemaReservas(int cantCiudades) {
                AC= new ArbolCiudades();
               
		Retorno ret = new Retorno();
                
                if(cantCiudades<0)
                    ret.resultado = Resultado.ERROR_1;
		 else
                    ret.resultado = Resultado.OK;
		
		
		return ret;
	}

	@Override
	public Retorno destruirSistemaReservas() {
		Retorno ret = new Retorno();
                if(AC != null){
                    //AC.vaciar();
                }                
		ret.resultado = Resultado.OK;
		
		return ret;
	}

	@Override
	public Retorno registrarCiudad(String ciudad) {
               Retorno ret = new Retorno();
               
               if (!AC.existe(ciudad)) {
                    ret.resultado= AC.insertar(ciudad);
               }
               else 
                    ret.resultado=Retorno.Resultado.ERROR_1;
		
		
		//ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
		Retorno ret = new Retorno();
                Crucero miCrucero = new Crucero(nombre, estrellas, capacidad);
                
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
                else if (AC.buscar(ciudad)!= null){
                    AC.buscar(ciudad).getLcrucero().agregarInicio(miCrucero);                 
		    ret.resultado = Resultado.OK;
                }else{
                    ret.resultado = Resultado.ERROR_4;
                }

		return ret;
	}

	@Override
	public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
		Retorno ret = new Retorno();
                
		/*if(AC.obtenerElemento(ciudad) == null){
                    ret.resultado = Resultado.ERROR_2;
                }else if(AC.obtenerElemento(ciudad).getLcrucero().buscarCrucero(nombre)){
                    ret.resultado = Resultado.ERROR_3;
                }
                else if (AC.obtenerElemento(ciudad)!= null){
                    AC.obtenerElemento(ciudad).getLcrucero().agregarInicio(miCrucero);                 
		    ret.resultado = Resultado.OK;
                }else{
                    ret.resultado = Resultado.ERROR_4;
                }*/
                
                ret.resultado = Resultado.NO_IMPLEMENTADA;
                
		return ret;
	}

	@Override
	public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno listarServicios(String ciudad, String crucero) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno listarCrucerosCiudad(String ciudad) {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
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
