import java.util.ArrayList;

/**
 *
 * @author a
 */
public class Matriz 
{
    private String id;
    private int filas;
    private int columnas;
    private float[][] elementos;
    
    /**
     *
     * @param filas
     * @param columnas
     * @param id
     */
    public Matriz(int filas, int columnas, String id)
    {
        this.filas = filas;
        this.columnas = columnas;
        elementos = new float[filas][columnas];
        this.id = id;
    }
    
    /**
     *
     * @param fila
     * @param columna
     * @param valor
     */
    public void setElemento(int fila, int columna, float valor)
    { elementos[fila][columna] = valor; }
    
    /**
     *
     * @param fila
     * @param columna
     * @return
     */
    public float getElemento(int fila, int columna)
    { return elementos[fila][columna]; }
    
    /**
     *
     * @return
     */
    public float[][] getElementos()
    { return elementos; }
    
    /**
     *
     * @return
     */
    public int getFilas() { return filas; }

    /**
     *
     * @return
     */
    public int getColumnas() { return columnas; }

    /**
     *
     * @return
     */
    public String getId() { return id; }
    
    /**
     *
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
     *
     * @param elementoFila
     * @param elementoColumna
     * @return
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
     *
     * @return
     */
    public String getDimensiones()
    {
        return ""+filas+"x"+columnas;
    }
}
