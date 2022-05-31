package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionObras 
{
	private static void pausa() 
	 {
		 System.out.println("\n Presione ENTER para continuar");
		 try{System.in.read();}
		 catch(Exception e){}
	 }
	
	static ArrayList <Obra> listaObras = new ArrayList<Obra>();
	static ArrayList <Artista> listaArtistas = new ArrayList<Artista>();
	
	// se cargan las obras del archivo 
	public static void cargarObras() {
		String SEPARATOR=",";
		String linea;
		long codigoObra;
		String 	titulo;
		String fecha;
		float precioRef;
		String dimensiones;
		boolean estado;
		long codigoArtista;
		//ArrayList <Obra> listaObras = new ArrayList<Obra>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("src\\galeria\\obra.csv"));
			linea = br.readLine();
			while (	linea != null)
			{				
				String [] fields = linea.split(SEPARATOR);
				codigoObra = Long.parseLong(fields[0]);
				titulo = fields[1];
				fecha = fields[2];
				precioRef = Float.parseFloat(fields[3]);
				dimensiones = fields[4];
				estado = Boolean.parseBoolean(fields[5]);
				codigoArtista =  Long.parseLong(fields[6]);

				listaObras.add(new Obra(codigoObra, titulo, fecha, precioRef, dimensiones, estado, codigoArtista));
								
				linea = br.readLine();
			}
						
		}
		catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());	
			
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}		
		
		
	}
	// se muestran las obras dispobiles TRUE
	public static void mostrarObras() 
	{
		System.out.println("-------------Listado de obras disponibles:  --------------");
		System.out.println("TITULO: \t\t FECHA: \t\t PRECIO: \t\t DIMENSIONES");
		for(int x = 0; x < listaObras.size(); x++)
		{
			if (listaObras.get(x).isEstado())
			{
				System.out.printf("%-30s %10s %20s %20s", listaObras.get(x).getTitulo(),
				listaObras.get(x).getFecha(), String.valueOf(listaObras.get(x).getPrecioRef()),
				listaObras.get(x).getDimensiones());
				System.out.println();
			}
		}
			
	}
	//BUSQUEDA DE OBRAS
	public static void buscarObras() 
	{
		Scanner sc = new Scanner (System.in);
		Scanner sc2 = new Scanner (System.in);
		//sc2.useDelimiter("\n");
		System.out.println("------BUSQUEDA OBRA------");
		System.out.println("Digite 1 para buscar por el TITULO ");
		System.out.println("Digite 2 para buscar por el ARTISTA");
		System.out.println("Digite 3 para buscar por el FECHA \n ");
        
		int tipo = sc.nextInt();
		System.out.println("Digite criterio de busqueda:  ");
		String buscar = sc2.next();
		
		switch (tipo) {
            case 1:
            	for(int x = 0; x < listaObras.size(); x++)
        		{
        			if (listaObras.get(x).getTitulo().contains(buscar))
        			{
        				System.out.println("TITULO: \t\t FECHA: \t\t PRECIO: \t\t DIMENSIONES");
        				System.out.printf("%-30s %10s %20s %20s", listaObras.get(x).getTitulo(),
						listaObras.get(x).getFecha(), String.valueOf(listaObras.get(x).getPrecioRef()),
						listaObras.get(x).getDimensiones());
						System.out.println();
        		
        			}
        		}
            	pausa();
                break;
                
            case 2:
            	for(int x = 0; x < listaObras.size(); x++)
        		{
        			if (listaObras.get(x).getCodigoArtista() == Long.parseLong(buscar))
        			{
        				System.out.println("TITULO: \t\t FECHA: \t\t PRECIO: \t\t DIMENSIONES");
        				System.out.printf("%-30s %10s %20s %20s", listaObras.get(x).getTitulo(),
						listaObras.get(x).getFecha(), String.valueOf(listaObras.get(x).getPrecioRef()),
						listaObras.get(x).getDimensiones());
						System.out.println();
        			}
        		}
            	pausa();
                 break;
            case 3:	
            	for(int x = 0; x < listaObras.size(); x++)
        		{
        			if (listaObras.get(x).getFecha().contains(buscar))
        			{
        				System.out.println("TITULO: \t\t FECHA: \t\t PRECIO: \t\t DIMENSIONES");
        				System.out.printf("%-30s %10s %20s %20s", listaObras.get(x).getTitulo(),
						listaObras.get(x).getFecha(), String.valueOf(listaObras.get(x).getPrecioRef()),
						listaObras.get(x).getDimensiones());
						System.out.println();
        			}
        		}
            	pausa();
                 break;
        } 
			
	}
	//metodos usados para saber si se encuentra codigos en la lista
	public static long  buscarCodigoArtista(long codigoObra)
	{
		for(int x = 0; x < listaObras.size(); x++)
		{
			if (listaObras.get(x).getCodigoObra() == codigoObra)
			{
				return listaObras.get(x).getCodigoArtista();
			}
		}
		return 0;
	}
	public static boolean buscarCodigoObra(long codigoObra)
	{
		for(int x = 0; x < listaObras.size(); x++)
		{
			if (codigoObra  == listaObras.get(x).getCodigoObra())
			{
				return true;
			}
		}
		return false;
	}
	//insertar una obra
	public static void insertarObra()
	{
		
		long codigoObra;
		String 	titulo;
		String fecha;
		float precioRef;
		String dimensiones;
		boolean estado = true;
		long codigoArtista;
		Scanner sc = new Scanner (System.in);
		Scanner sc2 = new Scanner (System.in);
		
		
		
		while (true)
		{
			System.out.println("Digite el codigo de la obra: ");
			
			codigoObra = sc.nextLong();
			if (codigoObra > 9999999 || codigoObra < 1000000)
			{
				System.out.println("CODIGO INVALIDO, el codigo debe de tener 7 cifras");
			}
			else
			{
				break;
			}
		}
		
		if (buscarCodigoObra(codigoObra))
		{
			System.out.println("Codigo de obra digitado ya existente");
		}
		
		else
		{
			sc.nextLine();
			sc2.useDelimiter("\n");
			System.out.println("Digite el Titulo de la obra: ");
			titulo = sc2.nextLine();

			System.out.println("Digite la fecha de la obra: ");
			fecha = sc.next();
			
			System.out.println("Digite el precio de la obra: ");
			precioRef = sc.nextFloat();
			
			System.out.println("Digite las dimesiones de la obra: ");
			dimensiones = sc.next();
			
			if (mostrarArtistas())
			{
				System.out.println("Digite el codigo del artista de la obra: ");
				codigoArtista = sc.nextLong();
				listaObras.add(new Obra(codigoObra, titulo, fecha, precioRef, dimensiones, estado, codigoArtista));
			}
			else
			{
				codigoArtista = insertarArtista();
				listaObras.add(new Obra(codigoObra, titulo, fecha, precioRef, dimensiones, estado, codigoArtista));
			}	
		}
	}
	
	public static void buscarObraPorCodigo(long codigoObra)
	{
		Scanner sc = new Scanner (System.in);
		for(int x = 0; x < listaObras.size(); x++)
		{
			if(listaObras.get(x).getCodigoObra() == codigoObra)
			{
	
				System.out.println("\t CODIGO OBRA: \t  TITULO: \t FECHA: \t PRECIO: \t DIMENSIONES \t ESTADO \t CODIGO ARTISTA ");
				
				System.out.printf("%-30s %10s %20s %20s %20s %20s  %20s", String.valueOf(listaObras.get(x).getCodigoObra()),listaObras.get(x).getTitulo(),
				listaObras.get(x).getFecha(), String.valueOf(listaObras.get(x).getPrecioRef()),
				listaObras.get(x).getDimensiones(), listaObras.get(x).isEstado(),
				String.valueOf(listaObras.get(x).getCodigoArtista()));
		
				System.out.println();

				
				System.out.println("------MODIFICACION DE OBRA------");
				System.out.println("Digite 1 para modificar el codigo de obra ");
				System.out.println("Digite 2 para modificar el titulo");
				System.out.println("Digite 3 para modificar la fecha");
				System.out.println("Digite 4 para modificar el precio");
				System.out.println("Digite 5 para modificar las dimensiones ");
				System.out.println("Digite 6 para modificar el estado ");
				System.out.println("Digite 7 para modificar el codigo del artista \n ");
		        
				int tipo = sc.nextInt();
				
				System.out.println("Digite el nuevo valor/criterio:  ");
				String valor = sc.next();
				
				switch (tipo) 
				{
		            case 1:
		            	listaObras.get(x).setCodigoObra(Long.parseLong(valor));
		                break;		                
		            case 2:		            	
		            	listaObras.get(x).setTitulo(valor); //titulo solo guarda la primera palabra
		                 break;
		            case 3:	
		            	listaObras.get(x).setFecha(valor);
		                 break;
		            case 4:	
		            	listaObras.get(x).setPrecioRef(Float.parseFloat(valor));
		                 break;
		            case 5:	
		            	listaObras.get(x).setDimensiones(valor);
		                 break;
		            case 6:	
		            	listaObras.get(x).setEstado(Boolean.parseBoolean(valor));
		                 break;
		            case 7:	
		            	listaObras.get(x).setCodigoArtista(Long.parseLong(valor));
		                 break;				
			      }
				
				System.out.println("TITULO: \t\t FECHA: \t\t PRECIO: \t\t DIMENSIONES");
				System.out.printf("%-30s %10s %20s %20s", listaObras.get(x).getTitulo(),
				listaObras.get(x).getFecha(), String.valueOf(listaObras.get(x).getPrecioRef()),
				listaObras.get(x).getDimensiones());
				System.out.println();
		
			}				
		}		
}
	
	//METODO CON EL DE ARRIBA QUE MODIFICA LA OBRA SEGUN LO QUE SE QUIERA CAMBIAR
	public static void modificarObra()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite el codigo de la obra a modificar:  ");
		long tempCodigoObra = sc.nextLong();
		
		if (!buscarCodigoObra(tempCodigoObra))
		{
			System.out.println("OBRA INEXSISTENTE");
		}
		else
		{
			buscarObraPorCodigo(tempCodigoObra);
			System.out.println("Obra modificada correctamente");
		}
		
	}
	//ELIMINACION DE OBRA
	public static void eliminarObra()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite el codigo de la obra a eliminar: ");
		long tempCodigoObra = sc.nextLong();
		
		if (!buscarCodigoObra(tempCodigoObra))
		{
			System.out.println("OBRA INEXSISTENTE");
		}
		else
		{
			for(int x = 0; x < listaObras.size(); x++)
			{
				if (listaObras.get(x).getCodigoObra() == tempCodigoObra && listaObras.get(x).isEstado() == false )
				{
					System.out.println("Esta obra no puede ser eliminada, ya que esta en proceso de venta....");
				}
				if (listaObras.get(x).getCodigoObra() == tempCodigoObra && listaObras.get(x).isEstado() == true )
				{
					listaObras.remove(x);
					System.out.println("Obra eliminada correctamente!");
				}
			
			}
		}
	}
	
	// SE INSERTA UN ARTISTA
	public static long insertarArtista()
	{
		Scanner sc = new Scanner (System.in);
		long codigoArtista;
		long cedula;
		String nombre;
		String apellidos;
		String fechaNacimiento;
		long telefono;
		
		System.out.println("Digite el Codigo del artista: ");
		codigoArtista =Long.parseLong(sc.next());
		
		System.out.println("Digite la cedula del artista: ");
		cedula = Long.parseLong(sc.next());
		
		System.out.println("Digite el nombre del artista: ");
		nombre = sc.next();
		
		System.out.println("Digite el apellido del artista ");
		apellidos = sc.next();
		
		System.out.println("Digite la fecha de nacimiento del artista ");
		fechaNacimiento = sc.next();
		
		System.out.println("Digite el telefono artista ");
		telefono = Long.parseLong(sc.next());
		
		listaArtistas.add(new Artista(codigoArtista, cedula, nombre, apellidos, fechaNacimiento, telefono));
		return codigoArtista;
	}
	//SE CARGAN LOS ARTISTAS DEL ARCHIVO EN LA LISTA
	public static void cargarArtistas() 
	{
		String SEPARATOR=",";
		String linea;
		long codigoArtista;
		long cedula;	
		String nombre;
		String apellidos;
		String fechaNacimiento;
		long telefono;
		
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("src\\galeria\\artista.csv"));
			linea = br.readLine();
			while (	linea != null)
			{				
				String [] fields = linea.split(SEPARATOR);
				codigoArtista = Long.parseLong(fields[0]);
				cedula = Long.parseLong(fields[1]);
				nombre = fields[2];
				apellidos = fields[3];
				fechaNacimiento = fields[4];
				telefono = Long.parseLong(fields[5]);

				listaArtistas.add(new Artista(codigoArtista, cedula, nombre, apellidos, fechaNacimiento, telefono));
								
				linea = br.readLine();
			}
			
						
		}
		catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());	
			
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}		
	}
	//SE MUESTRAN LOS ARTISTAS DE LA LISTA	
	public static boolean mostrarArtistas() 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("-------------Listado de artistas:  --------------");
		for(int x = 0; x < listaArtistas.size(); x++)
		{
	
			System.out.println(listaArtistas.get(x).getCodigoArtista()+
			"\t"+listaArtistas.get(x).getNombre()+
			"\t"+ String.valueOf(listaArtistas.get(x).getApellidos()));

		}
		while (true)
		{
			System.out.println("Se encuentra el artista de su obra en esta lista? S / N");
			String respuesta = sc.next();
			
			if (respuesta.toUpperCase().equals("S"))
			{
				return true;
			}
			else if (respuesta.toUpperCase().equals("N"))
			{
				return false;
			}
			
			System.out.println("OPCION NO VALIDA");
		}
			
	}

	

}
