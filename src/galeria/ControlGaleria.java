package galeria;

public class ControlGaleria {
	
	public ControlGaleria() 
	{
		GestionObras.cargarObras(); // Cargar coleccion de obras
		GestionObras.cargarArtistas(); // cargar coleccion artistas
		GestionClientes.cargarClientes(); //cargar coleccion de clientes
		Compra.cargarCompras();
	}

}
