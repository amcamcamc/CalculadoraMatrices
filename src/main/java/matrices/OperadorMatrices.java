package matrices;

/**
 * Opera con objetos Matriz
 * @author amaury
 */
public class OperadorMatrices 
{
    /**
     * Dadas dos matrices A y B con las mismas dimensiones, retorna la suma de A+B.
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
            return new Matriz(Matriz.ErrorMatriz.DIMENSIONES_INCOMPATIBLES);
        }
        Matriz resultado = new Matriz(A.getFilas(), A.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                resultado.setValor(i, j, A.getValor(i, j)+B.getValor(i, j));
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
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
                resultado.setValor(i, j, A.getValor(i, j)*escalar);
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
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
            return new Matriz(Matriz.ErrorMatriz.DIMENSIONES_INCOMPATIBLES);
        }
        
        Matriz resultado = new Matriz(A.getFilas(), B.getColumnas(), "R");
        
        for (int i = 0; i < A.getFilas(); ++i) 
        {
            float[] resultadoFila = resultado.getValores()[i];
            float[] filaA = A.getValores()[i];
            
            for (int j = 0; j < A.getColumnas(); ++j) 
            {
                float[] filaB = B.getValores()[j];
                for (int k = 0; k < B.getColumnas(); ++k)
                {
                    resultadoFila[k] += filaA[j] * filaB[k];
                }
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
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
            return new Matriz(Matriz.ErrorMatriz.NO_CUADRADA);
        }
        
        float determinante = calcularDeterminante(A).getValor(0, 0);
        //La matriz tampoco debe ser singular
        if (determinante == 0)
        {
            return new Matriz(Matriz.ErrorMatriz.SINGULAR);
        }
        
        int longitudMatriz = A.getFilas();
        Matriz calcMatriz = new Matriz(longitudMatriz,longitudMatriz*2,"T");
        calcMatriz.setValores(A.getValores(), longitudMatriz, longitudMatriz);
       
        //Aumentar la matriz A con la matriz de identidad
        for (int i = 0; i < longitudMatriz; i++)
        {
            for (int j = 0; j < longitudMatriz; j++)
            {
                //System.out.println(i+", "+j);
                if (i == j) { calcMatriz.setValor(i, j+longitudMatriz, 1); }
                else { calcMatriz.setValor(i, j+longitudMatriz, 0); }
            }
        }
        
        //Aplicar eliminacion de Gauss-Jordan a la matriz aumentada
        //Nota: Los 0F sumados al final es para que el numero flotante del resultado
        //aparezca con decimales y no se redondee automaticamente.
        for (int i = 0; i < longitudMatriz; i++)
        {
            //La diagonal principal no puede tener 0s
            if (calcMatriz.getValor(i, i) == 0)
            {
                return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO);
            }
            
            for (int j = 0; j < longitudMatriz; j++)
            {
                if (i != j)
                {
                    float radio = calcMatriz.getValor(j, i)/calcMatriz.getValor(i, i) + 0F;
                    
                    for (int k = 0; k < longitudMatriz*2; k++)
                    {
                        calcMatriz.setValor(j, k, calcMatriz.getValor(j, k) - radio * calcMatriz.getValor(i, k) + 0F);
                    }
                }
            }
        }
        
        //Convertir la diagonal principal en 1s
        //Nota: Los 0F sumados al final es para que el numero flotante del resultado
        //aparezca con decimales y no se redondee automaticamente.
        for (int i = 0; i < longitudMatriz; i++)
        {
            for (int j = longitudMatriz; j < longitudMatriz*2; j++)
            {
                calcMatriz.setValor(i, j, calcMatriz.getValor(i, j)/calcMatriz.getValor(i, i) + 0F);
            }
        }
        
        //Eliminar la parte que sobra de la matriz resultante
        Matriz resultado = new Matriz(A.getFilas(),A.getColumnas(),"R");
        for (int i = 0; i < longitudMatriz; i++)
        {
            for (int j = 0; j < longitudMatriz; j++)
            {
                resultado.setValor(i, j, calcMatriz.getValor(i, j+longitudMatriz));
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
    }
    
    /**
     * Dada una matriz A representando un sistema de ecuaciones, calcula la
     * solucion del sistema por el metodo de Gauss-Jordan.
     * @param A Matriz A representando el sistema de ecuaciones
     * @return Matriz de una sola fila representando con cada columna 
     * las variables correspondientes y su valor.
     */
    public Matriz solucionarSistemaGJ(Matriz A)
    {
        try {
  
        if (
            A.getColumnas() <= 2 || //Con este metodo solo se pueden solucionar matrices con dos variables o mas
            A.esMatrizIdentidad() //No se puede aplicar GJ a la matriz identidad
           )
        {
            return new Matriz(Matriz.ErrorMatriz.METODO_INCOMPATIBLE);
        }
        
        int columnaRespuesta = A.getColumnas()-1;
        int numVariables = A.getFilas();
        Matriz resultado = new Matriz(1,numVariables,"R");
        
        //Copiamos la Matriz A a otra matriz sin la columna resultado b
        Matriz calcMatriz = new Matriz(A.getFilas(), A.getColumnas()-1, "T");
        calcMatriz.setValores(A.getValores(), numVariables, columnaRespuesta);
        
        //Como vamos a realizar muchas operaciones con la matriz original,
        //es mejor no utilizar el objeto matriz. Creamos un arreglo al cual
        //se le puedan asignar los valores de la matriz
        float[][] Asinb = calcMatriz.getValores();
        
        //Como la matriz A ya deberia estar aumentada solo copiamos la columna
        //respuesta a un arreglo para poder manipularla.
        float[] bCol = new float[numVariables];
        
        for (int i = 0; i < numVariables; i++)
        {
            bCol[i] = A.getValor(i, columnaRespuesta);
        }
        
        final double epsilon = 1e-10; //margen de error para considerar la matriz singular
        System.out.println(epsilon);
        //Aplicar eliminacion de Gauss-Jordan a la matriz aumentada
        for (int pivote = 0; pivote < numVariables; pivote++)
        {
            //Encontrar el pivote
            int max = pivote;
            for (int i = pivote + 1; i < numVariables; i++)
            {
                
                if (Math.abs(Asinb[max][pivote]) < Math.abs(Asinb[i][pivote]))
                {
                    max = i;
                }
            }
            //Intercambiar filas
            float[] cambioFilaA = Asinb[pivote];
            Asinb[pivote] = Asinb[max];
            Asinb[max] = cambioFilaA;
            
            float cambioFilab = bCol[pivote];
            bCol[pivote] = bCol[max];
            bCol[max] = cambioFilab;

            //La matriz no puede ser singular
            if (Math.abs(Asinb[pivote][pivote]) <= epsilon)
            {
                return new Matriz(Matriz.ErrorMatriz.SINGULAR);
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
        //Nota: Los 0F sumados al final es para que el numero flotante del resultado
        //aparezca con decimales y no se redondee automaticamente.
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
            resultado.setValor(0, i, variables[i]);
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
    }
    
    /**
     * Dada una matriz A representando un sistema de ecuaciones, calcula la
     * solucion del sistema por el metodo de Cramer.
     * @param A Matriz A representando el sistema de ecuaciones
     * @return Matriz de una sola fila representando con cada columna
     * las variables correspondientes y su valor.
     */
    public Matriz solucionarSistemaCramer(Matriz A)
    {   
        try {
            
        if (
            A.getColumnas() <= 2 || //Con este metodo solo se pueden solucionar matrices con dos variables o mas
            A.esVacia() || //La matriz tampoco debe ser vacia
            A.esMatrizIdentidad() //No se puede aplicar Cramer a la matriz identidad
           )
        {
            return new Matriz(Matriz.ErrorMatriz.METODO_INCOMPATIBLE);
        }
        
        Matriz calcMatriz = new Matriz(A.getFilas(), A.getColumnas()-1, "T");
        //Introducir dentro de la matriz resultado el sistema de ecuaciones sin 
        //las soluciones.        
        calcMatriz.setValores(A.getValores(), A.getFilas(), A.getColumnas()-1);
        
        int columnaRespuesta = A.getColumnas()-1;
        int numVariables = A.getFilas();
        
        Matriz resultado = new Matriz(1,numVariables,"R");
        
        //Por cada variable, crear una matriz resultado donde se sobreescribe
        //la columna col con la columna de respuestas de la matriz A solo cuando
        //es la columna correspondiente
        for (int filaR = 0; filaR < numVariables; filaR++) //La variable columna actual (x1, x2, x3)
        {
            Matriz variableDet = new Matriz(calcMatriz.getFilas(), calcMatriz.getColumnas(), "T");
            variableDet.setValores(calcMatriz.getValores(), calcMatriz.getFilas(), calcMatriz.getColumnas());
            for (int col = 0; col < calcMatriz.getColumnas(); col++) //La columna actual
            {
                for (int fil = 0; fil < calcMatriz.getFilas(); fil++) //La fila actual
                {
                    for (int var = 0; var < numVariables; var++) //La variable fila actual (x,y,z)
                    {
                        //System.out.println("R:"+filaR+" columna:"+col+" fila:"+fil+" var: "+var);
                        if (var == fil && col == filaR)
                        {
                            //System.out.println("fila:"+fil+" var: "+var+" valor:"+A.getValor(var, columnaRespuesta));
                            variableDet.setValor(fil, col, A.getValor(var, columnaRespuesta));
                            break;
                        }
                    }
                }
            }
            //Al llegar a este punto, la variableDet debe de tener la matriz
            //superior de la formula, la cual solo tiene sobreescritas las
            //variables de resultado en la columna correspondiente al numero
            //de variable columna a obtener
            float resultadoFormula = calcularDeterminante(variableDet).getValor(0, 0)/calcularDeterminante(calcMatriz).getValor(0, 0);
            resultado.setValor(0, filaR, resultadoFormula);
        }
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
    }
    
    /**
     * Dada una matriz A, calcula su determinante de manera recursiva.
     * @param A Matriz A
     * @return int determinante de la matriz A.
     */
    public Matriz calcularDeterminante(Matriz A)
    {
        try {
        
        //Solo se puede calcular el determinante de matrices cuadradas
        if (!A.esCuadrada())
        {
            return new Matriz(Matriz.ErrorMatriz.NO_CUADRADA);
        }
        
        float detCalculado = 0;
        Matriz resultado = new Matriz(1,1,"R");
        
        final int longitudMatriz = A.getFilas();
        if(longitudMatriz > 2) //Si las dimensiones son mayores que 2x2
        {
            //Reducir la matriz de manera recursiva utilizando una matriz mas pequena
            Matriz subMatriz = new Matriz(longitudMatriz-1,longitudMatriz-1,"T");
            for(int i = 0; i < longitudMatriz; i++)
            {
                for (int j = 0; j < longitudMatriz-1; j++)
                {
                    //Copiar los elementos de la matriz parametro a la matriz pequena
                    int cont = 0;
                    for (int k = 0; k < longitudMatriz; k++)
                    {
                        if (k == i) { continue; }
                        subMatriz.setValor(j, cont, A.getValor(j+1, k));
                        cont++;
                    }
                }
                //El determinante de la matriz longitudMatriz-1 x longitudMatriz-1
                float determinantePequeno = A.getValor(0,i)*calcularDeterminante(subMatriz).getValor(0, 0);
                //El signo debe ser cambiado al intercambiar 2 columnas
                detCalculado += Math.pow(-1,i)*determinantePequeno;
            }
            resultado.setValor(0, 0, detCalculado);
            return resultado;
        }
        else if(A.getFilas() == 2) //Si las dimensiones son de 2x2
        {
            detCalculado = A.getValor(0,0)*A.getValor(1,1)-A.getValor(0,1)*A.getValor(1,0);
            resultado.setValor(0, 0, detCalculado);
            return resultado;
        }
        else 
        {
            resultado.setValor(0, 0, A.getValor(0, 0));
            return resultado; //El determinante de una matriz 1x1 es el unico elemento
        }
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
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
                resultado.setValor(j, i, A.getValor(i, j));
            }
        }
        
        return resultado;
        
        } catch(Exception e) { System.out.println(e); return new Matriz(Matriz.ErrorMatriz.ERROR_MATEMATICO); }
    }
}