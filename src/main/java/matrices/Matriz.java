package matrices;

import java.util.ArrayList;

/**
 * Clase Matriz. Aqui se hace la abstraccion de lo que es un objeto matriz
 * y se declaran sus propiedades que van a ser utilizadas para hacer operaciones
 * con ellas
 * @author amaury
 */
public class Matriz 
{
    /** El identificador de la matriz.
     * Debe ser una letra entre A y H. Se utiliza la letra R para las matrices
     * que sean resultantes de operaciones, y se utiliza la letra T para las
     * matrices en las cuales se realizan operaciones temporales.
     */
    private String id;
    private int filas; /** Numero de filas de la matriz */ 
    private int columnas; /** Numero de columnas de la matriz */ 
    /**
     * Los elementos de una matriz. El orden del arreglo es [filas][columnas]
     */
    private float[][] elementos;
    
    /**
     * Constructor del objeto Matriz. Se utiliza para crear una matriz vacia
     * rapidamente.
     * @param filas int Numero de filas
     * @param columnas int Numero de columnas
     * @param id String Identificador de la matriz
     */
    public Matriz(int filas, int columnas, String id)
    {
        this.filas = filas;
        this.columnas = columnas;
        elementos = new float[filas][columnas];
        this.id = id;
    }
    
    /**
     * Constructor del objeto Matriz. Se utiliza para crear una matriz con valores
     * predeterminados rapidamente.
     * @param filas int Numero de filas
     * @param columnas int Numero de columnas
     * @param id String Identificador de la matriz
     * @param elementos float[][] Elementos predeterminados
     */
    public Matriz(int filas, int columnas, String id, float[][] elementos)
    {
        this.filas = filas;
        this.columnas = columnas;
        this.elementos = elementos;
        this.id = id;
    }
    
    /**
     * Asigna un valor flotante al elemento de la matriz localizado en la
     * posicion [fila][columna]
     * @param fila
     * @param columna
     * @param valor
     */
    public void setElemento(int fila, int columna, float valor)
    { elementos[fila][columna] = valor; }
    
    /**
     * Retorna el valor flotante del elemento de la matriz
     * posicionado en [fila][columna]
     * @param fila
     * @param columna
     * @return
     */
    public float getElemento(int fila, int columna)
    { return elementos[fila][columna]; }
    
    /**
     * Retorna todos los elementos de la matriz.
     * @return float[][] El arreglo de elementos. Orden [fila][columna]
     */
    public float[][] getElementos()
    { return elementos; }
    
    /**
     * Retorna el numero de filas de la matriz.
     * @return int El numero de filas de la matriz.
     */
    public int getFilas() { return filas; }

    /**
     * Retorna el numero de columnas de la matriz.
     * @return int El numero de columnas de la matriz.
     */
    public int getColumnas() { return columnas; }

    /**
     * Retorna el identificador de la matriz.
     * @return String El identificador de la matriz.
     */
    public String getId() { return id; }
    
    /**
     * Imprime la representacion de la matriz al System.out
     */
    public void imprimir()
    {
        for (int fila = 0; fila < filas; ++fila) 
        {
            System.out.print("[");
            for (int columna = 0; columna < columnas; ++columna) 
            {
                //if (columna > 0) { System.out.print(" "); }
                System.out.printf("%7.2f", elementos[fila][columna]);
            }
            System.out.print("  ]");
            System.out.println("");
        }
    }
    
    /**
     * Muestra la representacion grafica de un elemento seleccionado en la matriz.
     * Esto es utilizado en la interfaz de edicion de matrices para que el
     * usuario pueda saber cual es el elemento seleccionado actualmente.
     * @param elementoFila El indice fila del elemento
     * @param elementoColumna El indice columna del elemento
     * @return ArrayList<String> La lista de cadenas que se requieren 
     * para dibujar la representacion de la matriz, incluyendo la representacion 
     * de la seleccion del elemento deseado.
     */
    public ArrayList<String> mostrarElemento(int elementoFila, int elementoColumna)
    {
        boolean elementoEncontrado = false;
        ArrayList<String> cadenas = new ArrayList<String>();
        int cadenasCont;
        
        for (int fila = 0; fila < filas; ++fila) 
        {
            cadenas.add("[  ");
            for (int columna = 0; columna < columnas; ++columna) 
            {
                if (columna > 0) { cadenas.add("        "); }
                if (fila == elementoFila && columna == elementoColumna && !elementoEncontrado)
                {
                    cadenas.add(">");
                    elementoEncontrado = true;
                }
                cadenas.add(""+elementos[fila][columna]);
                if (elementoEncontrado) { cadenas.add("<"); elementoEncontrado = false; }
            }
            cadenas.add("  ]");
            cadenas.add("\n");
        }
        return cadenas;
    }
    
    /**
     * Retorna si las dimensiones de las matrices comparadas son iguales.
     * @return boolean Verdadero o Falso a la premisa.
     */
    public boolean dimensionesIguales(Matriz comparacion)
    {
        if (this.getFilas() != comparacion.getFilas()) { return false; }
        if (this.getColumnas()!= comparacion.getColumnas()) { return false; }
        return true;
    }
    
    /**
     * Retorna si la matriz es cuadrada o no.
     * @return boolean Verdadero o Falso a la premisa.
     */
    public boolean esCuadrada()
    {
        return (this.getFilas() == this.getColumnas());
    }
    
    /**
     * Compara todos los elementos de dos matrices para concluir si son
     * iguales o no.
     * @param comparacion Matriz a comparar
     * @return boolean Verdadero o Falso a la premisa.
     */
    public boolean esIgualA(Matriz comparacion)
    {
        for (int i = 0; i < this.getFilas(); i++)
        {
            for (int j = 0; j < this.getColumnas(); j++)
            {
                float matrizEl = this.getElemento(i, j);
                float comparEl = comparacion.getElemento(i,j);
                
                //A veces los -0 no son iguales a los 0, asi que normalizamos.
                if (matrizEl == 0 || matrizEl == -0) { matrizEl = 0.0F; }
                if (comparEl == 0 || comparEl == -0) { comparEl = 0.0F; }
                
                if (matrizEl != comparEl)
                {
                    System.out.println("err: "+matrizEl+" =/= "+comparEl+" ["+i+","+j+"]");
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Asigna los elementos de la matriz utilizando un arreglo bidimensional
     * @param elementos float[][] Arreglo bidimensional de numeros
     */
    public void asignarElementos(float[][] elementos, int maxFilas, int maxColumnas)
    {
        for (int i = 0; i < maxFilas; i++)
        {
            for (int j = 0; j < maxColumnas; j++)
            {
                this.setElemento(i, j, elementos[i][j]);
            }
        }
    }
    
    /**
     * Redondea los elementos de la matriz 2 puntos decimales
     */
    public void redondearElementos()
    {
        for (int i = 0; i < getFilas(); i++)
        {
            for (int j = 0; j < getColumnas(); j++)
            {
                this.setElemento(i, j, Math.round(elementos[i][j]*100.0F)/100.0F);
            }
        }
    }
}
