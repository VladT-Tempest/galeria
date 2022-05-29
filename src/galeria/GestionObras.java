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
	public static void mostrarObras() 
	{
		System.out.println("-------------Listado de obras disponibles:  --------------");
		for(int x = 0; x < listaObras.size(); x++)
		{
			if (listaObras.get(x).isEstado())
			{
				System.out.println(listaObras.get(x).getTitulo()+
				"   "+listaObras.get(x).getFecha()+
				"   "+ String.valueOf(listaObras.get(x).getPrecioRef())+
				"   " +listaObras.get(x).getDimensiones());
			}
		}
			
	}
	
	public static void buscarObras() 
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("------BUSQUEDA OBRA------");
		System.out.println("Digite 1 para buscar por el TITULO ");
		System.out.println("Digite 2 para buscar por el ARTISTA");
		System.out.println("Digite 3 para buscar por el FECHA \n ");
        
		int tipo = sc.nextInt();
		
		System.out.println("Digite criterio de busqueda:  ");
		String buscar = sc.next();
		
		switch (tipo) {
            case 1:
            	for(int x = 0; x < listaObras.size(); x++)
        		{
        			if (listaObras.get(x).getTitulo().equals(buscar))
        			{
        				System.out.println(listaObras.get(x).getTitulo()+
        				"   "+listaObras.get(x).getFecha()+
        				"   "+ String.valueOf(listaObras.get(x).getPrecioRef())+
        				"   " +listaObras.get(x).getDimensiones());
        			}
        		}
            	pausa();
                break;
                
            case 2:
            	for(int x = 0; x < listaObras.size(); x++)
        		{
        			if (listaObras.get(x).getCodigoArtista() == Long.parseLong(buscar))
        			{
        				System.out.println("TITULO: \t FECHA: \t PRECIO: \t DIMENSIONES");
        				System.out.println(listaObras.get(x).getTitulo()+
        				"\t"+listaObras.get(x).getFecha()+
        				"\t"+ String.valueOf(listaObras.get(x).getPrecioRef())+
        				"\t\t" +listaObras.get(x).getDimensiones());
        			}
        		}
            	pausa();
                 break;
            case 3:	
            	for(int x = 0; x < listaObras.size(); x++)
        		{
        			if (listaObras.get(x).getFecha().contains(buscar))
        			{
        				System.out.println(listaObras.get(x).getTitulo()+
        				"   "+listaObras.get(x).getFecha()+
        				"   "+ String.valueOf(listaObras.get(x).getPrecioRef())+
        				"   " +listaObras.get(x).getDimensiones());
        			}
        		}
            	pausa();
                 break;
        } 
			
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
		
		
		
		while (true)
		{
			System.out.println("Digite el codigo de la obra: ");
			codigoObra = Long.parseLong(sc.next());
			
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
			System.out.println("Digite el Titulo de la obra: ");
			titulo = sc.next();
			
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
			
			if (respuesta.toUpperCase() == "S")
			{
				return true;
			}
			else if (respuesta.toUpperCase() == "N")
			{
				return false;
			}
			
			System.out.println("OPCION NO VALIDA");
		}
			
	}

	

}
