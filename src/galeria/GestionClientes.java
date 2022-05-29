package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GestionClientes {
	
	
	public static void cargarClientes() 
	{
		String SEPARATOR=",";
		String linea;
		long codigoCliente;
		long cedula;
		String nombre;
		String apellidos;
		String direccion;
		long telefono;
		ArrayList <Cliente> listaClientes = new ArrayList<Cliente>();
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader("src\\galeria\\cliente.csv"));
			linea = br.readLine();
			while (	linea != null)
			{				
				String [] fields = linea.split(SEPARATOR);
				codigoCliente = Long.parseLong(fields[0]);
				cedula = Long.parseLong(fields[1]);
				nombre = fields[2];
				apellidos = fields[3];
				direccion = fields[4];
				telefono = Long.parseLong(fields[5]);

				listaClientes.add(new Cliente(codigoCliente, cedula, nombre, apellidos, direccion, telefono));
								
				linea = br.readLine();
			}
			
						
		}
		catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());	
			
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}		
	}
	
	

}
