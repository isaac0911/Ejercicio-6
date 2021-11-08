import java.util.ArrayList;

/**
 * Modela a un Smartphone
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class Smartphone extends SmartWatch{
	
	/**
	 * Instancia un objeto de tipo Smartphone.
	 * @version 08/11/2021
	 * @param DatosNuevoArticulo Arreglo que contiene los datos del nuevo articulo
	 */
	public Smartphone(ArrayList<String> DatosNuevoArticulo){
		
		super (DatosNuevoArticulo);
		
	}
	
	/**
	 * Se definen las funcionalidades del articulo que se pueden probar
	 * @version 08/11/2021
	 * @return Devuelve el string contiene las funcionalidades del articulo que se pueden probar
	 */
	public String MenuOpcionesAProbar(){
		String mensaje = "1.\tHacer llamadas\n2.\tSer portable\n3.\tTomar fotografias\n4.\tNavegar por Internet\n5.\tReproducir Videos";
		return mensaje;
	}
	
	/**
	 * Se define el string que se muestra cuando el articulo navega por internet
	 * @version 08/11/2021
	 * @param SitioWeb Sitio web por el que se navegara
	 * @return Devuelve el string que se muestra cuando el articulo navega por internet
	 */
	public String NavegarPorInternet(String SitioWeb){
		String mensaje = "Navegando por el sitio web: " + SitioWeb + " ... La operacion tuvo exito.";
		return mensaje;
	}
	
	/**
	 * Se define el string que se muestra cuando el articulo reproduce un video
	 * @version 08/11/2021
	 * @param Video Video que se reproducirá
	 * @return Devuelve el string que se muestra cuando el articulo reproduce un video
	 */
	public String ReproducirVideo(String Video){
		String mensaje = "Reproduciendo el video: " + Video + " ... La operacion tuvo exito.";
		return mensaje;
	}
	
}