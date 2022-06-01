package galeria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Compra {
	static ArrayList <Compra> listaCompras = new ArrayList<Compra>();
	
	private long codigoCompra;
	private String fecha;
	private boolean pagado;
	private long codigoObra;
	private long codigoCliente;
	
	
	
	
	public Compra(long codigoCompra,String fecha, boolean pagado, long codigoObra, long codigoCliente) {
		this.codigoCompra = codigoCompra;
		this.fecha = fecha;
		this.pagado = pagado;
		this.codigoObra = codigoObra;
		this.codigoCliente = codigoCliente;
	}
	public long getCodigoCompra() {
		return codigoCompra;
	}
	public void setCodigoCompra(long codigoCompra) {
		this.codigoCompra = codigoCompra;
	}
	public long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;

	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
	
	public long getCodigoObra() {
		return codigoObra;
	}
	public void setCodigoObra(long codigoObra) {
		this.codigoObra = codigoObra;
	}
	public static void cargarCompras() 
	{
		listaCompras = new ArrayList<Compra>();
	}
	
	public static boolean verificarCliente(long tempCodigoCliente)
	{
		for(int x = 0; x < listaCompras.size(); x++)
		{
			if  (listaCompras.get(x).getCodigoCliente() == tempCodigoCliente)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void insertarCodigoArtista(long codigoArtista)
	{
		for(int x = 0; x < listaCompras.size(); x++)
		{
			
		}
	}
	
	
	public static void reporteTopArtista() {
		long[] compras = new long[30];
		long[] artistas = new long[30];
		long[] artistaUnico = new long[30];
		ArrayList <Long> resumidoArtista= new ArrayList<Long>();
		ArrayList <Integer> contVentasxArtista= new ArrayList<Integer>();
		
		int contador = 1;
 			
		long codigoObra;
		long codigoArtista;

		for(int x = 0; x < listaCompras.size(); x++)
		{
			codigoObra = listaCompras.get(x).getCodigoObra();
			codigoArtista = GestionObras.buscarCodigoArtista(codigoObra);
			
			compras[x] = codigoObra;
			artistas[x] = codigoArtista;	
				
		}
		
		for(int x = 0; x < artistas.length; x++)
		{
			if (resumidoArtista.indexOf(artistas[x]) == -1) { 
				resumidoArtista.add(artistas[x]);
				contVentasxArtista.add(contador);		
			} else {
				if(contVentasxArtista.get(resumidoArtista.indexOf(artistas[x])) > 1) {
					continue;
				} else {						
					contador ++;
					contVentasxArtista.set(resumidoArtista.indexOf(artistas[x]),contador);
				}
			}
			
			for(int y = x+1; y < artistas.length; y++)
			{
				if(artistas[x] == artistas[y])
				{
					contador++;
					contVentasxArtista.set(resumidoArtista.indexOf(artistas[x]),contador);
				}
			}
			
			contador = 1;
			
		}

		
		
		
		for(int x = 0; x < resumidoArtista.size(); x++)
		{
			System.out.println(resumidoArtista.get(x)+ "  " + contVentasxArtista.get(x));
		}
		
		//REPETICIONES..............
		

		
	}
	// SE CARGAN DELE ARCHIVO PRUEBA LAS SUPUESTAS COMPRAS
	public static void cargarComprasPruebas()
	{
			String SEPARATOR=",";
			String linea;
			long codigoCompra;
			String fecha;
			boolean pagado;
			long codigoObra;
			long codigoCliente;
			
			
			try 
			{
				BufferedReader br = new BufferedReader(new FileReader("src\\galeria\\comprasFAKE.csv"));
				linea = br.readLine();
				while (	linea != null)
				{				
					String [] fields = linea.split(SEPARATOR);
					codigoCompra = Long.parseLong(fields[0]);
					fecha = fields[1];
					pagado = Boolean.parseBoolean(fields[2]);
					codigoObra = Long.parseLong(fields[3]);
					codigoCliente = Long.parseLong(fields[4]);

					listaCompras.add(new Compra(codigoCompra, fecha,pagado,codigoObra,codigoCliente));
									
					linea = br.readLine();
				}
				
							
			}
			catch (FileNotFoundException ex) {
				System.err.println(ex.getMessage());	
				
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}		

	}
	
	// SE MUESTRAN LAS COMPRAS ACTUALES
	public static void mostrarCompras()
	{
		System.out.println(" CODIGO COMPRA:  \t FECHA: \t ESTADO: \t CODIGO OBRA \t CODIGO CLIENTE");
		for(int x = 0; x < listaCompras.size(); x++)
		{
			
			System.out.printf("%-20s %10s %10s %10s %10s", listaCompras.get(x).getCodigoCompra(),
			listaCompras.get(x).getFecha(), listaCompras.get(x).isPagado(),
			listaCompras.get(x).getCodigoObra(),listaCompras.get(x).getCodigoCliente());
			System.out.println();
	
		}
	}
	// METODO QUE VERIFICA SI EL CLIENTE NO ESTA INVOLUCRADO EN ALGUNA OTRA COMPRA
	public static void verificacionCompraCliente(long codigoCliente, long codigoObra, String fecha)
	{
		if (listaCompras.size() > 0)
		{
			for(int x = 0; x < listaCompras.size(); x++)
			{
					
				if  (listaCompras.get(x).getCodigoCliente() == codigoCliente)
				{
					if  (listaCompras.get(x).getCodigoObra() == codigoObra)
					{
						System.out.println("No se puede guardar el registro,"
								+ " ya hay una compra para ese cliente");
					}
					else
					{
						boolean pagado = false;
						long codigoCompra = (long)(Math.random()*100000+1);
						listaCompras.add(new Compra(codigoCompra,fecha, pagado,codigoObra, codigoCliente));
						System.out.println("Compra realizada correctamente!");
					}
				
			     }
				else
				{
					boolean pagado = false;
					long codigoCompra = (long)(Math.random()*100000+1);
					listaCompras.add(new Compra(codigoCompra,fecha, pagado,codigoObra, codigoCliente));
					System.out.println("Compra realizada correctamente!");
					break;
				}
		     }
			
				
		}
		else
		{
			boolean pagado = false;
			long codigoCompra = (long)(Math.random()*100000+1);
			listaCompras.add(new Compra(codigoCompra,fecha, pagado,codigoObra, codigoCliente));
			System.out.println("Compra realizada correctamente!");
		}

	}
	public static boolean verificarNumeroCompra(long tempCompra)
	{
		for(int x = 0; x < listaCompras.size(); x++)
		{
			if (listaCompras.get(x).getCodigoCompra() == tempCompra)
			{
				return true;
			}
		}
		return false;
		
	}
	//METODO QUE DIVIDE LA FECHA PARA ENCONTRAR LAS OBRAS COMPRADAS EN ESA FECHA
	public static boolean dividirFecha(String year, String mes)
	{
		int control = 0;
		System.out.println("COMPRAS ENCONTRADAS:    ");
		System.out.println(" CODIGO COMPRA:  \t FECHA: \t ESTADO: \t CODIGO OBRA \t CODIGO CLIENTE");
		for(int x = 0; x < listaCompras.size(); x++)
		{
			String tempFecha = listaCompras.get(x).getFecha();
			String[] fechaDividida =  tempFecha.split("/");
			if (fechaDividida[0].equals(mes) && fechaDividida[2].equals(year))
			{
				System.out.printf("%-30s %10s %20s %20s %20s", listaCompras.get(x).getCodigoCompra(),
				listaCompras.get(x).getFecha(), listaCompras.get(x).isPagado(),
				listaCompras.get(x).getCodigoObra(),listaCompras.get(x).getCodigoCliente());
				control = 1;

			}
		}
		if (control == 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
// METODO QUE ENCUENTRA LAS COMPRAS DEPENDIENDO DE LA FECHA INGRESADA
	public static void reporteVentasSegunFecha()
	{

		Scanner sc = new Scanner (System.in);

		System.out.println("REPORTE DE VENTAS SEGUN FECHA DIGITADA: ");
		
		System.out.println("Digite el a�o de las ventas a buscar: : ");
		String year = sc.next();
		
		System.out.println("Digite el Mes de las ventas a buscar: : ");
		String mes = sc.next();
		
	    if (!dividirFecha(year, mes))
	    {
	    	System.out.println("Registro de compras en la fecha indicada no encontrado......");
	    }
		
		
	}
	//METODO DE ELIMINACION DE COMPRA
	public static void eliminarCompra()
	{
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite el numero de compra a eliminar: ");
		long tempCompra = sc.nextLong();
		
		if (!verificarNumeroCompra(tempCompra))
		{
			System.out.println("Numero de compra a eliminar no encontrado");
		}
		else
		{
			for(int x = 0; x < listaCompras.size(); x++)
			{
				if (listaCompras.get(x).getCodigoCompra() == tempCompra)
				{
					System.out.println("Seguro de querer eliminar el cliente??: S/N");
					String respuesta = sc.next();
					if (respuesta.toUpperCase().equals("S"))
					{

							System.out.println("Compra eliminada correctamente!");
							listaCompras.remove(x);
							break;
					}
					if (respuesta.toUpperCase().equals("N"))
					{
						System.out.println("Eliminacion cancelada");
						break;
					}
				}
			}
		}
		
	}
	
	//METODO QUE REALIZA COMPRA DE OBRA 
	public static  void realizarCompra()
	{
		String fecha;
		long tempCodigo;
		long tempCodigo2;
		
		Scanner sc = new Scanner (System.in);
		while (true) 
		{
			System.out.println("Digite su codigo de cliente: ");
			tempCodigo = sc.nextLong();
			if (!GestionClientes.buscarCodigoCliente(tempCodigo))
			{
				System.out.println("Codigo de cliente no valido");
			}
			else
			{
				break;
			}				
		}
		while (true) 
		{
			System.out.println("Digite el codigo de la obra: ");
			tempCodigo2 = sc.nextLong();
			if (!GestionObras.buscarCodigoObra(tempCodigo2))
			{
				System.out.println("Codigo de obra no valido");
			}
			else
			{
				break;
			}				
		}
		
		System.out.println("Digite la fecha de compra: (mm/dd/yyyy) ");
		fecha = sc.next();
		verificacionCompraCliente(tempCodigo, tempCodigo2, fecha);
		
		
		
	}
	
	

}
