package matrices;

/**
 * Opera con objetos Matriz
 * @author amaury
 */
public class OperadorMatrices 
{
    /**
     * Dadas dos matrices A y B con las mismas dimensiones, retorna la suma de
     * A+B.
     * @param A Matriz A
     * @param B Matriz B
     * @return Matriz resultante de la suma A+B.
     */
    public Matriz sumaEntreMatrices(Matriz A, Matriz B)
    {
        assert(A.dimensionesIguales(B));
        Matriz resultado = new Matriz(A.getFilas(), A.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                resultado.setElemento(i, j, A.getElemento(i, j)+B.getElemento(i, j));
            }
        }
        
        return resultado;
    }
    
    /**
     * Dada una matriz A y un escalar e, retorna el producto entre la matriz y el escalar
     * A*e.
     * @param A Matriz A
     * @param escalar Escalar e
     * @return Matriz resultante de A*e.
     */
    public Matriz multiplicacionPorEscalar(Matriz A, float escalar)
    {
        Matriz resultado = new Matriz(A.getFilas(), A.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                resultado.setElemento(i, j, A.getElemento(i, j)*escalar);
            }
        }
        
        return resultado;
    }
    
    /**
     * Dadas dos matrices A y B, si el numero de columnas de la matriz A es
     * igual al numero de filas de la matriz B, entonces retorna el producto
     * de A*B.
     * @param A Matriz A
     * @param B Matriz B
     * @return Matriz resultante de A*B.
     */
    public Matriz productoEntreMatrices(Matriz A, Matriz B) 
    {
        assert(A.getColumnas() == B.getFilas());
        
        Matriz resultado = new Matriz(A.getFilas(), B.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            float[] resultadoFila = resultado.getElementos()[i];
            float[] AFila = A.getElementos()[i];
            
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                float[] BFila = B.getElementos()[j];
                for (int k = 0; k < B.getColumnas(); ++k)
                    resultadoFila[k] += AFila[j] * BFila[k];
            }
        }
        
        return resultado;
    }
    
    /**
     * Dada una matriz A cuadrada no singular, retorna la inversa de la matriz
     * A calculada con el metodo de Gauss-Jordan.
     * @param A Matriz A
     * @return Matriz A inversa.
     */
    public Matriz calcularInversa_GJ(Matriz A)
    {
        Matriz resultado = new Matriz(0,0,"R");
        return resultado;
    }
    
    /**
     * Dada una matriz A representando un sistema de ecuaciones, calcula la
     * solucion del sistema por el metodo de Gauss-Jordan.
     * @param A Matriz A representando el sistema de ecuaciones
     * @return Matriz de una sola fila representando con cada columna 
     * las variables correspondientes y su valor.
     */
    public Matriz solucionarSistema_GJ(Matriz A)
    {
        Matriz resultado = new Matriz(0,0,"R");
        return resultado;
    }
    
    /**
     * Dada una matriz A representando un sistema de ecuaciones, calcula la
     * solucion del sistema por el metodo de Cramer.
     * @param A Matriz A representando el sistema de ecuaciones
     * @return Matriz de una sola fila representando con cada columna
     * las variables correspondientes y su valor.
     */
    public Matriz solucionarSistema_Cramer(Matriz A)
    {
        Matriz resultado = new Matriz(0,0,"R");
        return resultado;
    }
    
    /**
     * Dada una matriz A, calcula su determinante de manera recursiva.
     * @param A Matriz A
     * @return int determinante de la matriz A.
     */
    public float calcularDeterminante(Matriz A)
    {
        float resultado = 0;
        
        //Solo se puede calcular el determinante de matrices cuadradas
        if (!A.esCuadrada()) { return 0; }
        
        int tamano = A.getFilas();
        if(tamano > 2) //Si las dimensiones son mayores que 2x2
        {
            //Reducir la matriz de manera recursiva utilizando una matriz mas pequena
            Matriz matrizPequena = new Matriz(tamano-1,tamano-1,"T");
            for(int i = 0; i < tamano; i++)
            {
                for (int j = 0; j < tamano-1; j++)
                {
                    //Copiar los elementos de la matriz parametro a la matriz pequena
                    int cont = 0;
                    for (int k = 0; k < tamano; k++)
                    {
                        if (k == i) { continue; }
                        matrizPequena.setElemento(j, cont, A.getElemento(j+1, k));
                        cont++;
                    }
                }
                //El determinante de la matriz tamano-1 x tamano-1
                float determinantePequeno = A.getElemento(0,i)*calcularDeterminante(matrizPequena);
                //El signo debe ser cambiado al intercambiar 2 columnas
                resultado += Math.pow(-1,i)*determinantePequeno;
            }
            return resultado;
        }
        else if(A.getFilas() == 2) //Si las dimensiones son de 2x2
        {
            resultado = ((A.getElemento(0,0))*(A.getElemento(1,1))-(A.getElemento(0,1))*(A.getElemento(1,0)));
            return resultado;
        }
        else 
        {
            return A.getElemento(0,0); //El determinante de una matriz 1x1 es el unico elemento
        }
    }
    
    /**
     * Dada una matriz A, calcula su transpuesta.
     * @param A Matriz A
     * @return Matriz A transpuesta.
     */
    public Matriz calcularTranspuesta(Matriz A)
    {
        Matriz resultado = new Matriz(A.getFilas(), A.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); i++)
        {
            for (int j = 0; j < A.getColumnas(); j++)
            {
                resultado.setElemento(j, i, A.getElemento(i, j));
            }
        }
        
        return resultado;
    }
}