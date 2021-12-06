package interfaz;

/**
 * Clase Main en donde se inicia el programa
 * @author amaury
 */
public class Main 
{
    /**
     * El objeto de la vista de la interfaz principal
     */
    private final static MenuPrincipal menuPrincipal = new MenuPrincipal();
    
    /**
     * @param args ninguno
     */
    public static void main(String[] args) 
    {
        menuPrincipal.setVisible(true);
    }
    
}
