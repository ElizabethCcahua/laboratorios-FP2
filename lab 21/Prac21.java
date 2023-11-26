
public class Prac21 {
    public static void main ( String [] args){

     Ejercito ejer1 = new Ejercito();
         Ejercito ejer2 = new Ejercito();
    ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
    
     ArrayList<Soldado> ejercito1=ejer1.generarEjercitoSoldadosAleatorio();
     for(int i=0;i<ejercito1.size();i++){
     ejercito1.get(i).setEjercitoNombre("1");
     }
     
    noRepetir(ejercito1, combinacionesUtilizadas);
    
    ArrayList<Soldado> ejercito2=ejer2.generarEjercitoSoldadosAleatorio();
     for(int i=0;i<ejercito2.size();i++){
     ejercito2.get(i).setEjercitoNombre("2");
     }
    noRepetir(ejercito2, combinacionesUtilizadas);
    
    
    Soldado[][] tablero = new Soldado[10][10];
 
    ubicarEjercitosEnTablero(ejercito1, ejercito2, tablero);
    mostrarTablero(tablero);
    
      System.out.println("\nEJERCITO 1\n");
        ejer1.mostrarDatosSoldadoMayorVida();
      System.out.println("\nEJERCITO 2\n");
        ejer2.mostrarDatosSoldadoMayorVida();
      
      System.out.println("\nEJERCITO 1\n");
        ejer1.calcularPromedioVidaSoldados();
      System.out.println("\nEJERCITO 2\n");
        ejer2.calcularPromedioVidaSoldados();
        
      System.out.println("\nEJERCITO 1\n");
         ejer1.mostrarDatosSoldadosEnOrden();
      System.out.println("\nEJERCITO 2\n");
         ejer2.mostrarDatosSoldadosEnOrden();
         
      System.out.println("\nEJERCITO 1\n");   
         ejer1.mostrarRankingPoder();
      System.out.println("\nEJERCITO 2\n");
         ejer2.mostrarRankingPoder();
   
      determinarGanador(ejer1, ejer2);
      
    }

 
}
