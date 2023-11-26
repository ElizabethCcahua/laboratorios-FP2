class Caballero extends Soldado{
    private boolean montado;
    private String armaActual;
      private static final int NIVEL_ATAQUE = 13;
      private static final int NIVEL_DEFENSA = 7;

    public Caballero() {
        super();
       nivelAtaque= NIVEL_ATAQUE ;
       nivelDefensa=NIVEL_DEFENSA ;   
       nivelVida=Soldado.Aleatorio(10, 12);
       vidaActual=nivelVida;
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
     public void setMontado(boolean montado) {
        this.montado = montado;
    }

    public boolean isMontado() {
        return montado;
    }

    public void setArmaActual(String armaActual) {
        this.armaActual = armaActual;
    }

    public String getArmaActual() {
        return armaActual;
    }

     @Override
    public String toString() {
        return super.toString() +
                "Montado: " + montado + "\n" +
                "Arma actual: " + armaActual;
    }
}
