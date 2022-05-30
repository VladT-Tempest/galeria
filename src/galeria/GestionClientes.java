package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionClientes {
static ArrayList <Cliente> listaClientes = new ArrayList<Cliente>();	

	
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
	
	public static void mostrarClientes() {
		Scanner sc = new Scanner (System.in);
		System.out.println("-------------Listado de clientes registrados:  --------------");
		System.out.println("CEDULA: \t NOMBRE COMPLETO: \t DIRECCION: \t TELEFONO");
		for(int x = 0; x < listaClientes.size(); x++)
		{
			
			System.out.println(listaClientes.get(x).getCedula()+
			"\t"+listaClientes.get(x).getNombre()+
			" "+listaClientes.get(x).getApellidos() +"\t"
			+ listaClientes.get(x).getDireccionEntrega()+
			"\t"+listaClientes.get(x).getTelefono());
			
	     }

	 }
}
