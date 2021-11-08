import java.util.ArrayList;

/**
 * Modela a una camara fotografica
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class CamaraFotografica extends ArticuloElectronico{
	
	/**
	 * Instancia un objeto de tipo CamaraFotografica.
	 * @version 08/11/2021
	 * @param DatosNuevoArticulo Arreglo que contiene los datos del nuevo articulo
	 */
	public CamaraFotografica(ArrayList<String> DatosNuevoArticulo){
		
		Nombre = DatosNuevoArticulo.get(0);
		Tipo = DatosNuevoArticulo.get(1);
		Precio = Float.parseFloat(DatosNuevoArticulo.get(2));
		NumSerie = DatosNuevoArticulo.get(3);
		Marca = DatosNuevoArticulo.get(4);
		AnoFabricacion = Integer.parseInt(DatosNuevoArticulo.get(5));
		MesFabricacion = Integer.parseInt(DatosNuevoArticulo.get(6));
		DiaFabricacion = Integer.parseInt(DatosNuevoArticulo.get(7));
		MarcadorAR = DatosNuevoArticulo.get(8);
		
	}
	
	/**
	 * Establece el String que se muestra cuando se despliegan todos los articulos que hay en el carrito
	 * @version 08/11/2021
	 * @return Devuelve el String que se muestra cuando se despliegan todos los articulos que hay en el carrito
	 */
	public String toString(){
		String mensaje = "\nNo. Serie: " + NumSerie + "\n\tNombre del Producto: " + Nombre + "\n\tTipo: " + Tipo + "\n\tMarca: " + Marca + "\n\tPrecio: Q" + Precio + "\n\tFecha de fabricacion: " + DiaFabricacion + "/" + MesFabricacion + "/" + AnoFabricacion + "\n\tMarcador AR: " + MarcadorAR;
		return mensaje;
	}
	
	/**
	 * Se definen las funcionalidades del articulo que se pueden probar
	 * @version 08/11/2021
	 * @return Devuelve el string contiene las funcionalidades del articulo que se pueden probar
	 */
	public String MenuOpcionesAProbar(){
		String mensaje = "1.\tTomar fotografias\n2.\tReproducir videos\n3.\tSer portable";
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
	 * Se define el string que se muestra cuando el articulo reproduce un video
	 * @version 08/11/2021
	 * @param Video Video que se reproducirá
	 * @return Devuelve el string que se muestra cuando el articulo reproduce un video
	 */
	public String ReproducirVideo(String Video){
		String mensaje = "Reproduciendo el video: " + Video + " ... La operacion tuvo exito.";
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
	
	/**
	 * Se define el mensaje que se muestra cuando el articulo aun es parte del inventario
	 * @version 08/11/2021
	 * @return Devuelve el string que se muestra cuando el articulo aun es parte del inventario
	 */
	public String MensajeAntesDeAgregarAlCarrito(){
		String mensaje = "\nNo. Serie: " + NumSerie + "\n\tNombre del Producto: " + Nombre + "\n\tTipo: " + Tipo + "\n\tMarca: " + Marca + "\n\tPrecio: Q" + Precio + "\n\tFecha de fabricacion: " + DiaFabricacion + "/" + MesFabricacion + "/" + AnoFabricacion + "\n\tMarcador AR: " + MarcadorAR + "\n\tExistencias: 1";
		return mensaje;
	}
	
	/**
	 * Se define el mensaje que se muestra cuando el articulo aparece en la factura
	 * @version 08/11/2021
	 * @return Devuelve el string que se muestra cuando el articulo aparece en la factura
	 */
	public String MensajeAlGenerarFactura(){
		String mensaje = "\n\tNombre del Producto: " + Nombre + "\n\tTipo: " + Tipo + "\n\tMarca: " + Marca + "\n\tPrecio: Q" + Precio + "\n\tFecha de fabricacion: " + DiaFabricacion + "/" + MesFabricacion + "/" + AnoFabricacion + "\n\tMarcador AR: " + MarcadorAR + "\n";
		return mensaje;
	}
	
}