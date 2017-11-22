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
 * @author sebastianvillar
 */
public class ISistemaIT {
    
    public ISistemaIT() {
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
     * Test of crearSistemaReservas method, of class ISistema.
     */
    @Test
    public void testCrearSistemaReservas() {
        System.out.println("crearSistemaReservas");
        int cantCiudades = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.crearSistemaReservas(cantCiudades);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destruirSistemaReservas method, of class ISistema.
     */
    @Test
    public void testDestruirSistemaReservas() {
        System.out.println("destruirSistemaReservas");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.destruirSistemaReservas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCiudad method, of class ISistema.
     */
    @Test
    public void testRegistrarCiudad() {
        System.out.println("registrarCiudad");
        String ciudad = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.registrarCiudad(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrarCrucero method, of class ISistema.
     */
    @Test
    public void testRegistrarCrucero() {
        System.out.println("registrarCrucero");
        String ciudad = "";
        String nombre = "";
        int estrellas = 0;
        int capacidad = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.registrarCrucero(ciudad, nombre, estrellas, capacidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarServicio method, of class ISistema.
     */
    @Test
    public void testIngresarServicio() {
        System.out.println("ingresarServicio");
        String ciudad = "";
        String crucero = "";
        String servicio = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.ingresarServicio(ciudad, crucero, servicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarServicio method, of class ISistema.
     */
    @Test
    public void testBorrarServicio() {
        System.out.println("borrarServicio");
        String ciudad = "";
        String crucero = "";
        String servicio = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.borrarServicio(ciudad, crucero, servicio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarReserva method, of class ISistema.
     */
    @Test
    public void testRealizarReserva() {
        System.out.println("realizarReserva");
        int cliente = 0;
        String ciudad = "";
        String crucero = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.realizarReserva(cliente, ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelarReserva method, of class ISistema.
     */
    @Test
    public void testCancelarReserva() {
        System.out.println("cancelarReserva");
        int cliente = 0;
        String ciudad = "";
        String crucero = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.cancelarReserva(cliente, ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ingresarComentario method, of class ISistema.
     */
    @Test
    public void testIngresarComentario() {
        System.out.println("ingresarComentario");
        String ciudad = "";
        String crucero = "";
        String comentario = "";
        int ranking = 0;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.ingresarComentario(ciudad, crucero, comentario, ranking);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarServicios method, of class ISistema.
     */
    @Test
    public void testListarServicios() {
        System.out.println("listarServicios");
        String ciudad = "";
        String crucero = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarServicios(ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosCiudad method, of class ISistema.
     */
    @Test
    public void testListarCrucerosCiudad() {
        System.out.println("listarCrucerosCiudad");
        String ciudad = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosCiudad(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosRankingAsc method, of class ISistema.
     */
    @Test
    public void testListarCrucerosRankingAsc() {
        System.out.println("listarCrucerosRankingAsc");
        String ciudad = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosRankingAsc(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosRankingDesc method, of class ISistema.
     */
    @Test
    public void testListarCrucerosRankingDesc() {
        System.out.println("listarCrucerosRankingDesc");
        String ciudad = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosRankingDesc(ciudad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarCrucerosRanking method, of class ISistema.
     */
    @Test
    public void testListarCrucerosRanking() {
        System.out.println("listarCrucerosRanking");
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarCrucerosRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarComentarios method, of class ISistema.
     */
    @Test
    public void testListarComentarios() {
        System.out.println("listarComentarios");
        String ciudad = "";
        String crucero = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.listarComentarios(ciudad, crucero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargarDistancias method, of class ISistema.
     */
    @Test
    public void testCargarDistancias() {
        System.out.println("cargarDistancias");
        int[][] ciudades = null;
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.cargarDistancias(ciudades);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCamino method, of class ISistema.
     */
    @Test
    public void testBuscarCamino() {
        System.out.println("buscarCamino");
        int[][] m = null;
        String origen = "";
        String destino = "";
        ISistema instance = new ISistemaImpl();
        Retorno expResult = null;
        Retorno result = instance.buscarCamino(m, origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ISistemaImpl implements ISistema {

        public Retorno crearSistemaReservas(int cantCiudades) {
            return null;
        }

        public Retorno destruirSistemaReservas() {
            return null;
        }

        public Retorno registrarCiudad(String ciudad) {
            return null;
        }

        public Retorno registrarCrucero(String ciudad, String nombre, int estrellas, int capacidad) {
            return null;
        }

        public Retorno ingresarServicio(String ciudad, String crucero, String servicio) {
            return null;
        }

        public Retorno borrarServicio(String ciudad, String crucero, String servicio) {
            return null;
        }

        public Retorno realizarReserva(int cliente, String ciudad, String crucero) {
            return null;
        }

        public Retorno cancelarReserva(int cliente, String ciudad, String crucero) {
            return null;
        }

        public Retorno ingresarComentario(String ciudad, String crucero, String comentario, int ranking) {
            return null;
        }

        public Retorno listarServicios(String ciudad, String crucero) {
            return null;
        }

        public Retorno listarCrucerosCiudad(String ciudad) {
            return null;
        }

        public Retorno listarCrucerosRankingAsc(String ciudad) {
            return null;
        }

        public Retorno listarCrucerosRankingDesc(String ciudad) {
            return null;
        }

        public Retorno listarCrucerosRanking() {
            return null;
        }

        public Retorno listarComentarios(String ciudad, String crucero) {
            return null;
        }

        public Retorno cargarDistancias(int[][] ciudades) {
            return null;
        }

        public Retorno buscarCamino(int[][] m, String origen, String destino) {
            return null;
        }
    }
    
}
