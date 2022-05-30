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
		boolean estado;
		
		
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
				estado = true;

				listaClientes.add(new Cliente(codigoCliente, cedula, nombre, apellidos, direccion, telefono, estado));
								
				linea = br.readLine();
			}
			
						
		}
		catch (FileNotFoundException ex) {
			System.err.println(ex.getMessage());	
			
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}		
	}
	
	public static void mostrarClientes() 
	{
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
	public static boolean buscarCodigoCliente(long codigoCliente)
	{
		for(int x = 0; x < listaClientes.size(); x++)
		{
			if (codigoCliente == listaClientes.get(x).getCodigoCliente())
			{
				return true;
			}
		}
		return false;
	}
	public static void insertarCliente()
	{
		boolean estado = true;
		long codigoCliente;
		long cedula;
		String nombre;
		String apellidos;
		String direccionEntrega;
		long telefono;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite el codigo del cliente: ");
		codigoCliente = sc.nextLong();
		if (buscarCodigoCliente(codigoCliente))
		{
			System.out.println("Codigo de cliente digitado ya existente");
		}
		
		else
		{
			sc.nextLine();
			System.out.println("Digite el codigo del cliente: ");
			codigoCliente = sc.nextLong();

			System.out.println("Digite la cedula del cliente: ");
			cedula = sc.nextLong();
			
			System.out.println("Digite el nombre del cliente: ");
			nombre= sc.next();
			
			System.out.println("Digite el apellido del cliente: ");
			apellidos = sc.next();
			
			System.out.println("Digite la direccion de entrega del cliente: ");
			direccionEntrega = sc.next();
			
			System.out.println("Digite el telefono del cliente ");
			telefono = sc.nextLong();
			

			listaClientes.add(new Cliente(codigoCliente, cedula, nombre, apellidos, direccionEntrega,telefono, estado));
	
		}
	}
	
	
	
	
	public static void buscarClientePorCodigo(long codigoCliente)
	{
		Scanner sc = new Scanner (System.in);
		for(int x = 0; x < listaClientes.size(); x++)
		{
			if(listaClientes.get(x).getCodigoCliente() == codigoCliente)
			{
				System.out.println("\\t CEDULA: \\t NOMBRE COMPLETO: \\t DIRECCION: \\t TELEFONO");
				System.out.println(listaClientes.get(x).getCodigoCliente()+
				"\t"+listaClientes.get(x).getCedula()+
				"\t"+listaClientes.get(x).getNombre()+
				" "+ listaClientes.get(x).getApellidos()+
				"\t\t" +listaClientes.get(x).getDireccionEntrega()+
				"\t"+ String.valueOf(listaClientes.get(x).getTelefono()));
				
				System.out.println("------MODIFICACION DE OBRA------");
				System.out.println("Digite 1 para modificar el codigo del cliente");
				System.out.println("Digite 2 para modificar la cedula del cliente");
				System.out.println("Digite 3 para modificar el nombre del cliente");
				System.out.println("Digite 4 para modificar los apellidos del cliente");
				System.out.println("Digite 5 para modificar la direccion del cliente ");
				System.out.println("Digite 6 para modificar el telefono del cliente ");
		        
				int tipo = sc.nextInt();
				
				System.out.println("Digite el nuevo valor/criterio:  ");
				String valor = sc.next();
				
				switch (tipo) 
				{
		            case 1:
		            	listaClientes.get(x).setCodigoCliente(Long.parseLong(valor));
		                break;		                
		            case 2:		            	
		            	listaClientes.get(x).setCedula(Long.parseLong(valor)); //titulo solo guarda la primera palabra
		                 break;
		            case 3:	
		            	listaClientes.get(x).setNombre(valor);
		                 break;
		            case 4:	
		            	listaClientes.get(x).setApellidos(valor);
		                 break;
		            case 5:	
		            	listaClientes.get(x).setDireccionEntrega(valor);
		                 break;
		            case 6:	
		            	listaClientes.get(x).setTelefono(Long.parseLong(valor));
		                 break;		
			      }
				
				System.out.println("\\t CEDULA: \\t NOMBRE COMPLETO: \\t DIRECCION: \\t TELEFONO");
				System.out.println(listaClientes.get(x).getCodigoCliente()+
				"\t"+listaClientes.get(x).getCedula()+
				"\t"+listaClientes.get(x).getNombre()+
				" "+ listaClientes.get(x).getApellidos()+
				"\t\t" +listaClientes.get(x).getDireccionEntrega()+
				"\t"+ String.valueOf(listaClientes.get(x).getTelefono())); // AGREGAR ESTADO
			}				
		}		
}
	
	public static void modificarCliente()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite el codigo del cliente a modificar:  ");
		long tempCodigoCliente = sc.nextLong();
		
		if (!buscarCodigoCliente(tempCodigoCliente))
		{
			System.out.println("Cliente INEXSISTENTE");
		}
		else
		{
			buscarClientePorCodigo(tempCodigoCliente);
			System.out.println("Cliente modificado correctamente");
		}
		
			
	}
	
	public static void eliminarCliente()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite el codigo del cliente a eliminar: ");
		long tempCodigoCliente= sc.nextLong();
		
		if (!buscarCodigoCliente(tempCodigoCliente))
		{
			System.out.println("CLIENTE INEXSISTENTE");
		}
		else
		{
			for(int x = 0; x < listaClientes.size(); x++)
			{
				if (listaClientes.get(x).getCodigoCliente() == tempCodigoCliente && listaClientes.get(x).isEstado() == false )
				{
					System.out.println("Esta obra no puede ser eliminada, ya que esta en proceso de venta....");
				}
				if (listaClientes.get(x).getCodigoCliente() == tempCodigoCliente && listaClientes.get(x).isEstado() == true )
				{
					System.out.println("Seguro de querer eliminar el cliente??: S/N");
					String respuesta = sc.next();
					if (respuesta.equals("S"))
					{
						System.out.println("Cliente eliminado correctamente!");
						listaClientes.remove(x);
					}
					if (respuesta.equals("N"))
					{
						System.out.println("Eliminacion cancelada");
					}

				}
			
			}
		}
	}
		
	
	
	
	
}
