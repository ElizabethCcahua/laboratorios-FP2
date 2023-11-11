import java.util.*;

public class VideoJuego {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
       
       ArrayList<Ejercito>[] reinos=  mapa.tableroBatalla();
       ArrayList<Ejercito> reino1 =reinos[0];
        ArrayList<Ejercito> reino2 =reinos[1];
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
