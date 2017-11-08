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
    public void testCrearSistemaReservas() {
        Sistema s = new Sistema();
        assertEquals(Retorno.Resultado.OK, s.crearSistemaReservas(20).resultado);
    }
    
    

    /**
     * Test of destruirSistemaReservas method, of class Sistema.
     */
    @Test
    public void testDestruirSistemaReservas() {
        /*System.out.println("destruirSistemaReservas");
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.destruirSistemaReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of registrarCiudad method, of class Sistema.
     */
    @Test
    public void testRegistrarCiudad() {
        Sistema s = new Sistema();
        s.crearSistemaReservas(20);
        assertEquals(Retorno.Resultado.OK, s.registrarCiudad("Montevideoerer").resultado);
    }

    /**
     * Test of registrarCrucero method, of class Sistema.
     */
    @Test
    public void testRegistrarCrucero() {
        System.out.println("registrarCrucero");
        String ciudad = "";
        String nombre = "";
        int estrellas = 0;
        int capacidad = 0;
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.registrarCrucero(ciudad, nombre, estrellas, capacidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarServicio method, of class Sistema.
     */
    @Test
    public void testIngresarServicio() {
        System.out.println("ingresarServicio");
        String ciudad = "";
        String crucero = "";
        String servicio = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.ingresarServicio(ciudad, crucero, servicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarServicio method, of class Sistema.
     */
    @Test
    public void testBorrarServicio() {
        System.out.println("borrarServicio");
        String ciudad = "";
        String crucero = "";
        String servicio = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.borrarServicio(ciudad, crucero, servicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarReserva method, of class Sistema.
     */
    @Test
    public void testRealizarReserva() {
        System.out.println("realizarReserva");
        int cliente = 0;
        String ciudad = "";
        String crucero = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.realizarReserva(cliente, ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelarReserva method, of class Sistema.
     */
    @Test
    public void testCancelarReserva() {
        System.out.println("cancelarReserva");
        int cliente = 0;
        String ciudad = "";
        String crucero = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.cancelarReserva(cliente, ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarComentario method, of class Sistema.
     */
    @Test
    public void testIngresarComentario() {
        System.out.println("ingresarComentario");
        String ciudad = "";
        String crucero = "";
        String comentario = "";
        int ranking = 0;
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.ingresarComentario(ciudad, crucero, comentario, ranking);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServicios method, of class Sistema.
     */
    @Test
    public void testListarServicios() {
        System.out.println("listarServicios");
        String ciudad = "";
        String crucero = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.listarServicios(ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosCiudad method, of class Sistema.
     */
    @Test
    public void testListarCrucerosCiudad() {
        System.out.println("listarCrucerosCiudad");
        String ciudad = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosCiudad(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosRankingAsc method, of class Sistema.
     */
    @Test
    public void testListarCrucerosRankingAsc() {
        System.out.println("listarCrucerosRankingAsc");
        String ciudad = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosRankingAsc(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosRankingDesc method, of class Sistema.
     */
    @Test
    public void testListarCrucerosRankingDesc() {
        System.out.println("listarCrucerosRankingDesc");
        String ciudad = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosRankingDesc(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosRanking method, of class Sistema.
     */
    @Test
    public void testListarCrucerosRanking() {
        System.out.println("listarCrucerosRanking");
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarComentarios method, of class Sistema.
     */
    @Test
    public void testListarComentarios() {
        System.out.println("listarComentarios");
        String ciudad = "";
        String crucero = "";
        Sistema instance = new Sistema();
        Retorno expResult = null;
        Retorno result = instance.listarComentarios(ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
