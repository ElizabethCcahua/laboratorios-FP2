
import java.util.ArrayList;

public class Prac18 {
    public static void main ( String [] args){




      
    }

     public static void mostrarTablero(Soldado[][] tablero) {
       System.out.println("      1   2   3   4   5   6   7   8   9  10");
       System.out.println("     _______________________________________");
        for (int i = 0; i < 10; i++) {
            if(i<9)
              System.out.print(" " + (i+1)+"  "); 
            else{
            System.out.print(" " + (i+1)+" ");}
            
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("|" +tablero[i][j].getEjercitoNombre()+tablero[i][j].getNombre().substring(0, 1)+  tablero[i][j].getVidaActual());
                } else {
                    System.out.print("|___");
                }
            }
            System.out.println("|");
        }
    }
     
    public static boolean identificarParejaUnica(int fila, int columna, ArrayList<String> combinacionesUtilizadas) {
        for (String combinacion : combinacionesUtilizadas) {
            if (combinacion.equals(fila + "-" + columna)) {
                return false;
            }
        }

        combinacionesUtilizadas.add(fila + "-" + columna);
        return true;
    }
      
      public static void ubicarEjercitosEnTablero(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2, Soldado[][] tablero) {
        for (Soldado soldado : ejercito1) {
            int fil = soldado.getFila();
            int col = soldado.getColumna();
            tablero[fil - 1][col - 1] = soldado;
        }

        for (Soldado soldado : ejercito2) {
            int fil = soldado.getFila();
            int col = soldado.getColumna();
            tablero[fil - 1][col - 1] = soldado;
        }
    }
      
      
        // para que no hayan 2 en un mismo lugar
    public static void noRepetir(ArrayList<Soldado> ejercito, ArrayList<String> combinacionesUtilizadas) {
        for (int i = 0; i < ejercito.size(); i++) {
            int  fila = ejercito.get(i).getFila();
             int columna =ejercito.get(i).getColumna();

            if (identificarParejaUnica(fila, columna, combinacionesUtilizadas)) {
                
                ejercito.get(i).setFila(fila);
                ejercito.get(i).setColumna(columna);
                    
            }
            else {
               fila = Aleatorio(1, 10);
               columna = Aleatorio(1, 10);
               ejercito.get(i).setFila(fila);
                ejercito.get(i).setColumna(columna);
                i--;
            }
        }
    }
    
    
     public static int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
     
     public static void mostrarejercito(ArrayList<Soldado> soldados) {
        
        for (Soldado soldado : soldados) {
            System.out.println(soldado.toString());
        }
    }
     
     public static void determinarGanador(Ejercito ejercito1, Ejercito ejercito2) {
    int sumaVidaEjercito1 = ejercito1.getSumatoriaNivelVidaSoldados();
    int sumaVidaEjercito2 = ejercito2.getSumatoriaNivelVidaSoldados();

    if (sumaVidaEjercito1 > sumaVidaEjercito2) {
        System.out.println("El ejército * es el ganador.");
    } else if (sumaVidaEjercito2 > sumaVidaEjercito1) {
        System.out.println("El ejército @ es el ganador.");
    } else {
        System.out.println("Ambos ejércitos tienen la misma suma de vida. Es un empate.");
    }
}
