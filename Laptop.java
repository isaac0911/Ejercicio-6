import java.util.ArrayList;

/**
 * Modela a una laptop
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class Laptop extends ComputadorDeEscritorio{
	
	/**
	 * Instancia un objeto de tipo Laptop.
	 * @version 08/11/2021
	 * @param DatosNuevoArticulo Arreglo que contiene los datos del nuevo articulo
	 */
	public Laptop(ArrayList<String> DatosNuevoArticulo){
		
		super (DatosNuevoArticulo);
		
	}
	
	/**
	 * Se definen las funcionalidades del articulo que se pueden probar
	 * @version 08/11/2021
	 * @return Devuelve el string contiene las funcionalidades del articulo que se pueden probar
	 */
	public String MenuOpcionesAProbar(){
		String mensaje = "1.\tNavegar por Internet\n2.\tReproducir Videos\n3.\tEjecutar videojuegos\n4.\tSer portable";
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