import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
       
       ArrayList<Ejercito>[] reinos=  mapa.tableroBatalla();
       ArrayList<Ejercito> reino1 =reinos[0];
        ArrayList<Ejercito> reino2 =reinos[1];

        //Compara el número de ejércitos en cada reino y selecciona el reino con la mayor cantidad de ejércitos como ganador. 
          if (reino1.size() > reino2.size()) {
            System.out.println("El ganador es el Reino 1 por tener más ejércitos.");
        } else if (reino2.size() > reino1.size()) {
            System.out.println("El ganador es el Reino 2 por tener más ejércitos.");
        } else {
            System.out.println("Empate en cantidad de ejércitos.");
        }

        // Suma la cantidad de soldados en cada ejército de ambos reinos y selecciona el reino con la mayor cantidad total de soldados como ganador.
        int cantidadSoldadosReino1 = CantidadTotalSoldados(reino1);
        int cantidadSoldadosReino2 = CantidadTotalSoldados(reino2);
        if (cantidadSoldadosReino1 > cantidadSoldadosReino2) {
            System.out.println("El ganador es el Reino 1 por tener más soldados en total.");
        } else if (cantidadSoldadosReino2 > cantidadSoldadosReino1) {
            System.out.println("El ganador es el Reino 2 por tener más soldados en total.");
        } else {
            System.out.println("Empate en cantidad total de soldados.");
        }

        // Métrica 3: Calcula la sumatoria de los niveles de vida de todos los soldados en cada reino y selecciona el reino con la mayor sumatoria como ganador. 
        int sumatoriaNivelVidaReino1 = SumatoriaNivelVida(reino1);
        int sumatoriaNivelVidaReino2 = SumatoriaNivelVida(reino2);
        if (sumatoriaNivelVidaReino1 > sumatoriaNivelVidaReino2) {
            System.out.println("El ganador es el Reino 1 por tener una mayor sumatoria de niveles de vida.");
        } else if (sumatoriaNivelVidaReino2 > sumatoriaNivelVidaReino1) {
            System.out.println("El ganador es el Reino 2 por tener una mayor sumatoria de niveles de vida.");
        } else {
            System.out.println("Empate en sumatoria de niveles de vida.");
        }

        // Métrica 4: Asigna un peso aleatorio a cada reino y selecciona al ganador basándose en la probabilidad asignada. Por ejemplo, puedes asignar un porcentaje aleatorio a cada reino y seleccionar al ganador en función de ese porcentaje. 
        double porcentajeReino1 = PorcentajeAleatorio();
        double porcentajeReino2 = PorcentajeAleatorio();
        if (porcentajeReino1 > porcentajeReino2) {
            System.out.println("El ganador es el Reino 1 según la probabilidad porcentaje aleatorio.");
        } else if (porcentajeReino2 > porcentajeReino1) {
            System.out.println("El ganador es el Reino 2 según la probabilidad porcentaje aleatorio.");
        } else {
            System.out.println("Empate según la probabilidad porcentaje aleatorio.");
        }
    }
    }
    private static int CantidadTotalSoldados(ArrayList<Ejercito> reino) {
        int cantidadTotalSoldados = 0;
        for (Ejercito ejercito : reino) {
            cantidadTotalSoldados += ejercito.getCantidadSoldados();
        }
        return cantidadTotalSoldados;
    }

    
    private static int SumatoriaNivelVida(ArrayList<Ejercito> reino) {
        int sumatoriaNivelVida = 0;
        for (Ejercito ejercito : reino) {
            sumatoriaNivelVida += ejercito.getSumatoriaNivelVidaSoldados();
        }
        return sumatoriaNivelVida;
    }

    //porcentaje aleatorio entre 0 y 100
    private static double PorcentajeAleatorio() {
        return Math.random() * 100;
    }
}
