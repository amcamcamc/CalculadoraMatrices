package matrices;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Pruebas JUnit de la clase OperadorMatrices
 * @author amaury
 */
public class OperadorMatricesTest {
    
    private OperadorMatrices instance = new OperadorMatrices();
    
    public OperadorMatricesTest() {
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
     * Test of sumaEntreMatrices method, of class OperadorMatrices.
     */
    @Test
    public void testSumaEntreMatrices() {
        System.out.println("sumaEntreMatrices");
        float[][] matA = {
                            {2,-3,5},
                            {4,1,-7}
                         };
        float[][] matB = {
                            {1,0,2},
                            {-3,5,8}
                         };
        float[][] matR = {
                            {3,-3,7},
                            {1,6,1}
                         };
        Matriz A = new Matriz(2,3,"A",matA);
        Matriz B = new Matriz(2,3,"B",matB);
        
        System.out.println("Operacion:");
        A.imprimir();
        System.out.println("SUMA");
        B.imprimir();
        
        Matriz expResult = new Matriz(2,3,"R",matR);
        Matriz result = instance.sumaEntreMatrices(A, B);
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }

    /**
     * Test of multiplicacionPorEscalar method, of class OperadorMatrices.
     */
    @Test
    public void testMultiplicacionPorEscalar() {
        System.out.println("multiplicacionPorEscalar");
        float[][] matA = {
                            {1,-2,3},
                            {0,1,8}
                         };
        float[][] matR = {
                            {-5,10,-15},
                            {0,-5,-40}
                         };
        Matriz A = new Matriz(2,3,"A",matA);
        float escalar = -5;
        
        System.out.println("Operacion:");
        A.imprimir();
        System.out.println("MULTIPLICA");
        System.out.println(escalar);
        
        Matriz expResult = new Matriz(2,3,"R",matR);
        Matriz result = instance.multiplicacionPorEscalar(A, escalar);
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }

    /**
     * Test of productoEntreMatrices method, of class OperadorMatrices.
     */
    @Test
    public void testProductoEntreMatrices() {
        System.out.println("productoEntreMatrices");
        float[][] matA = {
                            {1,0,2},
                            {-1,3,1}
                         };
        float[][] matB = {
                            {3,1},
                            {2,1},
                            {1,0}
                         };
        float[][] matR = {
                            {5,1},
                            {4,2}
                         };
        Matriz A = new Matriz(2,3,"A",matA);
        Matriz B = new Matriz(3,2,"B",matB);
        
        System.out.println("Operacion:");
        A.imprimir();
        System.out.println("MULTIPLICA");
        B.imprimir();
        
        Matriz expResult = new Matriz(2,2,"R",matR);
        Matriz result = instance.productoEntreMatrices(A, B);
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }

    /**
     * Test of calcularInversa_GJ method, of class OperadorMatrices.
     */
    @Test
    public void testCalcularInversa_GJ() {
        System.out.println("calcularInversa_GJ");
        float[][] matA = {
                            {1F,-6F,2F},
                            {2F,-2F,-1F},
                            {1F,-3F,-5F},
                         };
        float[][] matR = {
                            {-7/55F,36/55F,-2/11F},
                            {-9/55F,7/55F,-1/11F},
                            {4/55F,3/55F,-2/11F},
                         };
        Matriz A = new Matriz(3,3,"A",matA);
        
        System.out.println("Matriz:");
        A.imprimir();
        
        Matriz expResult = new Matriz(3,3,"R",matR);
        expResult.redondearElementos();
        Matriz result = instance.calcularInversa_GJ(A);
        result.redondearElementos();
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }

    /**
     * Test of solucionarSistema_GJ method, of class OperadorMatrices.
     */
    @Test
    public void testSolucionarSistema_GJ() {
        System.out.println("solucionarSistema_GJ");
        float[][] matA = {
                            {3,-0.1F,-0.2F,7.8500F},
                            {0.1F,7,-0.3F,-19.3F},
                            {0.3F,-0.2F,10,71.4F},
                         };
        float[][] matR = {
                            {3,-2.499F,7.001F},
                         };
        Matriz A = new Matriz(3,4,"A",matA);
        
        System.out.println("Matriz:");
        A.imprimir();
        
        Matriz expResult = new Matriz(1,3,"R",matR);
        expResult.redondearElementos();
        Matriz result = instance.solucionarSistema_GJ(A);
        result.redondearElementos();
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");;
    }

    /**
     * Test of solucionarSistema_Cramer method, of class OperadorMatrices.
     */
    @Test
    public void testSolucionarSistema_Cramer() {
        System.out.println("solucionarSistema_Cramer");
        float[][] matA = {
                            {3,2,1,1},
                            {2,0,1,2},
                            {-1,1,2,4},
                         };
        float[][] matR = {
                            {-1/11F,-5/11F,24/11F},
                         };
        Matriz A = new Matriz(3,4,"A",matA);
        
        System.out.println("Matriz:");
        A.imprimir();
        
        Matriz expResult = new Matriz(1,3,"R",matR);
        expResult.redondearElementos();
        Matriz result = instance.solucionarSistema_Cramer(A);
        result.redondearElementos();
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }

    /**
     * Test of calcularDeterminante method, of class OperadorMatrices.
     */
    @Test
    public void testCalcularDeterminante() {
        System.out.println("calcularDeterminante");
        float[][] matA = {
                            {3,2,0,-1},
                            {1,5,1,0},
                            {4,-2,0,1},
                            {0,1,-3,2},
                         };
        Matriz A = new Matriz(4,4,"A",matA);
        
        System.out.println("Matriz:");
        A.imprimir();
        
        float expResult = 140F;
        float result = instance.calcularDeterminante(A).getElemento(0, 0);
        
        System.out.println("Resultado esperado:");
        System.out.println(expResult);
        System.out.println("Resultado:");
        System.out.println(result);
        
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }

    /**
     * Test of calcularTranspuesta method, of class OperadorMatrices.
     */
    @Test
    public void testCalcularTranspuesta() {
        System.out.println("calcularTranspuesta");
        float[][] matA = {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9},
                         };
        float[][] matR = {
                            {1,4,7},
                            {2,5,8},
                            {3,6,9},
                         };
        Matriz A = new Matriz(3,3,"A",matA);
        
        System.out.println("Matriz:");
        A.imprimir();
        
        Matriz expResult = new Matriz(3,3,"R",matR);
        Matriz result = instance.calcularTranspuesta(A);
        
        System.out.println("Resultado esperado:");
        expResult.imprimir();
        System.out.println("Resultado:");
        result.imprimir();
        
        boolean igualdadResultado = result.esIgualA(expResult);
        assertEquals(true, igualdadResultado);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println("==============================");
    }
    
}
