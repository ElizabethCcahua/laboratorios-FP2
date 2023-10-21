import java.util.*;
public class BatallaDemo {
    public static void main ( String [] args){
       ArrayList <Soldado> ejercito1 = new ArrayList<Soldado>();
       ArrayList<Soldado> ejercito2 = new ArrayList<Soldado>(); 
        //creamos un arraylist para almacenar las combinaciones utilizadas con el fin de que no caigan dos soldados en la misma posicion
       ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
        inicializarEjercito(ejercito1,combinacionesUtilizadas);
        inicializarEjercito(ejercito2,combinacionesUtilizadas);
       
        
        for (int i = 0; i < ejercito2.size(); i++) {
    ejercito2.get(i).setNombre("Soldado" + i + "X2");
        }
        mostrarTablero(ejercito1,ejercito2);
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

    //metodo que permitira generar un par de fila y columna que no sea repetido anterior mente por otro soldado
    public static boolean generarParejaUnica(int fila, int columna, ArrayList<String> combinacionesUtilizadas) {
    // Si la pareja existe retorna falso, para que se busque otra pareja, de lo contrario lo añade al ArrayList
    for (String combinacion : combinacionesUtilizadas) {
        if (combinacion.equals(fila + "-" + columna)) {
            return false;
        }
        combinacionesUtilizadas.add(fila + "-" + columna);
            return true;
}
    }
}
