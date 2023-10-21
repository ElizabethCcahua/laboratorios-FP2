import java.util.*;
public class BatallaDemo {
    public static void main ( String [] args){
       ArrayList <Soldado> ejercito1 = new ArrayList<Soldado>();
       ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>(); 
       
        inicializarEjercito(ejercito1);
        inicializarEjercito(ejercito2);
        
        for (int i = 0; i < ejercito2.size(); i++) {
    ejercito2.get(i).setNombre("Soldado" + i + "X2");
        }
        System.out.println(ejercito1.size());
         System.out.println(ejercito2.size());
        mostrarTablerol(ejercito1,ejercito2);
    } 
public static void inicializarEjercito(ArrayList<Soldado> ejercito) {
        for (int i = 0; i < Aleatorio(1,10); i++) {
            int fila =Aleatorio(1,10);
            int columna =Aleatorio(1,10);
            int vida = Aleatorio(1, 5);
            int nivelAtaque =Aleatorio(1, 5);
            int nivelDefensa = Aleatorio(1, 5);

            Soldado soldado1 = new Soldado("Soldado" + i + "X1", nivelAtaque, nivelDefensa, vida, vida, 0, "defensiva", true);
            soldado1.setFila(fila);
            soldado1.setColumna(columna);
            ejercito.add(soldado1);
            
        }
       
    }
}
