package galeria;
import java.util.Scanner;

public class PantallaGaleria {
	
	 private static int menu() {
	        Scanner scanner = new Scanner(System.in);
	        int x = 0;
	        System.out.println("************** GALERIA LA PINTURA *************\n");
	        System.out.println(" 1. Ver listado de Obras disponibles");
	        System.out.println(" 2. Buscar una Obra por título, artista o año");
	        System.out.println(" 3. Insertar una Obra");
	        System.out.println(" 4. Ver listado de clientes registrados en el sistema");
	        System.out.println(" 5. Eliminar una obra");
	        System.out.println(" 6. Ver listado de clientes registrados en el sistema");
	        System.out.println(" 7. Buscar un Cliente");
	        System.out.println(" 8. Insertar Cliente");
	        System.out.println(" 9. Modificar datos de Cliente");
	        System.out.println("10. Eliminar un Cliente");
	        System.out.println("11. Realizar Compra de una Obra");
	        System.out.println("12. Eliminar Compra de Obra");
	        System.out.println("13. Ver listado de Compras Existentes");
	        System.out.println("14. Ver listado de Compras por mes/usuaeio");
	        System.out.println("15. Ver listado de Artistas más vendidos");
	        System.out.println("16. Salir");
	        System.out.println("Digite su Opcion: ");
	        x = scanner.nextInt();
	        return x;
	    }

	    public static void main(String[] args) {
	        int x=0;
	        do {
	            x = menu();
	            switch (x) {
	                case 1:
	                	 GestionObras.imprimirLectura();
	                     break;
	                case 2:
	                     break;
	                case 3:
	                     break;
	                case 4:
	                     break;
	                case 5:
	                    break;
	                case 6:
	                    break;
	                case 7:
	                    break;
	                case 8:
	                    break;
	                case 9:
	                    break;
	                case 10:
	                    break;
	                case 11:
	                    break;
	                case 12:
	                    break;
	                case 13:
	                    break;
	                case 14:
	                    break;
	                case 15:
	                    break;
	            } 
	        } while ( x != 16);
	        
	        	
	      }

}
