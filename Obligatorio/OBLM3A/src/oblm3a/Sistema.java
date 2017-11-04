<<<<<<< HEAD:Obligatorio/OBLM3A/src/oblm3a/Sistema.java
package oblm3a;

import oblm3a.Retorno.Resultado;

public class Sistema implements ISistema {
    public ListaCiudad LC;

	@Override
	public Retorno crearSistemaReservas(int cantCiudades) {
                LC= new ListaCiudad();
                LC.setTope(cantCiudades);
                
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno destruirSistemaReservas() {
		Retorno ret = new Retorno();
		
		ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarCiudad(String ciudad) {
               Retorno ret = new Retorno();
               
               if (LC.getCantelementos()< LC.getTope() || LC.getTope()==0){
                  if (LC.obtenerElemento(ciudad)==null) 
                      ret.resultado= LC.agregarInicio(ciudad);
                  else 
                      ret.resultado=Retorno.Resultado.ERROR_1;
               }
               else{
                     ret.resultado=Retorno.Resultado.ERROR_2;
                   }
		
		
		//ret.resultado = Resultado.NO_IMPLEMENTADA;
		
		return ret;
	}

	@Override
	public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
		Retorno ret = new Retorno();
		
                if (LC.obtenerElemento(ciudad)!= null){
                    LC.obtenerElemento(ciudad).getLcrucero().agregarInicio(nombre);                 
		    ret.resultado = Resultado.OK;
                }
                else
                    ret.resultado = Resultado.ERROR_3;
		return ret;
	}

	@Override
	public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
		Retorno ret = new Retorno();
		
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

=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obligatorio;
import obligatorio.Retorno.Resultado;

/**
 *
 * @author User
 */
public class Sistema implements ISistema{
    @Override
    public Retorno crearSistemaReservas(int cantCiudades) {
        Retorno ret = new Retorno();
        ret.resultado = Resultado.NO_IMPLEMENTADA;
        return ret;
    }

    @Override
    public Retorno destruirSistemaReservas() {
        Retorno ret = new Retorno();
        ret.resultado = Resultado.NO_IMPLEMENTADA;
        return ret;
    }

    @Override
    public Retorno registrarCiudad(String ciudad) {
        Retorno ret = new Retorno();
        ret.resultado = Resultado.NO_IMPLEMENTADA;
        return ret;
    }

    @Override
    public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
        Retorno ret = new Retorno();
        ret.resultado = Resultado.NO_IMPLEMENTADA;
        return ret;
    }

    @Override
    public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
        Retorno ret = new Retorno();
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
>>>>>>> 3f1771a18db3d00bc5c4ed03db87b6e0d4080c4f:Obligatorio/src/obligatorio/Sistema.java
}
