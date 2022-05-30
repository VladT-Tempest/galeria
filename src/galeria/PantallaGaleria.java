package galeria;
import java.io.IOException;
import java.util.Scanner;

public class PantallaGaleria {
	
	 private static int menu() {
	        Scanner scanner = new Scanner(System.in);
	        int x = 0;
	        System.out.println("************** GALERIA LA PINTURA *************\n");
	        System.out.println(" 1. Ver listado de Obras disponibles");
	        System.out.println(" 2. Buscar una Obra por titulo, artista o year");
	        System.out.println(" 3. Insertar una Obra");
	        System.out.println(" 4. Modificar una obra");
	        System.out.println(" 5. Eliminar una obra");
	        System.out.println(" 6. Ver listado de clientes registrados en el sistema");
	        System.out.println(" 7. Buscar un Cliente");
	        System.out.println(" 8. Insertar Cliente");
	        System.out.println(" 9. Modificar datos de Cliente");
	        System.out.println("10. Eliminar un Cliente");
	        System.out.println("11. Realizar Compra de una Obra");
	        System.out.println("12. Eliminar Compra de Obra");
	        System.out.println("13. Ver listado de Compras Existentes");
	        System.out.println("14. Ver listado de Compras por mes/año");
	        System.out.println("15. Ver listado de Artistas mas vendidos");
	        System.out.println("16. Salir");
	        System.out.println("Digite su Opcion: ");
	        x = scanner.nextInt();
	        return x;
	    }
	 private static void pausa() 
	 {
		 System.out.println("\n Presione ENTER para continuar");
		 try{System.in.read();}
		 catch(Exception e){}
	 }

	    public static void main(String[] args) {
	    	ControlGaleria galeria = new ControlGaleria();    	
	    
	        int x=0;
	        do {
	            x = menu();
	            switch (x) {
	                case 1:
	                	 GestionObras.mostrarObras();
	                	 pausa();
	                     break;
	                case 2:
	                	 GestionObras.buscarObras();
	                	 pausa();
	                     break;
	                case 3:
	                	GestionObras.insertarObra();
	                	pausa();	
	                     break;
	                case 4:
	                	GestionObras.modificarObra();
	                	pausa();
	                     break;
	                case 5:
	                	GestionObras.eliminarObra();
	                	pausa();
	                    break;
	                case 6:
	                	GestionClientes.mostrarClientes();
	                	pausa();
	                    break;
	                case 7:
	                	GestionClientes.buscarClientes();
	                	pausa();
	                    break;
	                case 8:
	                	GestionClientes.insertarCliente();
	                	pausa();
	                    break;
	                case 9:
	                	GestionClientes.modificarCliente();
	                	pausa();
	                    break;
	                case 10:
	                	GestionClientes.eliminarCliente();
	                	pausa();
	                    break;
	                case 11:
	                	Compra.realizarCompra();
	                	pausa();
	                    break;
	                case 12:
	                	Compra.eliminarCompra();
	                	pausa();
	                    break;
	                case 13:
	                	Compra.mostrarCompras();
	                	pausa();
	                    break;
	                case 14:
	                	Compra.reporteVentasSegunFecha();
	                	pausa();
	                    break;
	                case 15:
	                	pausa();
	                    break;
	                case 115:
	                	Compra.cargarComprasPruebas();
	                	pausa();
	                	break;
	            } 
	        } while ( x != 16);
	        
	        	
	      }

}
