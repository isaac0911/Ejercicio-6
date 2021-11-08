import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.Random;

/**
 * Comunica a la Vista con el Modelo y viceversa.
 * 
 * @author Isaac Solórzano Q.
 * @version 08/11/2021
 */

public class Controlador{
	
	/**
	* Arreglo que contiene a todo los articulos del carrito
	*/
	private ArrayList<ArticuloElectronico> Carrito;
	
	/**
	* Arreglo que contiene a todo los articulos que se encuentran a la venta
	*/
	private ArrayList<ArticuloElectronico> Productos;
	
	/**
	* Arreglo que contiene los datos de todos los productos que estan a la venta
	*/
	private ArrayList<ArrayList<String>> DatosProductos;
	
	/**
	* Arreglo que contiene los datos de todas las sucursales que existen
	*/
	private ArrayList<ArrayList<String>> DatosSucursales;
	
	/**
	 * Instancia un objeto de tipo Controlador.
	 * @version 08/11/2021
	 */
	public Controlador (){
		
		Carrito = new ArrayList<ArticuloElectronico>();
		Productos = new ArrayList<ArticuloElectronico>();
		
		DatosProductos = new ArrayList<ArrayList<String>>();
		DatosSucursales = new ArrayList<ArrayList<String>>();

	}
	
	/**
	 * Es el método principal. Manda a mostrar el mensaje de bienvenida, lee los archivos CSV y manda a ejecutar el método Ciclo
	 * @version 08/11/2021
	 */
	public void MetodoPrincipal(){
		
		boolean SePudoLeerCSV = true;
		
		try{
			DatosProductos = LeerDatosProductos();
			DatosSucursales = LeerDatosSucursales();
		}catch (IOException e){
			String s = "\n-------------------------------------------------------------------------------------------------------------------------------------------------\nHa ocurrido un error: " + e.getMessage() + "\n-------------------------------------------------------------------------------------------------------------------------------------------------";
			SePudoLeerCSV = false;
			Vista.MostrarMensaje(s);
		}
		
		if (SePudoLeerCSV){
			
			Vista.MensajeBienvenida();
			
			InstanciarArticulos(DatosProductos);
			
			Ciclo();
		}
		
	}
	
	/**
	 * Lee los datos de los productos del CSV DatosProductos.csv
	 * @version 08/11/2021
	 * @return Devuelve un arreglo que contiene los datos de los productos
	 */
	private ArrayList<ArrayList<String>> LeerDatosProductos() throws IOException{
		
		String nombreArchivo = "DatosProductos.csv";
		String Directorio = "C:\\ArchivosCSV\\DatosProductos.csv";
		try{
			ArrayList<ArrayList<String>> DatosProductos = new ArrayList<ArrayList<String>>();
			Path filePath = Paths.get(Directorio);
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datosLinea = linea.split(";");
				ArrayList<String> datosTemporal = new ArrayList<String>();
				for (String dato : datosLinea){
					datosTemporal.add(dato);
				}
				DatosProductos.add(datosTemporal);
			}
			
			return (DatosProductos);
		
		}catch(IOException e){
			e.printStackTrace();
			String s = "Compruebe que existe un archivo llamado " + nombreArchivo + " en la siguiente ubicacion: " + Directorio;
			throw new IOException(s);
		}
		
	}
	
	/**
	 * Lee los datos de las sucursales del CSV DatosSucursales.csv
	 * @version 08/11/2021
	 * @return Devuelve un arreglo que contiene los datos de las sucursales
	 */
	private ArrayList<ArrayList<String>> LeerDatosSucursales() throws IOException{
		
		String nombreArchivo = "DatosSucursales.csv";
		String Directorio = "C:\\ArchivosCSV\\DatosSucursales.csv";
		try{
			ArrayList<ArrayList<String>> DatosSucursales = new ArrayList<ArrayList<String>>();
			Path filePath = Paths.get(Directorio);
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datosLinea = linea.split(";");
				ArrayList<String> datosTemporal = new ArrayList<String>();
				for (String dato : datosLinea){
					datosTemporal.add(dato);
				}
				DatosSucursales.add(datosTemporal);
			}
			
			return (DatosSucursales);
		
		}catch(IOException e){
			e.printStackTrace();
			String s = "Compruebe que existe un archivo llamado " + nombreArchivo + " en la siguiente ubicacion: " + Directorio;
			throw new IOException(s);
		}
		
	}
	
	/**
	 * Instancia los articulos y los agrega al arreglo de nombre "Carrito"
	 * @version 08/11/2021
	 * @param DatosProductos Arreglo que contiene los datos de todos los productos
	 */
	private void InstanciarArticulos(ArrayList<ArrayList<String>> DatosProductos){
		
		
		for (int i=1; i<DatosProductos.size(); i++){
			
			ArrayList<String> DatosArticulo = DatosProductos.get(i);
			
			String TipoArticulo = DatosArticulo.get(1);
			
			if(TipoArticulo.equals("Smartphone")){
				
				Smartphone Articulo = new Smartphone(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Telefono celular")){
				
				TelefonoCelular Articulo = new TelefonoCelular(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Telefono fijo")){
				
				TelefonoFijo Articulo = new TelefonoFijo(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Camara fotografica")){
				
				CamaraFotografica Articulo = new CamaraFotografica(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Computador de Escritorio")){
				
				ComputadorDeEscritorio Articulo = new ComputadorDeEscritorio(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Laptop")){
				
				Laptop Articulo = new Laptop(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Smart TV")){
				
				SmartTV Articulo = new SmartTV(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Tablet")){
				
				Tablet Articulo = new Tablet(DatosArticulo);
				Productos.add(Articulo);
				
			}else if (TipoArticulo.equals("Smartwatch")){
				
				SmartWatch Articulo = new SmartWatch(DatosArticulo);
				Productos.add(Articulo);
				
			}
			
		}
		
	}
	
	/**
	 * Contiene el ciclo en el que se mantendra el flujo del programa mientras el usuario no quiera salir
	 * @version 08/11/2021
	 */
	private void Ciclo(){
		
		boolean DeseaContinuar = true;
		int opcion = -1;
		
		while (DeseaContinuar){
			
			opcion = Vista.MostrarMenuPrincipal();
			
			if (opcion == 1){
				
				String mensaje = "\n-------------------------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE AGREGAR UN ELEMENTO AL CARRITO\n";
				Vista.MostrarMensaje(mensaje);
				
				if(Productos.size()>0){
					
					//Se mandan a mostrar los artículos que están a la venta
					mensaje = "Los articulos que estan a la venta son los siguientes: ";
					Vista.MostrarMensaje(mensaje);
					Vista.MostrarInventario(Productos);
				
					//Se pide que ingrese un artículo para agregar al carrito (o probarlo antes de agregarlo)
					int posicionArticulo = Vista.PedirArticuloAAgregar(Productos);
				
					//Se obtiene el artículo elegido
					ArticuloElectronico ArticuloSeleccionado = Productos.get(posicionArticulo);
				
					mensaje = "\n****************************************************************************************\n\nHa seleccionado el articulo: " + ArticuloSeleccionado.getNombre();
					Vista.MostrarMensaje(mensaje);
					mensaje = "\n****************************************************************************************";
					Vista.MostrarMensaje(mensaje);
					
					//Se pregunta si desea agregarlos directamente al carrito o si desea probarlo antes
					int DeseaProbarlo = Vista.PedirProbarONo();
					
					if(DeseaProbarlo == 1){
						
						//Si lo desea agregar directamente
						Carrito.add(ArticuloSeleccionado);
						Productos.remove(posicionArticulo);
						mensaje = "\nSe ha agregado el articulo '" + ArticuloSeleccionado.getNombre() + "' al carrito";
						Vista.MostrarMensaje(mensaje);
						
					}else if (DeseaProbarlo == 2){
						
						//Si desea probarlo
						ProbarFuncionalidades(ArticuloSeleccionado);
					}
					
				}else if(Productos.size()==0){
					mensaje = "No se puede realizar esta accion ya que el inventario esta agotado";
					Vista.MostrarMensaje(mensaje);
				}
				
			}else if(opcion == 2){
				
				String mensaje = "\n-------------------------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE ELIMINAR UN ELEMENTO DEL CARRITO\n";
				Vista.MostrarMensaje(mensaje);
				
				if(Carrito.size()>0){
					
					//Se mandan a mostrar los artículos que están a la venta
					mensaje = "Los articulos que estan en el carrito son los siguientes: ";
					Vista.MostrarMensaje(mensaje);
					Vista.MostrarCarrito(Carrito);
					
					//Se pide que ingrese un artículo para agregar al carrito (o probarlo antes de agregarlo)
					int posicionArticulo = Vista.PedirArticuloAEliminar(Carrito);
					
					//Se obtiene el artículo elegido
					ArticuloElectronico ArticuloSeleccionado = Carrito.get(posicionArticulo);
					
					//Se elimina el articulo del carrito
					Carrito.remove(posicionArticulo);
					Productos.add(ArticuloSeleccionado);
					
					mensaje = "\n****************************************************************************************\n\nSe ha eliminado el articulo: " + ArticuloSeleccionado.getNombre() + " del carrito";
					Vista.MostrarMensaje(mensaje);
					mensaje = "\n****************************************************************************************";
					Vista.MostrarMensaje(mensaje);
					
				}else{
					
					mensaje = "\nNo se puede realizar esta accion ya que actualmente no hay ningun articulo en el carrito";
					Vista.MostrarMensaje(mensaje);
					
				}
				
			}else if(opcion == 3){
				
				String mensaje = "\n-------------------------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE VER ESTADO DEL CARRITO\n";
				Vista.MostrarMensaje(mensaje);
				
				if(Carrito.size()>0){
					mensaje = "\nActualmente el carrito contiene " + Carrito.size() + " elementos, y son los siguientes:";
					Vista.MostrarMensaje(mensaje);
					Vista.MostrarCarrito(Carrito);
					
				}else{
					
					mensaje = "\nEl carrito se actuentra actualmente vacio";
					Vista.MostrarMensaje(mensaje);
					
				}
				
			}else if(opcion == 4){
				
				String mensaje = "\n-------------------------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE ORDENAR LOS ARTICULOS DEL CARRITO\n";
				Vista.MostrarMensaje(mensaje);
				
				if(Carrito.size()>0){
					
					int NumOrdenar = Vista.PedirParametroParaOrdenar();
					
					if(NumOrdenar == 1){
						
						OrdenarPorPrecio();
						mensaje = "\nLos articulos han sido ordenados de acuerdo con su precio\n";
						Vista.MostrarMensaje(mensaje);
						
					}else if(NumOrdenar == 2){
						
						OrdenarPorFechaDeFabricacion();
						mensaje = "\nLos articulos han sido ordenados de acuerdo con su fecha de fabricacion\n";
						Vista.MostrarMensaje(mensaje);
						
					}else if(NumOrdenar == 3){
						
						OdernarPorMarca();
						mensaje = "\nLos articulos han sido ordenados de acuerdo con su marca\n";
						Vista.MostrarMensaje(mensaje);
						
					}
					
				}else{
					
					mensaje = "\nNo se puede realizar esta accion ya que actualmente no hay ningun articulo en el carrito";
					Vista.MostrarMensaje(mensaje);
					
				}
				
			}else if(opcion == 5){
				
				if(Carrito.size()>0){
					
					DeseaContinuar = false;
					
				}else{
					
					String mensaje = "\nNo se puede realizar esta accion. Ingrese, por lo  menos, un elemento al carrito para poder terminar la compra";
					Vista.MostrarMensaje(mensaje);
					
				}
				
			}else if(opcion == 6){
				
				DeseaContinuar = false;
				
			}
			
		}
		
		if(opcion == 5){
			
			String mensaje = "\n-------------------------------------------------------------------------------------------------------------------------------------------------\nHA SELECCIONADO LA OPCION DE TERMINAR LA COMPRA\n";
			Vista.MostrarMensaje(mensaje);
			
			PedirDatosFactura();
			
		}else if(opcion == 6){
			
			Vista.MensajeDespedida();
			
		}
		
	}
	
	/**
	 * Define que tipo de articulo recibe como parametro y manda a ejecutar las instrucciones necesarias para probar sus funcionalidades
	 * @version 08/11/2021
	 * @param ArticuloSeleccionado Articulo que el usuario desea probar
	 */
	private void ProbarFuncionalidades(ArticuloElectronico ArticuloSeleccionado){
		
		String TipoDeArticulo = ArticuloSeleccionado.getTipo();
		
		if(TipoDeArticulo.equals("Smartphone")){
			Smartphone Articulo = (Smartphone) ArticuloSeleccionado;
			ProbarSmartphone(Articulo);
		}else if(TipoDeArticulo.equals("Telefono celular")){
			TelefonoCelular Articulo = (TelefonoCelular) ArticuloSeleccionado;
			ProbarTelefonoCelular(Articulo);
		}else if(TipoDeArticulo.equals("Telefono fijo")){
			TelefonoFijo Articulo = (TelefonoFijo) ArticuloSeleccionado;
			ProbarTelefonoFijo(Articulo);
		}else if(TipoDeArticulo.equals("Camara fotografica")){
			CamaraFotografica Articulo = (CamaraFotografica) ArticuloSeleccionado;
			ProbarCamaraFotografica(Articulo);
		}else if(TipoDeArticulo.equals("Computador de Escritorio")){
			ComputadorDeEscritorio Articulo = (ComputadorDeEscritorio) ArticuloSeleccionado;
			ProbarComputadorDeEscritorio(Articulo);
		}else if(TipoDeArticulo.equals("Laptop")){
			Laptop Articulo = (Laptop) ArticuloSeleccionado;
			ProbarLaptop(Articulo);
		}else if(TipoDeArticulo.equals("Smart TV")){
			SmartTV Articulo = (SmartTV) ArticuloSeleccionado;
			ProbarSmartTV(Articulo);
		}else if(TipoDeArticulo.equals("Tablet")){
			Tablet Articulo = (Tablet) ArticuloSeleccionado;
			ProbarTablet(Articulo);
		}else if(TipoDeArticulo.equals("Smartwatch")){
			SmartWatch Articulo = (SmartWatch) ArticuloSeleccionado;
			ProbarSmartWatch(Articulo);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades de un Smartphone que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Smartphone a probar
	 */
	private void ProbarSmartphone(Smartphone Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionSmartPhone(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar las llamadas
				
				String numTelefono = Vista.PedirNumeroALlamar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.Llamar(numTelefono);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea probar la portabilidad (el hecho de que el dispositivo sea portable)
				
				String Lugar = Vista.PedirLugar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.SerPortable(Lugar);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==3){
				//Si desea probar las fotografias
				
				String Objeto = Vista.PedirObjetoATomarFoto();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.TomarFotografia(Objeto);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==4){
				//Si desea probar la navegacion por internet
				
				String SitioWeb = Vista.PedirSitioWebAVisitar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.NavegarPorInternet(SitioWeb);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==5){
				//Si desea reproducir un video
				
				String Video = Vista.PedirVideoAReproducir();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.ReproducirVideo(Video);
				Vista.MostrarMensaje(mensaje);
				
			}
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades de un Telefono Celular que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Telefono celular a probar
	 */
	private void ProbarTelefonoCelular(TelefonoCelular Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionTelefonoCelular(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar las llamadas
				
				String numTelefono = Vista.PedirNumeroALlamar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.Llamar(numTelefono);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea probar la portabilidad (el hecho de que el dispositivo sea portable)
				
				String Lugar = Vista.PedirLugar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.SerPortable(Lugar);
				Vista.MostrarMensaje(mensaje);
			}			
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades del telefono fijo que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Telefono fijo a probar
	 */
	private void ProbarTelefonoFijo(TelefonoFijo Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionTelefonoFijo(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar las llamadas
				
				String numTelefono = Vista.PedirNumeroALlamar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.Llamar(numTelefono);
				Vista.MostrarMensaje(mensaje);
				
			}			
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades de la camara fotografica que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Camara fotografica a probar
	 */
	private void ProbarCamaraFotografica(CamaraFotografica Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionCamaraFotografica(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar las fotografias
				
				String Objeto = Vista.PedirObjetoATomarFoto();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.TomarFotografia(Objeto);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea reproducir un video
				
				String Video = Vista.PedirVideoAReproducir();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.ReproducirVideo(Video);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==3){
				//Si desea probar la portabilidad (el hecho de que el dispositivo sea portable)
				
				String Lugar = Vista.PedirLugar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.SerPortable(Lugar);
				Vista.MostrarMensaje(mensaje);
				
			}
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades del computador de escritorio que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Computador de escritorio a probar
	 */
	private void ProbarComputadorDeEscritorio(ComputadorDeEscritorio Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionCompuDeEscritorio(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar la navegacion por internet
				
				String SitioWeb = Vista.PedirSitioWebAVisitar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.NavegarPorInternet(SitioWeb);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea reproducir un video
				
				String Video = Vista.PedirVideoAReproducir();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.ReproducirVideo(Video);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==3){
				//Si desea ejecutar un videojuego
				
				String VideoJuego = Vista.PedirVideoJuegoAEjecuat();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.EjecutarVideoJuego(VideoJuego);
				Vista.MostrarMensaje(mensaje);
				
			}
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades de la laptop que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Laptop a probar
	 */
	private void ProbarLaptop(Laptop Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionLaptop(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar la navegacion por internet
				
				String SitioWeb = Vista.PedirSitioWebAVisitar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.NavegarPorInternet(SitioWeb);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea reproducir un video
				
				String Video = Vista.PedirVideoAReproducir();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.ReproducirVideo(Video);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==3){
				//Si desea ejecutar un videojuego
				
				String VideoJuego = Vista.PedirVideoJuegoAEjecuat();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.EjecutarVideoJuego(VideoJuego);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==4){
				//Si desea probar la portabilidad (el hecho de que el dispositivo sea portable)
				
				String Lugar = Vista.PedirLugar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.SerPortable(Lugar);
				Vista.MostrarMensaje(mensaje);
				
			}
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades de la Smart TV que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Smart TV a probar
	 */
	private void ProbarSmartTV(SmartTV Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionSmartTV(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar la navegacion por internet
				
				String SitioWeb = Vista.PedirSitioWebAVisitar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.NavegarPorInternet(SitioWeb);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea reproducir un video
				
				String Video = Vista.PedirVideoAReproducir();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.ReproducirVideo(Video);
				Vista.MostrarMensaje(mensaje);
				
			}
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades de la tablet que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Tablet a probar
	 */
	private void ProbarTablet(Tablet Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionTablet(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar la navegacion por internet
				
				String SitioWeb = Vista.PedirSitioWebAVisitar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.NavegarPorInternet(SitioWeb);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea reproducir un video
				
				String Video = Vista.PedirVideoAReproducir();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.ReproducirVideo(Video);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==3){
				//Si desea probar las fotografias
				
				String Objeto = Vista.PedirObjetoATomarFoto();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.TomarFotografia(Objeto);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==4){
				//Si desea probar la portabilidad (el hecho de que el dispositivo sea portable)
				
				String Lugar = Vista.PedirLugar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.SerPortable(Lugar);
				Vista.MostrarMensaje(mensaje);
				
			}
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Prueba las funcionalidades del smart watch que el usuario pida
	 * @version 08/11/2021
	 * @param Articulo Smart watch a probar
	 */
	private void ProbarSmartWatch(SmartWatch Articulo){
		
		boolean DeseaProbarUnaFuncionalidad = true;
		
		while(DeseaProbarUnaFuncionalidad){
			
			//Se obtiene el nombre del articulo
			String nombreArticulo = Articulo.getNombre();
			
			//Se obtiene el String que contiene todas las funcionalidades del articulo
			String MenuFuncionalidades = Articulo.MenuOpcionesAProbar();
			
			//Se manda a pedir la funcionalidad que se desea probar
			int FuncionalidadElegida = Vista.PedirFuncionSmartWatch(MenuFuncionalidades, nombreArticulo);
			
			if(FuncionalidadElegida==1){
				//Si desea probar las llamadas
				
				String numTelefono = Vista.PedirNumeroALlamar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.Llamar(numTelefono);
				Vista.MostrarMensaje(mensaje);
				
			}else if(FuncionalidadElegida==2){
				//Si desea probar la portabilidad (el hecho de que el dispositivo sea portable)
				
				String Lugar = Vista.PedirLugar();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.SerPortable(Lugar);
				Vista.MostrarMensaje(mensaje);
			}else if(FuncionalidadElegida==3){
				//Si desea probar las fotografias
				
				String Objeto = Vista.PedirObjetoATomarFoto();
				String mensaje = "\n";
				Vista.MostrarMensaje(mensaje);
				mensaje = Articulo.TomarFotografia(Objeto);
				Vista.MostrarMensaje(mensaje);
			}		
			
			DeseaProbarUnaFuncionalidad = Vista.PreguntarDeseaProbarFuncionalidad(nombreArticulo);
		}
		
		String nombreArticulo = Articulo.getNombre();
		boolean deseaAgregarArticulo = Vista.PreguntarDeseaAgregarArticulo(nombreArticulo);
		
		if(deseaAgregarArticulo){
			
			Carrito.add(Articulo);
			int posicionArticulo = Productos.indexOf(Articulo);
			Productos.remove(posicionArticulo);
			String mensaje = "\nSe ha agregado el articulo '" + Articulo.getNombre() + "' al carrito";
			Vista.MostrarMensaje(mensaje);
			
		}else if (!deseaAgregarArticulo){
			
			String mensaje = "\nDe acuerdo, no hay problema";
			Vista.MostrarMensaje(mensaje);
		}
		
	}
	
	/**
	 * Se mandan a pedir los datos para generar la factura
	 * @version 08/11/2021
	 */
	private void PedirDatosFactura(){
		
		//Se piden el nombre del usuario
		String nombreUsuario = Vista.PedirNombreUsuario();
		
		//Se pide el numero de NIT
		String Nit = Vista.PedirNit();
		
		//Se pide la sucursal donde realiza la compra
		String DireccionSucursal = Vista.PedirSucursal(DatosSucursales);
		
		//Se obtiene la fecha actual
		LocalDate FechaActual = LocalDate.now();
		
		//Se genera el numero de factura aleatoriamente
		Random r = new Random();
		int numFactura = r.nextInt(1000);
		
		String mensaje = "\n\n\n(Generando factura)...\n\n";
		Vista.MostrarMensaje(mensaje);
		
		//Se arma el string de la factura
		
		String factura = EstructurarFactura(nombreUsuario, Nit, DireccionSucursal, FechaActual, numFactura);
		
		//Se manda a mostrar la factura
		
		Vista.MostrarMensaje(factura);
		
		//Se manda a mostrar un mensaje de agradecimiento por la compra
		
		mensaje = "\n\nGracias por su compra. Puede pasar a pagar. Que tenga un excelente dia.\n\n\n";
		Vista.MostrarMensaje(mensaje);
	}
	
	/**
	 * Se arma el string que se mostrara como factura
	 * @version 08/11/2021
	 * @param nombreUsuario Nombre de la persona que esta realizando la compra
	 * @param Nit Nit de la persona
	 * @param DireccionSucursal Direccion de la sucursal donde se esta realizando la compra
	 * @param FechaActual Fecha del dia en el que se esta realizando la compra
	 * @param numFactura Numero de la factura
	 * @return Devuelve un String que es la factura en sí
	 */
	private String EstructurarFactura(String nombreUsuario, String Nit, String DireccionSucursal, LocalDate FechaActual, int numFactura){
		
		//Se convierten todos los parametros que no son String a tipo String
		
		String fecha = String.valueOf(FechaActual);
		String numeroFactura = String.valueOf(numFactura);
		
		//Se inicializa la factura
		String factura = "\n****************************************************************************************\n*******************************ELECTRONICA PANAMERICANA*********************************\nFactura No.: " + numeroFactura + "\nFecha: " + fecha + "\nSucursal: " + DireccionSucursal + "\nA nombre de: " + nombreUsuario + "\nNo. NIT: " + Nit + "\n\nDetalles de la compra:\n";
		
		//Se agrega el detalle de los productos
		for(int i=0; i<Carrito.size(); i++){
			ArticuloElectronico Articulo = Carrito.get(i);
			String Mensaje = Articulo.MensajeAlGenerarFactura();
			factura = factura + Mensaje;
		}
		
		//Se obtene el total de la compra
		float TotalCompra = ObtenerTotalDeLaCompra();
		
		//Se agrega a la factura el total de la compra
		factura = factura + "\nTotal de la compra: Q" + TotalCompra + "\n****************************************************************************************\n****************************************************************************************\n";
		
		return factura;
		
	}
	
	/**
	 * Se suma el precio de todos los articulos comprados
	 * @version 08/11/2021
	 * @return Devuelve el monto total de la compra
	 */
	private float ObtenerTotalDeLaCompra(){
		
		float TotalCompra = 0;
		
		for(int i=0; i<Carrito.size(); i++){
			ArticuloElectronico Articulo = Carrito.get(i);
			float precioArticulo = Articulo.getPrecio();
			TotalCompra = TotalCompra + precioArticulo;
		}
		
		return TotalCompra;
		
	}
	
	/**
	 * Se ordenan los articulos por su precio
	 * @version 08/11/2021
	 */
	private void OrdenarPorPrecio(){
		
		//Se define un arraylist que contendra a los articulos ordenados
		ArrayList<ArticuloElectronico> ArticulosOrdenados = new ArrayList<ArticuloElectronico>();
		
		//Se obtiene un arrayList con los precios de los articulos
		ArrayList<Double> Precios = new ArrayList<Double>();
		double Precio;
		for(int i=0; i<Carrito.size(); i++){
			ArticuloElectronico Articulo = Carrito.get(i);
			Precio = (double) Articulo.getPrecio();
			Precios.add(Precio);
		}
		
		//Se define un ciclo para ir ordenando los articulos
		double mayor;
		double precioAAnalizar;
		while(Carrito.size()>0){
			//Se obtiene la posicion del articulo mas caro
			int posicionMasCaro = 0;
			mayor = Precios.get(0);
			for (int i = 1; i<Precios.size(); i++) {
				precioAAnalizar = Precios.get(i);
				if (precioAAnalizar > mayor) {
					mayor = Precios.get(i);
					posicionMasCaro = i;
				}
			}
			
			//Se obtiene el articulo mas caro
			ArticuloElectronico ArticuloMasCaro = Carrito.get(posicionMasCaro);
			
			//Se agrega el articulo mas caro al arraylist de articulos ordenados
			ArticulosOrdenados.add(ArticuloMasCaro);
			
			//Se elimina el precio del articulo mas caro del arraylist de los precios
			Precios.remove(posicionMasCaro);
			
			//Se elimina el articulo mas caro del carrito
			Carrito.remove(posicionMasCaro);
			
		}
		
		//Se le asigna al carrito el valor del arraylist que tiene los articulos ordenados
		Carrito = ArticulosOrdenados;
		
	}
	
	/**
	 * Se ordenan los articulos por su fecha de produccion
	 * @version 08/11/2021
	 */
	private void OrdenarPorFechaDeFabricacion(){
		
		
		//Se define un arraylist que contendra a los articulos ordenados
		ArrayList<ArticuloElectronico> ArticulosOrdenados = new ArrayList<ArticuloElectronico>();
		
		//Se obtiene un arrayList con los anios de produccion de los articulos
		ArrayList<Integer> Anios = new ArrayList<Integer>();
		int Anio;
		for(int i=0; i<Carrito.size(); i++){
			ArticuloElectronico Articulo = Carrito.get(i);
			Anio = Articulo.getAnioProduccion();
			Anios.add(Anio);
		}
		
		//Se define un ciclo para ir ordenando los articulos
		double mayor;
		double AnioAAnalizar;
		while(Carrito.size()>0){
			//Se obtiene la posicion del articulo mas reciente
			int posicionMasReciente = 0;
			mayor = Anios.get(0);
			for (int i = 1; i<Anios.size(); i++) {
				AnioAAnalizar = Anios.get(i);
				if (AnioAAnalizar > mayor) {
					mayor = Anios.get(i);
					posicionMasReciente = i;
				}
			}
			
			//Se obtiene el articulo mas reciente
			ArticuloElectronico ArticuloMasReciente = Carrito.get(posicionMasReciente);
			
			//Se agrega el articulo mas reciente al arraylist de articulos ordenados
			ArticulosOrdenados.add(ArticuloMasReciente);
			
			//Se elimina el precio del articulo mas reciente del arraylist de los precios
			Anios.remove(posicionMasReciente);
			
			//Se elimina el articulo mas reciente del carrito
			Carrito.remove(posicionMasReciente);
			
		}
		
		//Se le asigna al carrito el valor del arraylist que tiene los articulos ordenados
		Carrito = ArticulosOrdenados;
		
		
	}
	
	/**
	 * Se ordenan los articulos por su marca
	 * @version 08/11/2021
	 */
	private void OdernarPorMarca(){
		
		//Se define un arraylist que contendra a los articulos ordenados
		ArrayList<ArticuloElectronico> ArticulosOrdenados = new ArrayList<ArticuloElectronico>();
		
		//Se obtiene un arrayList con las marcas de los articulos
		ArrayList<String> Marcas = new ArrayList<String>();
		String Marca;
		for(int i=0; i<Carrito.size(); i++){
			ArticuloElectronico Articulo = Carrito.get(i);
			Marca = Articulo.getMarca();
			Marcas.add(Marca);
		}
		
		//Se define un ciclo para ir ordenando los articulos
		ArrayList<Integer> PosicionesMarca = new ArrayList<Integer>();
		ArrayList<ArticuloElectronico> ArticulosDeLaMismaMarca = new ArrayList<ArticuloElectronico>();
		while(Carrito.size()>0){
			
			Marca = Marcas.get(0);
			
			//Se obtiene el articulo en la posicion 0
			ArticuloElectronico Articulo = Carrito.get(0);
			//Se agrega el articulo en la posicion 0 al arraylist de articulos ordenados
			ArticulosOrdenados.add(Articulo);
			//Se elimina el precio del articulo mas reciente del arraylist de los precios
			Marcas.remove(0);
			//Se elimina el articulo  del carrito
			Carrito.remove(0);
			
			//Se define un ciclo para saber las posiciones de los articulos que son de la misma marca
			PosicionesMarca.clear();
			for(int i=0; i<Carrito.size(); i++){
				ArticuloElectronico ArticuloEnCuestion = Carrito.get(i);
				String MarcaArticuloEnCuestion = ArticuloEnCuestion.getMarca();
				if(MarcaArticuloEnCuestion.equals(Marca)){
					PosicionesMarca.add(i);
				}
			}
			
			//Se añaden los articulos de la misma marca al arraylist de articulos ordenados
			int posicion = 0;
			for(int i=0; i<PosicionesMarca.size(); i++){
				posicion = PosicionesMarca.get(i);
				//Se obtiene el determinada posicion
				Articulo = Carrito.get(posicion);
				//Se agrega el articulo de determinada posicion al arraylist ordenado
				ArticulosOrdenados.add(Articulo);
			}
			
			//Se obtiene un arrayList con los articulos de la misma marca
			ArticulosDeLaMismaMarca.clear();
			posicion = -1;
			for(int i=0; i<PosicionesMarca.size(); i++){
				posicion = PosicionesMarca.get(i);
				//Se obtiene el determinada posicion
				Articulo = Carrito.get(posicion);
				//Se agrega el articulo de determinada posicion al arraylist ordenado
				ArticulosDeLaMismaMarca.add(Articulo);
			}
			
			//Se elimina los precio de los articulos de la misma marca del arraylist de los precios
			posicion = -1;
			for(int i=0; i<ArticulosDeLaMismaMarca.size(); i++){
				ArticuloElectronico ArticuloEnCuestion = ArticulosDeLaMismaMarca.get(i);
				posicion = Carrito.indexOf(ArticuloEnCuestion);
				Carrito.remove(posicion);
				Marcas.remove(posicion);
			}
			
		}
		
		//Se le asigna al carrito el valor del arraylist que tiene los articulos ordenados
		Carrito = ArticulosOrdenados;
		
	}
	
}