
/**
 * Junta a las dos interfaces "MensajesArticulos" y "MenusArticulos" en una sola interfaz para que pueda ser implementada por la clase "ArticuloElectronico", ya que una clase no puede implementar mas de una interfaces.
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public interface Articulo extends MensajesArticulos, MenusArticulos{
	
}