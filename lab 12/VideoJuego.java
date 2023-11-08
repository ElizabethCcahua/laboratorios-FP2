import java.util.*;
public class VideoJuego {
    public static void main(String[] args) {
        menuPrincipal();
    }
    
     public static void menuPrincipal() {
     Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("----- MENÚ PRINCIPAL -----");
            System.out.println("1. Juego rápido");
            System.out.println("2. Juego personalizado");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    
                    
                    break;
                case 3:
                    System.out.println("FIN");
                    break;
                default:
                    System.out.println("opción inválida.seleccione una opción válida.");
                    break;
            }
            
        } while (opcion != 3);
    }
}
