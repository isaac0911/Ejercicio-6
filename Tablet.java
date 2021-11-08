import java.util.ArrayList;

/**
 * Modela a una tablet
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class Tablet extends SmartTV{
	
	/**
	 * Instancia un objeto de tipo Tablet.
	 * @version 08/11/2021
	 * @param DatosNuevoArticulo Arreglo que contiene los datos del nuevo articulo
	 */
	public Tablet(ArrayList<String> DatosNuevoArticulo){
		
		super (DatosNuevoArticulo);
		
	}
	
	/**
	 * Se definen las funcionalidades del articulo que se pueden probar
	 * @version 08/11/2021
	 * @return Devuelve el string contiene las funcionalidades del articulo que se pueden probar
	 */
	public String MenuOpcionesAProbar(){
		String mensaje = "1.\tNavegar por Internet\n2.\tReproducirVideos\n3.\tTomar fotografias\n4.\tSer portable";
		return mensaje;
	}
	
	/**
	 * Se define el string que se muestra cuando el articulo toma una fotografia
	 * @version 08/11/2021
	 * @param Objeto Objeto al que se le tomara una fotografia
	 * @return Devuelve el string que se muestra cuando el articulo toma una fotografia
	 */
	public String TomarFotografia(String Objeto){
		String mensaje = "Tomando una fotografia de: " + Objeto + " ... La operacion tuvo exito.";
		return mensaje;
	}
	
	/**
	 * Se define el string que se muestra cuando el articulo se transporta a algun lugar
	 * @version 08/11/2021
	 * @param Lugar Lugar al que se transportara el articulo
	 * @return Devuelve el string que se muestra cuando el articulo se transporta a algun lugar
	 */
	public String SerPortable(String Lugar){
		String mensaje = "Desplazando el articulo '" + Nombre + "' hacia " + Lugar + "... La operacion tuvo exito.";
		return mensaje;
	}
	
}