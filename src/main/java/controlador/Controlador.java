package controlador;

import modelo.Matriz;
import modelo.OperadorMatrices;
import interfaz.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase controlador en donde se manejan los datos del programa
 * @author amaury
 */
public class Controlador 
{
    /**
     * Todos los objetos Matriz disponibles en el programa.
     * Estan por defecto como matrices de 3x3 vacias.
     * Solo hay identificadores hasta la letra H. No se pueden utilizar las letras
     * R, T. Mas informacion en la clase Matriz.
     */
    private Matriz matrizA = new Matriz(3,3,"A");
    private Matriz matrizB = new Matriz(3,3,"B");
    private Matriz matrizC = new Matriz(3,3,"C");
    private Matriz matrizD = new Matriz(3,3,"D");
    private Matriz matrizE = new Matriz(3,3,"E");
    private Matriz matrizF = new Matriz(3,3,"F");
    private Matriz matrizG = new Matriz(3,3,"G");
    private Matriz matrizH = new Matriz(3,3,"H");

    /**
     * Vista del menu principal de matrices.
     */
    private MenuPrincipal menuPrincipal;

    /**
     * Vista del menu de la edicion de matrices.
     */
    private EditorMatrices menuEditarMatrices; //No se inicializa hasta que se llama

    /**
     * Clase que opera con las matrices.
     */
    private OperadorMatrices manipuladorMatrices = new OperadorMatrices();
    
    /**
     * El tipo de resultado es importante para saber si lo que se imprime
     * es una matriz o un flotante.
     */
    public enum TipoResultado
    {
        INVALIDO,
        MATRIZ,
        NUMERO,
    }
    
    /**
     * El nombre del procedimiento u operacion a realizar con la matriz o matrices
     * seleccionadas.
     */
    public enum Procedimiento
    {
        INVALIDO,
        SUMA,
        MULTIPLICACION_ESCALAR,
        MULTIPLICACION_MATRIZ,
        INVERSA_GJ,
        SOLUCION_SISTEMA_GJ,
        DETERMINANTE,
        SOLUCION_SISTEMA_CRAMER,
        TRANSPRUESTA,
    }
    
    /**
     * El resultado esperado de la operacion. Esto cambia segun al enum Procedimiento
     */
    private TipoResultado resultadoEsperado = TipoResultado.MATRIZ;

    /**
     * El procedimiento seleccionado actual
     */
    private Procedimiento procedimientoSeleccionado = Procedimiento.SUMA;

    /**
     * Constructo de la clase controlador. Inicializa el menu principal y carga
     * algunas funciones al inicio que son importantes para la experiencia del usuario
     */
    public Controlador()
    {
        menuPrincipal = new MenuPrincipal(this);
    
        javax.swing.JComboBox<String> selectorMatriz = menuPrincipal.getSelectorMatriz();

        menuPrincipal.previsualizarMatriz(obtenerMatrizSeleccionada(selectorMatriz));
        obtenerProcedimientoSeleccionado();
        menuPrincipal.mostrarArgumentosRelevantes(procedimientoSeleccionado);
        menuPrincipal.setVisible(true);
    }

    /**
     * Obtiene el objeto MATRIZ seleccionado sacado del selector JComboBox de la interfaz grafica
     * @param seleccion JComboBox Selector de matriz
     * @return MATRIZ El objeto matriz correspondiente a la seleccion
     */
    private Matriz obtenerMatrizSeleccionada(javax.swing.JComboBox<String> seleccion)
    {
        //System.out.println(seleccion.getSelectedItem().toString());
        switch(seleccion.getSelectedItem().toString())
        {
            case "A":
                return this.matrizA;
            case "B":
                return this.matrizB;
            case "C":
                return this.matrizC;
            case "D":
                return this.matrizD;
            case "E":
                return this.matrizE;
            case "F":
                return this.matrizF;
            case "G":
                return this.matrizG;
            case "H":
                return this.matrizH;
            default:
                return null;
        }
    }

    /**
     * Guarda los cambios realizados en la interfaz de edicion de matriz
     * en el objeto matriz que se habia seleccionado para editar.
     */
    public void guardarCambiosMatriz()
    {
        javax.swing.JComboBox<String> selectorMatriz = menuPrincipal.getSelectorMatriz();
        final Matriz guardado = menuEditarMatrices.getMatriz();
        
        switch(guardado.getId())
        {
            case "A":
                matrizA = guardado;
                break;
            case "B":
                matrizB = guardado;
                break;
            case "C":
                matrizC = guardado;
                break;
            case "D":
                matrizD = guardado;
                break;
            case "E":
                matrizE = guardado;
                break;
            case "F":
                matrizF = guardado;
                break;
            case "G":
                matrizG = guardado;
                break;
            case "H":
                matrizH = guardado;
                break;
        }
        menuPrincipal.previsualizarMatriz(obtenerMatrizSeleccionada(selectorMatriz));
    }

    /**
     * Obtiene el procedimiento seleccionado a partir del selector de procedimiento
     * que se encuentra en la interfaz grafica
     * @param seleccion JComboBox Selector de procedimiento
     */
    void obtenerProcedimientoSeleccionado()
    {
        javax.swing.JComboBox<String> seleccion = menuPrincipal.getSelectorProcedimiento();

        switch(seleccion.getSelectedItem().toString())
        {
            case "Suma de dos matrices":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.SUMA;
                break;
            case "Multiplicacion por Escalar":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.MULTIPLICACION_ESCALAR;
                break;
            case "Multiplicacion entre Matrices":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.MULTIPLICACION_MATRIZ;
                break;
            case "Inversa de Matriz por Gauss-Jordan":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.INVERSA_GJ;
                break;
            case "Solucion Sistema de Ecuaciones por Gauss-Jordan":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.SOLUCION_SISTEMA_GJ;
                break;
            case "Determinante de Matriz":
                resultadoEsperado = TipoResultado.NUMERO;
                procedimientoSeleccionado = Procedimiento.DETERMINANTE;
                break;
            case "Solucion Sistema de Ecuaciones por Cramer":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.SOLUCION_SISTEMA_CRAMER;
                break;
            case "Transpuesta de Matriz":
                resultadoEsperado = TipoResultado.MATRIZ;
                procedimientoSeleccionado = Procedimiento.TRANSPRUESTA;
                break;
            default:
                break;
        }
    }

    /**
     * Realiza el procedimiento seleccionado, pasando como parametros los argumentos
     * deseados. Devuelve la respuesta en forma de Matriz, aunque sea un solo numero.
     * @param parametros Object[] Aqui se puede introducir objetos MATRIZ o flotantes
     * @return MATRIZ Respuesta obtenida del procedimiento.
     */
    private Matriz realizarProcedimiento(Object[] parametros)
    {
        //System.out.println(seleccion.getSelectedItem().toString());
        Matriz retorno;
        switch(procedimientoSeleccionado)
        {
            case SUMA:
                retorno = manipuladorMatrices.sumaEntreMatrices((Matriz)parametros[0], (Matriz)parametros[1]);
                break;
            case MULTIPLICACION_ESCALAR:
                retorno = manipuladorMatrices.multiplicacionPorEscalar((Matriz)parametros[0], (float)parametros[2]);
                break;
            case MULTIPLICACION_MATRIZ:
                retorno = manipuladorMatrices.productoEntreMatrices((Matriz)parametros[0], (Matriz)parametros[1]);
                break;
            case INVERSA_GJ:
                retorno = manipuladorMatrices.calcularInversa_GJ((Matriz)parametros[0]);
                break;
            case SOLUCION_SISTEMA_GJ:
                retorno = manipuladorMatrices.solucionarSistemaGJ((Matriz)parametros[0]);
                break;
            case DETERMINANTE:
                retorno = manipuladorMatrices.calcularDeterminante((Matriz)parametros[0]);
                break;
            case SOLUCION_SISTEMA_CRAMER:
                retorno = manipuladorMatrices.solucionarSistemaCramer((Matriz)parametros[0]);
                break;
            case TRANSPRUESTA:
                retorno = manipuladorMatrices.calcularTranspuesta((Matriz)parametros[0]);
                break;
            default:
                retorno = null;
                break;
        }
        return retorno;
    }

    /**
     * Manda a llamar la operacion deseada dependiendo del procedimiento 
     * seleccionado. Al obtener una respuesta, la envia a que se imprima con
     * los otros metodos. Si hay un error, lo envia a procesar errores.
     */
    public void presionarBotonCalcular()
    {
        javax.swing.JComboBox<String> selectorMatriz1 = menuPrincipal.getSelectorMatriz1();
        javax.swing.JComboBox<String> selectorMatriz2 = menuPrincipal.getSelectorMatriz2();
        javax.swing.JSpinner selectorEscalar = menuPrincipal.getSelectorEscalar();

        final Matriz matrizSeleccionada1 = obtenerMatrizSeleccionada(selectorMatriz1);
        final Matriz matrizSeleccionada2 = obtenerMatrizSeleccionada(selectorMatriz2);
        
        //Aqui se pudo haber creado una clase para representar el arreglo
        //pero no se considero necesario debido a que es el unico lugar donde
        //se utiliza y no hay sentido de escalabilidad. Los indice 0 y 1 siempre
        //seran matrices y el indice 2 sera siempre el escalar flotante.
        Object[] parametros = new Object[3];
            parametros[0] = matrizSeleccionada1;
            parametros[1] = matrizSeleccionada2;
            parametros[2] = (float)selectorEscalar.getValue();
        
        obtenerProcedimientoSeleccionado();
        
        Matriz resultado = realizarProcedimiento(parametros);
        
        if (resultado.getError() != Matriz.ErrorMatriz.NINGUNO)
        {
            mostrarError(resultado.getError());
            return;
        }
        
        if (resultadoEsperado == TipoResultado.MATRIZ)
        {
            menuPrincipal.mostrarResultadoMatriz(resultado);
        }
        else if (resultadoEsperado == TipoResultado.NUMERO)
        {
            menuPrincipal.mostrarResultadoNumero(resultado.getValor(0, 0));
        }
    }

    /**
     * Obtiene la matriz seleccionada a editar y la envia como parametro a
     * la vista del menu editor de matrices, y muestra dicha vista.
     */
    public void presionarBotonEditar()
    {
        javax.swing.JComboBox<String> selectorMatriz = menuPrincipal.getSelectorMatriz();
        final Matriz matrizSeleccionada = obtenerMatrizSeleccionada(selectorMatriz);
        
        menuEditarMatrices = new EditorMatrices(matrizSeleccionada, menuPrincipal);
        menuEditarMatrices.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menuEditarMatrices.setVisible(true);
    }
 
    /**
     * Actualiza los valores del procedimiento seleccionado
     * y manda a llamar a actualizar la interfaz para mostrar los argumentos relevantes
     */
    public void procedimientoCambiado()
    {
        obtenerProcedimientoSeleccionado();
        menuPrincipal.mostrarArgumentosRelevantes(procedimientoSeleccionado);
    }

    /**
     * Obtiene la matriz seleccionada y la envia
     * a la interfaz para que se previsualize cuando se selecciona una matriz diferente en la interfaz.
     */  
    public void matrizSeleccionadaCambiada()
    {
        javax.swing.JComboBox<String> selectorMatriz = menuPrincipal.getSelectorMatriz();
        menuPrincipal.previsualizarMatriz(obtenerMatrizSeleccionada(selectorMatriz));
    }

    /**
     * Si se recibe una matriz con error marcado al hacer alguna operacion,
     * se alimenta a esta funcion para que muestre un mensaje de dialogo al
     * usuario sobre el error.
     * @param error ErrorMatriz Tipo de error al hacer la operacion
     */
    public void mostrarError(Matriz.ErrorMatriz error)
    {
        String mensajeError;
        switch(error)
        {
            case NO_CUADRADA:
                mensajeError = "La matriz introducida no es cuadrada.\n"
                              +"Por favor, introduzca una que si lo sea";
                break;
            case SINGULAR:
                mensajeError = "La matriz introducida es singular.\n"
                              +"Por favor, introduzca una que no lo sea";
                break;
            case METODO_INCOMPATIBLE:
                mensajeError = "La matriz introducida es incompatible con el metodo.\n"
                              +"Por favor, introduzca una que si lo sea.\n"
                              +"(Los metodos que solucionan sistemas no aceptan matrices < 2x3)";
                break;
            case DIMENSIONES_INCOMPATIBLES:
                mensajeError = "Las dimensiones de las matrices introducidas no son correctas.\n"
                              +"Por favor, utilice matrices con dimensiones compatibles";
                break;
            case ERROR_MATEMATICO:
                mensajeError = "Hubo un error matematico.\n"
                              +"Por favor, verifique los valores introducidos,\n"
                              +"introduzca una matriz diferente o intente con otro metodo";
                break;
            default:
                mensajeError = "Error desconocido.\n"
                              +"Por favor, verifique los valores introducidos,\n"
                              +"introduzca una matriz diferente o intente con otro metodo";
                break;
        }
        
        JOptionPane.showMessageDialog(null, mensajeError);
    }
}
