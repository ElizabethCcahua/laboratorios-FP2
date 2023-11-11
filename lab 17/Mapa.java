
import java.util.ArrayList; 
import java.util.HashMap; 
 
public class Mapa  {
    private final String territorio;
   
    
    public Mapa() {
        String[] territorios = {"bosque", "campo abierto", "montaña", "desierto", "playa"};
        this.territorio = territorios[(int)(Math.random() * territorios.length)];

    }

    
   public ArrayList<Ejercito>[] tableroBatalla() {
    Ejercito ejercitoPrincipal = new Ejercito();
    ArrayList<String> combinacionesUtilizadas = new ArrayList<>();
    
    ArrayList<Ejercito> reino1 = ejercitoPrincipal.generarEjercitosAleatorios();
    noRepetir(reino1, combinacionesUtilizadas);
    
    ArrayList<Ejercito> reino2 = ejercitoPrincipal.generarEjercitosAleatorios();
    noRepetir(reino2, combinacionesUtilizadas);
    
    String[] reinos = {"Inglaterra", "Francia", "Sacro Imperio", "Castilla - Aragón", "Moros"};
    String[] caract = {"Ing", "Fra", "Sac", "Cas", "Mor"};
    // Tomamos dos reinos aleatorios diferentes
    int primero = (int) (Math.random() * reinos.length);
    String primerNombre = caract[primero];
    int segundo = (int) (Math.random() * reinos.length);
    while (primero == segundo) {
        segundo = (int) (Math.random() * reinos.length);
    }
    String segundoNombre = caract[segundo];
    for (int i = 0; i < reino1.size(); i++) {
        reino1.get(i).setReino("Ejercito" + i + "X1");
        reino1.get(i).setAbrev(primerNombre);
    }
    for (int i = 0; i < reino2.size(); i++) {
        reino2.get(i).setReino("Ejercito" + i + "X2");
        reino2.get(i).setAbrev(segundoNombre);
    }
    BonusTerritorio(reino1);
    BonusTerritorio(reino2);
    
    Ejercito[][] tablero = new Ejercito[10][10];
    ubicarEjercitosEnTablero(reino1, reino2, tablero);
    mostrarTablero(tablero);
    System.out.println("\nTERRITORIO: " + territorio);
    mostrarejercitosMapa(reino1);
    mostrarejercitosMapa(reino2);

    // Devolvemos un arreglo de tamaño 2 con los reinos reino1 y reino2
    ArrayList<Ejercito>[] ambos = new ArrayList[2];
    ambos[0] = reino1;
    ambos[1] = reino2;
    return ambos;
}

  // para que no hayan 2 en un mismo lugar
    public void noRepetir(ArrayList<Ejercito> reino, ArrayList<String> combinacionesUtilizadas) {
        for (int i = 0; i < reino.size(); i++) {
            int  fila = reino.get(i).getFila();
             int columna =reino.get(i).getColumna();

            if (identificarParejaUnica(fila, columna, combinacionesUtilizadas)) {
                
                reino.get(i).setFila(fila);
                reino.get(i).setColumna(columna);
                    
            }
            else {
               fila = Aleatorio(1, 10);
               columna = Aleatorio(1, 10);
               reino.get(i).setFila(fila);
                reino.get(i).setColumna(columna);
                i--;
            }
        }
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

