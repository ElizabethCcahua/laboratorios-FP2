import java.util.ArrayList;
import java.util.Scanner;


class Ejercito {
    private String reino;
    private ArrayList<Soldado> misSoldados;
    private String abrev;
    private int fila=Aleatorio(1,10);
    private int columna=Aleatorio(1,10);
    
     public Ejercito() { 
         String[] reinos = {"Inglaterra", "Francia", "Sacro Imperio", "Castilla - Aragón", "Moros"};
         String[] caract = {"Ing", "Fra", "Sac", "Cas", "Mor"};
         this.reino=  reinos[(int)(Math.random() * reinos.length)];  
         this.abrev=  caract[(int)(Math.random() * reinos.length)]; 
        this.misSoldados = new ArrayList<>(); 
    }
      public Ejercito(String reino) {
        this.reino = reino;
        this.misSoldados = new ArrayList<>();
    }
  //agrega una cantidad aleatoria de soldados
    public void generarEjercitoSoldadosAleatorio() {
      
        int numSoldados = Aleatorio(1,10) ;
        for (int i = 0; i < numSoldados; i++) {
            Soldado soldado = new Soldado();
            soldado.setNombre(" soldado "+i);
            misSoldados.add(soldado);
        }
    }
    
    //agrega soldado uno a uno
    public void agregarSoldado(Soldado soldado) {
        if (misSoldados.size() < 10) {
            misSoldados.add(soldado);
            System.out.println("Soldado agregado al ejército.");
        } else {
            System.out.println("El ejército ya tiene el máximo de soldados permitidos.");
        }
    }
    // genera una cantidad aleatoria de soldados y la agrega
    public void generarEjercitoSoldadosManualmente() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese la cantidad de soldados a agregar: ");
    int cantidadSoldados = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea anterior

    for (int i = 0; i < cantidadSoldados; i++) {
        System.out.println("Soldado " + (i + 1));
        
        System.out.print("Ingrese el nivel de ataque del soldado: ");
        int nivelAtaque = scanner.nextInt();
        System.out.print("Ingrese el nivel de defensa del soldado: ");
        int nivelDefensa = scanner.nextInt();
        System.out.print("Ingrese la vida actual del soldado: ");
        int vidaActual = scanner.nextInt();
        System.out.print("Ingrese la velocidad del soldado: ");
        int velocidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea anterior
        System.out.print("Ingrese la actitud del soldado: ");
        String actitud = scanner.nextLine();

        Soldado soldado = new Soldado(" Soldado"+i, nivelAtaque, nivelDefensa, vidaActual, velocidad, actitud, abrev);
        misSoldados.add(soldado);
        System.out.println("Soldado agregado al ejército.");
    }
}
   
    // genera ejercitos para un reino
    public ArrayList<Ejercito> generarEjercitosAleatorios() {
    ArrayList<Ejercito> ejercitos = new ArrayList<>();
    int numEjercitos = Aleatorio(1, 10); // Genera un número aleatorio entre 1 y 10
    for (int i = 0; i < numEjercitos; i++) {
        Ejercito ejercito = new Ejercito();
        ejercito.generarEjercitoSoldadosAleatorio();
        ejercitos.add(ejercito);
    }
    return ejercitos;
}

   
public void eliminarSoldado() {
    if (misSoldados.size() == 1) {
        System.out.println("No se puede eliminar soldados. El ejército solo tiene un soldado.");
        return;
    }
    Scanner scanner = new Scanner(System.in);
    System.out.println("Soldados a eliminar del reino: " + reino);
    for (int i = 0; i < misSoldados.size(); i++) {
        System.out.println((i + 1) + ". " + misSoldados.get(i).getNombre());
    }
    System.out.print("Seleccione el número del soldado a eliminar: ");
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > misSoldados.size()) {
        System.out.println("Opción inválida. Por favor, seleccione un número válido.");
        return;
    }
    misSoldados.remove(opcion - 1);
    System.out.println("Soldado eliminado.");
}

public  void modificarSoldado() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Soldados disponibles del reino"+reino);
    for (int i = 0; i < misSoldados.size(); i++) {
        System.out.println((i + 1) + ". " + misSoldados.get(i).getNombre());
    }
    System.out.print("Seleccione el número del soldado que desea modificar: ");
    int opcion = scanner.nextInt();
    if (opcion < 1 || opcion > misSoldados.size()) {
        System.out.println("Opción inválida. Por favor, seleccione un número válido.");
        return;
    }
    Soldado soldado = misSoldados.get(opcion - 1);
    System.out.println("Datos actuales del soldado:");
    System.out.println("Nivel de ataque: " + soldado.getNivelAtaque());
    System.out.println("Nivel de defensa: " + soldado.getNivelDefensa());
    System.out.println("Vida actual: " + soldado.getVidaActual());
    System.out.println("Velocidad: " + soldado.getVelocidad());
    // Submenú para cambiar los atributos
    System.out.println("Seleccione el atributo que desea modificar:");
    System.out.println("1. Nivel de ataque");
    System.out.println("2. Nivel de defensa");
    System.out.println("3. Vida actual");
    System.out.println("4. Velocidad");
    int opcionAtributo = scanner.nextInt();
    switch (opcionAtributo) {
        case 1:
            System.out.print("Nuevo nivel de ataque: ");
            soldado.setNivelAtaque(scanner.nextInt());
            break;
        case 2:
            System.out.print("Nuevo nivel de defensa: ");
            soldado.setNivelDefensa(scanner.nextInt());
            break;
        case 3:
            System.out.print("Nueva vida actual: ");
            soldado.setVidaActual(scanner.nextInt());
            break;
        case 4:
            System.out.print("Nueva velocidad: ");
            soldado.setVelocidad(scanner.nextInt());
            break;
        default:
            System.out.println("Opción inválida. No se realizaron cambios.");
            break;
    }
    System.out.println("");
}

    public void obtenerSoldadoMayorAtaque() {
    Soldado soldadoMayorAtaque = null;
    int mayorAtaque = 0;
    for (Soldado soldado : misSoldados) {
        if (soldado.getNivelAtaque() > mayorAtaque) {
            mayorAtaque = soldado.getNivelAtaque();
            soldadoMayorAtaque = soldado;
        }
    }
    System.out.println("\nSoldado con mayor ataque: " + soldadoMayorAtaque.getNombre());
}

    public void mostrarRankingPoder() {
        System.out.println("Ranking de poder (nivel de vida descendente):"+ reino);
        for (int i = 0; i < misSoldados.size() - 1; i++) {
            for (int j = 0; j < misSoldados.size() - i - 1; j++) {
                if (misSoldados.get(j).getNivelVida() < misSoldados.get(j + 1).getNivelVida()) {
                    Soldado temp = misSoldados.get(j);
                    misSoldados.set(j, misSoldados.get(j + 1));
                    misSoldados.set(j + 1, temp);
                }
            }
        }
        for (Soldado soldado : misSoldados) {
            System.out.println( soldado.getNombre() + " - Nivel de vida: " + soldado.getNivelVida());
        }
    }
    
    public void gestionarEjercito() {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
        System.out.println("\n======== MENU GESTION =========");
        System.out.println("1. Ingresar datos soldados autogenerados");
        System.out.println("2. Ingresar datos soldados manualmente");
        System.out.println("3. Eliminar algún soldado del ejército");
        System.out.println("4. Modificar algún soldado del ejército");
        System.out.println("5. Eliminar algún soldado del ejército");
        System.out.println("6. Salir\n");
        System.out.print("Ingrese una opción: ");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                generarEjercitoSoldadosAleatorio();
                System.out.println("Datos Soldados generados");
                break;
            case 2:
                generarEjercitoSoldadosManualmente();
                System.out.println("Datos Soldados Ingresados.");
                break;
            case 3:
                modificarSoldado();
                System.out.println("Ejército modificado exitosamente.");
                break;
            case 4:
                modificarSoldado();
                System.out.println("Ejército modificado exitosamente.");
                break;
            case 5:
                eliminarSoldado();
                System.out.println("Soldado eliminado exitosamente.");
                break;
            case 6:
                System.out.println("Salio del menú");
                break;
            default:
                System.out.println("Opción inválida. Intente nuevamente.");
                break;
        }
    } while (opcion != 5);
    System.out.println("");
}
    
    
    public String toString() {
    return "\nEJERCITO:================> " + reino + "\n\nSoldados: " + misSoldados.toString();
}
    
     public void setMisSoldados(ArrayList<Soldado> misSoldados) {
        this.misSoldados = misSoldados;
    }

    public ArrayList<Soldado> getMisSoldados() {
        return misSoldados;
    }
    
     public void setReino(String nombre) {
        this.reino = nombre;
    }
     
     public String getReino() {
    return reino;
       }
    
    public void setAbrev(String abrev) {
    this.abrev = abrev;
    }

    public String getAbrev() {
        return abrev;
    }
  // Métodos set y get para el atributo fila
    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getFila() {
        return fila;
    }

    // Métodos set y get para el atributo columna
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getColumna() {
        return columna;
    }
    
    //metodo para poder obtener numeros aleatorios
    public int Aleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
    
}

