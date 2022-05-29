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
	
	public static void cargarObras() {
		String SEPARATOR=",";
		String linea;
		long codigoObra;
		String 	titulo;
		String fecha;
		float precioRef;
		String dimensiones;
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

				listaObras.add(new Obra(codigoObra, titulo, fecha, precioRef, dimensiones));
								
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
			System.out.println(listaObras.get(x).getTitulo()+
		    "   "+listaObras.get(x).getFecha()+
		    "   "+ String.valueOf(listaObras.get(x).getPrecioRef())+
		    "   " +listaObras.get(x).getDimensiones());
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
            	
                 break;
            case 3:	
                 break;
        } 
			
	}
	
	
	
	
	private static Object str(float precioRef) {
		// TODO Auto-generated method stub
		return null;
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
		ArrayList <Artista> listaArtistas = new ArrayList<Artista>();
		
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
		
	

	
   public void buscarObra (String criterio)
   {
	   //cuerpo
   }
   
   public void insertarObra ()
   {
	   //cuerpo
   }
   public void modificarObra (String criterio)
   {
	   //cuerpo
   }

   public void eliminarObra (String criterio)
   {
	   //cuerpo
   }
}
