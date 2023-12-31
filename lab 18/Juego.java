
import java.util.ArrayList;

public class Juego {
    public static void main ( String [] args){

     Ejercito ejer1 = new Ejercito();
         Ejercito ejer2 = new Ejercito();
    ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
    
     ArrayList<Soldado> ejercito1=ejer1.generarEjercitoSoldadosAleatorio();
     for(int i=0;i<ejercito1.size();i++){
     ejercito1.get(i).setEjercitoNombre("*");
     }
     
    noRepetir(ejercito1, combinacionesUtilizadas);
    
    ArrayList<Soldado> ejercito2=ejer2.generarEjercitoSoldadosAleatorio();
     for(int i=0;i<ejercito2.size();i++){
     ejercito2.get(i).setEjercitoNombre("@");
     }
    noRepetir(ejercito2, combinacionesUtilizadas);
    
    
    Soldado[][] tablero = new Soldado[10][10];
 
    ubicarEjercitosEnTablero(ejercito1, ejercito2, tablero);
    mostrarTablero(tablero);
    
      System.out.println("\nEJERCITO *************************\n");
        ejer1.mostrarDatosSoldadoMayorVida();
      System.out.println("\nEJERCITO @@@@@@@@@@@@@@@@@@@@@@@\n");
        ejer2.mostrarDatosSoldadoMayorVida();
      
      System.out.println("\nEJERCITO *************************\n");
        ejer1.calcularPromedioVidaSoldados();
      System.out.println("\nEJERCITO @@@@@@@@@@@@@@@@@@@@@@@\n");
        ejer2.calcularPromedioVidaSoldados();
        
      System.out.println("\nEJERCITO *************************\n");
         ejer1.mostrarDatosSoldadosEnOrden();
      System.out.println("\nEJERCITO @@@@@@@@@@@@@@@@@@@@@@@\n");
         ejer2.mostrarDatosSoldadosEnOrden();
         
      System.out.println("\nEJERCITO *************************\n");   
         ejer1.mostrarRankingPoder();
      System.out.println("\nEJERCITO @@@@@@@@@@@@@@@@@@@@@@@\n");
         ejer2.mostrarRankingPoder();
   
      determinarGanador(ejer1, ejer2);
      
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
}
