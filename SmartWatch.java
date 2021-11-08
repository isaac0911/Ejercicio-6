import java.util.ArrayList;

/**
 * Modela a un Smart Watch
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class SmartWatch extends TelefonoCelular{
	
	/**
	 * Instancia un objeto de tipo SmartWatch.
	 * @version 08/11/2021
	 * @param DatosNuevoArticulo Arreglo que contiene los datos del nuevo articulo
	 */
	public SmartWatch(ArrayList<String> DatosNuevoArticulo){
		
		super (DatosNuevoArticulo);
		
	}
	
	/**
	 * Se definen las funcionalidades del articulo que se pueden probar
	 * @version 08/11/2021
	 * @return Devuelve el string contiene las funcionalidades del articulo que se pueden probar
	 */
	public String MenuOpcionesAProbar(){
		String mensaje = "1.\tHacer llamadas\n2.\tSer portable\n3.\tTomar fotografias";
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
	
}