package galeria;

import java.util.Scanner;

public class PantallaGaleria {

    private static int menu() {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        System.out.println("1. Item 1");
        System.out.println("2. Item 2");
        System.out.println("3. Item 3");
        System.out.println("4. Item 4");
        System.out.println("5. Salir");
        System.out.println("Digite su Opción: ");
        x = scanner.nextInt();
        /*if (x <= 1 && x >= 5) System.out.println("Opción no valida");
        else return x; */
        return x;
    }

    public static void main(String[] args) {
        int x=0;
        do {
            x = menu();
            switch (x) {
                case 1:
                     break;
                case 2:
                     break;
                case 3:
                     break;
                case 4:
                     break;
                case 5:
                    break;
            } 
        } while ( x != 6);

    }

    
    
}
