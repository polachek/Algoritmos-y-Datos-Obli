/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oblm3a;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class SistemaTest {
    
    public SistemaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crearSistemaReservas method, of class Sistema.
     */
    @Test
    public void testCrearSistemaReservasOK() {
        Sistema s = new Sistema();
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(20).resultado);
    }
    
    @Test
    public void testCrearSistemaReservasNegativo() {
        Sistema s = new Sistema();
        assertEquals(Retorno.Resultado.ERROR_1, s.crearSistemaReservas(-4).resultado);
    }

    /**
     * Test of destruirSistemaReservas method, of class Sistema.
     */
    @Test
    public void testDestruirSistemaReservas() {
        Sistema s = new Sistema();
        assertEquals(Retorno.Resultado.OK, s.destruirSistemaReservas().resultado);
    }

    /**
     * Test of registrarCiudad method, of class Sistema.
     */
    @Test
    public void testRegistrarCiudadOK() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideoerer").resultado);
    }
    
    @Test
    public void testRegistrarCiudadYaExistente() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCiudad("Montevideo").resultado);
    }
    
    @Test
    public void testRegistrarCiudadNoTope() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(2);
        s.registrarCiudad("Montevideo");
        s.registrarCiudad("Maldonado");
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCiudad("Rocha").resultado);
    }
    

    /**
     * Test of registrarCrucero method, of class Sistema.
     */
    @Test
    public void testRegistrarCruceroOK() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.OK, s.registrarCrucero("Montevideo","Love Crucer",1,50).resultado);
    }
    
    @Test
    public void testRegistrarCruceroEstrella0() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_1, s.registrarCrucero("Montevideo","Love Crucer",0,50).resultado);
    }
    
    @Test
    public void testRegistrarCruceroCapacidad0() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        s.registrarCiudad("Montevideo");
        assertEquals(Retorno.Resultado.ERROR_2, s.registrarCrucero("Montevideo","Love Crucer",5,-1).resultado);
    }
    
    @Test
    public void testRegistrarCruceroRepetido() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_3, sis.registrarCrucero("Montevideo","Love Crucer",1,5).resultado);
    }
    
    @Test
    public void testRegistrarCruceroNoCiudad() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        assertEquals(Retorno.Resultado.ERROR_4, s.registrarCrucero("Montevideo","Love Crucer",1,5).resultado);
    }

    /**
     * Test of ingresarServicio method, of class Sistema.
     */
    @Test
    public void testIngresarServicioOK() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.OK, sis.ingresarServicio("Montevideo","Love Crucer", "Spa").resultado);
    }
    
    @Test
    public void testIngresarServicioCruceroNoenCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCiudad("Rocha");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_1, sis.ingresarServicio("Rocha","Love Crucer", "Spa").resultado);
    }
    
    @Test
    public void testIngresarServicioNoExistCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_2, sis.ingresarServicio("NO CIUDAD","Love Crucer", "Spa").resultado);
    }
    
    @Test
    public void testIngresarServicioRepetido() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo","Love Crucer", "Spa");
        assertEquals(Retorno.Resultado.ERROR_3, sis.ingresarServicio("Montevideo","Love Crucer", "Spa").resultado);
    }

    /**
     * Test of borrarServicio method, of class Sistema.
     */
    @Test
    public void testBorrarServicio() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo","Love Crucer", "Spa");
        assertEquals(Retorno.Resultado.OK, sis.borrarServicio("Montevideo","Love Crucer", "Spa").resultado);
    }
    
    @Test
    public void testBorrarServicioNoCrucero() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo","Love Crucer", "Spa");
        assertEquals(Retorno.Resultado.ERROR_1, sis.borrarServicio("Montevideo","No crucero", "Spa").resultado);
    }    

    @Test
    public void testBorrarServicioNoServicio() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo","Love Crucer", "Spa");
        assertEquals(Retorno.Resultado.ERROR_2, sis.borrarServicio("Montevideo","Love Crucer", "Lavandería").resultado);
    }        
    
    @Test
    public void testBorrarServicioNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo","Love Crucer", "Spa");
        assertEquals(Retorno.Resultado.ERROR_3, sis.borrarServicio("No ciudad&&","Love Crucer", "Lavandería").resultado);
    }    
    /**
     * Test of realizarReserva method, of class Sistema.
     */
    @Test
    public void testRealizarReserva() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.OK, sis.realizarReserva(1, "Montevideo", "Love Crucer").resultado);
    }
    
    @Test
    public void testRealizarReservaNoCrucero() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_1, sis.realizarReserva(1, "Montevideo", "No Crucero").resultado);
    } 
    
    @Test
    public void testRealizarReservaNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_2, sis.realizarReserva(1, "No ciudad", "No Crucero").resultado);
    }       

    /**
     * Test of cancelarReserva method, of class Sistema.
     */
    @Test
    public void testCancelarReserva() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.realizarReserva(1, "Montevideo", "Love Crucer");
        assertEquals(Retorno.Resultado.OK, sis.cancelarReserva(1, "Montevideo", "Love Crucer").resultado);        
    }
    
    @Test
    public void testCancelarReservaNoCrucero() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.realizarReserva(1, "Montevideo", "Love Crucer");
        assertEquals(Retorno.Resultado.ERROR_1, sis.cancelarReserva(1, "Montevideo", "No crucero").resultado);        
    }   
    
    @Test
    public void testCancelarReservaNoReserva() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_2, sis.cancelarReserva(1, "Montevideo", "Love Crucer").resultado);        
    }   

    @Test
    public void testCancelarReservaNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);        
        assertEquals(Retorno.Resultado.ERROR_3, sis.cancelarReserva(1, "No ciudad", "Love Crucer").resultado);        
    }       

    /**
     * Test of ingresarComentario method, of class Sistema.
     */
    @Test
    public void testIngresarComentario() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.OK, sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5).resultado);        
    }
    
    @Test
    public void testIngresarComentarioRankingMayor5() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_1, sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 8).resultado);        
    }    
    
    @Test
    public void testIngresarComentarioRankingMenor0() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_1, sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", -1).resultado);        
    }     
    
    @Test
    public void testIngresarComentarioNoCrucero() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_2, sis.ingresarComentario("Montevideo", "No crucero", "Muy lindo el crucero", 4).resultado);        
    }      
    
    @Test
    public void testIngresarComentarioNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        assertEquals(Retorno.Resultado.ERROR_3, sis.ingresarComentario("No ciudad", "Love Crucer", "Muy lindo el crucero", 4).resultado);        
    }    
    
    @Test
    public void testListarServicios() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo", "Love Crucer", "Wifi");
        sis.ingresarServicio("Montevideo", "Love Crucer", "Bebidas frías");        
        assertEquals(Retorno.Resultado.OK, sis.listarServicios("Montevideo", "Love Crucer").resultado);        
    }  

    @Test
    public void testListarServiciosNoCrucero() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo", "Love Crucer", "Wifi");
        sis.ingresarServicio("Montevideo", "Love Crucer", "Bebidas frías");        
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarServicios("Montevideo", "No Crucero").resultado);        
    }  

    @Test
    public void testListarServiciosNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.ingresarServicio("Montevideo", "Love Crucer", "Wifi");
        sis.ingresarServicio("Montevideo", "Love Crucer", "Bebidas frías");        
        assertEquals(Retorno.Resultado.ERROR_2, sis.listarServicios("No ciudad", "Love Crucer").resultado);        
    }    
    
    @Test
    public void testListarCrucerosCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50);                
        assertEquals(Retorno.Resultado.OK, sis.listarCrucerosCiudad("Montevideo").resultado);        
    }    
    
    @Test
    public void testListarCrucerosCiudadNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50);                
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosCiudad("No ciudad").resultado);        
    }

    /**
     * Test of listarCrucerosRankingAsc method, of class Sistema.
     */
    @Test
    public void testListarCrucerosRankingAsc() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "Pasamos muy lindo con mi señora y los chicos", 5); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "No tenían toalla", 1);    
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky", 4);
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky y buen vino", 5);        
        assertEquals(Retorno.Resultado.OK, sis.listarCrucerosRankingAsc("Montevideo").resultado);        
    }
    
    @Test
    public void testListarCrucerosRankingAscNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "Pasamos muy lindo con mi señora y los chicos", 5); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "No tenían toalla", 1);    
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky", 4);
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky y buen vino", 5);        
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosRankingAsc("No ciudad").resultado);        
    }    

    /**
     * Test of listarCrucerosRankingDesc method, of class Sistema.
     */
    @Test
    public void testListarCrucerosRankingDesc() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "Pasamos muy lindo con mi señora y los chicos", 5); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "No tenían toalla", 1);    
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky", 4);
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky y buen vino", 5);        
        assertEquals(Retorno.Resultado.OK, sis.listarCrucerosRankingDesc("Montevideo").resultado); 
    }

    @Test
    public void testListarCrucerosRankingDescNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "Pasamos muy lindo con mi señora y los chicos", 5); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "No tenían toalla", 1);    
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky", 4);
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky y buen vino", 5);        
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarCrucerosRankingDesc("No ciudad").resultado); 
    }
    /**
     * Test of listarCrucerosRanking method, of class Sistema.
     */
    @Test
    public void testListarCrucerosRanking() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "Pasamos muy lindo con mi señora y los chicos", 5); 
        sis.ingresarComentario("Montevideo", "Passion Crucer", "No tenían toalla", 1);    
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky", 4);
        sis.ingresarComentario("Montevideo", "Island Crucer", "Buen whisky y buen vino", 5);        
        assertEquals(Retorno.Resultado.OK, sis.listarCrucerosRanking().resultado); 
    }

    /**
     * Test of listarComentarios method, of class Sistema.
     */
    @Test
    public void testListarComentarios() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3);
        assertEquals(Retorno.Resultado.OK, sis.listarComentarios("Montevideo", "Island Crucer").resultado);     
    }

    @Test
    public void testListarComentariosNoCrucero() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3);
        assertEquals(Retorno.Resultado.ERROR_1, sis.listarComentarios("Montevideo", "No Crucero").resultado);     
    }      
    
    @Test
    public void testListarComentariosNoCiudad() {
        Sistema sis = new Sistema();
        sis.crearSistemaReservas(20);
        sis.registrarCiudad("Montevideo");
        sis.registrarCrucero("Montevideo","Love Crucer",1,50);
        sis.registrarCrucero("Montevideo","Passion Crucer",1,50);        
        sis.registrarCrucero("Montevideo","Island Crucer",1,50); 
        sis.ingresarComentario("Montevideo", "Love Crucer", "Muy lindo el crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "Horrible el crucero", 2);    
        sis.ingresarComentario("Montevideo", "Love Crucer", "Excelente crucero", 5);
        sis.ingresarComentario("Montevideo", "Love Crucer", "No me lavaron la ropa", 3);
        assertEquals(Retorno.Resultado.ERROR_2, sis.listarComentarios("No Ciudad", "Island Crucer").resultado);     
    }    

    /**
     * Test of cargarDistancias method, of class Sistema.
     */
    @Test
    public void testCargarDistancias() {
        System.out.println("cargarDistancias");
        int[][] ciudades = null;
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.cargarDistancias(ciudades);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCamino method, of class Sistema.
     */
    @Test
    public void testBuscarCamino() {
        System.out.println("buscarCamino");
        int[][] m = null;
        String origen = "";
        String destino = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.buscarCamino(m, origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
