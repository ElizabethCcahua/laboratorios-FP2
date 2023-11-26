class Caballero extends Soldado{
    private boolean montado;
    private String armaActual;

    public Caballero() {
        super();
        this.setNombre("Caballero " + (getContadorCaballero() + 1));
        aumentarContadorCaballero();
        montado = false;
        armaActual = "lanza";        
    }

    public void cambiarArma() {
        if (armaActual.equals("espada")) {
            armaActual = "lanza";
        } else {
            armaActual = "espada";
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            armaActual = "espada";
        }
    }

    public void montar() {
        if (!montado) {
            montado = true;
            armaActual = "lanza";
        }
         envestir();
    }

//modificar-cambiar metodo
    public void envestir() {
        if (montado) {
            System.out.println("ataca 3 veces!");
        } else {
            System.out.println("ataca 2 veces!");
        }
    }
}
