
/**
 * Modela a todo tipo de articulo electronico
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public abstract class ArticuloElectronico implements Articulo{
	
	/**
	* Nombre del articulo
	*/
	protected String Nombre;
	
	/**
	* Tipo del articulo
	*/
	protected String Tipo;
	
	/**
	* Precio del articulo
	*/
	protected float Precio;
	
	/**
	* Numero de serie del articulo
	*/
	protected String NumSerie;
	
	/**
	* Marca del articulo
	*/
	protected String Marca;
	
	/**
	* Año de fabricacion del articulo
	*/
	protected int AnoFabricacion;
	
	/**
	* Mes de fabricacion del articulo
	*/
	protected int MesFabricacion;
	
	/**
	* Dia de fabricacion del articulo
	*/
	protected int DiaFabricacion;
	
	/**
	* Marcador AR del articulo
	*/
	protected String MarcadorAR;
	
	/**
	 * Establece el String que se muestra cuando se despliegan todos los articulos que hay en el carrito
	 * @version 08/11/2021
	 * @return Devuelve el String que se muestra cuando se despliegan todos los articulos que hay en el carrito
	 */
	public abstract String toString();
	
	/**
	 * Devuelve el numero de serie del articulo
	 * @version 08/11/2021
	 * @return Devuelve el contenido del atributo "NumSerie"
	 */
	public String getNumSerie(){
		return NumSerie;
	}
	
	
	/**
	 * Devuelve el nombre del articulo
	 * @version 08/11/2021
	 * @return Devuelve el contenido del atributo "Nombre"
	 */
	public String getNombre(){
		return Nombre;
	}
	
	/**
	 * Devuelve el tipo del articulo
	 * @version 08/11/2021
	 * @return Devuelve el contenido del atributo "Tipo"
	 */
	public String getTipo(){
		return Tipo;
	}
	
	/**
	 * Devuelve el precio del articulo
	 * @version 08/11/2021
	 * @return Devuelve el contenido del atributo "Precio"
	 */
	public float getPrecio(){
		return Precio;
	}
	
	/**
	 * Devuelve el año de fabricacion del articulo
	 * @version 08/11/2021
	 * @return Devuelve el contenido del atributo "AnoFabricacion"
	 */
	public int getAnioProduccion(){
		return AnoFabricacion;
	}
	
	/**
	 * Devuelve la marca del articulo
	 * @version 08/11/2021
	 * @return Devuelve el contenido del atributo "Marca"
	 */
	public String getMarca(){
		return Marca;
	}
	
}