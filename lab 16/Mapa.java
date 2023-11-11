import java.util.ArrayList; 
import java.util.HashMap; 
 
public class Mapa  {
  private final String territorio;
  
 public Mapa() {
   String[] territorios = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
   this.territorio = territorios[(int)(Math.random() * territorios.length)];
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
