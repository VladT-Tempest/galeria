package galeria;

public class ControlGaleria {
	
	public ControlGaleria() 
	{
		// SE INICIALIZA TODO DESDE PANTALLA
		GestionObras.cargarObras(); // Cargar coleccion de obras
		GestionObras.cargarArtistas(); // cargar coleccion artistas
		GestionClientes.cargarClientes(); //cargar coleccion de clientes
		Compra.cargarCompras();
	}

}
