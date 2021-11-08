import java.util.ArrayList;

/**
 * Modela a un computador de escritorio
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class ComputadorDeEscritorio extends SmartTV{
	
	/**
	 * Instancia un objeto de tipo ComputadorDeEscritorio.
	 * @version 08/11/2021
	 * @param DatosNuevoArticulo Arreglo que contiene los datos del nuevo articulo
	 */
	public ComputadorDeEscritorio(ArrayList<String> DatosNuevoArticulo){
		
		super (DatosNuevoArticulo);
		
	}
	
	/**
	 * Se definen las funcionalidades del articulo que se pueden probar
	 * @version 08/11/2021
	 * @return Devuelve el string contiene las funcionalidades del articulo que se pueden probar
	 */
	public String MenuOpcionesAProbar(){
		String mensaje = "1.\tNavegar por Internet\n2.\tReproducir Videos\n3.\tEjecutar videojuegos";
		return mensaje;
	}
	
	/**
	 * Se define el string que se muestra cuando el articulo ejecuta algun videojuego
	 * @version 08/11/2021
	 * @param VideoJuego Video juego que se reproducirá
	 * @return Devuelve el string que se muestra cuando el articulo ejecuta algun videojuego
	 */
	public String EjecutarVideoJuego(String VideoJuego){
		String mensaje = "Ejecutando el videojuego: " + VideoJuego + " ... La operacion tuvo exito.";
		return mensaje;
	}
	
}