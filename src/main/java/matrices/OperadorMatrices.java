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
        try {
        
        //Las matrices deben tener la misma dimension para poder ser sumadas
        if (!A.dimensionesIguales(B))
        {
            return new Matriz(Matriz.ErrorMatriz.DimensionesIncompatibles);
        }
        Matriz resultado = new Matriz(A.getFilas(), A.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                resultado.setElemento(i, j, A.getElemento(i, j)+B.getElemento(i, j));
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
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
        try {
            
        Matriz resultado = new Matriz(A.getFilas(), A.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                resultado.setElemento(i, j, A.getElemento(i, j)*escalar);
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
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
        try {
            
        //El numero de columnas de A debe ser el mismo numero de filas de B
        if (!(A.getColumnas() == B.getFilas()))
        {
            return new Matriz(Matriz.ErrorMatriz.DimensionesIncompatibles);
        }
        
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
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
    }
    
    /**
     * Dada una matriz A cuadrada no singular, retorna la inversa de la matriz A
     * calculada con el metodo de Gauss-Jordan.
     * @param A Matriz A
     * @return Matriz A inversa.
     */
    public Matriz calcularInversa_GJ(Matriz A)
    {
        try {
        
        if (!A.esCuadrada())
        {
            return new Matriz(Matriz.ErrorMatriz.NoCuadrada);
        }
        
        int tamano = A.getFilas();
        Matriz temporal = new Matriz(tamano,tamano*2,"T");
        temporal.asignarElementos(A.getElementos(), tamano, tamano);
        
        float determinante = calcularDeterminante(A).getElemento(0, 0);
        
        //La matriz tampoco debe ser singular
        if (determinante == 0)
        {
            return new Matriz(Matriz.ErrorMatriz.Singular);
        }
       
        //Aumentar la matriz A con la matriz de identidad
        for (int i = 0; i < tamano; i++)
        {
            for (int j = 0; j < tamano; j++)
            {
                //System.out.println(i+", "+j);
                if (i == j) { temporal.setElemento(i, j+tamano, 1); }
                else { temporal.setElemento(i, j+tamano, 0); }
            }
        }
        
        //Aplicar eliminacion de Gauss-Jordan a la matriz aumentada
        for (int i = 0; i < tamano; i++)
        {
            //La diagonal principal no puede tener 0s
            if (temporal.getElemento(i, i) == 0)
            {
                return new Matriz(Matriz.ErrorMatriz.ErrorMatematico);
            }
            
            for (int j = 0; j < tamano; j++)
            {
                if (i != j)
                {
                    float radio = temporal.getElemento(j, i)/temporal.getElemento(i, i) + 0F;
                    
                    for (int k = 0; k < tamano*2; k++)
                    {
                        temporal.setElemento(j, k, temporal.getElemento(j, k) - radio * temporal.getElemento(i, k) + 0F);
                    }
                }
            }
        }
        
        //Convertir la diagonal principal en 1s
        for (int i = 0; i < tamano; i++)
        {
            for (int j = tamano; j < tamano*2; j++)
            {
                temporal.setElemento(i, j, temporal.getElemento(i, j)/temporal.getElemento(i, i) + 0F);
            }
        }
        
        //Eliminar la parte que sobra de la matriz resultante
        Matriz resultado = new Matriz(A.getFilas(),A.getColumnas(),"R");
        for (int i = 0; i < tamano; i++)
        {
            for (int j = 0; j < tamano; j++)
            {
                resultado.setElemento(i, j, temporal.getElemento(i, j+tamano));
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
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
        try {
            
        double epsilon = 1e-10; //margen de error para considerar la matriz singular
        
        int columnaRespuesta = A.getColumnas()-1;
        int numVariables = A.getFilas();
        Matriz resultado = new Matriz(1,numVariables,"R");
        
        //Con este metodo solo se pueden solucionar matrices con dos variables o mas
        if (A.getColumnas() <= 2)
        {
            return new Matriz(Matriz.ErrorMatriz.MetodoIncompatible);
        }
        
        //No se puede aplicar GJ a la matriz identidad
        if (A.esMatrizIdentidad())
        {
            return new Matriz(Matriz.ErrorMatriz.MetodoIncompatible);
        }
        
        //Copiamos la Matriz A a otra matriz sin la columna respuesta b
        Matriz temporal = new Matriz(A.getFilas(), A.getColumnas()-1, "T");
        temporal.asignarElementos(A.getElementos(), numVariables, columnaRespuesta);
        
        //Como vamos a realizar muchas operaciones con la matriz original,
        //es mejor no utilizar el objeto matriz. Creamos un arreglo al cual
        //se le puedan asignar los valores de la matriz
        float[][] Asinb = temporal.getElementos();
        
        //Como la matriz A ya deberia estar aumentada solo copiamos la columna
        //respuesta a un arreglo para poder manipularla.
        float[] bCol = new float[numVariables];
        
        for (int i = 0; i < numVariables; i++)
        {
            bCol[i] = A.getElemento(i, columnaRespuesta);
        }
        
        //Aplicar eliminacion de Gauss-Jordan a la matriz aumentada
        for (int pivote = 0; pivote < numVariables; pivote++)
        {
            //Encontrar el pivote
            int max = pivote;
            for (int i = pivote + 1; i < numVariables; i++)
            {
                
                if (Math.abs(Asinb[i][pivote]) > Math.abs(Asinb[max][pivote]))
                {
                    max = i;
                }
            }
            //Intercambiar filas
            float[] tempFila_A = Asinb[pivote];
            Asinb[pivote] = Asinb[max];
            Asinb[max] = tempFila_A;
            
            float tempFila_b = bCol[pivote];
            bCol[pivote] = bCol[max];
            bCol[max] = tempFila_b;

            //La matriz no puede ser singular
            if (Math.abs(Asinb[pivote][pivote]) <= epsilon)
            {
                return new Matriz(Matriz.ErrorMatriz.Singular);
            }

            //Pivote de A y b
            for (int i = pivote + 1; i < numVariables; i++)
            {
                float delta = Asinb[i][pivote] / Asinb[pivote][pivote];
                bCol[i] -= delta * bCol[pivote];
                for (int j = pivote; j < numVariables; j++)
                {
                    Asinb[i][j] -= delta * Asinb[pivote][j];
                }
            }
        }

        //Encontrar las variables sustituyendo en reversa
        float[] variables = new float[numVariables];
        for (int i = numVariables - 1; i >= 0; i--)
        {
            float suma = 0.0F;
            for (int j = i + 1; j < numVariables; j++)
            {
                suma += Asinb[i][j] * variables[j] + 0F;
            }
            variables[i] = (bCol[i] - suma) / Asinb[i][i] + 0F;
        }
        
        //Convertimos el arreglo de respuestas a matriz de una sola fila
        for (int i = 0; i < numVariables; i++)
        {
            resultado.setElemento(0, i, variables[i]);
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
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
        try {
            
        int columnaRespuesta = A.getColumnas()-1;
        int numVariables = A.getFilas();
        Matriz resultado = new Matriz(1,numVariables,"R");
        Matriz temporal = new Matriz(A.getFilas(), A.getColumnas()-1, "T");
        
        //Con este metodo solo se pueden solucionar matrices con dos variables o mas
        if (A.getColumnas() <= 2)
        {
            return new Matriz(Matriz.ErrorMatriz.MetodoIncompatible);
        }
        
        //La matriz tampoco debe ser vacia
        if (A.esVacia())
        {
            return new Matriz(Matriz.ErrorMatriz.MetodoIncompatible);
        }
        
        //No se puede aplicar Cramer a la matriz identidad
        if (A.esMatrizIdentidad())
        {
            return new Matriz(Matriz.ErrorMatriz.MetodoIncompatible);
        }
        
        //Introducir dentro de la matriz temporal el sistema de ecuaciones sin 
        //las soluciones.        
        temporal.asignarElementos(A.getElementos(), A.getFilas(), A.getColumnas()-1);
        
        //Por cada variable, crear una matriz temporal donde se sobreescribe
        //la columna col con la columna de respuestas de la matriz A solo cuando
        //es la columna correspondiente
        for (int filaR = 0; filaR < numVariables; filaR++) //La variable columna actual (x1, x2, x3)
        {
            Matriz variableDet = new Matriz(temporal.getFilas(), temporal.getColumnas(), "T");
            variableDet.asignarElementos(temporal.getElementos(), temporal.getFilas(), temporal.getColumnas());
            for (int col = 0; col < temporal.getColumnas(); col++) //La columna actual
            {
                for (int fil = 0; fil < temporal.getFilas(); fil++) //La fila actual
                {
                    for (int var = 0; var < numVariables; var++) //La variable fila actual (x,y,z)
                    {
                        //System.out.println("R:"+filaR+" columna:"+col+" fila:"+fil+" var: "+var);
                        if (var == fil && col == filaR)
                        {
                            //System.out.println("fila:"+fil+" var: "+var+" valor:"+A.getElemento(var, columnaRespuesta));
                            variableDet.setElemento(fil, col, A.getElemento(var, columnaRespuesta));
                            break;
                        }
                    }
                }
            }
            //Al llegar a este punto, la variableDet debe de tener la matriz
            //superior de la formula, la cual solo tiene sobreescritas las
            //variables de respuesta en la columna correspondiente al numero
            //de variable columna a obtener
            float resultadoFormula = calcularDeterminante(variableDet).getElemento(0, 0)/calcularDeterminante(temporal).getElemento(0, 0);
            resultado.setElemento(0, filaR, resultadoFormula);
        }
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
    }
    
    /**
     * Dada una matriz A, calcula su determinante de manera recursiva.
     * @param A Matriz A
     * @return int determinante de la matriz A.
     */
    public Matriz calcularDeterminante(Matriz A)
    {
        try {
        
        float resultado = 0;
        Matriz retorno = new Matriz(1,1,"R");
        
        //Solo se puede calcular el determinante de matrices cuadradas
        if (!A.esCuadrada())
        {
            return new Matriz(Matriz.ErrorMatriz.NoCuadrada);
        }
        
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
                float determinantePequeno = A.getElemento(0,i)*calcularDeterminante(matrizPequena).getElemento(0, 0);
                //El signo debe ser cambiado al intercambiar 2 columnas
                resultado += Math.pow(-1,i)*determinantePequeno;
            }
            retorno.setElemento(0, 0, resultado);
            return retorno;
        }
        else if(A.getFilas() == 2) //Si las dimensiones son de 2x2
        {
            resultado = ((A.getElemento(0,0))*(A.getElemento(1,1))-(A.getElemento(0,1))*(A.getElemento(1,0)));
            retorno.setElemento(0, 0, resultado);
            return retorno;
        }
        else 
        {
            retorno.setElemento(0, 0, A.getElemento(0, 0));
            return retorno; //El determinante de una matriz 1x1 es el unico elemento
        }
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
    }
    
    /**
     * Dada una matriz A, calcula su transpuesta.
     * @param A Matriz A
     * @return Matriz A transpuesta.
     */
    public Matriz calcularTranspuesta(Matriz A)
    {
        try {
            
        Matriz resultado = new Matriz(A.getColumnas(), A.getFilas(), "R");
        
        for (int i = 0; i < A.getFilas(); i++)
        {
            for (int j = 0; j < A.getColumnas(); j++)
            {
                resultado.setElemento(j, i, A.getElemento(i, j));
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ErrorMatematico); }
    }
}