
import java.util.*;
public class Lab15 {
    

    public static void main(String[] args) {
        Ejercito ejercitoPrincipal = new Ejercito();

        ejercitoPrincipal.gestionarEjercito();
        
        System.out.println("MAS DATOS DEL EJERCITOOO");
        String datosEjercito=ejercitoPrincipal.toString();
        
        System.out.println(datosEjercito);
        ejercitoPrincipal.mostrarRankingPoder();
        ejercitoPrincipal.obtenerSoldadoMayorAtaque();
        
    
    }
}
