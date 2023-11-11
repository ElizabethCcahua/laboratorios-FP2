import java.util.*;

public class Lab16 {
    public static void main(String[] args) {
        Mapa mapa = new Mapa();
       
       ArrayList<Ejercito>[] reinos=  mapa.tableroBatalla();
       ArrayList<Ejercito> reino1 =reinos[0];
        ArrayList<Ejercito> reino2 =reinos[1];
    }
}
