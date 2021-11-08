/**
 * Contiene el metodo main. Se encarga se arrancar el programa.
 * 
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class DriverProgram{
	
	/**
	 * Es el primer método del sistema que se ejecuta. Manda a ejecutar el controlador.
	 * @version 08/11/2021
	 * @param args Valores que se le proporcionan al sistema en la terminal de la computadora antes de ejecutarlo.
	 */
	public static void main(String[] args){
		
		Controlador Control = new Controlador();
		Control.MetodoPrincipal();
		
	}
	
}