
/**
 * Define los mensajes que todo articulo debe tener para poder existir 
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public interface MensajesArticulos{
	
	/**
	 * Se define el mensaje que se muestra cuando el articulo aun es parte del inventario
	 * @version 08/11/2021
	 * @return Devuelve el string que se muestra cuando el articulo aun es parte del inventario
	 */
	public String MensajeAntesDeAgregarAlCarrito();
	
	/**
	 * Se define el mensaje que se muestra cuando el articulo aparece en la factura
	 * @version 08/11/2021
	 * @return Devuelve el string que se muestra cuando el articulo aparece en la factura
	 */
	public String MensajeAlGenerarFactura();
	
}