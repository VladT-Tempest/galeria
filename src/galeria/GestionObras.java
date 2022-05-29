package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class GestionObras 
{
	public static void imprimirLectura()
	{
		String linea;
		long CodigoObra;
		String 	titulo;
		Calendar fecha;
		float precioRef;
		String dimesiones;
		
		System.out.println("entra");
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("obra.csv"));
			linea = br.readLine();
			while (	linea != null)
			{
				System.out.println(linea);
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
