import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Muestra mensajes en pantalla y recibe mensajes del usuario a través del teclado
 * 
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class Vista{
	
	/**
	 * Muestra el mensaje de bienvenida
	 * @version 08/11/2021
	 */
	public static void MensajeBienvenida(){
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------\nBIENVENIDO A LA TIENDA AR DE ELECTRONICA LATINOAMERICANA");
	}
	
	/**
	 * Muestra el mensaje de despedida
	 * @version 08/11/2021
	 */
	public static void MensajeDespedida(){
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------\nGraciar por visitarnos. Feliz dia.\n-------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	/**
	 * Muestra el String que recibe como parámetro.
	 * @version 08/11/2021
	 * @param mensaje Conjunto de caracteres que se desea mostrar en pantalla.
	 */
	public static void MostrarMensaje (String mensaje){
		System.out.println(mensaje);
	}
	
	/**
	 * Muestra el menu de opciones principales y pregunta la opcion a ejecutar
	 * @version 08/11/2021
	 * @return Devuelve un entero que indica la opción ingresada por el usuario
	 */
	public static int MostrarMenuPrincipal(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------\nQue desea hacer?\n");
		System.out.println("1. Agregar articulo al carrito");
		System.out.println("2. Eliminar articulo del carrito");
		System.out.println("3. Ver estado del carrito");
		System.out.println("4. Ordenar los articulos del carrito");
		System.out.println("5. Terminar compra");
		System.out.println("6. Cancelar compra\n");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>6){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 6.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Muestra los articulos que estan a la venta
	 * @version 08/11/2021
	 * @param Productos Productos que estan a la venta
	 */
	public static void MostrarInventario(ArrayList<ArticuloElectronico> Productos){
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<Productos.size(); i++){
			ArticuloElectronico ProductoEnCuestion = Productos.get(i);
			System.out.println(ProductoEnCuestion.MensajeAntesDeAgregarAlCarrito());
		}
		
	}
	
	/**
	 * Muestra los articulos que estan en el carrito
	 * @version 08/11/2021
	 * @param Carrito Productos que estan en el carrito
	 */
	public static void MostrarCarrito(ArrayList<ArticuloElectronico> Carrito){
		
		Scanner scan = new Scanner(System.in);
		
		for (int i=0; i<Carrito.size(); i++){
			ArticuloElectronico ProductoEnCuestion = Carrito.get(i);
			System.out.println(ProductoEnCuestion.toString());
		}
		
	}
	
	/**
	 * Se pide el articulo que desea agregar al carrito
	 * @version 08/11/2021
	 * @param Productos Productos que estan a la venta
	 * @return Devuelve un entero que indica el articulo ingresado por el usuario
	 */
	public static int PedirArticuloAAgregar(ArrayList<ArticuloElectronico> Productos){
		
		System.out.println("\n****************************************************************************************\n\nIngrese el numero de serie del articulo que desea agregar");
		
		//Se crea un arreglo con los numeros de serie de todos los articulos que estan a la venta
		ArrayList<String> numerosDeSerie = new ArrayList<String>();
		String numSerie = "";
		for (int i=0; i<Productos.size(); i++){
			ArticuloElectronico ProductoEnCuestion = Productos.get(i);
			numSerie = ProductoEnCuestion.getNumSerie();
			numerosDeSerie.add(numSerie);
		}
		
		System.out.println("\n");
		
		//Se comprueba que se ingrese un numero válido
		
		Scanner scan = new Scanner(System.in);
		boolean EsUnNumeroValido=false;
		
		String opcion = scan.nextLine();
		if(numerosDeSerie.contains(opcion)){
			EsUnNumeroValido=true;
		}
		
		while(!EsUnNumeroValido){
			System.out.println("ERROR!! Ingrese un numero de serie valido.");
			opcion = scan.nextLine();
			if(numerosDeSerie.contains(opcion)){
				EsUnNumeroValido=true;
			}		
		}
		
		int numero = numerosDeSerie.indexOf(opcion);
		
		return numero;
		
	}
	
	/**
	 * Se pide el articulo que desea eliminar del carrito
	 * @version 08/11/2021
	 * @param Carrito Productos que estan en el carrito
	 * @return Devuelve un entero que indica el articulo ingresado por el usuario
	 */
	public static int PedirArticuloAEliminar(ArrayList<ArticuloElectronico> Carrito){
		
		System.out.println("\n****************************************************************************************\n\nIngrese el numero de serie del articulo que desea eliminar del carrito");
		
		//Se crea un arreglo con los numeros de serie de todos los articulos que estan a la venta
		ArrayList<String> numerosDeSerie = new ArrayList<String>();
		String numSerie = "";
		for (int i=0; i<Carrito.size(); i++){
			ArticuloElectronico ProductoEnCuestion = Carrito.get(i);
			numSerie = ProductoEnCuestion.getNumSerie();
			numerosDeSerie.add(numSerie);
		}
		
		System.out.println("\n");
		
		//Se comprueba que se ingrese un numero válido
		
		Scanner scan = new Scanner(System.in);
		boolean EsUnNumeroValido=false;
		
		String opcion = scan.nextLine();
		if(numerosDeSerie.contains(opcion)){
			EsUnNumeroValido=true;
		}
		
		while(!EsUnNumeroValido){
			System.out.println("ERROR!! Ingrese un numero de serie valido.");
			opcion = scan.nextLine();
			if(numerosDeSerie.contains(opcion)){
				EsUnNumeroValido=true;
			}		
		}
		
		int numero = numerosDeSerie.indexOf(opcion);
		
		return numero;
		
	}
	
	/**
	 * Se pregunta al usuario si desea probar o no el articulo antes de agregarlo al carrito
	 * @version 08/11/2021
	 * @return Devuelve un entero que indica la decicion ingresada por el usuario
	 */
	public static int PedirProbarONo(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nQue desea hacer con este articulo?\n");
		System.out.println("1. Agregarlo directamente al carrito");
		System.out.println("2. Probar sus funcionalidades antes de decidir si comprarlo o no");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>2){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad del smartphone que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades del smartphone
	 * @param nombreArticulo Nombre del smartphone
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionSmartPhone(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>5){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 5.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad del telefono celular que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades del telefono celular
	 * @param nombreArticulo Nombre del telefono celular
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionTelefonoCelular(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>2){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad del telefono fijo que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades del telefono fijo
	 * @param nombreArticulo Nombre del telefono fijo
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionTelefonoFijo(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>1){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 1.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad de la camara fotografica que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades de la camara fotografica
	 * @param nombreArticulo Nombre de la camara fotografica
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionCamaraFotografica(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad de la computadora de escritorio que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades de la computadora de escritorio
	 * @param nombreArticulo Nombre de la computadora de escritorio
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionCompuDeEscritorio(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad de la laptop que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades de la laptop
	 * @param nombreArticulo Nombre de la laptop
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionLaptop(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad de la SmartTV que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades de la SmartTV
	 * @param nombreArticulo Nombre de la SmartTV
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionSmartTV(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>2){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad de la Tablet que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades de la Tablet
	 * @param nombreArticulo Nombre de la Tablet
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionTablet(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>4){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 4.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide la funcionalidad del smart watch que se desea probar
	 * @version 08/11/2021
	 * @param MenuFuncionalidades String que contiene todas las funcionalidades del smart watch
	 * @param nombreArticulo Nombre del smart watch
	 * @return Devuelve un entero que indica la funcionalidad elegida por el usuario
	 */
	public static int PedirFuncionSmartWatch(String MenuFuncionalidades, String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nQue funcionalidad del articulo '" + nombreArticulo +"' desea probar?\n");
		System.out.println(MenuFuncionalidades);
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Se pide el numero al que se desea llamar
	 * @version 08/11/2021
	 * @return Devuelve el numero al que se desea llamar
	 */
	public static String PedirNumeroALlamar(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese el numero de telefono al que desea llamar");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide el lugar al cual se desea transportar el articulo
	 * @version 08/11/2021
	 * @return Devuelve el lugar al que se desea transportar el articulo
	 */
	public static String PedirLugar(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese el lugar al que desea transportar el articulo");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide el objeto al que se le desea tomar una foto
	 * @version 08/11/2021
	 * @return Devuelve el nombre del objeto ingresado
	 */
	public static String PedirObjetoATomarFoto(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese el objeto al que le desea tomar una foto");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide el sitio web por el que se desea navegar
	 * @version 08/11/2021
	 * @return Devuelve la URL del sitio web ingresado
	 */
	public static String PedirSitioWebAVisitar(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese la direccion web que desea visitar");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide el video que se desea reproducir
	 * @version 08/11/2021
	 * @return Devuelve la URL del video ingresado
	 */
	public static String PedirVideoAReproducir(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese la URL del video que desea reproducir");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide el video juego que se desea ejecutar
	 * @version 08/11/2021
	 * @return Devuelve el nombre del video juego ingresado
	 */
	public static String PedirVideoJuegoAEjecuat(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese el nombre del videojuego que desea ejecutar");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pregunta si desea probar otra funcionalidad del articulo seleccionado
	 * @version 08/11/2021
	 * @param nombreArticulo Nombre del articulo que esta siendo probado
	 * @return Devuelve true si desea probar otra funcion, de lo contrario, devuelve false
	 */
	public static boolean PreguntarDeseaProbarFuncionalidad(String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nDesea probar otra funcionalidad del articulo '" + nombreArticulo +"'?\n\n1.\tSi\n2.\tNo");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>2){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		boolean deseaProbarOtraFuncionalidad = true;
		
		if(numero==1){
			deseaProbarOtraFuncionalidad = true;
		}else{
			deseaProbarOtraFuncionalidad = false;
		}
		
		return deseaProbarOtraFuncionalidad;
		
	}
	
	/**
	 * Se pregunta si desea agregar el articulo al carrito luego de haberlo probado
	 * @version 08/11/2021
	 * @param nombreArticulo Nombre del articulo que esta siendo probado
	 * @return Devuelve true si desea agregar el articulo, de lo contrario, devuelve false
	 */
	public static boolean PreguntarDeseaAgregarArticulo(String nombreArticulo){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n****************************************************************************************\n\nLuego de probar las funcionalides del articulo '" + nombreArticulo +"', desea agregarlo al carrito?\n\n1.\tSi\n2.\tNo");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>2){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 2.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		boolean deseaProbarOtraFuncionalidad = true;
		
		if(numero==1){
			deseaProbarOtraFuncionalidad = true;
		}else{
			deseaProbarOtraFuncionalidad = false;
		}
		
		return deseaProbarOtraFuncionalidad;
		
	}
	
	/**
	 * Se pide el nombre de la persona que esta realizado la compra
	 * @version 08/11/2021
	 * @return Devuelve el nombre de la persona
	 */
	public static String PedirNombreUsuario(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese su nombre:");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide el nit de la persona que esta realizado la compra
	 * @version 08/11/2021
	 * @return Devuelve el nit de la persona
	 */
	public static String PedirNit(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese su numero de NIT:");
		
		String opcion = scan.nextLine();
		
		return opcion;
		
	}
	
	/**
	 * Se pide la direccion de la sucursal donde esta realizando la compra
	 * @version 08/11/2021
	 * @param DatosSucursales Arreglo que contiene todos los datos correspondientes a la direccion de las sucursales
	 * @return Devuelve la direccion de la sucursal ingresada por el usuario
	 */
	public static String PedirSucursal(ArrayList<ArrayList<String>> DatosSucursales){
		
		ArrayList<String> DireccionesSucursales = new ArrayList<String>();
		
		//Se llena un arrayList con las direcciones de todas las sucursales
		for(int i=1; i<DatosSucursales.size();i++){
			ArrayList<String> DatosSucursaleEnCuestion = DatosSucursales.get(i);
			String Direccion = DatosSucursaleEnCuestion.get(1);
			DireccionesSucursales.add(Direccion);
		}
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nIngrese la direccion de la sucursal donde esta realizando la compra:");
		for(int i=0; i<DireccionesSucursales.size(); i++){
			String direccion = DireccionesSucursales.get(i);
			System.out.println((i+1) + ".\t" + direccion);
		}
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>DireccionesSucursales.size()){
			System.out.println("ERROR!! Ingrese un numero entre 1 y " + DireccionesSucursales.size() +".");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		String SucursalElegida = DireccionesSucursales.get(numero-1);
		
		return SucursalElegida;
		
		
	}
	
	/**
	 * Se pide el parametro por el que se desean ordenar los articulos del carrito
	 * @version 08/11/2021
	 * @return Devuelve un entero que indica el parametro elegido
	 */
	public static int PedirParametroParaOrdenar(){
		
		int numero = 0;
		String opcion = "";
		boolean validacion = false;
		
		//Se muestran las opciones y se recibe el dato
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nQue parametro desea utilizar para ordenar los articulos?\n");
		System.out.println("1. El precio (de mas caro a mas barato)");
		System.out.println("2. La fecha de fabricacion (de mas reciente a mas antiguo)");
		System.out.println("3. La marca");
			
		opcion = scan.nextLine();
		
		//Se comprueba que el dato esté dentro del rango permitido
		validacion = comprobarNumero(opcion);
		
		if (validacion){
			numero = Integer.parseInt(opcion);
		}
		
		while (validacion = false || numero<1 || numero>3){
			System.out.println("ERROR!! Ingrese un numero entre 1 y 3.");
			opcion = scan.nextLine();
			validacion = comprobarNumero(opcion);
			if (validacion){
				numero = Integer.parseInt(opcion);
			}
		}
		
		return numero;
		
	}
	
	/**
	 * Verifica si el valor que recibe como parámetro es un entero.
	 * @version 01/11/2021
	 * @param conjuntoCaracteres Valor del cual se verificará si es un entero o no.
	 * @return Devuelve true si el valor recibido como parámetro es un entero, de lo contrario, devuelve false
	 */
	private static boolean comprobarNumero(String conjuntoCaracteres){
		try{
			//Se trata de convertir el objeto de tipo String a tipo int
			Integer.parseInt(conjuntoCaracteres);
			return true;
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
}