package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class GestionObras 
{
	public void imprimirLectura()
	{
		String linea;
		long CodigoObra;
		String 	titulo;
		Calendar fecha;
		float precioRef;
		String dimesiones;
		{
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("Obra.csv"));
			linea = br.readLine();
			while (	linea != null)
			{
				System.out.println(linea);
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
			
}
}
