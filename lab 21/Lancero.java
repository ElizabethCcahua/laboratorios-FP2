class Lancero extends Soldado {
    private int longitudLanza;
     private static final int NIVEL_ATAQUE = 5;
    private static final int NIVEL_DEFENSA = 10;
    
    public Lancero() { 
       super();
        nivelAtaque= NIVEL_ATAQUE ;
       nivelDefensa=NIVEL_DEFENSA ;   
       nivelVida=Soldado.Aleatorio(5, 8);
       vidaActual=nivelVida;
        this.setNombre("Lancero " + (getContadorLancero() + 1));
        aumentarContadorLancero();
        this.longitudLanza = Aleatorio(1, 10);
         
    }

    public Lancero(String nombre, int nivelAtaque, int nivelDefensa, int vidaActual, int velocidad, String actitud, String caracteristica, int longitudLanza) {
        super(nombre, nivelAtaque, nivelDefensa, vidaActual, velocidad, actitud, caracteristica);
        this.longitudLanza = longitudLanza;
    }

    public int getLongitudLanza() {
        return longitudLanza;
    }

    public void setLongitudLanza(int longitudLanza) {
        this.longitudLanza = longitudLanza;
    }

    public void schiltrom() {
        setNivelDefensa(getNivelDefensa() + 1);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Longitud de lanza: " + longitudLanza + "\n";
    }
}
