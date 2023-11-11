import java.util.ArrayList; 
import java.util.HashMap; 
 
public class Mapa  {
  private final String territorio;
  
 public Mapa() {
   String[] territorios = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
   this.territorio = territorios[(int)(Math.random() * territorios.length)];
    }
private boolean identificarParejaUnica(int fila, int columna, ArrayList<String> combinacionesUtilizadas) {
        for (String combinacion : combinacionesUtilizadas) {
            if (combinacion.equals(fila + "-" + columna)) {
                return false;
            }
        }

        combinacionesUtilizadas.add(fila + "-" + columna);
        return true;
    }

    private void ubicarEjercitosEnTablero(ArrayList<Ejercito> reino1, ArrayList<Ejercito> reino2, Ejercito[][] tablero) {
        for (Ejercito ejercito : reino1) {
            int fila = ejercito.getFila();
            int columna = ejercito.getColumna();
            tablero[fila - 1][columna - 1] = ejercito;
        }

        for (Ejercito ejercito : reino2) {
            int fila = ejercito.getFila();
            int columna = ejercito.getColumna();
            tablero[fila - 1][columna - 1] = ejercito;
        }
    }

   private void mostrarTablero(Ejercito[][] tablero) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tablero[i][j] != null) {
                    System.out.print("|" + tablero[i][j].getAbrev()+  tablero[i][j].getCantidadSoldados()+"-"+tablero[i][j].getSumatoriaNivelVidaSoldados());
                } else {
                    System.out.print("|_______");
                }
            }
            System.out.println();
        }
    }
 
public void mostrarejercitosMapa(ArrayList<Ejercito> ejercitos) {
        
        for (Ejercito ejercito : ejercitos) {
            System.out.println(ejercito.toString());
        }
    }

    public void BonusTerritorio(ArrayList<Ejercito> ejercitos) {
        HashMap<String, String> bonusTerritorio = new HashMap<>();
        bonusTerritorio.put("Inglaterra", "bosque");
        bonusTerritorio.put("Francia", "campo abierto");
        bonusTerritorio.put("Castilla - Aragón", "montaña");
        bonusTerritorio.put("Moros", "desierto");
        bonusTerritorio.put("Sacro Imperio", "bosque, playa , campo abierto");

        for (Ejercito ejercito : ejercitos) {
            String reino = ejercito.getReino();
            if (bonusTerritorio.containsKey(reino) && bonusTerritorio.get(reino).contains(territorio)) {
                ArrayList<Soldado> soldados = ejercito.getMisSoldados();
                for (Soldado soldado : soldados) {
                    int nuevoNivelVida = soldado.getNivelVida() + 1;
                    soldado.setNivelVida(nuevoNivelVida);
                }
            }
        }
    }
   

    private int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
