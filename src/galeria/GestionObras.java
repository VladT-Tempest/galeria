package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class GestionObras 
{
	
	public static void cargarObras() {
		String SEPARATOR=",";
		String linea;
		long codigoObra;
		String 	titulo;
		String fecha;
		float precioRef;
		String dimensiones;
		ArrayList <Obra> listaObras = new ArrayList<Obra>();
		
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
	
	public class cargarArtistas() {
		
		String SEPARATOR=",";
		String linea;
		
		
		
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
