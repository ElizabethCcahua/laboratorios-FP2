
public class Prac21 {
    public static void main ( String [] args){

    Mapa mapa = new Mapa();
     Ejercito[] reinos=  mapa.tableroBatalla();
              
                
         Ejercito ejer1 = reinos[0];
             Ejercito ejer2 = reinos[1];
 
    
      //MAYOR VIDA   
    System.out.println("\n_________SOLDADO MAYOR VIDA_______");  
        System.out.println("EJERCITO 1"); 
        ejer1.mostrarDatosSoldadoMayorVida();
      System.out.println("\nEJERCITO 2\n");
        ejer2.mostrarDatosSoldadoMayorVida();
         System.out.println("");
         //PROMEDIO   
      System.out.println("\n_________PROMEDIO VIDA POR EJERCITO_______");
      System.out.println("\nEJERCITO 1");
        ejer1.calcularPromedioVidaSoldados();
      System.out.println("\nEJERCITO 2");
        ejer2.calcularPromedioVidaSoldados();
         //SOLDADOS EN ORDEN EN Q FUERON CREADOS  
      System.out.println("\n_________SOLDADO EN ORDEN EN Q FUERON CREADOS_______");
  
      System.out.println("\nEJERCITO 1\n");
         ejer1.mostrarDatosSoldadosEnOrden();
      System.out.println("\nEJERCITO 2\n");
         ejer2.mostrarDatosSoldadosEnOrden();

         //RANKING    
       System.out.println("\n_________RANKING POR EJERCITO(nivel vida descendente)_______");
      System.out.println("\nEJERCITO 1\n");   
         ejer1.mostrarRankingPoder();
      System.out.println("\nEJERCITO 2\n");
         ejer2.mostrarRankingPoder();
   
      //RESUMEN
       System.out.println("\n_________RESUMEN FINAL_______");
          System.out.println("\nEJERCITO 1: "+ejer1.getReino());
        ejer1.mostrarResumen();
         System.out.println("\nEJERCITO 2: "+ejer2.getReino());
        ejer2.mostrarResumen();
    
        ejer1.mostrarProbabilidadVictoria(ejer2);
      
    }

 
}
