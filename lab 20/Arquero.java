class Arquero extends Soldado{
    private int numFlechas;
    
    public Arquero() {
        super();
        this.setNombre("Arquero " + (getContadorArquero() + 1));
        aumentarContadorArquero();
        this.numFlechas = Aleatorio(1, 10);
    }
    
    public Arquero(String nombre, int nivelAtaque, int nivelDefensa, int vidaActual, int velocidad, String actitud, String caracteristica, int numFlechas) {
        super(nombre, nivelAtaque, nivelDefensa, vidaActual, velocidad, actitud, caracteristica);
        this.numFlechas = numFlechas;
    }
    
    // Métodos set y get atributo numFlechas
    public void setNumFlechas(int numFlechas) {
        this.numFlechas = numFlechas;
    }
    
    public int getNumFlechas() {
        return numFlechas;
    }
}
